package com.fabric.ilearn.model.adm;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name="adm_user_roles")
@Getter
@Setter
@NoArgsConstructor
public class AdmUserRole implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="USER_ROLE_ID")
    private Long userRoleId;

    @Temporal(TemporalType.DATE)
    @Column(name="effective_start_date")
    private Date effectiveStartDate;

    @Temporal(TemporalType.DATE)
    @Column(name="effective_end_date")
    private Date effectiveEndDate;

    @ManyToOne
    @JoinColumn(name="ROLE_ID")
    private AdmRole admRole;

    @ManyToOne
    @JoinColumn(name="USER_ID")
    @JsonBackReference
    private AdmUser admUser;
}
