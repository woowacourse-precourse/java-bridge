package bridge.view;

import bridge.dto.StepResponseDto;
import global.config.AppConfig;

public enum OutputMessage {
    START_LINE("["),
    END_LINE("]"),
    SUCCESS(" O "),
    FAIL(" X "),
    EMPTY("   "),
    SPLIT("|");

    private final String message;

    OutputMessage(String message) {
        this.message = message;
    }

    public static String getStepMessage(StepResponseDto stepResponseDto) {
        MessageFactory messageFactory = new AppConfig().messageFactory(stepResponseDto.getStep());
        if (stepResponseDto.isSuccess()) {
            return messageFactory.successMessage();
        }
        return messageFactory.failMessage();
    }

    public static String findMessage(OutputMessage outputMessage) {
        return outputMessage.message;
    }
}
