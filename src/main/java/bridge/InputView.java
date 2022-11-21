package bridge;

import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public int readBridgeSize() {
        String bridgeSize = camp.nextstep.edu.missionutils.Console.readLine();
        validateBridgeSize(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    public String readMoving() {
        String movingStep = camp.nextstep.edu.missionutils.Console.readLine();
        validateMovingStep(movingStep);
        return movingStep;

    }

    public String readGameCommand() {
        String gameCommand = camp.nextstep.edu.missionutils.Console.readLine();
        validateGameCommand(gameCommand);
        return gameCommand;
    }

    private void validateBridgeSize(String bridgeSize) throws IllegalArgumentException {
        if (!Pattern.matches("[0-9]]+", bridgeSize)) {
            throw new IllegalArgumentException();
        }
        if (Integer.parseInt(bridgeSize) < 3 || Integer.parseInt(bridgeSize) > 20) {
            throw new IllegalArgumentException();
        }
    }

    private void validateMovingStep(String movingStep) throws IllegalArgumentException {
        if (!movingStep.equals('U') ^ !movingStep.equals('D')) {
            throw new IllegalArgumentException();
        }
    }

    private void validateGameCommand(String gameCommand) throws IllegalArgumentException{
        if (!gameCommand.equals('R') ^ !gameCommand.equals('Q')) {
            throw new IllegalArgumentException();
        }
    }

}
