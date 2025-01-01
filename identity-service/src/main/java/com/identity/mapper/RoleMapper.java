package com.identity.mapper;

import com.identity.entity.Role;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import com.identity.dto.request.RoleRequest;
import com.identity.dto.response.RoleResponse;

@Mapper(componentModel = "spring")
public interface RoleMapper {
    @Mapping(target = "permissions", ignore = true)
    Role toRole(RoleRequest request);

    RoleResponse toRoleResponse(Role role);
}
