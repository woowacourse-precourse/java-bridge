package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        OutputView.messageGameStart();
        OutputView.messageInputBridge();
        int bridgelength = 0;
        try {
            bridgelength = Integer.parseInt(Console.readLine());
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 숫자를 입력하세요. (3~20)");
        }
        validateOfBridgeLength(bridgelength);
        return bridgelength;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        OutputView.messageInputMove();
        String moveTO = Console.readLine();
        validateOfMoveTo(moveTO);
        return moveTO;
    }

    public boolean readGameCommand() {
        String restart = Console.readLine();
        validateOfRestart(restart);
        return restart.equals("R");
    }

    private void validateOfBridgeLength(int bridgelength) {
        if ((bridgelength < 3) || (bridgelength > 20)) {
            System.out.println("[ERROR] 올바른 범위의 값을 입력하세요. (3~20)");
            throw new IllegalArgumentException();
        }
    }

    private void validateOfMoveTo(String moveTo) {
        if ((!moveTo.equals("U")) && (!moveTo.equals("D"))) {
            System.out.println("[ERROR]");
            throw new IllegalArgumentException();
        }
    }

    private void validateOfRestart(String restart) {
        if ((!restart.equals("R")) && (!restart.equals("Q"))) {
            System.out.println("[ERROR]");
            throw new IllegalArgumentException();
        }
    }
    }
