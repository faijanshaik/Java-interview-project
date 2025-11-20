package main.java.com.faijanshaikh.switchCases;

public class AllSwitchCasesExamples {

    public static void main(String[] args) {

        AllSwitchCasesExamples traditional = new AllSwitchCasesExamples();
        traditional.traditionalSwitchCase();
    }

    //Traditional Switch Cases (Java 1.0)
    public void traditionalSwitchCase() {
        int day = 2;

        switch (day) {
            case 1:
                System.out.println("Monday");
                break;
            case 2:
                System.out.println("TuesDay");
                break;
            case 3:
                System.out.println("Wednesday");
                break;
            case 4:
                System.out.println("Thursday");
                break;
            case 5:
                System.out.println("Friday");
                break;
            case 6:
                System.out.println("Saturday");
                break;
            default:
                System.out.println("Sunday");
                break;
        }
    }

    //Swith with String (Java 7)
    public void swithWithString() {
        String flower = "Rose";

        switch (flower) {
            case "Rose":
                System.out.println("Rose Flower");
                break;
            case "jasmine":
                System.out.println("Jamine Flower");
                break;
            case "Lotus":
                System.out.println("Lotus Flower");
                break;
            case "Tulip":
                System.out.println("Tulip Flower");
                break;
            case "Lavender":
                System.out.println("Lavender Flower");
                break;
            default:
                System.out.println("Other Flower");
                break;
        }
    }

    //Enhanced SwithcExpression(java 14+ ,stabilized from java 17)
    public void enhancedSwitchExpression() {
        String flower = "Lavender";

        String result = switch (flower) {
            case "Rose", "jasmine" -> "smelled flowers";
            case "Lotus", "Tulip" -> "smell-less flowers";
            default -> "Other Flowers";
        };
    }

    public void switchWithYield() {
        String flower = "Lavender";

        String result = switch (flower) {
            case "Rose", "jasmine" -> "smelled flowers";
            case "Lotus", "Tulip" -> {
                System.out.println("smell less flowers");
                yield "Lotus and Tulip";
            }
            default -> "Other Flowers";
        };
    }
}
