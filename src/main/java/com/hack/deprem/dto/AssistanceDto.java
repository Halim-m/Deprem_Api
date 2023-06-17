package com.hack.deprem.dto;

import com.hack.deprem.model.Assistance;
import com.hack.deprem.model.Product;

import java.util.Collections;
import java.util.List;

public record AssistanceDto(
        List<Product> product,
        int fromCity,
        String toLocation

) {
    public static AssistanceDto convert(Assistance assistance){
        return new AssistanceDto(Collections.emptyList(), assistance.getFromCity(), assistance.getToLocation());
    }
}
