package bridge;

import View.InputView;
import View.OutputView;
import java.util.List;
import data.InputGuide;

public class BridgeMaster {
    BridgeRandomNumberGenerator tempGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(tempGenerator);
    BridgeGame bridgeGame = new BridgeGame();
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();

    int attempt = 0;
    boolean isSuccess = false;
    void startGame(){
        boolean starter = true;
        while(starter){
            List<String> bridge = startFirstPhase();
            System.out.println(bridge);
            startSecondPhase();
            starter = startThirdPhase();
        }
    }

    List<String> startFirstPhase(){
        InputGuide.printWelcomeMessage();
        int size = inputView.readBridgeSize();

        System.out.println();
        return bridgeMaker.makeBridge(size);
    }

    void startSecondPhase(){

    }

    boolean startThirdPhase(){
        return false;
    }

}
