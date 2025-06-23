package Mayo2022.backend.controller;

import java.net.URI;
import java.util.List;

import Mayo2022.backend.dto.ConcertDTO;
import Mayo2022.backend.service.ConcertService;
import Mayo2023.backend.dto.ContactDTO;

@RestController
@RequestMapping("api/concerts")
public class ConcertRestController {
    
    @Autowired
    private ConcertService service;

    @GetMapping("/")
    public List<ConcertDTO> getConcerts() {
        return service.getConcerts();
    }

    @PostMapping("/")
    public ConcertDTO createConcert(@RequestBody ConcertDTO concertDTO) { 
        ConcertDTO concert = service.createConcert(concertDTO);

        if(concert == null){
            return new ResponseEntity<>(HttpsStatus.NOT_FOUND);
        } else {
            URI location = fromCurrentRequest().path("{id}").buildAndExpand(concert.id()).toUri();
            return ResponseEntity.created(location).body(concert);
        }
    }
}
