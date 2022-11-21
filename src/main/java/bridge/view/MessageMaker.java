package bridge.view;

import static bridge.BridgeMaker.TOP_ROW;
import static bridge.view.OutputMessage.EMPTY;
import static bridge.view.OutputMessage.END_LINE;
import static bridge.view.OutputMessage.FAIL;
import static bridge.view.OutputMessage.FINAL_FAIL;
import static bridge.view.OutputMessage.FINAL_SUCCESS;
import static bridge.view.OutputMessage.SPLIT;
import static bridge.view.OutputMessage.START_LINE;
import static bridge.view.OutputMessage.SUCCESS;
import static bridge.view.OutputMessage.findMessage;

import bridge.dto.StepResponseDto;
import java.util.List;

public class MessageMaker implements MessageFactory{

    public static final String RETRY_MESSAGE = "총 시도한 횟수: ";
    public static final String NEW_LINE = "\n";

    private final StringBuilder upperBridge;
    private final StringBuilder underBridge;
    private final List<String> steps;

    public MessageMaker(final List<String> steps){
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

    @Override
    public String finalMessage(final StepResponseDto stepResponseDto) {
        if (stepResponseDto.isFinal()) {
            return findMessage(FINAL_SUCCESS) + NEW_LINE + RETRY_MESSAGE + stepResponseDto.getRetryCount();
        }
        return findMessage(FINAL_FAIL) + NEW_LINE + RETRY_MESSAGE + stepResponseDto.getRetryCount();
    }

    private void judgeMessageLocation(final int step, final OutputMessage message) {
        if (steps.get(step).equals(TOP_ROW)) {
            appendStepMessage(findMessage(message), findMessage(EMPTY));
            return;
        }
        appendStepMessage(findMessage(EMPTY), findMessage(message));
    }

    private void appendStepMessage(final String upperMessage, final String underMessage) {
        upperBridge.append(upperMessage).append(findMessage(SPLIT));
        underBridge.append(underMessage).append(findMessage(SPLIT));
    }

    private String replaceFinalMessage(StringBuilder upperBridge, StringBuilder underBridge) {
        upperBridge.deleteCharAt(upperBridge.length() - 1).append(findMessage(END_LINE));
        underBridge.deleteCharAt(upperBridge.length() - 1).append(findMessage(END_LINE));
        return upperBridge + NEW_LINE + underBridge + NEW_LINE;
    }
}
