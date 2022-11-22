package bridge.view;

import bridge.constant.Bridge;
import bridge.constant.Constant;
import bridge.constant.ErrorMessage;
import bridge.constant.Message;
import camp.nextstep.edu.missionutils.Console;
import java.util.function.Consumer;
import java.util.regex.Pattern;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println(Message.REQUEST_BRIDGE_SIZE);
        String bridgeSize = Console.readLine();
        System.out.println();

        if (isThrowError(this::validateBridgeSize, bridgeSize)) {
            return readBridgeSize();
        }
        return Integer.parseInt(bridgeSize);
    }

    private void validateBridgeSize(String bridgeSize) {
        if (!Pattern.matches(Constant.BRIDGE_SIZE_REGEX, bridgeSize)) {
            throw new IllegalArgumentException(ErrorMessage.ONLY_NUMBER);
        }
        if (isInvalidBridgeSize(Integer.parseInt(bridgeSize))) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_BRIDGE_SIZE);
        }
    }

    private boolean isInvalidBridgeSize(int bridgeSize) {
        return bridgeSize < Constant.BRIDGE_SIZE_MIN || bridgeSize > Constant.BRIDGE_SIZE_MAX;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println(Message.REQUEST_MOVE_TO_PLACE);
        String moveToBridge = Console.readLine();

        if (isThrowError(this::validateMoveToBridge, moveToBridge)) {
            return readMoving();
        }
        return moveToBridge;
    }

    private void validateMoveToBridge(String moveToBridge) {
        if (!Bridge.contains(moveToBridge)) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_MOVE_TO_PLACE_FORM);
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println(Message.REQUEST_IS_RESTART_GAME);
        String isRestartGame = Console.readLine();

        if (isThrowError(this::validateIsRestartGame, isRestartGame)) {
            return readGameCommand();
        }
        return isRestartGame;
    }

    private void validateIsRestartGame(String isRestartGame) {
        if (isInvalidRestartGameForm(isRestartGame)) {
            throw new IllegalArgumentException(ErrorMessage.WRONG_RESTART_GAME_FORM);
        }
    }

    private boolean isInvalidRestartGameForm(String isRestartGame) {
        return !isRestartGame.equals(Constant.QUIT_GAME) && !isRestartGame.equals(Constant.RESTART_GAME);
    }

    private boolean isThrowError(Consumer<String> validateFunction, String input) {
        boolean isThrowError = false;
        try {
            validateFunction.accept(input);
        } catch (IllegalArgumentException e) {
            System.out.printf(ErrorMessage.ERROR_MESSAGE_FORM, e.getMessage());
            isThrowError = true;
        }
        return isThrowError;
    }
}
