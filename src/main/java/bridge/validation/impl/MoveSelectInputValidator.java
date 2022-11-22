package bridge.validation.impl;

import bridge.dto.InputValidationDto.Request;
import bridge.dto.InputValidationDto.Response;
import bridge.exception.ErrorCode;
import bridge.type.BridgeSpaceStatus;
import bridge.type.InputType;
import bridge.validation.InputValidationChain;
import bridge.validation.support.ValidationSupport;

public class MoveSelectInputValidator extends ValidationSupport implements InputValidationChain {

    private InputValidationChain next;

    @Override
    public void setNextChain(InputValidationChain nextChain) {
        next = nextChain;
    }

    @Override
    public Response validate(final Request request) {
        if (!request.getType().equals(InputType.MOVE_SELECT)) {
            return next.validate(request);
        }
        if (!isExceptedLetter(request, BridgeSpaceStatus.UP.getLetter(),
            BridgeSpaceStatus.DOWN.getLetter())) {
            return new Response(false, ErrorCode.INVALID_INPUT.getMessage());
        }
        return new Response(true);
    }
}
