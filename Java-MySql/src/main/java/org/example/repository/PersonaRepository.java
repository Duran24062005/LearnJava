package org.example.repository;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import org.example.config.MysqlConnection;
import org.example.interfaces.IPersonaRepository;
import org.example.model.Persona;

public class PersonaRepository implements IPersonaRepository {

    @Override
    public boolean crearPersona(Persona persona) {
        String sql = "INSERT INTO personas (nombre, apellido, edad) VALUES (?, ?, ?)";

        try (Connection conn = MysqlConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql)) {

            ps.setString(1, persona.getNombre());
            ps.setInt(2, persona.getEdad());
            ps.setString(3, persona.getApellido());

            ps.executeUpdate();
            return true;

        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    @Override
    public List<Persona> listarPersona() {
        List<Persona> personas = new ArrayList<>();
        String sql = "SELECT * FROM personas";

        try (Connection conn = MysqlConnection.getConnection();
                PreparedStatement ps = conn.prepareStatement(sql);
                ResultSet rs = ps.executeQuery()) {

            while (rs.next()) {
                Persona persona = new Persona(rs.getString("nombre"), rs.getString("apellido"), rs.getInt("edad"));
                personas.add(persona);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return personas;
    }

    @Override
    public Persona buscarPersonaPorId(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'buscarPersonaPorId'");
    }

    @Override
    public boolean actualizarPersona(Persona persona, int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'actualizarPersona'");
    }

    @Override
    public boolean eliminarPersona(int id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'eliminarPersona'");
    }

}
