package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private BridgeGame bridgeGame;

    public int readBridgeSize() {
        try {
            this.bridgeGame = new BridgeGame(Integer.parseInt(Console.readLine()));
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
            this.readBridgeSize();
        }
        return bridgeGame.getSize();
    }

    public String readMoving() {
        try {
            this.bridgeGame = new BridgeGame(Console.readLine(),"R");
        } catch (IllegalArgumentException e) {
            System.out.println("[ERROR] 이동할 칸을 U 혹은 D로 선택해주세요. (위: U, 아래: D)");
            this.readMoving();
        }
        return bridgeGame.getReadMoving();
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        return null;
    }
}
