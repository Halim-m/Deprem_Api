package com.hack.deprem.dto;

import com.hack.deprem.model.AssistancePoint;
import com.hack.deprem.model.Help;
import com.hack.deprem.model.Product;

import java.util.List;

public record AssistancePointDto(
        String location,
        List<Product> stock,
        List<Product> onRoad,
        List<Product> need
) {
    public static AssistancePointDto convert(AssistancePoint assistancePoint){
        return new AssistancePointDto(assistancePoint.getLocation(), assistancePoint.getStock(), assistancePoint.getOnRoad(), assistancePoint.getNeed());
    }
}
