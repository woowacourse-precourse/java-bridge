package bridge.controller;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.Bridge;
import bridge.domain.BridgeGame;
import bridge.ui.InputView;
import bridge.ui.OutputView;

import java.util.List;

import static bridge.util.Constant.QUIT_GAME;
import static bridge.util.Constant.RETRY_GAME;

public class BridgeGameController {

    private final BridgeMaker bridgeMaker;
    private final InputView inputView;
    private final OutputView outputView;

    public BridgeGameController() {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void run() {
        try {
            int bridgeSize = getBridgeSize();
            Bridge bridge = makeBridge(bridgeMaker, bridgeSize);
            BridgeGame bridgeGame = new BridgeGame(bridge);
            int position;

            do {
                String block = getMovingInput();
                position = bridgeGame.getPosition();

                if (bridge.isMovableBlock(position, block)) {
                    outputView.printMap(bridgeGame, true);
                    position = bridgeGame.move();
                    continue;
                }
                outputView.printMap(bridgeGame, false);
                String gameCommandInput = getGameCommandInput();

                if (gameCommandInput.equals(RETRY_GAME)) {
                    bridgeGame.retry();
                    continue;
                }
                if (gameCommandInput.equals(QUIT_GAME)) {
                    outputView.printResult(bridgeGame, false);
                    return;
                }

            } while (position < bridgeSize);

            outputView.printResult(bridgeGame, true);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private int getBridgeSize() {
        System.out.println("다리 길이를 입력해주세요.");
        int bridgeSize = inputView.readBridgeSize();
        System.out.println(" ");
        return bridgeSize;
    }

    private Bridge makeBridge(BridgeMaker bridgeMaker, int bridgeSize) {
        List<String> strings = bridgeMaker.makeBridge(bridgeSize);
        return new Bridge(strings);
    }

    private String getMovingInput() {
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String block = inputView.readMoving();
        System.out.println(block);
        return block;
    }

    private String getGameCommandInput() {
        System.out.println("게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)");
        String gameCommand = inputView.readGameCommand();
        System.out.println(gameCommand);
        return gameCommand;
    }
}
