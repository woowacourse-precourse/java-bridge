package bridge.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import bridge.domain.validation.BridgeSize;
import bridge.domain.constants.GameCommands;
import bridge.domain.constants.MoveCommands;
import java.util.function.Supplier;

public class InputView {

    private static final String ERROR_PREFIX = "[ERROR] ";

    private final InputValueConverter inputValueConverter;

    public InputView(InputValueConverter inputValueConverter) {
        this.inputValueConverter = inputValueConverter;
    }

    public BridgeSize bridgeSize() {
        return repeatInputUntilSuccess(() ->
                inputValueConverter.bridgeSize(valueForBridgeSize()));
    }

    private String valueForBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        return readLine();
    }

    public MoveCommands moveCommand() {
        return repeatInputUntilSuccess(() ->
                inputValueConverter.moveCommands(valueForMoveCommand()));
    }

    private String valueForMoveCommand() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        return readLine();
    }

    public GameCommands gameCommand() {
        return repeatInputUntilSuccess(() ->
                inputValueConverter.gameCommands(valueForGameCommand()));
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
