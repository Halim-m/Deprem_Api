package com.hack.deprem.dto;

import com.hack.deprem.model.Help;
import com.hack.deprem.model.Product;

import java.util.List;

public record HelpDto(
        String lat,
        String lon,

        Product product
) {
    public static HelpDto convert(Help help){
        String[] parts = help.getLocation().split("-");

        String lat = parts[0];
        String lon = parts[1];
        return new HelpDto(lat, lon, help.getProduct());
    }
}
