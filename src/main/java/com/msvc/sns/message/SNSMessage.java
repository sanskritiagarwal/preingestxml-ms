/***************************************************************************
 * Copyright (C) Centivo 
 * 
 * The reproduction, transmission or use of this document or its contents is not permitted without
 * prior express written consent of Centivo. Offenders will be liable for damages. All rights,
 * including but not limited to rights created by patent grant or registration of a utility model or
 * design, are reserved.
 * 
 * Centivo reserves the right to modify technical specifications and features.
 * 
 * Technical specifications and features are binding only insofar as they are specifically and
 * expressly agreed upon in a written contract.
 * 
 **************************************************************************/
package com.msvc.sns.message;

import java.util.HashMap;
import java.util.Map;

import com.amazonaws.services.sns.AmazonSNS;
import com.amazonaws.services.sns.AmazonSNSClient;
import com.amazonaws.services.sns.model.MessageAttributeValue;
import com.amazonaws.services.sns.model.PublishRequest;
import com.amazonaws.services.sns.model.PublishResult;
import com.msvc.util.PreIngestXmlUtil;
import com.msvc.vo.Constant;

/**
 * Class for preparing sns message and publishing in a topic
 * 
 * @author anoop.singh
 *
 */
public class SNSMessage {

	private Map<String, MessageAttributeValue> messageAttributes;

	private AmazonSNS snsClent = AmazonSNSClient.builder().withRegion(Constant.REGION).build();

	public SNSMessage() {
		messageAttributes = new HashMap<>();
	}

	public void addAttribute(String attributeName, String attributeValue) {
		MessageAttributeValue messageAttributeValue = new MessageAttributeValue().withDataType("String")
				.withStringValue(attributeValue);
		messageAttributes.put(attributeName, messageAttributeValue);
	}

	/**
	 * publish message for a given topic
	 * 
	 * @param snsClient
	 * @param topicArn
	 * @return
	 */
	public String publish(MessageEvent event, String topicArn) {
		event.setEventType(Constant.EventType.PREINGESTION.getEvent());

		addAttribute(Constant.SNS_MESSAGE, PreIngestXmlUtil.writeAsJsonString(event));

		PublishRequest request = new PublishRequest(topicArn, event.getEventMessage())
				.withMessageAttributes(messageAttributes);
		PublishResult result = snsClent.publish(request);
		return result.getMessageId();
	}

	/**
	 * public message to CpocIngestObject topic
	 * 
	 * @param event
	 */
	public void publishMessage(MessageEvent event) {
		this.publish(event, Constant.CPOC_INGEST_OBJECT_TOPIC_ARN);
	}

	/**
	 * publish message to CpocIngestionException
	 * 
	 * @param event
	 */
	public void publishException(MessageEvent event) {
		this.publish(event, Constant.CPOC_INGEST_EXCEPTION_TOPIC_ARN);
	}

}
