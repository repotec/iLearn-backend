package com.fabric.ilearn.model.lrn.subject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "lrn_subjects")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LrnSubject implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="subject_id")
    private Long subjectId;

    @Column(name="subject_icon_path")
    private String subjectIconPath;

    @OneToMany(mappedBy="lrnSubject")
    private List<LrnRegisteredSubject> lrnRegisteredSubjects;

    @OneToMany(mappedBy = "lrnSubject")
    private List<LrnSubjectLocale> lrnSubjectLocales;
}