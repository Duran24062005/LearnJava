package controller;

public class UserController {
    String name;

    public UserController(String name) {
        this.name = name;
    }

    public void great() {
        System.out.println("""
                Hola %s
                """.formatted(this.name));
    }
}
