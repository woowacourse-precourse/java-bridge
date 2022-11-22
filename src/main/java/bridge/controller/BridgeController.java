package bridge.controller;

import bridge.BridgeGame;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import bridge.domain.PlayResult;
import bridge.domain.Stage;
import bridge.view.InputView;
import java.util.List;
import java.util.stream.Collectors;

public class BridgeController {

    private BridgeGame game;

    private final InputView inputView;

    public BridgeController() {
        inputView = new InputView();
    }

    public void start() {
        // 다리 생성 테스트
        setUpBridge();

        // 다리 건너기 테스트
        play();

        // 최종 결과
        printOutput();
    }

    private void setUpBridge() {
        game = new BridgeGame(buildBridge(inputView.readBridgeSize()));
    }

    private List<Stage> buildBridge(final int bridgeSize) {
        BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
        System.out.println("bridge = " + bridge);
        return bridge
            .stream()
            .map(Stage::new)
            .collect(Collectors.toList());
    }

    private void play() {
        playGame();

        if (!game.isClear()) {
            askRestart();
        }
    }

    private void playGame() {
        for (int round = 0; round < game.getStages(); round++) {
            PlayResult playResult = game.move(round, inputView.readMoving());

            if (game.isOver()) {
                break;
            }
            System.out.println("통과!");
        }
    }

    private void askRestart() {
        String commend = inputView.readGameCommand();

        if ("R".equals(commend)) {
            resetGame();
            play();
        }
    }

    private void resetGame() {
        game.retry();
    }

    private void printOutput() {
        System.out.println("게임 결과: " + (game.isClear() ? "승리" : "패배"));
        System.out.println("재시도: " + game.getAttempts());
    }
}
