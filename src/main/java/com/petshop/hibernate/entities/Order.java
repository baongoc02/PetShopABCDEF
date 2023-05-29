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
@Table(name="Orders", schema="dbo")
public class Order {
  private Integer id;
  private Date createdOn;
  private Date deletedOn;
  private Date deliveredAt;
  private Integer userId;
  private String fullName;
  private String phoneNumber;
  private String address;
  private String note;
  private String orderMethod;
  private String status;

  public Order() {
    
  }
  
  public Order(Date deliveredAt, Integer userId) {
    super();
    this.deliveredAt = deliveredAt;
    this.userId = userId;
    
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
  
  @Column(name="DeliveredAt")
  public Date getDeliveredAt() {
    return deliveredAt;
  }

  public void setDeliveredAt(Date deliveredAt) {
    this.deliveredAt = deliveredAt;
  }
  
  @Column(name="UserId")
  public Integer getUserId() {
    return userId;
  }

  public void setUserId(Integer userId) {
    this.userId = userId;
  }

  	@Column(name="FullName")
	public String getFullName() {
		return fullName;
	}
	
	public void setFullName(String fullName) {
		this.fullName = fullName;
	}
	
	@Column(name="PhoneNumber")
	public String getPhoneNumber() {
		return phoneNumber;
	}
	
	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}
	
	@Column(name="Address")
	public String getAddress() {
		return address;
	}
	
	public void setAddress(String address) {
		this.address = address;
	}
	
	@Column(name="Note")
	public String getNote() {
		return note;
	}
	
	public void setNote(String note) {
		this.note = note;
	}
	
	@Column(name="OrderMethod")
	public String getOrderMethod() {
		return orderMethod;
	}
	
	public void setOrderMethod(String orderMethod) {
		this.orderMethod = orderMethod;
	}
	
	@Column(name="Status")
	public String getStatus() {
		return status;
	}
	
	public void setStatus(String status) {
		this.status = status;
	}
}
