package bridge.view;

import bridge.domain.GameControl;
import bridge.domain.GameMoving;
import bridge.verifier.BridgeSizeVerifier;
import bridge.verifier.GameCommandVerifier;
import bridge.verifier.MovingVerifier;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    private final String READ_BRIDGE_MESSAGE = "다리의 길이를 입력해주세요.";
    private final String READ_MOVING_MESSAGE =
            String.format("이동할 칸을 선택해주세요. (위: %s, 아래: %s)\n", GameMoving.UP, GameMoving.DOWN);
    private final String READ_GAME_COMMAND_MESSAGE =
            String.format("게임을 다시 시도할지 여부를 입력해주세요. (재시도: %s, 종료: %s)\n", GameControl.RETRY, GameControl.QUIT);

    public int readBridgeSize() {
        System.out.println(READ_BRIDGE_MESSAGE);

        String bridgeSize = Console.readLine();
        BridgeSizeVerifier bridgeSizeVerifier = new BridgeSizeVerifier();
        bridgeSizeVerifier.check(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    public String readMoving() {
        System.out.printf(READ_MOVING_MESSAGE);

        String moving = Console.readLine();
        MovingVerifier movingVerifier = new MovingVerifier();
        movingVerifier.check(moving);
        return moving;
    }

    public String readGameCommand() {
        System.out.printf(READ_GAME_COMMAND_MESSAGE);

        String gameCommand = Console.readLine();
        GameCommandVerifier gameCommandVerifier = new GameCommandVerifier();
        gameCommandVerifier.check(gameCommand);
        return gameCommand;
    }
}
