package com.ust.DepartmentService.Controller;

import com.ust.DepartmentService.Entity.Department;
import com.ust.DepartmentService.Repo.DepartmentRepo;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.Path;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/department")
public class DepartmentController {

  @Autowired
  private DepartmentRepo repo;

  @PostMapping("/")
  public ResponseEntity<Department> saveDepartment(@RequestBody Department department){
    return ResponseEntity.ok().body(repo.save(department));
  }

  @GetMapping("/all")
  public ResponseEntity<List<Department>> getAll(){
    return ResponseEntity.ok().body(repo.findAll());
  }

  @GetMapping("/{id}")
    public ResponseEntity<Department> getById(@PathVariable  long departmentId){
    Optional<Department> dept=repo.findBydepartmentId(departmentId);
    if(dept.isEmpty()){

      return ResponseEntity.noContent().build();

    }
    return ResponseEntity.ok().body(dept.get());
  }



}
