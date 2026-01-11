package HouseExample;

public class House {
    private int doors;
    private int windows;
    private double size;

    public House() {
    }

    public House(int doors, int windows, double size) {
        this.doors = doors;
        this.windows = windows;
        this.size = size;
    }

    public void setDoors(int doors) {
        this.doors = doors;
    }

    public int getDoors() {
        return doors;
    }

    public void setWindows(int windows) {
        this.windows = windows;
    }

    public int getWindows() {
        return windows;
    }

    public void setSize(double size) {
        if (size > 0) {
            this.size = size;
        } else {
            System.out.println("El tamaño debe ser mayor a 1.");
        }
    }

    public double getSize() {
        return size;
    }

    public void openDoor() {
        System.out.println("La puerta astá abierta.");
    }

    public double calcularArea() {
        return size * size;
    }
}
