package bridge.domain;

import bridge.domain.game.SuccessStep;
import bridge.domain.generator.BridgeMaker;

import java.util.ArrayList;
import java.util.List;

public class Bridge {
    private List<String> answerBridge;
    private int nowPosition;
    private InputValidator inputValidator;

    public int getNowPosition() {
        return nowPosition;
    }

    public void initNowPosition(){
        nowPosition = 0;
    }

    public Bridge(List<String> answer) {
        nowPosition = 0;
        this.answerBridge = answer;
        this.inputValidator = new InputValidator();
    }

    public SuccessStep go(String userStep) {
        inputValidator.checkUpDown(userStep);
        SuccessStep result = SuccessStep.compareStep(answerBridge.get(nowPosition), userStep);
        if (result.getStatus()) {
            nowPosition++;
        }
        return result;
    }
    //끝까지 갔으면 false, 아직 진행 가능이면 true
    public boolean bridgeEnd() {
        return nowPosition != answerBridge.size();
    }

}
