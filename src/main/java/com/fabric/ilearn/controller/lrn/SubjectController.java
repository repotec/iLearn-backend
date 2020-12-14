package com.fabric.ilearn.controller.lrn;

import com.fabric.ilearn.dao.lrn.LessonRepository;
import com.fabric.ilearn.dto.lrn.subject.SubjectDto;
import com.fabric.ilearn.service.lrn.LessonService;
import com.fabric.ilearn.service.lrn.RegisteredSubjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;


@RestController
@RequestMapping(produces = {"application/json", "application/hal+json"}, value = "/subjects")
public class SubjectController {
    Logger logger = LoggerFactory.getLogger(SubjectController.class);

    private RegisteredSubjectService registeredSubjectService;
    private LessonService lessonService;

    @Autowired
    public void setLessonService(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @Autowired
    public void setRegisteredSubjectService(RegisteredSubjectService registeredSubjectService) {
        this.registeredSubjectService = registeredSubjectService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{localeCode}/{semesterId}")
    public ResponseEntity<?> findSubjectById(@PathVariable Optional<String> localeCode, @PathVariable long semesterId){
        logger.info("start");
        String locale = localeCode.isPresent() ? localeCode.get() : "en";
        List<SubjectDto> subjects = registeredSubjectService.getSubjectsBySemesterId(locale, semesterId);

        subjects.forEach(subject -> {
            subject.add(linkTo(methodOn(SubjectController.class).findSubjectById(Optional.of(locale), subject.getSubjectId())).withSelfRel());
            subject.add(linkTo(methodOn(SubjectController.class).getLessonsForSubject(Optional.of(locale), subject.getSubjectId())).withRel("lessons"));
        });

        return new ResponseEntity<>(subjects, HttpStatus.OK);
    }

    @RequestMapping(method = RequestMethod.GET, value = "{localeCode}/{subjectRegisteredId}/lessons")
    public ResponseEntity<?> getLessonsForSubject(@PathVariable Optional<String> localeCode, @PathVariable long subjectRegisteredId) {
        logger.info("start");
        String locale = localeCode.isPresent() ? localeCode.get() : "en";

        return new ResponseEntity<>(lessonService.findAllByLocaleCodeAndRegisteredSubjectId(locale, subjectRegisteredId), HttpStatus.OK);
    }
}
