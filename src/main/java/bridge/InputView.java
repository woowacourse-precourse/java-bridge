package bridge;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        return 0;
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
