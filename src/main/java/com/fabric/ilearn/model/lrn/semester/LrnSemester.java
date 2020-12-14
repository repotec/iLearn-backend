package com.fabric.ilearn.model.lrn.semester;

import com.fabric.ilearn.model.lrn.level.LrnLevel;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name="lrn_semesters")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LrnSemester implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="semester_id")
    private Long semesterId;

    @Column(name="semester_from")
    private String semesterFrom;

    @Column(name="semester_to")
    private String semesterTo;

    @Column(name="level_id", updatable = false, insertable = false)
    private long levelId;

    @OneToMany(mappedBy="lrnSemester")
    @JsonManagedReference
    private List<LrnSemesterLocale> lrnSemesterLocales;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "level_id")
    @JsonBackReference
    private LrnLevel lrnLevel;
}
