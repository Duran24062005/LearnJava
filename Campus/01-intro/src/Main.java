//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // TIP Press <shortcut actionId="ShowIntentionActions"/> with your caret at the
        // highlighted text
        // to see how IntelliJ IDEA suggests fixing it.
        int myNumber = 30;
        long bigNum = 2000000;
        double decimal = 56.7;
        String nombre = "Alexi";
        int[] newInt = new int[5];
        boolean isAvailable = true;
        System.out.printf("Hello and welcome!");

        for (int i = 1; i <= 5; i++) {
            // TIP Press <shortcut actionId="Debug"/> to start debugging your code. We have
            // set one <icon src="AllIcons.Debugger.Db_set_breakpoint"/> breakpoint
            // for you, but you can always add more by pressing <shortcut
            // actionId="ToggleLineBreakpoint"/>.
            System.out.println("i = " + i);

        }
        System.out.println("Alexi Durán Gómez en Java" + myNumber + bigNum + nombre + newInt + decimal + isAvailable);
    }
}