package LIncensesManager;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFileChooser;

public class GestionLicencias {
    private ArrayList<Licencia> licencias = new ArrayList<>();
    private final String ARCHIVO = "licencias.dat";

    public void cargar() {
        File f = new File(ARCHIVO);
        if (!f.exists()) {
            return;
        }
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(ARCHIVO))) {
            licencias = (ArrayList<Licencia>) ois.readObject();
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    public void guardar() {
        try (ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
            oss.writeObject(licencias);
        } catch (Exception e) {
            System.out.println(e);
        }
    }

    // Constructor
    public GestionLicencias() {
        this.cargar();
    }

    // Administrar lisata
    public void registrar(Licencia l) {
        licencias.add(l);
    }

    public void listar() {
        if (licencias.isEmpty()) {
            System.out.println("No hay licencias");
            return;
        }
        for (Licencia l : licencias) {
            System.out.println(l);
        }
    }

    public void buscar(int cedula) {
        for (Licencia l : licencias) {
            if (l.getPersona().getCedula().equals(cedula)) {
                System.out.println(l);
            }
        }
    }

    public void eliminar(String cedula) {
        for (Licencia l : licencias) {
            if (l.getPersona().getCedula().equals(cedula)) {
                licencias.remove(l);
            }
        }
    }

    public void exportarBackup() {
        JFileChooser j = new JFileChooser();
        j.setDialogTitle("Escoja la ruta a guardar.");
        int op = j.showSaveDialog(j);
        if (op == JFileChooser.APPROVE_OPTION) {
            File destino = j.getSelectedFile();
            try (ObjectOutputStream oss = new ObjectOutputStream(new FileOutputStream(ARCHIVO))) {
                oss.writeObject(licencias);
                System.out.println("Base de datos exportada correctamente.");
            } catch (Exception e) {
                // TODO: handle exception
            }
        }
    }
}
