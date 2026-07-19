package com.ana.quarryflow.core.infrastructure.adapters.in.web.common;

import java.time.LocalDateTime;

public record ApiError(
    LocalDateTime timestamp,
    int status,
    String error,
    String message,
    String path
) {}