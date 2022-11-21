package bridge;

import java.util.List;

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
            List<String> bridge = service.getBridge();
            List<String> input = service.getInput();
            outputView.printMap(input, bridge);
            if (service.isEnd()) {
                if (service.isWin()) break;
                // 처음부터 다시할건지 물어보기 끝낼거야 계속 할거야
                String s = inputView.readGameCommand();
                if ("Q".equals(s)) break;
                service.retry();
            }
        }
        // 끝난거면 결과 출력
        List<String> bridge = service.getBridge();
        List<String> input = service.getInput();
        BridgeGame game = service.getGame();
        outputView.printResult(input, bridge, game.getGameState(), game.getTime());
    }
}
