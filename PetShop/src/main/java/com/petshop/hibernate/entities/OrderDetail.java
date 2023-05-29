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
@Table(name="OrderDetails", schema="dbo")
public class OrderDetail {
  private Integer id;
  private Date createdOn;
  private Date deletedOn;
  private Integer quantity;
  private Integer orderId;
  private Integer productId;
  

  public OrderDetail() {
    
  }
  
  public OrderDetail(Integer quantity, Integer orderId, Integer productId) {
    super();
    this.quantity = quantity;
    this.orderId = orderId;
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
  
  @Column(name="Quantity")
  public Integer getQuantity() {
    return quantity;
  }

  public void setQuantity(Integer quantity) {
    this.quantity = quantity;
  }
  
  @Column(name="OrderId")
  public Integer getOrderId() {
    return orderId;
  }

  public void setOrderId(Integer orderId) {
    this.orderId = orderId;
  }
  
  @Column(name="ProductId")
  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }
  
}