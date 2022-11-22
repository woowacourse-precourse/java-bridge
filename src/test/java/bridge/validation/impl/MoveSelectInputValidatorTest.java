package bridge.validation.impl;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.dto.InputValidationDto.Request;
import bridge.dto.InputValidationDto.Response;
import bridge.exception.ErrorCode;
import bridge.type.BridgeSpaceStatus;
import bridge.type.InputType;
import bridge.validation.InputValidationChain;
import org.junit.jupiter.api.Test;

class MoveSelectInputValidatorTest {

    private final InputValidationChain validator = new MoveSelectInputValidator();

    @Test
    public void validateInvalidInputFailure() {
        //given
        String target = "A";
        Request request = new Request(InputType.MOVE_SELECT, target);

        //when
        Response response = validator.validate(request);

        //then
        assertThat(response.isValid()).isFalse();
        assertThat(response.getErrorMessage()).isEqualTo(ErrorCode.INVALID_INPUT.getMessage());
    }

    @Test
    public void validateSuccess() {
        //given
        Request request1 = new Request(InputType.MOVE_SELECT, BridgeSpaceStatus.UP.getLetter());
        Request request2 = new Request(InputType.MOVE_SELECT, BridgeSpaceStatus.DOWN.getLetter());

        //when
        Response response1 = validator.validate(request1);
        Response response2 = validator.validate(request2);

        //then
        assertThat(response1.isValid()).isTrue();
        assertThat(response2.isValid()).isTrue();
    }
}