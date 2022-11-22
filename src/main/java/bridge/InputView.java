package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.regex.Pattern;

public class InputView {
    private static final String GREETING_GAME = "다리 건너기 게임을 시작합니다.\n";
    private static final String CHOOSE_BRIDGE_SIZE = "다리의 길이를 입력해주세요.";
    public static final String CHOOSE_SQUARE = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    private static final String GREETING_GAME_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    private static final Pattern INT_FILTER = Pattern.compile("^\\d*$");
    private static final Pattern RANGE_FILTER = Pattern.compile("^[1-9]|1[0-9]|20$");

    public void greetingGame() {
        System.out.println(GREETING_GAME);
    }

    public void chooseSquare() {
        System.out.println(CHOOSE_SQUARE);
    }

    public BridgeSizeParameter readBridgeSize() {
        System.out.println(CHOOSE_BRIDGE_SIZE);
        String bridgeSize = Console.readLine();
        checkBridgeSize(bridgeSize);

        return new BridgeSizeParameter(convertBridge(bridgeSize));
    }

    public MovingCommandParameter readMoving() {
        String moving = Console.readLine();
        checkMovingCommand(moving);

        return new MovingCommandParameter(moving);
    }

    public CommandParameter readGameCommand() {
        System.out.println(GREETING_GAME_COMMAND);
        String command = Console.readLine();
        checkRetryCommand(command);

        return new CommandParameter(command);
    }

    private void checkBridgeSize(String bridgeSize) {
        try {
            blank(bridgeSize);
            isNumber(bridgeSize);
            checkRange(bridgeSize);
        } catch (InputException e) {
            System.out.println(e.getMessage());
            readBridgeSize();
        }
    }

    private void checkMovingCommand(String movingCommand) {
        try {
            blank(movingCommand);
        } catch (InputException e) {
            System.out.println(e.getMessage());
            readMoving();
        }
    }

    private void checkRetryCommand(String retryCommand) {
        try {
            blank(retryCommand);
        } catch (InputException e) {
            System.out.println(e.getMessage());
            readGameCommand();
        }
    }

    private void blank(String input) {
        if (input.isBlank()) {
            throw new InputException("[ERROR] 공백은 입력할 수 없습니다.");
        }
    }

    private void checkRange(String bridgeSize) {
        if (!RANGE_FILTER.matcher(bridgeSize).matches()) {
            throw new InputException("[ERROR] 최소보다 작거나 최대 입력 값보다 큽니다.");
        }
    }


    private void isNumber(String input) {
        if (!INT_FILTER.matcher(input).matches()) {
            throw new InputException("[ERROR] 숫자만 입력할 수 있습니다.");
        }
    }

    private int convertBridge(String bridgeSize) {
        return Integer.parseInt(bridgeSize);
    }
}
