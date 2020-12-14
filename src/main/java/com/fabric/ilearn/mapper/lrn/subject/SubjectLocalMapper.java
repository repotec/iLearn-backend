package com.fabric.ilearn.mapper.lrn.subject;

import com.fabric.ilearn.dto.lrn.subject.SubjectLocaleDto;
import com.fabric.ilearn.model.lrn.subject.LrnSubjectLocale;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface SubjectLocalMapper {
    @Mapping(target = "displayName", source = "subjectDisplayName")
    SubjectLocaleDto subjectLocalToSubjectLocaleDto(LrnSubjectLocale lrnSubjectLocale);
}
