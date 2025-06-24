package Mayo2023.backend.controller;

import java.util.List;

import Mayo2023.backend.model.Contact;
import Mayo2023.backend.service.ContactService;
// Imports

@Controller
public class ContactController {
    @Autowired
	private ContactService contactService;

	@GetMapping("/")
	public String showContacts() {
		List<Contact> contacts = contactService.getContacts();
		model.addAttribute("contacts", contacts);

		return "index";
	}

	@PostMapping("/createContact")
	public String createContact(Contact contact) {
		Contact createdContact = contactService.createContact(contact);

		if (createdContact == null) {
			return "error";
		} else {
			return "redirect:/";
		}
	}

	@GetMapping("/deleteContact/{id}")
	public String deleteContact(@PathVariable Long id) {
		Contact deletedContact = contactService.deleteContact(id);

		if (deletedContact == null) {
			return "error";
		} else {
			return "redirect:/";
		}
	}
}