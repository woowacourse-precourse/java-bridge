package bridge.domain;

import bridge.domain.game.SuccessStep;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private List<String> answerBridge;
    private static int nowPosition;
    private InputValidator inputValidator;

    public static int getNowPosition() {
        return nowPosition;
    }

    public Bridge(BridgeMaker bridgeMaker, int size) {
        nowPosition = 0;
        this.answerBridge = bridgeMaker.makeBridge(size);
    }

    public void go(String userStep){
        inputValidator.checkUpDown(userStep);
        SuccessStep result = SuccessStep.compareStep(answerBridge.get(nowPosition), userStep);
        if (result.getStatus()){
            nowPosition++;
        }
    }

    //끝까지 갔으면 false, 아직 진행 가능이면 true
    public boolean bridgeEnd(int userPosition){
        return userPosition != answerBridge.size();
    }

}
