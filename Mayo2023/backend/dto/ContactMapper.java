package Mayo2023.backend.dto;

public interface ContactMapper {
    public List<ContactDTO> toDTOs(List<Contact> contacts);
    public Contact toDomain(ContactDTO contact);
}
