package com.fabric.ilearn.dto.adm.principle;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class UserPrincipleDTO {
    private String userName;
    private String password;
    private String token;
    private List<UserRolePrincipleDTO> userRolesPrinciple;
}
