package bridge.view;

import static bridge.view.MessageMaker.NEW_LINE;

import bridge.dto.StepResponseDto;
import global.config.AppConfig;

public enum OutputMessage {
    START_LINE("["),
    END_LINE("]"),
    SUCCESS(" O "),
    FAIL(" X "),
    EMPTY("   "),
    SPLIT("|"),
    FINAL_SUCCESS("게임 성공 여부: 성공"),
    FINAL_FAIL("게임 성공 여부: 실패");

    private final String message;


    OutputMessage(String message) {
        this.message = message;
    }

    public static String getStepMessage(final StepResponseDto stepResponseDto) {
        MessageFactory messageFactory = new AppConfig().messageFactory(stepResponseDto.getStep());
        if (stepResponseDto.isSuccess()) {
            return messageFactory.successMessage();
        }
        return messageFactory.failMessage();
    }

    public static String getFinalMessage(final StepResponseDto stepResponseDto) {
        MessageFactory messageFactory = new AppConfig().messageFactory(stepResponseDto.getStep());
        if (stepResponseDto.isFinal()) {
            return messageFactory.successMessage() + NEW_LINE +messageFactory.finalMessage(stepResponseDto);
        }
        return messageFactory.failMessage() + NEW_LINE + messageFactory.finalMessage(stepResponseDto);
    }


    public static String findMessage(OutputMessage outputMessage) {
        return outputMessage.message;
    }
}
