package Mayo2023.backend.model;

@Entity
public class Contact {
    @Id
    @GeneratedValue(strategy = generatedType.AUTO)
    private Long id

    private String name;

    private String description;

    private int phoneNumber;

    public Contact () {}

    public Contact (String name, String description, int phoneNumber) {
        super();

        this.name = name;
        this.description = description;
        this.phoneNumber = phoneNumber;
    }

    // Getter and Setter methods
}
