package com.petshop.hibernate.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="ProductDescriptions", schema="dbo")
public class ProductDescription {
  private Integer id;
  private Date createdOn;
  private Date deletedOn;
  private String type;
  private Integer order;
  private String content;
  private Integer productId;
  

  public ProductDescription() {
    
  }
  
  public ProductDescription(String type, Integer order, String content, Integer productId) {
    super();
    this.type = type;
    this.order = order;
    this.content = content;
    this.productId = productId; 
  }
  
  @Id
  @Column(name="Id")
  @GeneratedValue(strategy=GenerationType.IDENTITY)
  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }
  
  @Column(name="CreatedOn")
  public Date getCreatedOn() {
    return createdOn;
  }

  public void setCreatedOn(Date createdOn) {
    this.createdOn = createdOn;
  }
  
  @Column(name="DeletedOn")
  public Date getDeletedOn() {
    return deletedOn;
  }

  public void setDeletedOn(Date deletedOn) {
    this.deletedOn = deletedOn;
  }
  
  @Column(name="Type")
  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }
  
  @Column(name="[Order]")
  public Integer getOrder() {
    return order;
  }

  public void setOrder(Integer order) {
    this.order = order;
  }
  
  @Column(name="Content")
  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }
  
  @Column(name="ProductId")
  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }
  
}