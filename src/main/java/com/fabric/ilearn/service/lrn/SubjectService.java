package com.fabric.ilearn.service.lrn;

import com.fabric.ilearn.dao.lrn.SubjectRepository;
import com.fabric.ilearn.dto.lrn.subject.RegisteredSubjectDto;
import com.fabric.ilearn.dto.lrn.subject.SubjectDto;
import com.fabric.ilearn.mapper.lrn.subject.SubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SubjectService {
    @Autowired
    SubjectRepository subjectRepository;

    @Autowired
    SubjectMapper subjectMapper;

    public List<SubjectDto> findAllByLrnSubjectLocalesLocaleCode(String localeCode){
        return subjectRepository.findAllByLrnSubjectLocalesLocaleCode(localeCode).stream().map(subjectMapper::lrnSubjectToSubjectDto).collect(Collectors.toList());
    }

}
