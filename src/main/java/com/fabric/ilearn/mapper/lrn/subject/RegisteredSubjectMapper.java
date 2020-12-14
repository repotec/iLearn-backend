package com.fabric.ilearn.mapper.lrn.subject;


import com.fabric.ilearn.dto.lrn.subject.SubjectDto;
import com.fabric.ilearn.model.lrn.subject.LrnRegisteredSubject;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper(componentModel = "spring", uses = {SubjectMapper.class, SubjectLocalMapper.class})
public interface RegisteredSubjectMapper {
    @Mapping(target = "subjectId", source = "lrnRegisteredSubject.registerSubjectId")
    @Mapping(target = "icon", source = "lrnRegisteredSubject.lrnSubject.subjectIconPath")
    @Mapping(target = "locale", source = "lrnRegisteredSubject.lrnSubject.lrnSubjectLocales")
    SubjectDto registeredSubjectToRegisteredSubjectDto(LrnRegisteredSubject lrnRegisteredSubject);
}