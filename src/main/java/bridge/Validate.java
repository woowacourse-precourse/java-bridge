package bridge;

public class Validate {

    public static void check(String input,int num) throws IllegalArgumentException{
        if (num == 1) {
            checkLenInput(input);
        } else if (num == 2) {
            checkUD(input);
        } else if (num == 3) {
            checkRQ(input);
        }
    }

    public static void checkLenInput(String input) {
        int len = Integer.parseInt(input);
        if (!input.chars().allMatch(Character::isDigit) || 3 > len || len > 20){
            throw new IllegalArgumentException();
        }
    }

    public static void checkUD(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException();
        }
    }

    public static void checkRQ(String input) {
        if (!input.equals("R") && !input.equals("Q")) {
            throw new IllegalArgumentException();
        }
    }


}
