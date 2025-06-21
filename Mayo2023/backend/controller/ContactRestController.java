package Mayo2023.backend.controller;

import java.util.Collection;

import Mayo2023.backend.dto.ContactDTO;
import Mayo2023.backend.service.ContactService;

@RestController
@RequestMapping("/api/contacts")
public class ContactRestController {
    
    @Autowired
	private ContactService contactService;
    
    @GetMapping
    public Collection<ContactDTO> showContacts() {
        return contactService.getContacts();
    }

    @PostMapping
    public ContactDTO createContact(@RequestBody ContactDTO contactDTO) {
        // ¿no vale solo con?: return contactService.createContact(contactDTO);

        ContactDTO created = contactService.createContact(contactDTO);

        if (created == null) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        }

        return ResponseEntity.ok(created);
    }

    @DeleteMapping("/{id}")
    public void deleteContact(@PathVariable Long id) {
        contactService.deleteContact(id);
    }
    
}
