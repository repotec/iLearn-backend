package com.fabric.ilearn.model.adm;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="adm_users")
@Getter
@Setter
@NoArgsConstructor
@NamedEntityGraph(name = "userPrinciple-graph",
        attributeNodes = @NamedAttributeNode(value = "admUserRoles", subgraph = "role-subgraph"),
        subgraphs = @NamedSubgraph(name = "role-subgraph", attributeNodes = @NamedAttributeNode("admRole")))
public class AdmUser implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="USER_ID")
    private Long userId;

    @Column(name="USER_NAME")
    private String userName;

    @Column(name="PASSWORD")
    private String password;

    @Column(name="USER_AVATAR")
    private String userAvatar;

    @OneToMany(mappedBy="admUser", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<AdmUserRole> admUserRoles;
}
