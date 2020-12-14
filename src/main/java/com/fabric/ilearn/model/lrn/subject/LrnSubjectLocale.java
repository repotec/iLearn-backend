package com.fabric.ilearn.model.lrn.subject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "lrn_subject_locales")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LrnSubjectLocale implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "SUBJECT_LOCALE_ID")
    private long subjectLocaleId;

    @Column(name = "SUBJECT_ID", insertable = false, updatable = false)
    private long subjectId;

    @Column(name = "LOCALE_CODE")
    private String localeCode;

    @Column(name = "SUBJECT_DISPLAY_NAME")
    private String subjectDisplayName;

    @ManyToOne
    @JoinColumn(name = "SUBJECT_ID")
    private LrnSubject lrnSubject;
}
