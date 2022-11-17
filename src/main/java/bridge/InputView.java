package bridge;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    ValidateUserInput validateUserInput = new ValidateUserInput();
    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize(String bridgeLength) {
        validateUserInput.checkBridgeLength(bridgeLength);
        return Integer.parseInt(bridgeLength);
    }
    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving(String moveButton) {
        validateUserInput.checkReadMoving(moveButton);
        return moveButton;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand(String gameCommandButton) {
        validateUserInput.checkGameCommand(gameCommandButton);
        return gameCommandButton;
    }
}
