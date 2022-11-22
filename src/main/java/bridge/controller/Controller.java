package bridge.controller;

import bridge.Result;
import bridge.constant.State;
import bridge.service.BridgeGameService;
import bridge.InputView;
import bridge.OutputView;

public class Controller {
    private final BridgeGameService service;
    private final InputView inputView;
    private final OutputView outputView;

    public Controller(BridgeGameService service, InputView inputView, OutputView outputView) {
        this.service = service;
        this.inputView = inputView;
        this.outputView = outputView;
    }

    public void start() {
        int size = inputView.readBridgeSize();
        service.makeBridge(size);
    }

    public void play() {
        while (true) {
            String moving = inputView.readMoving();
            Result result = service.move(moving);
            outputView.printMap(result);
            if (isWin(result)) {
                break;
            }
            if (isLoss(result)) {
                String s = inputView.readGameCommand();
                if ("Q".equals(s)) break;
                service.retry();
            }
        }
    }

    private boolean isLoss(Result result) {
        return result.getState() == State.Loss;
    }

    private boolean isWin(Result result) {
        return result.getState() == State.Win;
    }

    public void print() {
        Result result = service.getResult();
        outputView.printResult(result);
    }
}
