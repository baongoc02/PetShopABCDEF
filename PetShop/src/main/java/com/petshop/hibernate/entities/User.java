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
@Table(name="Users", schema="dbo")
public class User {
  private Integer id;
  private Date createdOn;
  private Date deletedOn;
  private String username;
  private String password;
  private String fullName;
  private String role;
  private String address;
  private String phoneNumber;
  

  public User() {
    
  }
  
  public User(String username, String password, String fullName, String role, String address, String phoneNumber) {
    super();
    this.username = username;
    this.password = password;
    this.fullName = fullName;
    this.role = role;
    this.address = address;
    this.phoneNumber = phoneNumber;
    
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
  
  @Column(name="Username")
  public String getUsername() {
    return username;
  }

  public void setUsername(String username) {
    this.username = username;
  }
  
  @Column(name="Password")
  public String getPassword() {
    return password;
  }

  public void setPassword(String password) {
    this.password = password;
  }
  
  @Column(name="FullName")
  public String getFullName() {
    return fullName;
  }

  public void setFullName(String fullName) {
    this.fullName = fullName;
  }
  
  @Column(name="Role")
  public String getRole() {
    return role;
  }

  public void setRole(String role) {
    this.role = role;
  }
  
  @Column(name="Address")
  public String getAddress() {
    return address;
  }

  public void setAddress(String address) {
    this.address = address;
  }
  
  @Column(name="PhoneNumber")
  public String getPhoneNumber() {
    return phoneNumber;
  }

  public void setPhoneNumber(String phoneNumber) {
    this.phoneNumber = phoneNumber;
  }
  
}