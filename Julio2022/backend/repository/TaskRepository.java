package Julio2022.backend.repository;

public interface TaskRepository extends JPARepository <Task,Long>{
    public Optional<Task> findById(Long id);
    public List<Task> findAll();
}
