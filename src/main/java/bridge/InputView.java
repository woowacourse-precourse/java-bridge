package bridge;

import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    public int readBridgeSize() {
        String bridgeSize = "";
        while (true) {
            try {
                bridgeSize = camp.nextstep.edu.missionutils.Console.readLine();
                validateBridgeSize(bridgeSize);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return Integer.parseInt(bridgeSize);
    }

    public String readMoving() {
        String movingStep = "";
        while (true) {
            try {
                movingStep = camp.nextstep.edu.missionutils.Console.readLine();
                validateMovingStep(movingStep);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return movingStep;
    }

    public String readGameCommand() {
        String gameCommand = "";
        while (true) {
            try {
                gameCommand = camp.nextstep.edu.missionutils.Console.readLine();
                validateGameCommand(gameCommand);
                break;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
        return gameCommand;
    }

    private void validateBridgeSize(String bridgeSize) {
        if (!Pattern.matches("[0-9]+", bridgeSize)) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이가 숫자가 아닙니다.");
        }
        if (Integer.parseInt(bridgeSize) < 3 || Integer.parseInt(bridgeSize) > 20) {
            throw new IllegalArgumentException("[ERROR] 다리의 길이가 3에서 20이 아닙니다.");
        }
    }

    private void validateMovingStep(String movingStep) throws IllegalArgumentException {
        if (!(movingStep.equals("U") || movingStep.equals("D"))) {
            throw new IllegalArgumentException("[ERROR] 입력은 U 혹은 D만 가능합니다. ");
        }
    }

    private void validateGameCommand(String gameCommand) throws IllegalArgumentException{
        if (!(gameCommand.equals("R") || gameCommand.equals("Q"))) {
            throw new IllegalArgumentException("[ERROR] 입력은 R 혹은 Q만 가능합니다. ");
        }
    }

}
