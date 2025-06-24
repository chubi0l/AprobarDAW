package backend.dto;

public interface BookMapper {
    public BookDTO toDTO(Book book);
    public List<BookDTO> toDTOs(List<Book> books);
    public Book toDomain(BookDTO bookDTO);
}
