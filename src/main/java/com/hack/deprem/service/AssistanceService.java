package com.hack.deprem.service;

import com.hack.deprem.dto.request.CreateAssistanceRequest;
import com.hack.deprem.dto.request.CreateProductRequest;
import com.hack.deprem.model.Assistance;
import com.hack.deprem.model.Help;
import com.hack.deprem.model.Product;
import com.hack.deprem.repository.AssistanceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AssistanceService {
    private final AssistanceRepository assistanceRepository;
    private final ProductService productService;

    public AssistanceService(AssistanceRepository assistanceRepository,
                             ProductService productService) {
        this.assistanceRepository = assistanceRepository;
        this.productService = productService;
    }

    public void createAssistance(CreateAssistanceRequest assistanceRequest,
                                 CreateProductRequest productRequest){
        Assistance assistance;
        if(assistanceRepository.existsByFromCity(assistanceRequest.from())){
            assistance = assistanceRepository.getAssistanceByFromCity(assistanceRequest.from());
        }else{

            assistance = new Assistance(assistanceRequest.from());
        }
        Product product = productService.createProduct(productRequest);
        List<Product> products = assistance.getProduct();
        products.add(product);
        Assistance updatedAssistance = new Assistance(
                assistance.getUuid(),
                products,
                assistance.getFromCity(),
                assistance.getToLocation());

        assistanceRepository.save(updatedAssistance);
    }

    public void routeAssistance(String toLocation){}
}
