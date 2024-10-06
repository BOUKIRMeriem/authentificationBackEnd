package com.example.authentification.Controller;

import com.example.authentification.DTO.RoleDto;
import com.example.authentification.Entity.RoleEntity;
import com.example.authentification.Service.RoleService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@CrossOrigin("*")
@RequestMapping("/role")
@RequiredArgsConstructor
@RestController
public class RoleController {
    private final RoleService roleService;

    @GetMapping("/list")
    public List<RoleDto> getAll(){

        return roleService.getAll();
    }
}
