package com.fabric.ilearn.controller.lrn;

import com.fabric.ilearn.dto.lrn.level.LevelDto;
import com.fabric.ilearn.dto.lrn.level.LevelSemesterDto;
import com.fabric.ilearn.dto.lrn.semester.SemesterDto;
import com.fabric.ilearn.service.lrn.LevelService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping(produces = {"application/json", "application/hal+json"}, value = "/levels")
public class LevelController {
    Logger logger = LoggerFactory.getLogger(LevelController.class);

    private LevelService levelService;

    @Autowired
    public void setLevelService(LevelService levelService) {
        this.levelService = levelService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{localeCode}")
    public ResponseEntity<List<LevelSemesterDto>> findAllLevels(@PathVariable Optional<String> localeCode){
        logger.info("findAllLevels");

        String locale = localeCode.isPresent() ? localeCode.get() : "en";

        List<LevelSemesterDto> levels = levelService.findAllByLrnLevelLocalesLocaleCode(locale);
        levels.forEach(level -> {
            level.add(linkTo(methodOn(LevelController.class).findLevelByIdAndLocale(Optional.of(locale), level.getLevelId())).withSelfRel());
            level.add(linkTo(methodOn(LevelController.class).findAllBySemesterLevelIdAndLocale(locale, level.getLevelId())).withRel("semesters"));
        });

        return new ResponseEntity<>(levels, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{localeCode}/{levelId}")
    public ResponseEntity<LevelDto> findLevelByIdAndLocale(@PathVariable Optional<String> localeCode, @PathVariable long levelId) {
        logger.info("findLevelByIdAndLocale");
        String locale = localeCode.isPresent() ? localeCode.get() : "en";
        LevelDto level = levelService.findLevelById(locale, levelId);
        level.add(linkTo(methodOn(LevelController.class).findLevelByIdAndLocale(Optional.of(locale), level.getLevelId())).withSelfRel());
        level.add(linkTo(methodOn(LevelController.class).findAllBySemesterLevelIdAndLocale(locale, level.getLevelId())).withRel("semesters"));

        return new ResponseEntity<>(level, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "{localeCode}/{levelId}/semesters")
    public ResponseEntity<?> findAllBySemesterLevelIdAndLocale(@PathVariable String localeCode, @PathVariable long levelId){
        logger.info("start");
        List<SemesterDto> semesters = levelService.findAllBySemesterLevelIdAndLocale(localeCode, levelId);
        return new ResponseEntity<>(semesters, HttpStatus.OK);
    }
}
