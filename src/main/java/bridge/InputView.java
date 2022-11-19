package bridge;

import static camp.nextstep.edu.missionutils.Console.readLine;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        String inputBridgeSize = readLine();
        validateBrigeSize(inputBridgeSize);
        return changeInt(inputBridgeSize);
    }

    public int changeInt(String size) {
        try {
            return Integer.parseInt(size);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 길이는 정수만 입력해주세요.");
        }
    }

    public void validateBrigeSize(String size) {
        int bridgeSize = Integer.parseInt(size);
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3~ 20 사이만 가능합니다.");
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        String move = readLine();
        move = move.toUpperCase();
        validateMove(move);
        validateMoveSize(move);
        return move;
    }

    private void validateMove(String move) {
        if (!move.equals("U") && !move.equals("D")) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    private void validateMoveSize(String move) {
        if (move.length() > 1) {
            throw new IllegalArgumentException("[ERROR]");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
