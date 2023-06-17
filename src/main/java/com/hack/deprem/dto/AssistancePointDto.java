package com.hack.deprem.dto;

import com.hack.deprem.model.AssistancePoint;
import com.hack.deprem.model.Product;

import java.util.List;

public record AssistancePointDto(
        String lat,
        String lon,
        List<Product> onRoad,
        List<Product> need
) {
    public static AssistancePointDto convert(AssistancePoint assistancePoint){
        String[] parts = assistancePoint.getLocation().split("-");

        String lat = parts[0];
        String lon = parts[1];
        return new AssistancePointDto(lat, lon, assistancePoint.getOnRoad(), assistancePoint.getNeed());
    }
}
