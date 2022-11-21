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

    public static List<String> setBridgeGame() {
        BridgeNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();;
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        outputView.printStatements(NormalStatements.GAME_START.getNormalStatement());
        int bridgeLength = new InputView().readBridgeSize(); //Validator 객체를 사용해 유효성 검증 후 반환하게 한다.
        return crossableBridge = bridgeMaker.makeBridge(bridgeLength);
    }



}
