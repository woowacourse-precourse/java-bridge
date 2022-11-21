package bridge;

import java.util.List;
import java.util.ArrayList;

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
            startFirstPhase();
            startSecondPhase();
            startThirdPhase();
        }
    }

    void startFirstPhase(){

    }

    void startSecondPhase(){

    }

    void startThirdPhase(){

    }
}
