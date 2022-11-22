package bridge;

import java.util.List;

public class Application {

    public static void main(String[] args) {

    }

    private static List<String> makeBridge(int bridgeSize){
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        return bridgeMaker.makeBridge(bridgeSize);
    }

    private static String bridgeState(BridgeGame bridgeGame, List<String> bridge, int index){
        String userMove = InputView.repeatInputMoving();
        String rightWrong = bridgeGame.moveUpDown(bridge.get(index),userMove);
        OutputView.printMap(bridgeGame);
        return rightWrong;
    }

    private static boolean chooseRetryQuit(BridgeGame bridgeGame,int count){
        String gameCommand = InputView.repeatInputRetry();
        if(!bridgeGame.retry(gameCommand)){
            return endGame(bridgeGame,"실패",count);
        }
        return false;
    }

    private static boolean endGame(BridgeGame bridgeGame,String result,int count){
        OutputView.printResult(bridgeGame,result,count);

        if(result.equals("성공") || result.equals("실패")){
            return true;
        }
        return false;
    }


}
