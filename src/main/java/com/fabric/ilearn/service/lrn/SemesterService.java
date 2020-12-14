package com.fabric.ilearn.service.lrn;

import com.fabric.ilearn.dao.lrn.SemesterRepository;
import com.fabric.ilearn.dto.lrn.semester.SemesterDto;
import com.fabric.ilearn.mapper.lrn.semester.SemesterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class SemesterService {

    private SemesterRepository semesterRepository;
    private SemesterMapper semesterMapper;

    @Autowired
    public void setSemesterRepository(SemesterRepository semesterRepository) {
        this.semesterRepository = semesterRepository;
    }

    @Autowired
    public void setSemesterMapper(SemesterMapper semesterMapper) {
        this.semesterMapper = semesterMapper;
    }

    public List<SemesterDto> findAllLrnLevelSemestersLocaleCode(String localeCode) {
        return semesterRepository.findAllByLrnSemesterLocalesLocaleCode(localeCode).stream().map(semesterMapper::semesterToSemesterDto).collect(Collectors.toList());
    }

    public List<SemesterDto> findAllSemestersByIdAndLocaleCode(String localeCode, long semesterId) {
        return semesterRepository.findAllByLrnSemesterLocalesLocaleCodeAndSemesterId(localeCode, semesterId).stream().map(semesterMapper::semesterToSemesterDto).collect(Collectors.toList());
    }
}
