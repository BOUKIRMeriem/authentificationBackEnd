package com.example.authentification.mapper;

import com.example.authentification.DTO.RoleDto;
import com.example.authentification.Entity.RoleEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleMapper {

    RoleDto roleEntityToRoleDto(RoleEntity roleEntity);
}
