package bridge.domain;

import bridge.domain.game.SuccessStep;

import java.util.List;

public class Bridge {
    private List<String> answerBridge;
    private int nowPosition;
    private InputValidator inputValidator;

    public void initNowPosition() {
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

    public boolean bridgeEnd() {
        return nowPosition == answerBridge.size();
    }

}
