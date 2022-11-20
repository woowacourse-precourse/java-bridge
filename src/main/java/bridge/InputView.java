package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 * 제공된 InputView 클래스를 활용해 구현해야 한다.
 * InputView의 패키지는 변경할 수 있다.
 * InputView의 메서드의 시그니처(인자, 이름)와 반환 타입은 변경할 수 있다.
 * 사용자 값 입력을 위해 필요한 메서드를 추가할 수 있다.
 */
public class InputView {

    private final String CHOOSE_UP = "U";
    private final String CHOOSE_DOWN = "D";
    private final String CHOOSE_RESTART = "R";
    private final String CHOOSE_END = "Q";
    private final int MAX_BRIDGE_SIZE = 20;
    private final int MIN_BRIDGE_SIZE = 3;


    private final String OPENING_MESSAGE = "다리 건너기 게임을 시작합니다.\n";
    private final String ASK_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    private final String ASK_UP_DOWN = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private final String ASK_RESTART_NOT = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        try {
            System.out.println(OPENING_MESSAGE);
            System.out.println(ASK_BRIDGE_SIZE);
            int bridgeSize = Integer.parseInt(Console.readLine());
            validateBridgeSize(bridgeSize);
            return bridgeSize;
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(ASK_UP_DOWN);
        String moveChoice = Console.readLine();
        validateInputMoving(moveChoice);
        return moveChoice;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(ASK_RESTART_NOT);
        String gameCommandChoice = Console.readLine();
        validateInputGameCommand(gameCommandChoice);
        return gameCommandChoice;
    }

    private void validateBridgeSize(int bridgeSize) {
        if (bridgeSize < MIN_BRIDGE_SIZE || bridgeSize > MAX_BRIDGE_SIZE) {
            throw new IllegalArgumentException();
        }
    }

    private void validateInputMoving(String moveChoice) {
        if (!moveChoice.equals(CHOOSE_UP) && !moveChoice.equals(CHOOSE_DOWN)) {
            throw new IllegalArgumentException();
        }
    }

    private void validateInputGameCommand(String gameCommandChoice) {
        if (!gameCommandChoice.equals(CHOOSE_RESTART) && !gameCommandChoice.equals(CHOOSE_END)) {
            throw new IllegalArgumentException();
        }
    }

}
