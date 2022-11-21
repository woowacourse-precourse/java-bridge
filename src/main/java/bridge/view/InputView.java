package bridge.view;

import static camp.nextstep.edu.missionutils.Console.readLine;

import bridge.domain.resources.GameCommand;
import bridge.domain.resources.Move;
import bridge.domain.resources.bridge.BridgeSize;
import bridge.utils.parser.BridgeSizeInputParser;
import bridge.utils.parser.GameCommandInputParser;
import bridge.utils.parser.MoveInputParser;

public class InputView {

    public BridgeSize readBridgeSize() {
        String bridgeSizeInput = inputWithMessage("다리의 길이를 입력해주세요.");
        BridgeSize bridgeSize;
        try {
            bridgeSize = BridgeSizeInputParser.parseBridgeSize(bridgeSizeInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readBridgeSize();
        }
        return bridgeSize;
    }

    public Move readMoving() {
        String moveInput = inputWithMessage("\n이동할 칸을 선택해주세요. (위: U, 아래: D)");
        Move move;
        try {
            move = MoveInputParser.parseMove(moveInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readMoving();
        }
        return move;
    }

    public GameCommand readGameCommand() {
        String gameCommandInput = inputWithMessage("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        GameCommand gameCommand;
        try {
            gameCommand = GameCommandInputParser.parseGameCommand(gameCommandInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return readGameCommand();
        }
        return gameCommand;
    }
    private String inputWithMessage(final String message) {
        System.out.println(message);
        return inputBasicLine();
    }

    public String inputBasicLine() {
        return readLine();
    }
}