package backend.main.dto;

import backend.main.model.FunkoState;

public record FunkoDTO (
    Long id,
    String name,
    double price,
    FunkoState status
)