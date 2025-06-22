package Mayo2021.backend.repository;

public interface RoomScheduleRepository extends JPARepository<RoomSchedule,Long>{
    public Optional<RoomSchedule> findById(Long id);
    public List<RoomSchedule> findAll();    
}
