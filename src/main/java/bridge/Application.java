package bridge;

import java.util.ArrayList;
import java.util.List;

public class Application {

    public static void main(String[] args) {
        InputView inputView = new InputView();
        int n = inputView.readBridgeSize();
        BridgeRandomNumberGenerator bridgeRandomNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bm = new BridgeMaker(bridgeRandomNumberGenerator);
        List<String> bridge = bm.makeBridge(n);
        OutputView output = new OutputView();
        List<String> nextStep = new ArrayList<>();
        BridgeGame game = new BridgeGame();

        int turn=0;
        int tryCount=1;
        int count=0;
        int cnt=0;

        while(turn<bridge.size()){
            nextStep.add(inputView.readMoving());
            System.out.println(nextStep);
            turn = game.move(turn);
            String ret = output.printMap(nextStep,bridge,turn);

            if(ret.equals(" X ")){
                String re = inputView.readGameCommand();
                cnt = game.retry(re);
                tryCount++;
                count=turn;
                turn=0;
            }
            if(ret.equals(" X ") && cnt==0) {
                tryCount--;
                break;
            }
            if (ret.equals(" X ") && nextStep.size() > 0)
                nextStep.subList(0, nextStep.size()).clear();
            count=turn;
        }
        if(count>0)
            output.printResult(bridge, nextStep, tryCount, count);
    }
}
