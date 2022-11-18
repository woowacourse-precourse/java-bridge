package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public void startMsg() {
        System.out.println("다리 건너기 게임을 시작합니다.");
    }

    public void bridgeSizeMsg() {
        System.out.println("다리의 길이를 입력해주세요.");
    }

    public void selectBridgeMsg() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
    }

    public void quitOrRetryMsg() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
    }


    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            try {
                bridgeSizeMsg();
                String input = Console.readLine();
                int bridgeSize = Integer.parseInt(input);
                bridgeSizeException(bridgeSize);
                return bridgeSize;
            } catch (NumberFormatException e) {
                throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
    }

    private void bridgeSizeException(int bridgeSize) {
        if (bridgeSize < 3 || bridgeSize > 20) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }


    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        try {
            selectBridgeMsg();
            String move = Console.readLine();
            movingException(move);
            return move;
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
    }

    private void movingException(String move) {
        if (!move.equals("U") && !move.equals("D")) {
            throw new IllegalArgumentException("[ERROR] 이동할 칸은 U 또는 D여야 합니다.");
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        quitOrRetryMsg();
        String select = Console.readLine();
        return select;
    }

}
