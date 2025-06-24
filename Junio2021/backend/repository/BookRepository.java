package backend.repository;

public interface BookRepository extends JPARepository <Book,Long>{
    public Book findById(Long id);
    public List<Book> findAll();
    public List<Book> findByTitleOrderByPrice(String title);
}
