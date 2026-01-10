package intro;

public class FlowControl {
    public static void main(String[] args) {
        // Example of a simple if-else statement
        boolean isRaining = false;
        if (isRaining) {
            System.out.println("\n \t It's raining. Don't forget to take an umbrella! \n ");
        } else {
            System.out.println("\n \t It's not raining. Enjoy your day! \n ");
        }

        // Example of a switch statement
        int day = 3;
        String dayName;
        switch (day) {
            case 1:
                dayName = "Monday";
                break;
            case 2:
                dayName = "Tuesday";
                break;
            case 3:
                dayName = "Wednesday";
                break;
            case 4:
                dayName = "Thursday";
                break;
            case 5:
                dayName = "Friday";
                break;
            case 6:
                dayName = "Saturday";
                break;
            case 7:
                dayName = "Sunday";
                break;
            default:
                dayName = "Invalid day";
        }

        // Looops
        System.out.println("Day of the week: " + dayName);
        for (int i = 1; i <= 5; i++) {
            System.out.println("Iteration: " + i);
        }

        // While loop example
        int count = 1;
        while (count <= 5) {
            System.out.println("Count: " + count);
            count++;
        }
    }
}
