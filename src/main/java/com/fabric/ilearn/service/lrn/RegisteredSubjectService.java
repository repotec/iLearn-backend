package com.fabric.ilearn.service.lrn;

import com.fabric.ilearn.dao.lrn.RegisteredSubjectRepository;
import com.fabric.ilearn.dto.lrn.subject.RegisteredSubjectDto;
import com.fabric.ilearn.dto.lrn.subject.SubjectDto;
import com.fabric.ilearn.mapper.lrn.subject.RegisteredSubjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class RegisteredSubjectService {
    private RegisteredSubjectRepository registeredSubjectRepository;
    private RegisteredSubjectMapper registeredSubjectMapper;

    @Autowired
    public void setRegisteredSubjectRepository(RegisteredSubjectRepository registeredSubjectRepository) {
        this.registeredSubjectRepository = registeredSubjectRepository;
    }

    @Autowired
    public void setRegisteredSubjectMapper(RegisteredSubjectMapper registeredSubjectMapper) {
        this.registeredSubjectMapper = registeredSubjectMapper;
    }

    public List<SubjectDto> findAllRegisterSubjects(String localeCode, long semesterId){
        return registeredSubjectRepository.findAllBySemesterIdAndLrnSubjectLrnSubjectLocalesLocaleCode(semesterId,localeCode).stream().map(registeredSubjectMapper::registeredSubjectToRegisteredSubjectDto).collect(Collectors.toList());
    }

    public List<SubjectDto> findSubjectsByLocale(String localeCode){
        return registeredSubjectRepository.findAllByLrnSubjectLrnSubjectLocalesLocaleCode(localeCode).stream().map(registeredSubjectMapper::registeredSubjectToRegisteredSubjectDto).collect(Collectors.toList());
    }

    public List<SubjectDto> findBySubjectId(String localeCode, long subjectId){
        return registeredSubjectRepository.findAllBySubjectIdAndLrnSubjectLrnSubjectLocalesLocaleCode(subjectId,localeCode).stream().map(registeredSubjectMapper::registeredSubjectToRegisteredSubjectDto).collect(Collectors.toList());
    }

    public List<SubjectDto> getSubjectsBySemesterId(String localeCode, long semesterId){
        return registeredSubjectRepository.findAllBySemesterIdAndLrnSubjectLrnSubjectLocalesLocaleCode(semesterId,localeCode).stream().map(registeredSubjectMapper::registeredSubjectToRegisteredSubjectDto).collect(Collectors.toList());
    }
}
