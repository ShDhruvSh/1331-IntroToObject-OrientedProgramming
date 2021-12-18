public class Collatz {
    public static void main(String[] args) {
        int collatzNum = 16;
        int numSteps = 0;
        int highestNumReached = collatzNum;
        int initValue = collatzNum;

        System.out.println(collatzNum);

        //keep running loop until at 1
        while(collatzNum != 1) {
            if(collatzNum % 2 == 0) {
                collatzNum /= 2;
            }
            else {
                collatzNum = 3 * collatzNum + 1;
            }

            if(collatzNum > highestNumReached) {
                highestNumReached = collatzNum;
            }
            System.out.println(collatzNum);
            numSteps++;
        }
        System.out.println("Initial value: " + initValue + "\n" +
                "Number of steps: " + numSteps +  "\n" +
                "Highest number reached: " + highestNumReached);

        if (numSteps == 0) {
            System.out.println("No steps required");
        }
        else if (numSteps == 1) {
            System.out.println("Only took one step!");
        }
        else if (numSteps == 2) {
            System.out.println("Two steps");
        }
        else if (numSteps == 3) {
            System.out.println("Three steps");
        }
        else if (numSteps == 4) {
            System.out.println("Four steps");
        }
        else {
            System.out.println("Wow, " + numSteps + " steps was a lot of steps!");
        }

    }
}
