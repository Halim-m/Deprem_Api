package com.hack.deprem.service;


import com.hack.deprem.dto.HelpDto;
import com.hack.deprem.dto.request.CreateHelpRequest;
import com.hack.deprem.model.Help;
import com.hack.deprem.model.Product;
import com.hack.deprem.repository.HelpRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HelpService {
    private final HelpRepository helpRepository;
    private final ProductService productService;

    public HelpService(HelpRepository helpRepository, ProductService productService) {
        this.helpRepository = helpRepository;
        this.productService = productService;
    }

    public List<HelpDto> getHelps(){
        return helpRepository.findAll().stream().map(HelpDto::convert).toList();
    }
    public List<HelpDto> getHelpsByLocation(String location){
        return helpRepository.getHelpsByLocation(location).stream().map(HelpDto::convert).toList();
    }

    public void createHelp(CreateHelpRequest helpRequest){
        Product product = productService.createProduct(helpRequest.productName(), helpRequest.number(), helpRequest.isHuman(), helpRequest.phoneNumber());
        Help help = new Help(helpRequest.location(), product); //Todo
        helpRepository.save(help);
    }
}
