package bridge;

import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.domain.gameStatus;
import bridge.ui.InputView;
import bridge.ui.OutputView;

public class Application {

    public static void main(String[] args) {
        InputView input = new InputView();
        OutputView output = new OutputView();

        output.printStartMessage();

        System.out.println("다리의 길이를 입력해주세요.");
        int size = input.readBridgeSize();

        Bridge bridge = new Bridge(size);
        BridgeGame game = new BridgeGame(bridge);

        while (game.currentStatus == gameStatus.CONTINUE) {
            System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
            String direction = input.readMoving();
            game.move(direction);

            if (game.currentStatus == gameStatus.FAIL) {
                System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
                String gameCommand = input.readGameCommand();
                if (gameCommand.equals("R")) {
                    game.retry();
                }
            }
            if (game.currentStatus == gameStatus.SUCCESS) {
                // TODO: 게임 결과 출력
                break;
            }
        }
    }
}
