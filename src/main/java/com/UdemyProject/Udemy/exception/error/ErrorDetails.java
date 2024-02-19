package com.UdemyProject.Udemy.exception.error;

import java.time.LocalDateTime;

public record ErrorDetails(
        LocalDateTime timeStamp,

        String message,

        String details


) {
}
