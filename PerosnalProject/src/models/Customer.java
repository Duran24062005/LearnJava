package models;

/**
 * Representa un cliente del sistema
 */
public class Customer {
    private String id;
    private String name;
    private String email;
    private CustomerTier tier;

    public Customer(String id, String name, String email, CustomerTier tier) {
        this.id = id;
        this.name = name;
        this.email = email;
        this.tier = tier;
    }

    // Getters
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public CustomerTier getTier() {
        return tier;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", tier=" + tier +
                '}';
    }
}
