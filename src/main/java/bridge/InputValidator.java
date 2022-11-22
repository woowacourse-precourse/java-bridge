package bridge;

/**
 * 사용자의 입력을 검사하는 역할을 한다.
 */
public class InputValidator {

    /**
     * input String값이 숫자면 ture를, 아니면 false를 반환한다.
     */
    public boolean isNumeric(String input) {
        try {
            Integer.parseInt(input);
            return true;
        } catch (NumberFormatException e){
            return false;
        }
    }

    /**
     * 입력 받은 다리의 길이가 올바른 값인지 검사한다.
     */
    public void checkBridgeSize(String input) {
        if (!isNumeric(input)){
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
        int bridgeSizeInput = Integer.parseInt(input);
        if (bridgeSizeInput < 3 || bridgeSizeInput > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    /**
     * 입력받은 이동할 칸이 올바른 값인지 검사한다.
     */
    public void checkMoving(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U와 D 중 하나의 문자여야 합니다.");
        }
        if (!input.equals("U") && !input.equals("D")){
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U와 D 중 하나의 문자여야 합니다.");
        }
    }

    public void checkRetryCommand(String input) {
        if (input.length() != 1) {
            throw new IllegalArgumentException("[ERROR] 입력은 R과 Q 중 하나의 문자여야 합니다.");
        }
        if (!input.equals("R") && !input.equals("Q")){
            throw new IllegalArgumentException("[ERROR] 입력은 R과 Q 중 하나의 문자여야 합니다.");
        }
    }

}
