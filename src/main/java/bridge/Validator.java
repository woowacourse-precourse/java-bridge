package bridge;

public class Validator {

    static void validateBridgeSize(String input) {
        validateDecimal(input);
        int size = Integer.parseInt(input);
        if (size < 3 || size > 20) {
            throw new IllegalArgumentException("다리의 길이는 3이상 20이하의 정수여야 합니다");
        }
    }

    static void validateMove(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U(위 칸)와 D(아래 칸) 중 하나의 문자여야 합니다.");
        }
    }

    static void validateGameCommand(String input) {
        if (!input.equals("R") && !input.equals("Q")) {
            throw new IllegalArgumentException("[ERROR] 게임 재시작/종료 여부는 R(재시작)과 Q(종료) 중 하나의 문자여야 합니다.");
        }
    }

    private static void validateDecimal(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                throw new IllegalArgumentException("[ERROR] 입력값이 정수여야 합니다.");
            }
        }
    }
}
