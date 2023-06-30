package com.ust.UserService.controller;

import com.ust.UserService.VO.Department;
import com.ust.UserService.VO.ResponseTemplateVO;
import com.ust.UserService.entity.User;
import com.ust.UserService.repo.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {

  @Autowired
  private UserRepo userRepo;

  @Autowired
  private RestTemplate restTemplate;

  @PostMapping("/d")
  public ResponseEntity<User> saveUser(@RequestBody User user){
    return ResponseEntity.ok().body(userRepo.save(user));
  }

  @GetMapping("/getallusers")
  public ResponseEntity<List<User>> getall(){
    return ResponseEntity.ok().body(userRepo.findAll());
  }
  @GetMapping("/getuser")
  public ResponseEntity<ResponseTemplateVO> getUserWithDept(@PathVariable long uid){
    ResponseTemplateVO op=new ResponseTemplateVO();
    User user=userRepo.findByUid(uid);
    if(user==null){
      return ResponseEntity.noContent().build();
    }
    Department department=restTemplate.getForObject("http://DEPARTMENT/department/"+user.getUid(), Department.class);
    op.setUser(user);
    op.setDepartment(department);
    return  ResponseEntity.ok().body(op);


  }


}
