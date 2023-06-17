package com.hack.deprem.controller;

import com.hack.deprem.dto.request.CreateAssistanceRequest;
import com.hack.deprem.service.AssistanceService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/v1/Assistance")
public class AssistanceController {
    private final AssistanceService assistanceService;

    public AssistanceController(AssistanceService assistanceService) {
        this.assistanceService = assistanceService;
    }

}