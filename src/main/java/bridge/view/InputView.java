package bridge.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import bridge.domain.BridgeSize;
import bridge.domain.constants.GameCommands;
import bridge.domain.constants.MoveCommands;

public class InputView {

    private final InputDataConverter inputDataConverter;

    public InputView(InputDataConverter inputDataConverter) {
        this.inputDataConverter = inputDataConverter;
    }

    public BridgeSize bridgeSize() {
        return inputDataConverter.bridgeSize(this::valueForBridgeSize);
    }

    private String valueForBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        return readLine();
    }

    public MoveCommands moveCommand() {
        return inputDataConverter.moveCommand(this::valueForMoveCommand);
    }

    private String valueForMoveCommand() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        return readLine();
    }

    public GameCommands gameCommand() {
        return inputDataConverter.gameCommand(this::valueForGameCommand);
    }

    private String valueForGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        return readLine();
    }
}
