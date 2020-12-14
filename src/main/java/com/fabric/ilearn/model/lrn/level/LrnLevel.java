package com.fabric.ilearn.model.lrn.level;

import com.fabric.ilearn.model.lrn.semester.LrnSemester;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="lrn_levels")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LrnLevel implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="LEVEL_ID")
    private long levelId;

    @Column(name="LEVEL_ICON_PATH")
    private String levelIconPath;

    @OneToMany(mappedBy="lrnLevel", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<LrnLevelLocale> lrnLevelLocales;

    @OneToMany(mappedBy = "lrnLevel", fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<LrnSemester> lrSemesters;
}
