package Mayo2023.backend.repository;

import java.util.List;
import java.util.Optional;

import Mayo2023.backend.model.Contact;

public interface ContactRepository extends JpaRepository <Contact,Long>{
    public List<Contact> findByIdOrderByName();
    public Optional<Contact> findByName(String name);
    public Optional<Contact> findById(Long id);
}
