package com.fabric.ilearn.mapper.adm.principle;

import com.fabric.ilearn.dto.adm.principle.UserRolePrincipleDTO;
import com.fabric.ilearn.model.adm.AdmUserRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring",  uses = RolePrincipleMapper.class)
public interface UserRolePrincipleMapper {
    @Mapping(target = "rolePrinciple", source = "admUserRole.admRole")
    UserRolePrincipleDTO userRoleToUserRolePrinciple(AdmUserRole admUserRole);
}
