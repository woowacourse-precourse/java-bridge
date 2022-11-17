package bridge;

import static bridge.command.GameCommand.RESTART;

import bridge.view.InputView;
import bridge.view.OutputView;
import java.util.List;

public class Application {
    private static final InputView inputView = new InputView();
    private static final OutputView outputView = new OutputView();

    public static void main(String[] args) {
        try {
            // TODO: 프로그램 구현
            outputView.printStart();

            outputView.printRequestBridgeLength();
            int bridgeSize = inputView.readBridgeSize();
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
            BridgeGame game = new BridgeGame(bridge);

            while (!game.isEnd()) {
                outputView.printRequestMoveDirection();
                game.move(inputView.readMoving());
                outputView.printMap(game.getGameResult());

                if (!game.isStepSuccess()) {
                    outputView.printRequestRestartOrQuit();
                    String command = inputView.readGameCommand();
                    if (command.equals(RESTART.ofHotKey())) {
                        game.retry();
                    } else {//QUIT
                        break;
                    }
                }
            }
            outputView.printResult(game);
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
