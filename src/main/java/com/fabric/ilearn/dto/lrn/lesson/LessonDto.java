package com.fabric.ilearn.dto.lrn.lesson;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LessonDto extends RepresentationModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long lessonId;
    private String url;
    private List<LessonLocaleDto> locale;
}
