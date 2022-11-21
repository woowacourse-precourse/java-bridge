package bridge.domain;

import bridge.domain.game.SuccessStep;
import bridge.domain.generator.BridgeMaker;

import java.util.List;

public class Bridge {
    private final List<String> answerBridge;
    private static int nowPosition;
    private InputValidator inputValidator;

    public static int getNowPosition() {
        return nowPosition;
    }

    public Bridge(BridgeMaker bridgeMaker, int size) {
        nowPosition = 0;
        this.answerBridge = bridgeMaker.makeBridge(size);
        this.inputValidator = new InputValidator();
    }

    public SuccessStep go(String userStep){
        inputValidator.checkUpDown(userStep);
        SuccessStep result = SuccessStep.compareStep(answerBridge.get(nowPosition), userStep);
        if (result.getStatus()){
            nowPosition++;
        }
        return result;
    }

    //끝까지 갔으면 false, 아직 진행 가능이면 true
    public boolean bridgeEnd(int userPosition){
        return userPosition != answerBridge.size();
    }

}
