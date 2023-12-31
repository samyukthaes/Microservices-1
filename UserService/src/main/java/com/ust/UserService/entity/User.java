package com.ust.UserService.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class User {

  @Id
  @GeneratedValue
  private long uid;
  private String uName;
  private String uAddress;
  private long departmentId;
}
