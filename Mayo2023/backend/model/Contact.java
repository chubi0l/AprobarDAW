package Mayo2023.backend.model;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String description;

    private String phoneNumber;

    public Contact () {}

    public Contact (String name, String description, String phoneNumber) {
        super();

        this.name = name;
        this.description = description;
        this.phoneNumber = phoneNumber;
    }

    // Getter and Setter methods
}
