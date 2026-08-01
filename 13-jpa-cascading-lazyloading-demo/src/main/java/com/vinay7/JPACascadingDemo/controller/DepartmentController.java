package com.vinay7.JPACascadingDemo.controller;



import com.vinay7.JPACascadingDemo.model.Department;
import com.vinay7.JPACascadingDemo.service.DepartmentService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/department")
public class DepartmentController {
    private DepartmentService departmentService;

    public DepartmentController(DepartmentService departmentService){
        this.departmentService=departmentService;
    }

    @PostMapping
    public ResponseEntity<String> createDepartment(@RequestBody Department department){
        departmentService.createDepartment(department);
        return ResponseEntity.ok("DONE");
    }

    @DeleteMapping("/{deptId}")
    public ResponseEntity<String> deleteDepartment(@PathVariable Long deptId){
        departmentService.removeDepartment(deptId);
        return ResponseEntity.ok("DONE");
    }


}
