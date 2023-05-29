package com.petshop.hibernate.entities;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.persistence.UniqueConstraint;

@Entity
@Table(name="ProductImages", schema="dbo")
public class ProductImage {
  private Integer id;
  private Date createdOn;
  private Date deletedOn;
  private Integer order;
  private String productImageLink;
  private Integer productId;
  

  public ProductImage() {
    
  }
  
  public ProductImage(Integer order, String productImageLink, Integer productId) {
    super();
    this.order = order;
    this.productImageLink = productImageLink;
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
  
  @Column(name="[Order]")
  public Integer getOrder() {
    return order;
  }

  public void setOrder(Integer order) {
    this.order = order;
  }
  
  @Column(name="ProductImageLink")
  public String getProductImageLink() {
    return productImageLink;
  }

  public void setProductImageLink(String productImageLink) {
    this.productImageLink = productImageLink;
  }
  
  @Column(name="ProductId")
  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }
  
}