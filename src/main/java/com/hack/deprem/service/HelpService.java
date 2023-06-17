package com.hack.deprem.service;


import com.hack.deprem.dto.HelpDto;
import com.hack.deprem.dto.request.CreateHelpRequest;
import com.hack.deprem.dto.request.CreateProductRequest;
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

    public void createHelp(CreateHelpRequest helpRequest, CreateProductRequest productRequest){
        Product product = productService.createProduct(productRequest);
        Help help = new Help(helpRequest.location()); //Todo
        List<Product> products = help.getProduct();
        products.add(product);
        Help updatedHelp = new Help(help.getUuid(), help.getLocation(), products);
        helpRepository.save(updatedHelp);
    }


}
