package bridge;

import java.util.List;

public class BridgeController {
    private static InputView inputView = new InputView();
    private OutputView outputView = new OutputView();
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
        boolean breakPoint = isPossibleMove.getCode().equals("X");
        if(printMove(isPossibleMove)&&!breakPoint) return false;
        if(breakPoint){
            return restartCheck();
        }
        return true;
    }

    public boolean printMove(BirdgeMoveType isPossibleMove){

        return outputView.printMap(isPossibleMove,inputView,bridgeGame);
    }
    public boolean restartCheck(){
        String restartCommand=inputView.readGameCommand();
        return restartComDivide(restartCommand);
    }
    public boolean restartComDivide(String restartCommand){
        if (restartCommand.equals("R")){
            outputView = new OutputView();
            bridgeGame.retry();
            return true; }
        if (restartCommand.equals("Q")) {
            System.out.println("게임 성공 여부: 실패");
            outputView.printResult(bridgeGame);
            return false; }
        throw new IllegalArgumentException("[ERROR] R / Q 로 입력해주세요");
    }
}
