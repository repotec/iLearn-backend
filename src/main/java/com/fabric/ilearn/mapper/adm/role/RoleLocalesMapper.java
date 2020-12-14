package com.fabric.ilearn.mapper.adm.role;

import com.fabric.ilearn.dto.adm.role.RoleLocales;
import com.fabric.ilearn.model.adm.AdmRoleLocales;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RoleLocalesMapper {
    RoleLocales admRoleToRoleLocales(AdmRoleLocales admRoleLocales);
    AdmRoleLocales roleLocalesToAdmRole(RoleLocales roleLocales);
}
