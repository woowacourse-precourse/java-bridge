package bridge.controller;

import bridge.BridgeGame;
import bridge.domain.GameRecord;
import bridge.view.InputView;
import bridge.view.OutputView;

import java.util.List;

public class GameController {
    private InputView inputView;
    private OutputView outputView;
    private BridgeGame bridgeGame;
    private GameRecord gameRecord;
    private List<String> bridge;

    public GameController() {
        inputView = new InputView();
        outputView = new OutputView();
        bridgeGame = new BridgeGame();
        gameRecord = new GameRecord();
    }

    public void start() {
        // 게임 시작

        // 다리 길이 입력받음, 다리 생성
        generateBridge();
        // 게임 종료할 때 까지의 사이클
        do{
            // U, D 입력 받으며 다리 위 이동
            gameRecord.setPlayTimes(gameRecord.getPlayTimes() + 1);
            bridgeGame.generateNewRound();
            play();
        } while (true);

        // 결과 출력 및 종료
    }

    private void generateBridge() {
        try {
            outputView.printInputBridgeSize();
            int size = inputView.readBridgeSize();
            bridgeGame.generateBridge(size);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            generateBridge();
        }
    }

    private void play() {
        outputView.printMoveCommand();

        move();
    }

    private void move() {
        outputView.printMoveCommand();

        String correctResult = bridgeGame.move(inputView.readMoving());
        // 현재 까지의 결과 출력

    }
}
