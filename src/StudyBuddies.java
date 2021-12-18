public class StudyBuddies {

    public static Student[] groupFinder() {
        Student[] studentArray = new Student[6];
        Student[] studentArrayPlaceholder = Student.values();
        int randNum;

        //adding random elements from enum to the studentArray
        for (int i = studentArray.length - 1; i >= 0; i--) {
            randNum = (int) (Math.random() * studentArray.length);
            studentArray[studentArray.length - 1 - i] = studentArrayPlaceholder[randNum];

            //if we had to remove the element we used
//            if(randNum == i) {
//                studentArrayPlaceholder[i] = null;
//            }
//            else {
//                for(int j = randNum; j < studentArrayPlaceholder.length - 2; j++) {
//                    studentArrayPlaceholder[j] = studentArrayPlaceholder[j + 1];
//                }
//            }
        }
        return studentArray;
    }

    //prints out all the student types and the number of each
    public static void groupAnalyzer(Student[] studentArray) {
        System.out.println("The following types of students are in your study group:");
        int countType = 0;
        for (Student studentType : studentArray) {
            if (studentType.equals(Student.PROCRASTINATOR)) {
                countType++;
            }
        }
        System.out.println("PROCRASTINATOR " + countType);
        countType = 0;

        for (Student studentType : studentArray) {
            if (studentType.equals(Student.CURVE_BREAKER)) {
                countType++;
            }
        }
        System.out.println("CURVE_BREAKER " + countType);
        countType = 0;

        for (Student studentType : studentArray) {
            if (studentType.equals(Student.LATECOMER)) {
                countType++;
            }
        }
        System.out.println("LATECOMER " + countType);
        countType = 0;

        for (Student studentType : studentArray) {
            if (studentType.equals(Student.DAYDREAMER)) {
                countType++;
            }
        }
        System.out.println("DAYDREAMER " + countType);
        countType = 0;

        for (Student studentType : studentArray) {
            if (studentType.equals(Student.TROUBLEMAKER)) {
                countType++;
            }
        }
        System.out.println("TROUBLEMAKER " + countType);
        countType = 0;

        for (Student studentType : studentArray) {
            if (studentType.equals(Student.QUIET_ACHIEVER)) {
                countType++;
            }
        }
        System.out.println("QUIET_ACHIEVER " + countType);
        countType = 0;
    }

    public static void groupScores(Student[] group1, Student[] group2) {
        int totalScore1 = 0;
        int totalScore2 = 0;
        int countType = 0;

        //Group1
        for (Student studentType : group1) {
            if (studentType.equals(Student.PROCRASTINATOR)) {
                countType++;
            }
        }
        totalScore1 += Student.PROCRASTINATOR.ordinal() * countType;
        countType = 0;

        for (Student studentType : group1) {
            if (studentType.equals(Student.CURVE_BREAKER)) {
                countType++;
            }
        }
        totalScore1 += Student.CURVE_BREAKER.ordinal() * countType;
        countType = 0;

        for (Student studentType : group1) {
            if (studentType.equals(Student.LATECOMER)) {
                countType++;
            }
        }
        totalScore1 += Student.LATECOMER.ordinal() * countType;
        countType = 0;

        for (Student studentType : group1) {
            if (studentType.equals(Student.DAYDREAMER)) {
                countType++;
            }
        }
        totalScore1 += Student.DAYDREAMER.ordinal() * countType;
        countType = 0;

        for (Student studentType : group1) {
            if (studentType.equals(Student.TROUBLEMAKER)) {
                countType++;
            }
        }
        totalScore1 += Student.TROUBLEMAKER.ordinal() * countType;
        countType = 0;

        for (Student studentType : group1) {
            if (studentType.equals(Student.QUIET_ACHIEVER)) {
                countType++;
            }
        }
        totalScore1 += Student.QUIET_ACHIEVER.ordinal() * countType;
        countType = 0;



        //Group2
        for (Student studentType : group2) {
            if (studentType.equals(Student.PROCRASTINATOR)) {
                countType++;
            }
        }
        totalScore2 += Student.PROCRASTINATOR.ordinal() * countType;
        countType = 0;

        for (Student studentType : group2) {
            if (studentType.equals(Student.CURVE_BREAKER)) {
                countType++;
            }
        }
        totalScore2 += Student.CURVE_BREAKER.ordinal() * countType;
        countType = 0;

        for (Student studentType : group2) {
            if (studentType.equals(Student.LATECOMER)) {
                countType++;
            }
        }
        totalScore2 += Student.LATECOMER.ordinal() * countType;
        countType = 0;

        for (Student studentType : group2) {
            if (studentType.equals(Student.DAYDREAMER)) {
                countType++;
            }
        }
        totalScore2 += Student.DAYDREAMER.ordinal() * countType;
        countType = 0;

        for (Student studentType : group2) {
            if (studentType.equals(Student.TROUBLEMAKER)) {
                countType++;
            }
        }
        totalScore2 += Student.TROUBLEMAKER.ordinal() * countType;
        countType = 0;

        for (Student studentType : group2) {
            if (studentType.equals(Student.QUIET_ACHIEVER)) {
                countType++;
            }
        }
        totalScore2 += Student.QUIET_ACHIEVER.ordinal() * countType;
        countType = 0;

        if (totalScore1 > totalScore2) {
            System.out.println("The former is predicted to perform better than the latter.");
        } else if (totalScore1 < totalScore2) {
            System.out.println("The latter is predicted to perform better than the former.");
        } else if (totalScore1 == totalScore2) {
            System.out.println("The two groups are predicted to perform equally well.");
        }
    }


    public static void main(String[] args) {
        Student[] group1;
        Student[] group2;

        group1 = StudyBuddies.groupFinder();
        group2 = StudyBuddies.groupFinder();

        StudyBuddies.groupAnalyzer(group1);
        StudyBuddies.groupAnalyzer(group2);


        StudyBuddies.groupScores(group1,group2);
    }
}