package com.example.authentification.Service;

import com.example.authentification.DTO.RoleDto;
import com.example.authentification.Entity.RoleEntity;

import java.util.List;

public interface RoleService {
    List<RoleDto> getAll();
}
