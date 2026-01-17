package mock;

import model.BeneficiciarioModel;
import model.ColaboradorModel;
import model.EmpleadoModel;
import repository.PersonaRepository;
import service.PersonService;

public class UsersMock {
    public static void main(String[] args) {
        EmpleadoModel Alexi = new EmpleadoModel("Alexi", "Duran", 20, "1223456", "Calle 107 #22a - 33", 1300000,
                "junior", "8-5 pm");
        EmpleadoModel e1 = new EmpleadoModel(
                "Andres", "Diaz", 32, "CC2001", "Bogotá",
                2500000, "Desarrollador", "8-5 pm");

        EmpleadoModel e2 = new EmpleadoModel(
                "Laura", "Moreno", 29, "CC2002", "Medellín",
                2200000, "Diseñadora", "8-5 pm");

        EmpleadoModel e3 = new EmpleadoModel(
                "Camilo", "Ruiz", 45, "CC2003", "Cali",
                3000000, "Supervisor", "8-5 pm");

        EmpleadoModel e4 = new EmpleadoModel(
                "Paula", "Castro", 34, "CC2004", "Pereira",
                2100000, "Analista", "8-5 pm");

        EmpleadoModel e5 = new EmpleadoModel(
                "Sergio", "Vargas", 38, "CC2005", "Manizales",
                2800000, "Arquitecto", "8-5 pm");

        // Colaboradores
        ColaboradorModel c1 = new ColaboradorModel(
                "Diana", "Ramos", 22, "CC3001", "Bogotá", 10);

        ColaboradorModel c2 = new ColaboradorModel(
                "Felipe", "Navarro", 27, "CC3002", "Medellín", 15);

        ColaboradorModel c3 = new ColaboradorModel(
                "Natalia", "Suarez", 31, "CC3003", "Cali", 20);

        ColaboradorModel c4 = new ColaboradorModel(
                "Juan", "Mendoza", 24, "CC3004", "Ibagué", 8);

        ColaboradorModel c5 = new ColaboradorModel(
                "Valentina", "Ortiz", 29, "CC3005", "Neiva", 25);

        // Beneficiarios
        BeneficiciarioModel b1 = new BeneficiciarioModel(
                "Pedro", "Sanchez", 60, "CC4001", "Bogotá", 2);

        BeneficiciarioModel b2 = new BeneficiciarioModel(
                "Rosa", "Jimenez", 55, "CC4002", "Medellín", 3);

        BeneficiciarioModel b3 = new BeneficiciarioModel(
                "Manuel", "Torres", 70, "CC4003", "Cali", 5);

        BeneficiciarioModel b4 = new BeneficiciarioModel(
                "Elena", "Pineda", 48, "CC4004", "Cartagena", 1);

        BeneficiciarioModel b5 = new BeneficiciarioModel(
                "Oscar", "Herrera", 65, "CC4005", "Santa Marta", 4);

        Alexi.introduceOneself();
        PersonaRepository repo = new PersonaRepository();
        PersonService service = new PersonService(repo);
        service.regiterPerson(Alexi);
        service.regiterPerson(e1);
        service.regiterPerson(e2);
        service.regiterPerson(e3);
        service.regiterPerson(e4);
        service.regiterPerson(e5);
        service.regiterPerson(c1);
        service.regiterPerson(c2);
        service.regiterPerson(c3);
        service.regiterPerson(c4);
        service.regiterPerson(c5);
        service.regiterPerson(b1);
        service.regiterPerson(b2);
        service.regiterPerson(b3);
        service.regiterPerson(b4);
        service.regiterPerson(b5);
        service.showPerson();
        service.showStatistics();
    }
}
