package bridge;

import java.util.List;

public class Application {
    private static final InputView input = new InputView();
    private static final BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
    private static final BridgeMaker bridgeMaker = new BridgeMaker(bridgeRandomNumberGenerator);
    private static final BridgeGame bridgeGame = new BridgeGame();
    private static final OutputView output = new OutputView();
    public static void main(String[] args) {
        int size;
        try{
            size = input.readBridgeSize();
            List<String> bridge = bridgeMaker.makeBridge(size);
            int trial = 1;
            String success = "실패";

            while (true) {
                if(bridgeGame.move(bridge)){
                    success = "성공";
                    break;
                }

                if(bridgeGame.retry()){
                    trial++;
                    continue;
                }
                break;
            }

            output.printResult(success, trial);

        } catch (RuntimeException error){
            System.out.println(error);
        }
    }

}
