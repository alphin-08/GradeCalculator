import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        options();
    }

    public static void options() {
        Scanner console = new Scanner(System.in);
        System.out.println("Enter 1: Grade Calculator");
        System.out.println("Enter 2: Final Grade Calculator");
        System.out.println("Enter 3: To quit");
        int option = console.nextInt();

        if (option == 1) {
            display();
        } else if (option == 2) {
            display2();
        } else if (option == 3) {
            System.out.println("GoodBye");
        } else {
            System.out.println("Invalid input");
            options();
        }
    }
    
    public static void display() {
        System.out.println("*****GRADE CALCULATOR*****");
        System.out.println();
        userInputs();
    }

    public static void userInputs() {
        Scanner console = new Scanner(System.in);

        System.out.println("How many grade categories? ");
        int categories = console.nextInt();

        double totalWeight = 0;
        double remainingWeight = 0;
        double remainingWeight2 = 0;
        double finalGradeGoal = 0;
        double finalGradeGoal2 = 0;
        double totalWeightedPtsEarned = 0;

        System.out.println("Enter the assignments along with grade and weight");
        for (int i = 1; i < categories + 1; i++) {

            System.out.println(i + " Assignment:");
            String assignment = console.nextLine();
            console.nextLine();
            System.out.println("Grade");
            double grade = console.nextDouble();

            System.out.println("Weight");
            double weight = console.nextDouble();

            totalWeight += weight;
            totalWeightedPtsEarned += (weight / 100 * grade);
        }
            if (totalWeight >= 100) {
                System.out.println("Weight cannot be greater than 100 percent");
                options();
            }

        remainingWeight = 100 - totalWeight;
        remainingWeight2 = remainingWeight / 100;

        System.out.println("Weight of remaining task is " + remainingWeight + " What is your Final Grade Goal ? ");
        finalGradeGoal = console.nextInt();
        finalGradeGoal2 = finalGradeGoal;

        calculateGrade(totalWeightedPtsEarned, remainingWeight, remainingWeight2, finalGradeGoal, finalGradeGoal2);
    }

    public static void calculateGrade(double totalWegihtPtsEarned, double remainingWeight, double remainingWeight2,
            double finalGradeGoal, double finalGradeGoal2) {

        finalGradeGoal2 -= totalWegihtPtsEarned;
        finalGradeGoal2 /= remainingWeight2;

        if(finalGradeGoal2 > 0){
            System.out.println("A grade of " + finalGradeGoal2 + " is needed for the remaining " + remainingWeight
                    + " of tasks to ensure a final grade of " + finalGradeGoal);
        }else{
            System.out.println("A grade of " + finalGradeGoal
                    + " will be obtained even if 0 is attained for the remaining " + remainingWeight
                    + " of tasks ");
        }
        System.out.println();
        options();
    }
    /*
     * FINAL GRADE CALCULATOR
     */
    public static void display2() {
        System.out.println("*****Final GRADE CALCULATOR*****");
        System.out.println();
        userInputs2();
    }

    public static void userInputs2() {
        Scanner console = new Scanner(System.in);

        System.out.println("Your current grade: ");
        double grade = console.nextDouble();
        System.out.println("The grade you want: ");
        double gradeWanted = console.nextDouble();
        System.out.println("Your final is worth: ");
        double finalWorth = console.nextDouble();

        double finalgrade = (grade * (100-finalWorth) + gradeWanted*finalWorth)/100;
        calculateGrade2(finalgrade, gradeWanted);
    }

    public static void calculateGrade2(double finalGrade, double gradeWanted) {
        if(finalGrade > 0) {
            System.out.println("You will need a grade of " + finalGrade + " or higher on the final to achieve a " + gradeWanted);
        }else{
            System.out.println("A grade of " + gradeWanted +
                    " will be obtained even if 0 is attained on the final");
        }
        System.out.println();
        options();
    }
    
    public static void menu() {
        options();
    }
}

