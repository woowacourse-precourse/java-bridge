package bridge.controller;

import bridge.BridgeGame;
import bridge.InputView;
import bridge.OutputView;
import bridge.Result;
import java.util.List;

public class GameController {
    private final InputView inputView = new InputView();
    private final OutputView outputView = new OutputView();
    private final BridgeGame bridgeGame = new BridgeGame();

    public void run(){
       start();
       while(true){
           move();
       }
    }

    private void start(){
        System.out.println("다리 건너기 게임을 시작합니다.");
        System.out.println();
        System.out.println("다리의 길이를 입력해주세요.");
        int bridgeSize = inputView.readBridgeSize();
        bridgeGame.start(bridgeSize);
    }

    private void move(){
        System.out.println("이동할 칸을 선택해주세요. (위: U, 아래: D)");
        String direction = inputView.readMoving();
        List<Result> gameResults = bridgeGame.move(direction);
        boolean isSuccess = gameResults.get(gameResults.size() - 1).isSuccess();
        outputView.printMap(gameResults);
    }
}
