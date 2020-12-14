package com.fabric.ilearn.dto.lrn.lesson;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.io.Serializable;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class LessonLocaleDto  implements Serializable {
    private static final long serialVersionUID = 1L;

    private String displayName;
}
