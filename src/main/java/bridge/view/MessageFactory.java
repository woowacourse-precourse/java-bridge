package bridge.view;

import bridge.dto.StepResponseDto;

public interface MessageFactory {

    String successMessage();

    String failMessage();

    String finalMessage(final StepResponseDto stepResponseDto);
}
