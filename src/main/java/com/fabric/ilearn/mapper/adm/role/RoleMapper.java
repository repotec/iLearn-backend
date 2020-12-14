package com.fabric.ilearn.mapper.adm.role;

import com.fabric.ilearn.dto.adm.role.RoleDto;
import com.fabric.ilearn.model.adm.AdmRole;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = RoleLocalesMapper.class)
public interface RoleMapper {
    @Mapping(target = "roleName", source = "roleName")
    @Mapping(target = "effectiveStartDate", source = "effectiveStartDate")
    @Mapping(target = "effectiveEndDate", source = "effectiveEndDate")
    @Mapping(target = "roleLocales", source = "admRole.admRoleLocales")
    RoleDto roleToRoleDto(AdmRole admRole);
}
