package backend.dto;

public record BookDTO (
    Long id,
    String title, 
    double price,
    boolean offer
) {
    
}
