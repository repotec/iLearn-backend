package com.fabric.ilearn.model.lrn.semester;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name="lrn_semester_locales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LrnSemesterLocale implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name="semester_Locale_id")
    private Long semesterLocaleId;

    @Column(name="semester_id", insertable = false, updatable = false)
    private Long semesterId;

    @Column(name="locale_code")
    private String localeCode;

    @Column(name="semester_display_name")
    private String semesterDisplayName;

    @ManyToOne
    @JoinColumn(name="semester_id")
    @JsonBackReference
    private LrnSemester lrnSemester;
}
