package com.fabric.ilearn.dto.adm.role;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.sql.Date;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class RoleDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private String roleName;
    private Date effectiveStartDate;
    private Date effectiveEndDate;

    private List<RoleLocales> roleLocales;
}
