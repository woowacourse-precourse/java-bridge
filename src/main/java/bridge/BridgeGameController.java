package bridge;

import Statements.NormalStatements;

import java.util.List;

public class BridgeGameController {
    private static List<String> crossableBridges;
    static InputView inputView = new InputView();
    static OutputView outputView = new OutputView();

    public BridgeGameController(List<String> crossableBridges){
        this.crossableBridges = crossableBridges;
    }

    public static BridgeMaker startGame() {
        BridgeNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();;
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
        outputView.printStatements(NormalStatements.GAME_START.getNormalStatement());
        outputView.printStatements("");
        return bridgeMaker;
    }
    public static List<String> tryCatchSetBridgeGame(BridgeMaker bridgeMaker){
        try{
            return setBridgeGame(bridgeMaker);
        }catch (IllegalArgumentException e){
            return tryCatchSetBridgeGame(bridgeMaker);
        }
    }
    private static List<String> setBridgeGame(BridgeMaker bridgeMaker) {
            outputView.printStatements(NormalStatements.ASK_BRIDGE_LENGTH.getNormalStatement());
            int bridgeLength = new InputView().readBridgeSize();
            return crossableBridges = bridgeMaker.makeBridge(bridgeLength);
    }

    public static BridgeGame chooseToMoveOn(BridgeGame bridgeGame, List<String> crossableBridges){
            outputView.printStatements(NormalStatements.ASK_BRIDGE_TO_MOVE_ON.getNormalStatement());
            for(int i=0; i<crossableBridges.size(); i++) {
                bridgeGame.checkWinOrFail(crossableBridges.get(i), inputView.readMoving());
                if(bridgeGame.checkWinOrFail(crossableBridges.get(i), inputView.readMoving())==true){
                    break;
                }
                outputView.printMap(i, crossableBridges.size(), crossableBridges.get(i));
            }

    }
}
