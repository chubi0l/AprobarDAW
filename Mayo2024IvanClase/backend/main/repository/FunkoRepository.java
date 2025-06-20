package backend.main.controller.repository;

import java.util.List;

import backend.main.controller.model.Funko;

public interface FunkoRepository extends JpaRepository<Long, Funko>{
    public List<Funko> findByStatusOrderByPrice(FunkoState status);
}
