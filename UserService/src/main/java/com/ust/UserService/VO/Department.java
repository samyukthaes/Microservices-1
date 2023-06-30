package com.ust.UserService.VO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;

import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department{
  @Id
  @GeneratedValue
  private Long departmentId;
  private String departmentName;
  private String departmentCode;
}
