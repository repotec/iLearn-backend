package com.fabric.ilearn.dto.lrn.level;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.hateoas.RepresentationModel;

import java.io.Serializable;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class LevelSemesterDto extends RepresentationModel implements Serializable {
    private static final long serialVersionUID = 1L;

    private long levelId;
    private String icon;
    private List<LevelLocaleDto> locale;


}
