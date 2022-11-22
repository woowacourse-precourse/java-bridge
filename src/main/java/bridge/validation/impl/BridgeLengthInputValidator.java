package bridge.validation.impl;

import bridge.config.BridgeInformation;
import bridge.dto.InputValidationDto.Request;
import bridge.dto.InputValidationDto.Response;
import bridge.exception.ErrorCode;
import bridge.type.InputType;
import bridge.validation.InputValidationChain;

public class BridgeLengthInputValidator implements InputValidationChain {

    private InputValidationChain next;

    @Override
    public void setNextChain(InputValidationChain nextChain) {
        next = nextChain;
    }

    @Override
    public Response validate(final Request request) {
        if (!request.getType().equals(InputType.BRIDGE_LENGTH)) {
            return next.validate(request);
        }
        return validateNumericAndRange(request);
    }

    private Response validateNumericAndRange(final Request request) {
        if (!isNumeric(request.getTarget())) {
            return new Response(false, ErrorCode.NOT_NUMERIC_VALUE.getMessage());
        }
        if (!isInRange(Integer.parseInt(request.getTarget()))) {
            return new Response(false, String.format(ErrorCode.OUT_OF_RANGE.getMessage(),
                BridgeInformation.MIN_SIZE, BridgeInformation.MAX_SIZE));
        }
        return new Response(true);
    }

    private boolean isNumeric(final String target) {
        return !target.isBlank() && target.chars().allMatch(Character::isDigit);
    }

    private boolean isInRange(final Integer target) {
        return BridgeInformation.MIN_SIZE <= target && BridgeInformation.MAX_SIZE >= target;
    }
}
