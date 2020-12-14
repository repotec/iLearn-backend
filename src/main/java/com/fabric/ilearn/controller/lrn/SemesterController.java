package com.fabric.ilearn.controller.lrn;

import com.fabric.ilearn.dto.lrn.semester.SemesterDto;
import com.fabric.ilearn.service.lrn.RegisteredSubjectService;
import com.fabric.ilearn.service.lrn.SemesterService;
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
@RequestMapping(produces = {"application/json", "application/hal+json"}, value = "/semesters")
public class SemesterController {
    Logger logger = LoggerFactory.getLogger(SemesterController.class);

    private SemesterService semesterService;
    private RegisteredSubjectService registeredSubjectService;

    @Autowired
    public void setRegisteredSubjectService(RegisteredSubjectService registeredSubjectService) {
        this.registeredSubjectService = registeredSubjectService;
    }

    @Autowired
    public void setSemesterService(SemesterService semesterService) {
        this.semesterService = semesterService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{localeCode}")
    public ResponseEntity<?> getAllSemesters(@PathVariable Optional<String> localeCode){
        logger.info("start");
        String locale = localeCode.isPresent() ? localeCode.get() : "en";

        List<SemesterDto> semesters = semesterService.findAllLrnLevelSemestersLocaleCode(locale);
        semesters.forEach(semester -> {
            semester.add(linkTo(methodOn(SemesterController.class).getAllSemestersById(Optional.of(locale), semester.getSemesterId())).withSelfRel());
            semester.add(linkTo(methodOn(SemesterController.class).getSemesterSubjectsBySemesterId(Optional.of(locale), semester.getSemesterId())).withRel("subjects"));
        });
        return new ResponseEntity<>(semesters, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{localeCode}/{semesterId}")
    public ResponseEntity<?> getAllSemestersById(@PathVariable Optional<String> localeCode, @PathVariable long semesterId){
        logger.info("start");
        String locale = localeCode.isPresent() ? localeCode.get() : "en";
        List<SemesterDto> semesters = semesterService.findAllSemestersByIdAndLocaleCode(locale, semesterId);
        semesters.forEach(semester -> {
            semester.add(linkTo(methodOn(SemesterController.class).getAllSemestersById(Optional.of(locale), semester.getSemesterId())).withSelfRel());
            semester.add(linkTo(methodOn(SemesterController.class).getSemesterSubjectsBySemesterId(Optional.of(locale), semester.getSemesterId())).withRel("subjects"));
        });

        return new ResponseEntity<>(semesters, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "{localeCode}/{semesterId}/subjects")
    public ResponseEntity<?> getSemesterSubjectsBySemesterId(@PathVariable Optional<String> localeCode, @PathVariable long semesterId){
        String locale = localeCode.isPresent() ? localeCode.get() : "en";
        return new ResponseEntity<>(registeredSubjectService.getSubjectsBySemesterId(locale, semesterId), HttpStatus.OK);
    }

}
