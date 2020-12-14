package com.fabric.ilearn.mapper.adm.principle;


import com.fabric.ilearn.dto.adm.principle.RolePrincipleDTO;
import com.fabric.ilearn.model.adm.AdmRole;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface RolePrincipleMapper {
    RolePrincipleDTO roleToRolePrinciple(AdmRole admRole);
}
