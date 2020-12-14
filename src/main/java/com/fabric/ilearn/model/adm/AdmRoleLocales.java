package com.fabric.ilearn.model.adm;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import com.fasterxml.jackson.annotation.JsonBackReference;

import java.io.Serializable;

@Entity
@Table(name="adm_role_locales")
@NoArgsConstructor
@Getter
@Setter
public class AdmRoleLocales implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="ADM_ROLE_LOCALE_ID")
    private Long admRoleLocaleId;

    @Column(name="LOCALE_CODE")
    private String localeCode;

    @Column(name="ROLE_ID", insertable = false, updatable = false)
    private Long roleId;

    @Column(name="ROLE_DISPLAY_NAME")
    private String roleDisplayName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="ROLE_ID")
    @JsonBackReference
    private AdmRole admRole;
}
