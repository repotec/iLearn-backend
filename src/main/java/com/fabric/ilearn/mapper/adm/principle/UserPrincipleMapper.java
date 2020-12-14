package com.fabric.ilearn.mapper.adm.principle;

import com.fabric.ilearn.dto.adm.principle.UserPrincipleDTO;
import com.fabric.ilearn.model.adm.AdmUser;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = UserRolePrincipleMapper.class)
public interface UserPrincipleMapper {
    @Mapping(target = "userName", source = "userName")
    @Mapping(target = "password", source = "password")
    @Mapping(target = "userRolesPrinciple", source = "admUser.admUserRoles")
    UserPrincipleDTO UserToUserPrinciple(AdmUser admUser);
}