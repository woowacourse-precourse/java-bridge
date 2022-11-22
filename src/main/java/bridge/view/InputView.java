package bridge.view;

import bridge.constant.GameCommand;
import bridge.constant.MoveCommand;
import bridge.domain.BridgeSizeValidator;
import camp.nextstep.edu.missionutils.Console;

import java.util.function.Supplier;

public class InputView {

    private static final String ERROR_PREFIX = "[ERROR] ";

    private final InputViewConverter inputValueConverter;

    public InputView(InputViewConverter inputValueConverter) {
        this.inputValueConverter = inputValueConverter;
    }

    public BridgeSizeValidator bridgeSize() {
        return repeatInputUntilSuccess(() ->
                inputValueConverter.bridgeSize(valueForBridgeSize()));
    }

    private String valueForBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        return Console.readLine();
    }

    public MoveCommand moveCommand() {
        return repeatInputUntilSuccess(() ->
                inputValueConverter.moveCommands(valueForMoveCommand()));
    }

    private String valueForMoveCommand() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        return Console.readLine();
    }

    public GameCommand gameCommand() {
        return repeatInputUntilSuccess(() ->
                inputValueConverter.gameCommands(valueForGameCommand()));
    }

    private String valueForGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        return Console.readLine();
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
