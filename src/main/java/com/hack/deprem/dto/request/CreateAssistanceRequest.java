package com.hack.deprem.dto.request;


public record CreateAssistanceRequest(
        short from,
        String productName,
        int number,
        boolean isHuman,
        String phoneNumber
        ) {

}
