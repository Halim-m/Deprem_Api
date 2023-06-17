package com.hack.deprem.service;

import com.hack.deprem.dto.AssistancePointDto;
import com.hack.deprem.dto.request.CreateAssistancePointRequest;
import com.hack.deprem.model.AssistancePoint;
import com.hack.deprem.repository.AssistancePointRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssistancePointService {
    private final AssistancePointRepository assistancePointRepository;

    public AssistancePointService(AssistancePointRepository assistancePointRepository) {
        this.assistancePointRepository = assistancePointRepository;
    }

    public void createAssistancePoint(CreateAssistancePointRequest request){
        AssistancePoint assistancePoint = new AssistancePoint(request.location());
        assistancePointRepository.save(assistancePoint);
    }

    public List<AssistancePointDto> getPoints(){
        return assistancePointRepository.findAll().stream().map(AssistancePointDto::convert).toList();
    }

    public AssistancePointDto getPoint(String location){
        return AssistancePointDto.convert(assistancePointRepository.getAssistancePointByLocation(location));
    }
}
