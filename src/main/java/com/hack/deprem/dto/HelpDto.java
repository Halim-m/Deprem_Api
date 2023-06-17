package com.hack.deprem.dto;

import com.hack.deprem.model.Help;
import com.hack.deprem.model.Product;

import java.util.List;

public record HelpDto(
        String location,

        List<Product> product
) {
    public static HelpDto convert(Help help){
        return new HelpDto(help.getLocation(), help.getProduct());
    }
}
