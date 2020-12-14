package com.fabric.ilearn.service.adm;

import com.fabric.ilearn.dao.adm.AdmRoleRepository;
import com.fabric.ilearn.dto.adm.role.RoleDto;
import com.fabric.ilearn.mapper.adm.role.RoleMapper;
import com.fabric.ilearn.model.adm.AdmRole;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RoleService {
    @Autowired
    AdmRoleRepository roleRepository;

    @Autowired
    RoleMapper roleMapper;

    public List<RoleDto> findAll(){
        return roleRepository.findAll().stream().map(roleMapper::roleToRoleDto).collect(Collectors.toList());
    }

    public List<RoleDto> findAllRoleByLocaleCode(String localCode){
        return roleRepository.findAllByAdmRoleLocalesLocaleCode(localCode).stream().map(roleMapper::roleToRoleDto).collect(Collectors.toList());
    }

    public Optional<AdmRole> findById(long roleId){
        return roleRepository.findById(roleId);
    }
}
