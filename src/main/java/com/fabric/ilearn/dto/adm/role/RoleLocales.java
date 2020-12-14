package com.fabric.ilearn.dto.adm.role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoleLocales implements Serializable {
    private static final long serialVersionUID = 1L;

    private String roleDisplayName;
}
