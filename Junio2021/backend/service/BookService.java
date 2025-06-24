package backend.service;

import backend.dto.BookMapper;
import backend.repository.BookRepository;

@Service
public class BookService {
    
    @Autowired
    private BookRepository repository;

    @Autowired
    private BookMapper mapper;

    public List<BookDTO> getBooks() {
        return mapper.toDTOs(repository.findAll());
    }

    public List<BookDTO> searchBook(String title) {
        return mapper.toDTOs(repository.findByTitleOrderByPrice(title));
    }
}
