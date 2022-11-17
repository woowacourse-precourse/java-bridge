package bridge;

import camp.nextstep.edu.missionutils.Console;

import java.util.List;
import java.util.Objects;

/**
 * 사용자로부터 입력을 받는 역할을 한다.
 */
public class InputView {

    private static final List<String> MOVE_COMMAND = List.of(MoveCommand.UP.getCommand(), MoveCommand.DOWN.getCommand());
    private static final List<String> GAME_COMMAND = List.of(GameCommand.REPLAY.getCommand(),GameCommand.QUIT.getCommand());

    /**
     * 다리의 길이를 입력받는다.
     */
    public static int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String input = Console.readLine();
        System.out.println();
        validationInteger(input);
        int bridgeSize = Integer.parseInt(input);
        validationBridgeSize(bridgeSize);
        return bridgeSize;
    }

    /**
     * 사용자가 이동할 칸을 입력받는다.
     */
    public static MoveCommand readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String moveCommand = Console.readLine();
        validationMoveCommand(moveCommand);
        if (Objects.equals(moveCommand, MoveCommand.UP.getCommand())) {
            return MoveCommand.UP;
        }
        return MoveCommand.DOWN;
    }

    /**
     * 사용자가 게임을 다시 시도할지 종료할지 여부를 입력받는다.
     */
    public static GameCommand readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String gameCommand = Console.readLine();
        validationGameCommand(gameCommand);
        if (Objects.equals(gameCommand, GameCommand.QUIT.getCommand())) {
            return GameCommand.QUIT;
        }
        return GameCommand.REPLAY;
    }

    private static void validationInteger(String input) {
        try {
            Integer.parseInt(input);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 숫자를 입력해야 합니다.");
        }
    }

    private static void validationBridgeSize(int bridgeSize) {
        if (bridgeSize > 20 || bridgeSize < 3) {
            throw new IllegalArgumentException("[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.");
        }
    }

    private static void validationMoveCommand(String moveCommand) {
        if(!MOVE_COMMAND.contains(moveCommand)) {
            throw new IllegalArgumentException("[ERROR] U,D를 입력해 주세요.");
        }
    }

    private static void validationGameCommand(String gameCommand) {
        if (!GAME_COMMAND.contains(gameCommand)) {
            throw new IllegalArgumentException("[ERROR] R,Q를 입력해 주세요.");
        }
    }
}
