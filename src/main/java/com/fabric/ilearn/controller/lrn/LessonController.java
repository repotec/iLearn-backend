package com.fabric.ilearn.controller.lrn;

import com.fabric.ilearn.dto.lrn.lesson.LessonDto;
import com.fabric.ilearn.service.lrn.LessonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.methodOn;

@RestController
@RequestMapping(produces = {"application/json", "application/hal+json"}, value = "/lessons")
public class LessonController {

    private LessonService lessonService;

    @Autowired
    public void setLessonService(LessonService lessonService) {
        this.lessonService = lessonService;
    }

    @RequestMapping(method = RequestMethod.GET, value = "/{localeCode}/{registeredSubject}")
    public ResponseEntity<?> findAllByLocaleCode(@PathVariable Optional<String> localeCode, @PathVariable long registeredSubject){
        String locale = localeCode.isPresent() ? localeCode.get() : "en";
        List<LessonDto> lessons = lessonService.findAllByLocaleCodeAndRegisteredSubjectId(locale, registeredSubject);
        lessons.forEach(lesson ->{
            lesson.add(linkTo(methodOn(LessonController.class).findAllByLocaleCode(Optional.of(locale), registeredSubject)).withSelfRel());
        });
        return new ResponseEntity<>(lessons, HttpStatus.OK);
    }
}
