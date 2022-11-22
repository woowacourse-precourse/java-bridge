package bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.Print;

import java.util.ArrayList;
import java.util.List;

public class GameSetting {
    InputView inputView = new InputView();
    private List<String> bridge = new ArrayList<>();
    private String userInput;
    private String userRetryInput;

    public List<String> getBridge() {
        return bridge;
    }


    public List<String> make(int bridgeSize) { //입력값만큼 다리 만들고 랜덤값 넣기
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        bridge = bridgeMaker.makeBridge(bridgeSize);
        return bridge;
    }

    public String validateMoveInput(){
        int retryCheckNumber = 1;
        while (retryCheckNumber != 0) {
            Print.requestPickAPartOfBridgeMessage();
            try {
                userInput = inputView.readMoving();
                System.out.println("userInput 받은거 " + userInput );
                retryCheckNumber = 0;
            } catch (IllegalArgumentException e) {
                Print.exceptionMessage(e);
                retryCheckNumber = 1;
            }
        }
        return userInput;
    }

    public String validateRetryInput(){
        int retryCheckNumber = 1;
        while (retryCheckNumber != 0) {
            Print.askRetryMessage();
            try {
                userRetryInput = inputView.readGameCommand();
                retryCheckNumber = 0;
            } catch (IllegalArgumentException e) {
                Print.exceptionMessage(e);
                retryCheckNumber = 1;
            }
        }
        return userRetryInput;
    }
}
