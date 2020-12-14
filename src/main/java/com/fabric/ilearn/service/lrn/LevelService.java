package com.fabric.ilearn.service.lrn;

import com.fabric.ilearn.dao.lrn.LevelRepository;
import com.fabric.ilearn.dao.lrn.SemesterRepository;
import com.fabric.ilearn.dto.lrn.level.LevelDto;
import com.fabric.ilearn.dto.lrn.level.LevelSemesterDto;
import com.fabric.ilearn.dto.lrn.semester.SemesterDto;
import com.fabric.ilearn.mapper.lrn.level.LevelMapper;
import com.fabric.ilearn.mapper.lrn.level.LevelSemesterMapper;
import com.fabric.ilearn.mapper.lrn.semester.SemesterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class LevelService {

    private LevelRepository levelRepository;
    private SemesterRepository SemesterRepository;
    private LevelMapper levelMapper;
    private LevelSemesterMapper levelSemesterMapper;
    private SemesterMapper semesterMapper;

    @Autowired
    public void setSemesterRepository(SemesterRepository semesterRepository) {
        SemesterRepository = semesterRepository;
    }

    @Autowired
    public void setLevelMapper(LevelMapper levelMapper) {
        this.levelMapper = levelMapper;
    }

    @Autowired
    public void setLevelRepository(LevelRepository levelRepository) {
        this.levelRepository = levelRepository;
    }

    @Autowired
    public void setLevelSemesterMapper(LevelSemesterMapper levelSemesterMapper) {
        this.levelSemesterMapper = levelSemesterMapper;
    }

    @Autowired
    public void setSemesterMapper(SemesterMapper semesterMapper) {
        this.semesterMapper = semesterMapper;
    }

    public List<LevelSemesterDto> findAllByLrnLevelLocalesLocaleCode(String localCode){
        return levelRepository.findAllByLrnLevelLocalesLocaleCode(localCode).stream().map(levelSemesterMapper::LevelToLevelDto).collect(Collectors.toList());
    }

    public LevelDto findLevelById(String localeCode, long levelId){
        return levelMapper.LevelToLevelDto(levelRepository.findAllByLrnLevelLocalesLocaleCodeAndLevelId(localeCode, levelId));
    }

    public List<SemesterDto> findAllBySemesterLevelIdAndLocale(String localeCode, long semesterId){
        return SemesterRepository.findAllByLrnSemesterLocalesLocaleCodeAndSemesterId(localeCode, semesterId).stream().map(semesterMapper::semesterToSemesterDto).collect(Collectors.toList());
    }
}
