package bridge;

import java.util.ArrayList;
import java.util.List;

import static bridge.BridgeGame.*;

public class Application {
    private static BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    static BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    static int trial = 0;
    public static void startGame(){
        OutputView.printStart();
        List<String> bridge = bridgeMaker.makeBridge(InputView.readBridgeSize());
        boolean success = move(bridge);
        while(!success){
            OutputView.printRetry();
            String command = InputView.readGameCommand();
            if(checkCommand(command)) {
                success = retry(bridge);
                trial++;
            }
        }
        OutputView.printResult(bridge, inputMove);
        OutputView.printSuccess(OutputView.ifSuccess(success));
        OutputView.printRetry(trial+1);
    }
    public static void makeMove(){
        OutputView.printGetMove();
        inputMove.add(InputView.readMoving());
    }
    public static void makeMap(int i, List<String> bridge, List<String> inputMove){
        OutputView.printMap(i, bridge, inputMove);
    }
    public static void main(String[] args) {
        // TODO: 프로그램 구현
        startGame();
    }
}
