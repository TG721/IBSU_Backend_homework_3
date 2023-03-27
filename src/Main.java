import java.util.*;

public class Main {
    static final String input = "kakali";
    public static void main(String[] args) {
        ArrayList<Student> list = fillAndGetStudentsList();
        Student result  = highestAveragePoint(list);
        System.out.println("The student with highest average point is " + result.getFullName());
    }

    private static Student highestAveragePoint(ArrayList<Student> list) {
        Student temp = list.get(0);
        for (int i=0; i<list.size(); i++){
            list.get(i).calculateAverage();
            if(i!=0) {
                if (temp.getAverage() < list.get(i).getAverage()) {
                    temp = list.get(i);
                }
            }
        }
        return temp;
    }

    private static ArrayList<Student> fillAndGetStudentsList() {
        ArrayList<Student> list = new ArrayList<Student>();
        String nameInput = "Initial";
        Double gradeInput = 0.0;
        String gradeInputString = "";
        while (!nameInput.equals("")) {
            gradeInputString = "";
            List<Double> gradeList = new ArrayList<Double>();
            Scanner scanner = new Scanner(System.in);
            System.out.println("Enter Student's full name ");
            nameInput = scanner.nextLine();
            while (!gradeInputString.equals("!") && !nameInput.equals("")) {
                System.out.println("Enter Student's grade or '!' to finish grades inputting");
                gradeInputString = scanner.nextLine();
                if(isDouble(gradeInputString)){
                    gradeInput = Double.parseDouble(gradeInputString);
                    gradeList.add(gradeInput);
                }
            }
            list.add(new Student(nameInput, gradeList));
        }
        return list;
    }
    private static boolean isDouble(String s){
        try{
            Double.parseDouble(s);
            return true;
        }catch (NumberFormatException e){
            return false;
        }
    }

    private static void printCharOccurrences(String input) {
        Map<Character,Integer> charOccurrences = new HashMap<Character, Integer>();
        Integer tempValue;
        Character tempKey;
        for (int i=0; i<input.length(); i++) {
            tempKey=input.charAt(i);
            if(Character.isAlphabetic(tempKey) || Character.isDigit(tempKey)) {
                if (!charOccurrences.containsKey(tempKey)) {
                    charOccurrences.put(tempKey, 1);
                } else {
                    tempValue = charOccurrences.get(tempKey);
                    charOccurrences.replace(tempKey, ++tempValue);
                }
            }
        }
        for (Map.Entry<Character, Integer> entry : charOccurrences.entrySet()) {
            System.out.println("Character - " + entry.getKey() + " Occurrence - " + entry.getValue());
        }
    }

    private static void printUniqueCharacters(String input) {
        List<Character> charactersAppeared = new ArrayList<Character>();
        for (int i=0; i<input.length(); i++) {
            Character temp =input.charAt(i);
            if(Character.isAlphabetic(temp) || Character.isDigit(temp)) {
                if (!charactersAppeared.contains(temp)) {
                    charactersAppeared.add(temp);
                    System.out.print(temp);
                }
            }
        }
    }
}
