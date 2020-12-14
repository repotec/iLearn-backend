package com.fabric.ilearn.mapper.lrn.subject;

import com.fabric.ilearn.dto.lrn.subject.SubjectDto;
import com.fabric.ilearn.model.lrn.subject.LrnSubject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = SubjectLocalMapper.class)
public interface SubjectMapper {
    @Mapping(target = "subjectId", source = "subjectId")
    @Mapping(target = "icon", source = "subjectIconPath")
    @Mapping(target = "locale", source = "lrnSubject.lrnSubjectLocales")
    SubjectDto lrnSubjectToSubjectDto(LrnSubject lrnSubject);
}
