package bridge.game;

import bridge.bridge.BridgeGame;
import bridge.input.InputView;
import bridge.output.OutputView;

/**
 * 전체 게임 로직을 관리하는 클래스입니다.
 * @version 1.0.0
 * @author CHO Min Ho
 */
public class GameApplication {
    private final BridgeGame bridgeGame;
    private final InputView inputView;
    private final OutputView outputView;

    public GameApplication(BridgeGame bridgeGame) {
        this.bridgeGame = new BridgeGame();
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void startGame() {

    }

    public void inputBridgeLength() {

    }

    /**
     * 이동할 칸을 입력받고, 해당 방향으로 이동하는 메서드입니다.
     * @return 현재 이동이 성공한지 여부
     */
    public boolean singleStage() {
        bridgeGame.move(inputView.readMoving());
        outputView.printMap(bridgeGame.getBridge(), bridgeGame.getUserInput());
        return bridgeGame.getUserInput().get(bridgeGame.getUserInput().size() - 1)
                .equals(bridgeGame.getBridge().get(bridgeGame.getUserInput().size() - 1));
    }

}
