package com.fabric.ilearn.dto.lrn.subject;

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
public class SubjectDto extends RepresentationModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long subjectId;
    private String icon;
    private List<SubjectLocaleDto> locale;

}
