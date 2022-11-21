package bridge;

import java.util.List;

public class BridgeController {
    private static InputView inputView = new InputView();
    private static OutputView outputView = new OutputView();
    private BridgeGame bridgeGame;
    public BridgeGame doBridgeMake(){

        int bridgeSize = inputView.readBridgeSize();

        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> bridgeList = bridgeMaker.makeBridge(bridgeSize);
        bridgeGame = new BridgeGame(bridgeList);
        return bridgeGame;
    }

    public boolean doBridgeMove(BridgeGame bridgeGame){
        String moveWay = inputView.readMoving();

        BirdgeMoveType isPossibleMove = bridgeGame.move(moveWay);
        printMove(isPossibleMove);

        if(isPossibleMove.getCode().equals("X")){
            boolean restart = restartCheck();
            return restart;
        }
        return true;
    }

    public void printMove(BirdgeMoveType isPossibleMove){

        System.out.println(isPossibleMove);
        outputView.printMap(isPossibleMove);
    }
    public boolean restartCheck(){
        String restartCommand=inputView.readGameCommand();
        if (restartCommand.equals("R")){
            outputView = new OutputView();
            bridgeGame.retry();
            return true;
        } else if (restartCommand.equals("Q")) {
            outputView.printResult();
            return false;
        }
        throw new IllegalArgumentException("[ERROR] R / Q 로 입력해주세요");
    }
}
