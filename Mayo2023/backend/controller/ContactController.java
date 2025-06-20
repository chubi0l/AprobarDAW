package Mayo2023.backend.controller;

import Mayo2023.backend.service.ContactService;
// Imports

@Controller
public class ContactController {
    @Autowired
	private ContactService contactService;

	@GetMapping("/")
	public String showContacts() {
		contactService.getContacts();

		return "index";
	}

	@PostMapping("/createContact")
	public String createContact(Contact contact) {
		Contact createdContact = contactService.createContact(contact);

		if (createdContact == null) {
			return "redirect:/error";
		} else {
			return "redirect:/";
		}
	}

	@GetMapping("/deleteContact/{id}")
	public String deleteContact(@PathVariable Long id) {
		Contact deletedContact = contactService.deleteContact(id);

		if (deletedContact == null) {
			return "redirect:/error";
		} else {
			return "redirect:/";
		}
	}

	@GetMapping("/error")
	public String showError() {
		return "error";
	}
}