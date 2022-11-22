package bridge;

import camp.nextstep.edu.missionutils.Console;
import java.util.Objects;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private InputView() {
    }

    private static class InputViewHelper {
        private static final InputView INSTANCE = new InputView();
    }

    public static InputView getInstance() {
        return InputViewHelper.INSTANCE;
    }

    /**
     * 다리의 길이를 입력받는다.
     */
    public int readBridgeSize() {
        System.out.println("다리 건너기 게임을 시작합니다.");

        while (true) {
            try {
                int bridgeSize = Integer.parseInt(Console.readLine());
                validateBridgeSize(bridgeSize);
                return bridgeSize;
            } catch (IllegalArgumentException e) {
                System.out.println(ErrorMessage.BRIDGE_SIZE_EXCEPTION.getMessage());
            }
        }
    }

    private void validateBridgeSize(int bridgeSize) {
        if (bridgeSize < BridgeSizeBound.LOWER.getBound() || BridgeSizeBound.UPPER.getBound() < bridgeSize) {
            throw new IllegalArgumentException(ErrorMessage.BRIDGE_SIZE_EXCEPTION.getMessage());
        }
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");

        while (true) {
            try {
                String moveChoice = Console.readLine();
                validateMoveChoice(moveChoice);
                return moveChoice;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateMoveChoice(String moveChoice) {
        if ((!moveChoice.equals("U")) && (!moveChoice.equals("D"))) {
            throw new IllegalArgumentException(ErrorMessage.MOVE_CHOICE_EXCEPTION.getMessage());
        }
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");

        while (true) {
            try {
                String command = Console.readLine();
                validateGameCommand(command);
                return command;
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
        }
    }

    private void validateGameCommand(String command) {
        if (!command.equals(Command.RESTART.getCommandStr()) && !command.equals(Command.QUIT.getCommandStr())) {
            throw new IllegalArgumentException(ErrorMessage.GAME_END_CHOICE_EXCEPTION.getMessage());
        }
    }
}
