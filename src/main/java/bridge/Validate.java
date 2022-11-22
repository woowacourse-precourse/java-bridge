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
        if (!input.chars().allMatch(Character::isDigit) || 3 > Integer.parseInt(input) || Integer.parseInt(input) > 20){
            throw new IllegalArgumentException("[ERROR] 3 ~ 20사이 숫자를 입력하여 주세요.");
        }
    }

    public static void checkUD(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException("[ERROR] 위: U, 아래: D로 입력해야 합니다.");
        }
    }

    public static void checkRQ(String input) {
        if (!input.equals("R") && !input.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] 재시도: R,종료: Q로 입력해야 합니다.");
        }
    }


}
