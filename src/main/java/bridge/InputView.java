package bridge;

import camp.nextstep.edu.missionutils.Console;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {
    private static final String bridgeSizeInputExceptionMessage = "다리 길이는 3부터 20 사이의 숫자여야 합니다.";
    private static final String movingInputExceptionMessage = "U와 D 중 하나로 입력해야 합니다.";
    private static final String gameCommandInputExceptionMessage = "R과 Q 중 하나로 입력해야 합니다.";
    private static OutputView outputView = new OutputView();

    /**
     * 다리의 길이를 입력받는다.
     */
    
    
    //모든 메서드에서 안내 메세지 출력 필요 -> OutputView 클래스에 구현하깅
    public int readBridgeSize() {
        outputView.printLengthMessage();
        String bridgeSize = Console.readLine();
        validateBridgeSizeInput(bridgeSize);
        System.out.println();

        return Integer.parseInt(bridgeSize);
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        outputView.printMoveMessage();
        String direction = Console.readLine();
        validateMovingInput(direction);
        return direction;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        outputView.printRetryMessage();
        String gameCommand = Console.readLine();
        validateGameCommand(gameCommand);
        return gameCommand;
    }

    private void validateBridgeSizeInput(String input) {
        if (!input.matches("^[0-9]+$")) {
            throw new IllegalArgumentException(bridgeSizeInputExceptionMessage);
        }
        int integerInput = Integer.parseInt(input);
        if (integerInput > 20 || integerInput < 3) {
            throw new IllegalArgumentException(bridgeSizeInputExceptionMessage);
        }
    }

    private void validateMovingInput(String input) {
        if (!input.equals("U") && !input.equals("D")) {
            throw new IllegalArgumentException(movingInputExceptionMessage);
        }
    }

    private void validateGameCommand(String input) {
        if (!input.equals("R") && !input.equals("Q")) {
            throw new IllegalArgumentException(gameCommandInputExceptionMessage);
        }
    }
}
