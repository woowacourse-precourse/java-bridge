package bridge.view;

import bridge.verifier.BridgeSizeVerifier;
import bridge.verifier.GameCommandVerifier;
import bridge.verifier.MovingVerifier;
import camp.nextstep.edu.missionutils.Console;

public class InputView {
    public int readBridgeSize() {
        System.out.println("다리의 길이를 입력해주세요.");
        String bridgeSize = Console.readLine();

        BridgeSizeVerifier bridgeSizeVerifier = new BridgeSizeVerifier();
        bridgeSizeVerifier.check(bridgeSize);
        return Integer.parseInt(bridgeSize);
    }

    public String readMoving() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String moving = Console.readLine();

        MovingVerifier movingVerifier = new MovingVerifier();
        movingVerifier.check(moving);
        return moving;
    }

    public String readGameCommand() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String gameCommand = Console.readLine();

        GameCommandVerifier gameCommandVerifier = new GameCommandVerifier();
        gameCommandVerifier.check(gameCommand);
        return gameCommand;
    }
}
