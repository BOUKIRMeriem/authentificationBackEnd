package com.example.authentification.Service.Imp;

import com.example.authentification.DTO.RoleDto;
import com.example.authentification.Entity.RoleEntity;
import com.example.authentification.Repository.RoleRepository;
import com.example.authentification.Service.RoleService;
import com.example.authentification.mapper.RoleMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class RoleServiceImp implements RoleService {
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;
    @Override
    public List<RoleDto> getAll() {
        List<RoleEntity> roleEntity = roleRepository.findAll();
        return roleEntity.stream().map(roleMapper ::roleEntityToRoleDto).collect(Collectors.toList());

    }
}
