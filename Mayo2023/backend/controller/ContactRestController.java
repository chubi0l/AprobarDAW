package Mayo2023.backend.controller;

import java.net.URI;
import java.util.Collection;

import Mayo2023.backend.dto.ContactDTO;
import Mayo2023.backend.model.Contact;
import Mayo2023.backend.service.ContactService;

@RestController
@RequestMapping("/api/contacts")
public class ContactRestController {
    
    @Autowired
	private ContactService contactService;
    
    @GetMapping
    public Collection<ContactDTO> getContacts() {
        return contactService.getContacts();
    }

    @GetMapping("{id}")
    public ContactDTO getContact (@PathVariable Long id) {
        return contactService.getContact(id);
    }

    @PostMapping
    public ContactDTO createContact(@RequestBody ContactDTO contactDTO) {

        ContactDTO created = contactService.createContact(contactDTO);

        if (created == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        } else {
            URI location = fromCurrentRequest().path("/{id}").buildAndExpand(created.id()).toUri();

            return ResponseEntity.created(location).body(created);
        }
    }

    @DeleteMapping("/{id}")
    public ContactDTO deleteContact(@PathVariable Long id) {
        return contactService.deleteContact(id);
    }
    
}
