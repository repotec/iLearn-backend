package com.fabric.ilearn.model.lrn.lesson;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import javax.persistence.*;

@Entity
@Table(name="lrn_lesson_locales")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LrnLessonLocale implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "lesson_locale_id")
    private Long lessonLocaleId;

    @Column(name = "lesson_display_name")
    private String lessonDisplayName;

    @Column(name = "lesson_id", updatable = false, insertable = false)
    private Long lessonId;

    @Column(name = "locale_code")
    private String localeCode;

    @ManyToOne
    @JoinColumn(name="LESSON_ID")
    @JsonBackReference
    private LrnLesson lrnLesson;
}