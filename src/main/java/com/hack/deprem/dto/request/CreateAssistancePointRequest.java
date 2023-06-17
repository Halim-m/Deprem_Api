package com.hack.deprem.dto.request;

import org.hibernate.validator.constraints.UniqueElements;

public record CreateAssistancePointRequest(
        @UniqueElements
        String location
) {
}
