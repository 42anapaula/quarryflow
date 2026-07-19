package com.ana.quarryflow.core.infrastructure.adapters.in.web.common;

import java.time.LocalDateTime;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import jakarta.servlet.http.HttpServletRequest;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(IllegalArgumentException.class)
    public ResponseEntity<ApiError> handleIllegalArgument(IllegalArgumentException ex, HttpServletRequest request) {
        ApiError error = new ApiError(
            LocalDateTime.now(),
            HttpStatus.BAD_REQUEST.value(),
            "Requisição Inválida",
            ex.getMessage(),
            request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(DataIntegrityViolationException.class)
    public ResponseEntity<ApiError> handleDataIntegrity(DataIntegrityViolationException ex, HttpServletRequest request) {
        String friendlyMessage = "Erro ao persistir os dados. Verifique o tamanho dos campos ou duplicidade.";
        
        String rootMessage = ex.getRootCause() != null ? ex.getRootCause().getMessage() : "";
        if (rootMessage != null && rootMessage.contains("value too long")) {
            if (rootMessage.contains("varying(7)") || rootMessage.contains("placa") || rootMessage.contains("plate")) {
                friendlyMessage = "A placa informada excede o tamanho máximo permitido de 7 caracteres.";
            } else if (rootMessage.contains("modelo") || rootMessage.contains("model")) {
                friendlyMessage = "O modelo informado excede o tamanho máximo de caracteres permitido.";
            } else {
                friendlyMessage = "Um ou mais campos informados excedem o tamanho máximo permitido no sistema.";
            }
        }

        ApiError error = new ApiError(
            LocalDateTime.now(),
            HttpStatus.BAD_REQUEST.value(),
            "Erro de Integridade de Dados",
            friendlyMessage,
            request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(error);
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiError> handleGenericException(Exception ex, HttpServletRequest request) {
        ApiError error = new ApiError(
            LocalDateTime.now(),
            HttpStatus.INTERNAL_SERVER_ERROR.value(),
            "Erro Interno do Servidor",
            "Ocorreu um erro inesperado no sistema. Tente novamente mais tarde.",
            request.getRequestURI()
        );
        return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(error);
    }
}
