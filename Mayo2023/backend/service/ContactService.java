package Mayo2023.backend.service;

import java.util.Collection;

import Mayo2023.backend.dto.ContactDTO;
import Mayo2023.backend.dto.ContactMapper;
import Mayo2023.backend.model.Contact;
import Mayo2023.backend.repository.ContactRepository;

@Service
public class ContactService {
    @Autowired
    private ContactRepository repository;

    @Autowired
    private ContactMapper mapper;

    public Collection<ContactDTO> getContacts() {
		return toDTOs(repository.findByIdOrderByName());
	}

	public ContactDTO getContact(long id) {
		return toDTO(repository.findById(id).orElseThrow());
	}

	public ContactDTO createContact(ContactDTO contactDTO) {

		if (repository.findByName(contactDTO.name()).isPresent()) {
			return null;
		}

		Contact contact = toDomain(contactDTO);

		repository.save(repository);

		return toDTO(contact);
	}

    public ContactDTO deleteContact(long id) {

		Contact contact = repository.findById(id).orElseThrow();

		ContactDTO contactDTO = toDTO(contact);

		repository.deleteById(id);

		return contactDTO;
	}

	private ContactDTO toDTO(Contact contact) {
		return mapper.toDTO(contact);
	}

	private Contact toDomain(ContactDTO contactDTO) {
		return mapper.toDomain(contactDTO);
	}

	private Collection<ContactDTO> toDTOs(Collection<Contact> contacts) {
		return mapper.toDTOs(contacts);
	}
}
