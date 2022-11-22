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

    public void move() {
        while (true) {
            String moving = inputView.readMoving();
            service.move(moving);
            Result result = service.getResult();
            outputView.printMap(result);
            if (result.getState() == State.Win) {
                break;
            }
            if (result.getState() == State.Loss) {
                String s = inputView.readGameCommand();
                if ("Q".equals(s)) break;
                service.retry();
            }
        }
        // 끝난거면 결과 출력
        Result result = service.getResult();
        outputView.printResult(result);
    }
}
