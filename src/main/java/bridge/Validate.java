package bridge;

public class Validate {

    public static void checkLenInput(String input) {
        int len = Integer.parseInt(input);
        if (!input.chars().allMatch(Character::isDigit) || 3 > len || len > 20){
            throw new IllegalArgumentException();
        }
    }


}
