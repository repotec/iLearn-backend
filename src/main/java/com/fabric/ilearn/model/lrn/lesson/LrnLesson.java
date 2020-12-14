package com.fabric.ilearn.model.lrn.lesson;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.util.List;
import javax.persistence.*;

@Entity
@Table(name="lrn_lessons")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LrnLesson implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "lesson_id")
    private Long lessonId;

    @Column(name = "lesson_url")
    private String lessonUrl;

    @Column(name = "registered_subject_id")
    private Long registeredSubjectId;

    @OneToMany(mappedBy = "lrnLesson")
    @JsonManagedReference
    private List<LrnLessonLocale> lrnLessonLocales;
}
