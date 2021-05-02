package com.example.AlkemyLabs.controller;

import com.example.AlkemyLabs.model.Role;
import com.example.AlkemyLabs.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/role")
public class RoleController {
    private RoleService rolService;
    @Autowired
    public RoleController(RoleService rolService){
        this.rolService=rolService;
    }

    @PostMapping("/")
    public void addCurrency(@RequestBody Role role){
        rolService.addRole(role);
    }

    @GetMapping()
    public List<Role> getAll(){
        return rolService.getAll();
    }

    @GetMapping("/{id}")
    public Role getById(@PathVariable Integer id) throws Throwable {
        return rolService.getById(id);
    }
    @DeleteMapping("/{id}")
    public void deleteCurrenty(@PathVariable Integer id){
        rolService.delete(id);
    }

}
