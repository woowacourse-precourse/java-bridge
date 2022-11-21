package bridge;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize(String readSize) {
        validForSize(readSize);
        return Integer.parseInt(readSize);
    }

    private void validForSize(String readSize) {
        isNumber(readSize);
        validRange(readSize);
    }

    private void validRange(String readSize) {
        int size = Integer.parseInt(readSize);
        if (size < 3 || 20 < size) {
            System.err.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            throw new IllegalArgumentException();
        }
    }
    private void isNumber(String size) {
        for (char number : size.toCharArray()) {
            if (!Character.isDigit(number)) {
                System.err.println("[ERROR] 다리 길이는 숫자여야 합니다.");
                throw new IllegalArgumentException();
            }
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public Move readMoving(String move) {
        validForMove(move);
        return Move.valueOf(move);
    }

    private void validForMove(String move) {
        if (!Pattern.matches(Regex.MOVE.getPattern(), move)) {
            System.err.println("[ERROR] 이동 명령은 U 혹은 D를 입력해야만 합니다.");
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
