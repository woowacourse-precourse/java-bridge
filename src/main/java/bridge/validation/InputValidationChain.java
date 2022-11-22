package bridge.validation;

import bridge.dto.InputValidationDto;

public interface InputValidationChain {

    void setNextChain(InputValidationChain nextChain);

    InputValidationDto.Response validate(InputValidationDto.Request request);
}
