package bridge;

import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public void readBridgeSize() {
        try {
            System.out.println("다리의 길이를 입력해주세요");
            int size = Integer.parseInt(Console.readLine());
            BridgeGame bridgeGame = new BridgeGame();
            bridgeGame.start(size);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            this.readBridgeSize();
        }
    }

    public String readMoving() {
        return null;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
