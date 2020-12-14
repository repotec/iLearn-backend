package com.fabric.ilearn.model.adm;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name="adm_roles")
@Getter
@Setter
@NoArgsConstructor
public class AdmRole implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="ROLE_ID")
    private Long roleId;

    @Column(name="ROLE_NAME")
    private String roleName;

    @Temporal(TemporalType.DATE)
    @Column(name="EFFECTIVE_START_DATE")
    private Date effectiveStartDate;

    @Temporal(TemporalType.DATE)
    @Column(name="EFFECTIVE_END_DATE")
    private Date effectiveEndDate;

    @OneToMany(mappedBy = "admRole")
    @JsonManagedReference
    private List<AdmRoleLocales> admRoleLocales;
}