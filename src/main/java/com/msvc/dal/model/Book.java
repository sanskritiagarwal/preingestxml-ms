package com.msvc.dal.model;


import java.math.BigDecimal;
import java.time.LocalDate;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlAttribute;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.adapters.XmlJavaTypeAdapter;
 
@XmlAccessorType(XmlAccessType.FIELD)
public class Book
{
    @XmlAttribute
    private String id;
    private String author;
    private String title;
    private String genre;
    private BigDecimal price;
 
    @XmlElement(name = "publish_date")
    //@XmlJavaTypeAdapter(LocalDateAdapter.class)
    private LocalDate pubdate;
    private String description;
 
    public String getId()
    {
        return id;
    }
 
    public void setId(String id)
    {
        this.id = id;
    }
 
    public String getAuthor()
    {
        return author;
    }
 
    public void setAuthor(String author)
    {
        this.author = author;
    }
 
    public String getTitle()
    {
        return title;
    }
 
    public void setTitle(String title)
    {
        this.title = title;
    }
 
    public String getGenre()
    {
        return genre;
    }
 
    public void setGenre(String genre)
    {
        this.genre = genre;
    }
 
    public BigDecimal getPrice()
    {
        return price;
    }
 
    public void setPrice(BigDecimal price)
    {
        this.price = price;
    }
 
    public LocalDate getPubdate() {
        return pubdate;
    }
 
    public void setPubdate(LocalDate pubdate) {
        this.pubdate = pubdate;
    }
 
    public void setPubdate(String pubdate)
    {
        this.pubdate = LocalDate.parse(pubdate);
    }
 
    public String getDescription()
    {
        return description;
    }
 
    public void setDescription(String description)
    {
        this.description = description;
    }
}