package bridge.view;

import static bridge.BridgeMaker.TOP_ROW;
import static bridge.view.OutputMessage.*;

import java.util.List;

public class MessageMaker implements MessageFactory{

    private final StringBuilder upperBridge;
    private final StringBuilder underBridge;
    private final List<String> steps;

    public MessageMaker(List<String> steps){
        this.upperBridge = new StringBuilder(findMessage(START_LINE));
        this.underBridge = new StringBuilder(findMessage(START_LINE));
        this.steps = steps;
    }

    @Override
    public String successMessage() {
        for (int step = 0; step < steps.size(); step++) {
            judgeMessageLocation(step, SUCCESS);
        }
        return replaceFinalMessage(upperBridge, underBridge);
    }

    @Override
    public String failMessage() {
        for (int step = 0; step < steps.size(); step++) {
            if (step == steps.size() - 1) {
                judgeMessageLocation(step, FAIL);
                break;
            }
            judgeMessageLocation(step, SUCCESS);
        }
        return replaceFinalMessage(upperBridge, underBridge);
    }

    private void judgeMessageLocation(int step, OutputMessage message) {
        if (steps.get(step).equals(TOP_ROW)) {
            appendMessage(findMessage(message), findMessage(EMPTY));
            return;
        }
        appendMessage(findMessage(EMPTY), findMessage(message));
    }

    private void appendMessage(String upperMessage, String underMessage) {
        upperBridge.append(upperMessage).append(findMessage(SPLIT));
        underBridge.append(underMessage).append(findMessage(SPLIT));
    }

    private String replaceFinalMessage(StringBuilder upperBridge, StringBuilder underBridge) {
        upperBridge.deleteCharAt(upperBridge.length() - 1).append(findMessage(END_LINE));
        underBridge.deleteCharAt(upperBridge.length() - 1).append(findMessage(END_LINE));
        return upperBridge + "\n" + underBridge;
    }
}
