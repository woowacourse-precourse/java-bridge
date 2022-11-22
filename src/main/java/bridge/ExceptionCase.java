package bridge;

public class ExceptionCase {

    static OutputView display = new OutputView();

    static public void isInputUpOrDown(String input) {
        if (!(input.equals("U") || input.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] 다리는 U와 D로만 움직여야 합니다.");
        }
    }

    static public void isInputBound(int input) {

        if (!(input >= 3 && input <= 20)) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이는 3부터 20사이의 숫자여야 합니다.");
        }
    }

    static public void isInputTry(String input) {
        if (!(input.equals("R") || input.equals("Q"))) {
            throw new IllegalArgumentException("[ERROR] 재시작은 R과 Q로만 입력 가능합니다..");
        }
    }

    static public int isInputAllNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 자연수를 입력해주세요.");
        }
    }
}
