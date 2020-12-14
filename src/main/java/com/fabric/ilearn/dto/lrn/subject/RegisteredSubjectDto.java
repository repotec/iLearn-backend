package com.fabric.ilearn.dto.lrn.subject;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RegisteredSubjectDto implements Serializable {
    private static final long serialVersionUID = 1L;

    private SubjectDto subject;
}
