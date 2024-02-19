package com.ms.email.dtos;

import java.util.UUID;

public record EmailRecord(
        UUID userId,
        String emailTo,
        String subject,
        String message) {
}
