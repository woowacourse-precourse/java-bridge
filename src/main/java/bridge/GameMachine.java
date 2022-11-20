package bridge;

import bridge.types.BridgeType;
import bridge.types.MoveResult;
import bridge.types.RetryCommand;
import bridge.views.InputView;
import bridge.views.OutputView;

import java.util.List;

public class GameMachine {
    private InputView ui = new InputView();
    private OutputView view = new OutputView();
    private BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    public void run() {
        int counter = 0;
        view.printStart();
        RetryCommand retry = RetryCommand.RETRY;
        while (retry == RetryCommand.RETRY) {
            play();
            view.printRestartRequest();
            retry = RetryCommand.of(ui.readGameCommand());
            counter++;
        }
        view.printResult();
        view.printGameCount(counter);
    }

    /**
     * todo: 재시작해도 처음에 만든 다리로 재사용한다.
     * todo: Exception이 아닌 IllegalArgumentException, IllegalStateException 등과 같은 명확한 유형을 처리한다.
     * todo: 실패했을 때 게임을 재시작할 수 있어야 한다.
     */
    private void play() {
        view.printBridgeSizeRequest();
        List<BridgeType> bridge = makeBridge();
        bridge.stream().forEach(a -> System.out.println(a));
        BridgeGame bridgeGame = new BridgeGame(bridge);
        for (int location = 0; location < bridge.size(); location++) {
            view.printMoveTypeRequest();
            BridgeType userInput = BridgeType.of(ui.readMoving());
            if (MoveResult.FAIL == bridgeGame.move(userInput)) {
                view.printMap(bridge, location, MoveResult.FAIL);
                return;
            }
            view.printMap(bridge, location, MoveResult.PASS);
        }
    }

    private List<BridgeType> makeBridge() {
        List<String> bridge = bridgeMaker.makeBridge(
                ui.readBridgeSize()
        );
        return BridgeType.toBridge(bridge);
    }
}
