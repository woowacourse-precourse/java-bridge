package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        start();
    }

    private static List<String> makeBridge(int bridgeSize){
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        return bridgeMaker.makeBridge(bridgeSize);
    }

    private static void start(){
        System.out.println("다리 건너기 게임을 시작합니다.\n");
        int bridgeSize = InputView.readBridgeSize();
        List<String> bridge = new ArrayList<>(makeBridge(bridgeSize));
        int playCount = 1;
        playGameUntilEnd(bridge,playCount);
    }

    private static void playGameUntilEnd(List<String> bridge,int playCount){
        while(true) {
            if(playGame(bridge,playCount++)){
                break;
            }
        }
    }

    private static boolean playGame(List<String> bridge, int count){
        BridgeGame bridgeGame = new BridgeGame();
        for(int i = 0 ; i < bridge.size(); i++){
            String rightWrong = bridgeState(bridgeGame,bridge,i);
            if(rightWrong.equals("X")){
                return chooseRetryQuit(bridgeGame,count);
            }
        }
        return endGame(bridgeGame,"성공",count);
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
