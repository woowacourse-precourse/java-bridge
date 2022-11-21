package bridge.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import bridge.domain.BridgeSize;
import bridge.domain.constants.GameCommands;
import bridge.domain.constants.MoveCommands;
import java.util.function.Supplier;

public class InputView {

    private static final String ERROR_PREFIX = "[ERROR] ";

    public BridgeSize bridgeSize() {
        return repeatInputUntilSuccess(() -> new BridgeSize(valueForBridgeSize()));
    }

    private String valueForBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        return readLine();
    }

    public MoveCommands moveCommand() {
        return repeatInputUntilSuccess(() -> MoveCommands.of(valueForMoveCommand()));
    }

    private String valueForMoveCommand() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        return readLine();
    }

    public GameCommands gameCommand() {
        return repeatInputUntilSuccess(() -> GameCommands.of(valueForGameCommand()));
    }

    private String valueForGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        return readLine();
    }

    private <T> T repeatInputUntilSuccess(Supplier<T> supplier) {
        while (true) {
            try {
                return supplier.get();
            } catch (IllegalArgumentException e) {
                System.out.println(ERROR_PREFIX + e.getMessage());
            }
        }
    }
}
