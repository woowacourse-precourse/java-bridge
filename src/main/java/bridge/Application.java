package bridge;

import java.util.List;

import static bridge.Count.getAttempts;
import static bridge.EndGame.endGame;
import static bridge.EndGame.fail;

public class Application {
    private static boolean repeat = true;
    private static boolean end = false;
    
    
    public static void main(String[] args) {
       try{
           System.out.println("다리 건너기 게임을 시작합니다.");
           InputView inputView = new InputView();
           OutputView outputView = new OutputView();
           int bridgeSize = inputView.readBridgeSize();
           BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
           List<String> bridge = bridgeMaker.makeBridge(bridgeSize);
           loop(bridgeSize, bridge);
           int attempts = getAttempts();
           outputView.printResult(attempts, repeat);
       }
       catch(Exception e){
           System.out.println("[ERROR]");
       }
    }
    
    public static void loop(int bridgeSize, List<String> bridge) throws Exception{
        IllegalArgumentException illegalArgumentException = new IllegalArgumentException();
        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        while(repeat){
            if(end){
                break;
            }
            String step = inputView.readMoving();
            BridgeGame bridgeGame = new BridgeGame();
            repeat = bridgeGame.move(bridge, step);
            if(repeat){
                end = endGame(bridgeSize);
                outputView.printMap();
                continue;
            }
            outputView.printMap();
            fail();
            throw illegalArgumentException;
        }
    }
}
