package Mayo2023.backend.repository;

import java.util.List;
import java.util.Optional;

import Mayo2023.backend.model.Contact;

public interface ContactRepository extends JpaRepository <Long,Contact>{
    public List<Contact> findByIdOrderByName(Long id);
    public Optional<Contact> findByName(String name);
    public Optional<Contact> findById(Long id);
}
