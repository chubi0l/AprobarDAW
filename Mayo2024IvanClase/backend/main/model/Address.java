package backend.main.model;

import backend.main.controller.model.Funko;

@Entity
public class Address {
    
    @Id
    @GeneratedValue(...) // strategy = GenerationType.IDENTITY
    private Long id;
    private String address;

    @OneToOne
    private Funko funko;

    // Constructores, getters, setters
}
