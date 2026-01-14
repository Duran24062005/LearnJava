package string;

public class MetodosString {
    public MetodosString() {
        // Método length()
        String text = "Hola, mundo!";
        System.out.println("Longitud: " + text.length()); // 12

        // Método charAt(int index)
        System.out.println("Carácter en la posición 2: " + text.charAt(2)); // 'l'

        // Método substring(int beginIndex, int endIndex)
        System.out.println("Subcadena: " + text.substring(0, 5)); // "Hola,"

        // Métodos toUpperCase() y toLowerCase()
        System.out.println("Mayúsculas: " + text.toUpperCase()); // "HOLA, MUNDO!"
        System.out.println("Minúsculas: " + text.toLowerCase()); // "hola, mundo!"

        // Método equals(Object obj)
        String text1 = "Hola";
        String text2 = "hola";
        System.out.println("¿Son iguales? " + text1.equals(text2)); // false

        // Método equalsIgnoreCase(String str)
        System.out.println("¿Son iguales (ignorando mayúsculas)? " + text1.equalsIgnoreCase(text2)); // true

        // Método contains(CharSequence s)
        System.out.println("¿Contiene 'mundo'? " + text.contains("mundo")); // true

        // Método replace(char oldChar, char newChar)
        System.out.println("Reemplazado: " + text.replace('o', 'a')); // "Hala, munda!"

        // Método trim()
        String textWithSpaces = "   Hola, mundo!   ";
        System.out.println("Trimmed: " + textWithSpaces.trim()); // "Hola, mundo!"

        // Método split(String regex)
        String csvText = "Uno,Dos,Tres";
        String[] parts = csvText.split(",");
        String[] parts2 = { "Uno", "Dos", "Tres", "Cuatro" };
        System.out.println("Dividido:");

        for (String part : parts) {
            System.out.println(part);
        }

        // Salida:
        // Uno
        // Dos
        // Tres
    }
}
