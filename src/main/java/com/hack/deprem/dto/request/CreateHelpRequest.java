package com.hack.deprem.dto.request;


public record CreateHelpRequest(
        String location,
        String productName,
        int number,
        boolean isHuman,
        String phoneNumber
) {
}
