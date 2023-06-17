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
        String lat;
        String lon;
        if(!help.getLocation().isEmpty()){
            String[] parts = help.getLocation().split("-");

            lat = parts[0];
            lon = parts[1];
        }
        else{
            lat = "-1";
            lon = "-1";
        }
        return new HelpDto(lat, lon, help.getProduct());
    }
}
