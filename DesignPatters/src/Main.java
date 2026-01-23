import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main extends JFrame {
    private JLabel welcomeLabel;
    private JTextField inputField;
    private JButton submitButton;
    private JTextArea outputArea;

    public Main() {
        // Configurar ventana principal
        setTitle("Design Patterns - UI Simple");
        setSize(500, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // Crear panel principal
        JPanel mainPanel = new JPanel(new BorderLayout(10, 10));
        mainPanel.setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
        mainPanel.setBackground(new Color(240, 240, 240));

        // Panel superior con etiqueta
        JPanel topPanel = new JPanel();
        topPanel.setBackground(new Color(70, 130, 180));
        welcomeLabel = new JLabel("Bienvenido a Design Patterns");
        welcomeLabel.setFont(new Font("Arial", Font.BOLD, 18));
        welcomeLabel.setForeground(Color.WHITE);
        topPanel.add(welcomeLabel);
        mainPanel.add(topPanel, BorderLayout.NORTH);

        // Panel central con entrada de texto
        JPanel centerPanel = new JPanel(new GridLayout(3, 1, 10, 10));
        centerPanel.setBackground(new Color(240, 240, 240));

        JLabel inputLabel = new JLabel("Ingresa tu nombre:");
        inputLabel.setFont(new Font("Arial", Font.PLAIN, 12));
        centerPanel.add(inputLabel);

        inputField = new JTextField();
        inputField.setFont(new Font("Arial", Font.PLAIN, 14));
        inputField.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        centerPanel.add(inputField);

        submitButton = new JButton("Enviar");
        submitButton.setFont(new Font("Arial", Font.BOLD, 12));
        submitButton.setBackground(new Color(70, 130, 180));
        submitButton.setForeground(Color.WHITE);
        submitButton.setFocusPainted(false);
        submitButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                handleSubmit();
            }
        });
        centerPanel.add(submitButton);
        mainPanel.add(centerPanel, BorderLayout.CENTER);

        // Panel inferior con área de salida
        JPanel bottomPanel = new JPanel(new BorderLayout());
        bottomPanel.setBackground(new Color(240, 240, 240));

        JLabel outputLabel = new JLabel("Salida:");
        outputLabel.setFont(new Font("Arial", Font.BOLD, 12));
        bottomPanel.add(outputLabel, BorderLayout.NORTH);

        outputArea = new JTextArea(6, 40);
        outputArea.setFont(new Font("Courier New", Font.PLAIN, 11));
        outputArea.setEditable(false);
        outputArea.setBorder(BorderFactory.createLineBorder(Color.GRAY, 1));
        outputArea.setBackground(Color.WHITE);

        JScrollPane scrollPane = new JScrollPane(outputArea);
        bottomPanel.add(scrollPane, BorderLayout.CENTER);
        mainPanel.add(bottomPanel, BorderLayout.SOUTH);

        add(mainPanel);
        setVisible(true);
    }

    private void handleSubmit() {
        String nombre = inputField.getText().trim();
        if (nombre.isEmpty()) {
            outputArea.setText("Error: Por favor ingresa tu nombre");
        } else {
            outputArea.append("¡Hola, " + nombre + "!\n");
            outputArea.append("Estás explorando Design Patterns en Java\n");
            outputArea.append("Patrón: " + obtenerPatronAleatorio() + "\n\n");
            inputField.setText("");
        }
    }

    private String obtenerPatronAleatorio() {
        String[] patrones = {
                "Singleton", "Factory", "Abstract Factory", "Builder",
                "Prototype", "Adapter", "Bridge", "Composite",
                "Decorator", "Facade", "Flyweight", "Proxy"
        };
        int random = (int) (Math.random() * patrones.length);
        return patrones[random];
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main());
    }
}