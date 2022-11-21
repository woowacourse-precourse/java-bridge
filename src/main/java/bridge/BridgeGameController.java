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

    public static BridgeGame chooseToMoveOn(List<String> crossableBridges){
            outputView.printStatements(NormalStatements.ASK_BRIDGE_TO_MOVE_ON.getNormalStatement());
            BridgeGame bridgeGame = new BridgeGame(crossableBridges);
            for(int i=1; i<crossableBridges.size()+1; i++) {
                bridgeGame.checkWinOrFail(crossableBridges.get(i), inputView.readMoving());
                if(bridgeGame.checkWinOrFail(crossableBridges.get(i), inputView.readMoving())=="fail"){
                outputView.printFailedMap(i, crossableBridges.size(), crossableBridges.get(i));
                outputView.printStatements(NormalStatements.ASK_RETRY.getNormalStatement());
                if(inputView.readGameCommand()=="R"){
                    i=1;
                }
                if(inputView.readGameCommand()=="Q"){
                    outputView.printStatements(NormalStatements.DECLARE_RESULT.getNormalStatement());
                    outputView.printFailedMap(i, crossableBridges.size(), crossableBridges.get(i));
                    outputView.printStatements(NormalStatements.RESULT_FAIL.getNormalStatement());
                    outputView.printStatements(NormalStatements.SHOW_GAME_TRIALS.getNormalStatement()
                            +BridgeGame.getTotalGameTrials());
                }
                }
                outputView.printMap(i, crossableBridges.size(), crossableBridges.get(i));
            }

    }
}
