package bridge.View;

public class InputValidate {

    public void IsCorrectFormatBridgeSize(String input) {
        if (!input.matches("-?\\d+(\\.\\d+)?")) {
            System.out.println("[ERROR] 다리 길이는 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void IsOverRangeBridgeSize(String input) {
        int length = Integer.parseInt(input);
        if ((length < 2)||(length > 20)) {
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void IsNoneInputBridgeSize(String input) {
        if (input.isBlank()) {
            System.out.println("[ERROR] 다리 길이를 입력해주셔야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void IsZeroOrOneComputerBridge(int input) {
        if (input != 1 && input != 0) {
            throw new IllegalArgumentException();
        }
    }

    public void IsNoneInputUserBridge(String input) {
        if (input.isBlank()) {
            System.out.println("[ERROR] 이동할 칸을 입력해주셔야 합니다.");
            throw new IllegalArgumentException();
        }
    }
    public void IsUorDByUserBridge(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            System.out.println("[ERROR] 이동할 칸을 U 혹은 D로 입력해주셔야 합니다.");
            throw new IllegalArgumentException();
        }
    }

    public void IsCorrectFormatByreGame(String input) {
        if (!input.equals("R") || !input.equals("Q")) {
            System.out.println("[ERROR] 재시도 여부는 R 또는 Q로 입력해주세요.");
            throw new IllegalArgumentException();
        }

    }
}
