package bridge;

import Statements.NormalStatements;

import java.util.List;

public class BridgeGameController {
    private static List<String> crossableBridge;
    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();

    public BridgeGameController(List<String> crossableBridge){
        this.crossableBridge = crossableBridge;
    }

    public static BridgeMaker startGame() {
        BridgeNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();;
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        outputView.printStatements(NormalStatements.GAME_START.getNormalStatement());
        outputView.printStatements("");
        return bridgeMaker;
    }
    public static List<String> setBridgeGame(BridgeMaker bridgeMaker) {
        try {
            outputView.printStatements(NormalStatements.ASK_BRIDGE_LENGTH.getNormalStatement());
            int bridgeLength = new InputView().readBridgeSize();
            return crossableBridge = bridgeMaker.makeBridge(bridgeLength);
        }catch(IllegalArgumentException e){
            return setBridgeGame(bridgeMaker);
        }
    }

}
