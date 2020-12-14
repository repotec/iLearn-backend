package com.fabric.ilearn.dto.lrn.semester;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SemesterLocaleDto implements Serializable {
    private static final long serialVersionUID = 1L;
    private String displayName;
}
