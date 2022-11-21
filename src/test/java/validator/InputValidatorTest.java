package validator;

import static model.BridgeGame.MAXIMUM_BRIDGE_SIZE;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import model.BridgeGame;
import model.InputValidator;
import model.enums.MoveChoice;
import model.enums.RetryIntention;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

public class InputValidatorTest {

    private InputValidator inputValidator = new InputValidator();

    @Nested
    @DisplayName("validateBridgeLength 메서드는 다리 길이를 입력받아")
    class describe_validateBridgeLength {

        @Test
        @DisplayName("알맞은 입력인 경우 아무것도 하지 않는다.")
        void normalTest() {
            for (int i = MAXIMUM_BRIDGE_SIZE; i <= MAXIMUM_BRIDGE_SIZE; i++) {
                inputValidator.validateBridgeLength(i);
            }
        }

        @Test
        @DisplayName("범위를 벗어난 경우 예외를 발생시킨다.")
        void throwExceptionTest() {
            assertThatThrownBy(() -> inputValidator.validateBridgeLength(2))
                    .isInstanceOf(IllegalArgumentException.class);

            assertThatThrownBy(() -> inputValidator.validateBridgeLength(21))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("validateMoveChoice 메서드는 이동 방향을 입력받아")
    class describe_validateMoveChoice {

        @Test
        @DisplayName("알맞은 입력인 경우 아무것도 하지 않는다.")
        void normalTest() {
            inputValidator.validateMoveChoice(MoveChoice.UP.moving);
            inputValidator.validateMoveChoice(MoveChoice.DOWN.moving);
        }

        @Test
        @DisplayName("잘못된 입력인 경우 예외를 발생시킨다.")
        void throwExceptionTest() {
            assertThatThrownBy(() -> inputValidator.validateMoveChoice("a"))
                    .isInstanceOf(IllegalArgumentException.class);

            assertThatThrownBy(() -> inputValidator.validateMoveChoice("w"))
                    .isInstanceOf(IllegalArgumentException.class);

            assertThatThrownBy(() -> inputValidator.validateMoveChoice("6"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Nested
    @DisplayName("validateRetryIntention 메서드는 게임 재시도 여부를 입력받아")
    class describe_validateRetryIntention {

        @Test
        @DisplayName("알맞은 입력인 경우 아무것도 하지 않는다.")
        void normalTest() {
            inputValidator.validateRetryIntention(RetryIntention.RETRY.intention);
            inputValidator.validateRetryIntention(RetryIntention.QUIT.intention);
        }

        @Test
        @DisplayName("잘못된 입력인 경우 예외를 발생시킨다.")
        void throwExceptionTest() {
            assertThatThrownBy(() -> inputValidator.validateRetryIntention("q"))
                    .isInstanceOf(IllegalArgumentException.class);

            assertThatThrownBy(() -> inputValidator.validateRetryIntention("r"))
                    .isInstanceOf(IllegalArgumentException.class);
        }
    }
}
