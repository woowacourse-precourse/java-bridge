package bridge.view;

import bridge.domain.GameResult;
import bridge.domain.MovingResult;

public class View {

    private InputView inputView;
    private OutputView outputView;

    public View(InputView inputView, OutputView outputView) {
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void printStartGame() {
        System.out.println("다리 건너기 게임을 시작합니다." + System.lineSeparator());
    }

    public int readBridgeSize() {
        return inputView.readBridgeSize();
    }

    public String readMoving() {
        return inputView.readMoving();
    }

    public String readGameCommand() {
        return inputView.readGameCommand();
    }

    public void printMap(MovingResult moveResult) {
        outputView.printMap(moveResult);
    }

    public void printResult(GameResult gameResult) {
        outputView.printResult(gameResult);
    }

    public void initMap() {
        outputView.initMap();
    }

}
