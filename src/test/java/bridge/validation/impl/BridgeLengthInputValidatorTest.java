package bridge.validation.impl;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.config.BridgeInformation;
import bridge.dto.InputValidationDto.Request;
import bridge.dto.InputValidationDto.Response;
import bridge.exception.ErrorCode;
import bridge.type.InputType;
import bridge.validation.InputValidationChain;
import org.junit.jupiter.api.Test;

class BridgeLengthInputValidatorTest {

    private final InputValidationChain validator = new BridgeLengthInputValidator();

    @Test
    public void validateRangeFailure() {
        //given
        String target1 = "2";
        String target2 = "21";
        Request request1 = new Request(InputType.BRIDGE_LENGTH, target1);
        Request request2 = new Request(InputType.BRIDGE_LENGTH, target2);

        //when
        Response response1 = validator.validate(request1);
        Response response2 = validator.validate(request2);

        //then
        String errorMessage = String.format(ErrorCode.OUT_OF_RANGE.getMessage(),
            BridgeInformation.MIN_SIZE, BridgeInformation.MAX_SIZE);
        assertThat(response1.isValid()).isFalse();
        assertThat(response2.isValid()).isFalse();
        assertThat(response1.getErrorMessage()).isEqualTo(errorMessage);
        assertThat(response2.getErrorMessage()).isEqualTo(errorMessage);
    }

    @Test
    public void validateNumericFailure() {
        //given
        String target = "test";
        Request request = new Request(InputType.BRIDGE_LENGTH, target);

        //when
        Response response = validator.validate(request);

        //then
        assertThat(response.isValid()).isFalse();
        assertThat(response.getErrorMessage()).isEqualTo(ErrorCode.NOT_NUMERIC_VALUE.getMessage());
    }

    @Test
    public void validateSuccess() {
        //given
        String target1 = "3";
        String target2 = "20";
        Request request1 = new Request(InputType.BRIDGE_LENGTH, target1);
        Request request2 = new Request(InputType.BRIDGE_LENGTH, target2);

        //when
        Response response1 = validator.validate(request1);
        Response response2 = validator.validate(request2);

        //then
        assertThat(response1.isValid()).isTrue();
        assertThat(response2.isValid()).isTrue();
    }
}