package models;

/**
 * Niveles de membresía del cliente
 */
public enum CustomerTier {
    BRONZE(0.0), // Sin descuento
    SILVER(0.05), // 5% descuento
    GOLD(0.10); // 10% descuento

    private final double discount;

    CustomerTier(double discount) {
        this.discount = discount;
    }

    public double getDiscount() {
        return discount;
    }
}
