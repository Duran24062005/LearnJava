package Repositories;

public class Repository {

    String dbName;

    public Repository(String dbName) {
        this.dbName = dbName;
    }

    public void getData() {
        System.out.println("""
                Data obtenida
                """);
    }

    public void getDatoId(int id) {
        System.out.println("""
                Dat0 con id %s obtenido
                """.formatted(id));
    }

}
