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
@Table(name="CategoryProducts", schema="dbo")
public class CategoryProduct {
  private Integer id;
  private Date createdOn;
  private Date deletedOn;
  private Integer categoryId;
  private Integer productId;
  

  public CategoryProduct() {
    
  }
  
  public CategoryProduct(Integer categoryId, Integer productId) {
    super();
    this.categoryId = categoryId;
    this.productId = productId;
    
  }
  
  @ManyToOne
  @JoinColumn(name="ProductId", nullable=true)
  private Product product;
  
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
  
  @Column(name="CategoryId")
  public Integer getCategoryId() {
    return categoryId;
  }

  public void setCategoryId(Integer animalId) {
    this.categoryId = animalId;
  }
  
  @Column(name="ProductId")
  public Integer getProductId() {
    return productId;
  }

  public void setProductId(Integer productId) {
    this.productId = productId;
  }
  
}