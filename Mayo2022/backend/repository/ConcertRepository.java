package Mayo2022.backend.repository;

public interface ConcertRepository extends JPARepository<Concert,Long>{
    public Concert findById(Long id);
    public List<Concert> findAll();
}
