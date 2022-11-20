package bridge;

import java.util.ArrayList;
import java.util.List;

public class BridgeGameController {

    BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
    BridgeGame bridgeGame = new BridgeGame();
    OutputView outputView = new OutputView();
    InputView inputView = new InputView();

    public List<String> upSideDownSideMove = new ArrayList<>();

    public void run(int size) {
        List<String> bridge = bridgeMaker.makeBridge(size);
        do {
            upSideDownSideMove = updateUpSideDownSideMove(bridge);
            if (bridgeGame.isFailure(upSideDownSideMove)) {
                String gameCommand = inputView.readGameCommand();
                bridgeGame.retry(gameCommand);
            }
        } while (BridgeGame.gameFlag && bridgeGame.isFailure(upSideDownSideMove));
        outputView.printResult(upSideDownSideMove, BridgeGame.retryCount);
    }

    public List<String> updateUpSideDownSideMove(List<String> bridge) {
        List<String> updateMove = new ArrayList<>(List.of("", ""));
        for (String bridgeElement : bridge) {
            CompareBridge playerMove = new CompareBridge(inputView.readMoving());
            updateMove = bridgeGame.move(playerMove, updateMove, bridgeElement);
            outputView.printMap(updateMove);
            if (bridgeGame.isFailure(updateMove)) {
                break;
            }
        }
        return updateMove;
    }
}
