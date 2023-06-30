package com.ust.DepartmentService.Entity;

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
public class Department {
  @Id
  @GeneratedValue
  private Long departmentId;
  private String departmentName;
  private String departmentCode;
}
