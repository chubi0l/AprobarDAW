package Mayo2022.backend.controller;

import java.util.List;

import Mayo2022.backend.service.ConcertService;
import Mayo2023.backend.model.Contact;

@Controller
public class ConcertController {
    
    @Autowired
    private ConcertService service;

    @GetMapping("/")
    public String getConcerts() {
        List<Concert> concerts = service.getConcerts();
		model.addAttribute("concerts", concerts);
		model.addAttribute("concerts", new Concert());

        service.getConcerts();

        return "index.html";
    }

    @PostMapping("/createConcert")
    public String createConcert(Concert concert) {
        Concert createdConcert = service.createConcert(concert);

        if (createdConcert == null) {
            return "error";
        } else {
            return "redirect:/";
        }
        
    }
}
