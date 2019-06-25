package com.lambdaschool.ruralSchools.controllers;

import com.lambdaschool.ruralSchools.models.Condition;
import com.lambdaschool.ruralSchools.services.ConditionService;
import io.swagger.annotations.ApiModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ConditionController {
    @Autowired
    private ConditionService conditionService;

    private static final Logger logger = LoggerFactory.getLogger(ConditionController.class);

    @GetMapping(value = "/condition", produces = {"application/json"})
    public ResponseEntity<?> listAllAuthors(@PageableDefault(page = 0, size = 5)Pageable pageable) {
        logger.trace("/condition accessed");

        List<Condition> myCondition = conditionService.findAll(pageable);
        return new ResponseEntity<>(myCondition, HttpStatus.OK);
    }
}