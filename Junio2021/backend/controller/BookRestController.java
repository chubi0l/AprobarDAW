package backend.controller;

import backend.service.BookService;

@RestController
@RequestMapping("/api/v1/books")
public class BookRestController {
    
    @Autowired
    private BookService service;

    @GetMapping("/")
    public List<BookDTO> getBooks() {
        return service.getBooks();
    }
    
    @GetMapping("/{title}")
    public List<BookDTO> searchBook(String title) {
        return service.searchBook(title);
    }
}
