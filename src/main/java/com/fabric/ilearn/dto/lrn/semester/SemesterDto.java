package com.fabric.ilearn.dto.lrn.semester;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.Date;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SemesterDto extends RepresentationModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private Long semesterId;
    private String semesterFrom;
    private String semesterTo;
    private List<SemesterLocaleDto> locale;
}
