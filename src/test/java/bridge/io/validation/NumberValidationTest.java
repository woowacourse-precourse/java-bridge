package bridge.io.validation;

import bridge.enums.ExceptionMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class NumberValidationTest {

  @ParameterizedTest
  @ValueSource(strings = {"a", "2147483648", "우테코너무하구싶다"})
  void 입력값이_integer_숫자가_아니라면_예외를_던지는가(String input) {
    NumberValidation numberValidation = new NumberValidation(new NullValidation());
    assertThatThrownBy(() -> numberValidation.validate(input))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessageContaining(ExceptionMessage.ERROR.getMessage() + ExceptionMessage.NOT_A_NUMBER.getMessage());
  }

  @ParameterizedTest
  @ValueSource(strings = {"1", "2147483647", "-1234726", "0"})
  void 입력값이_integer_숫자라면_정상적으로_작동하는가(String input) {
    NumberValidation numberValidation = new NumberValidation(new NullValidation());
    assertThatCode(() -> numberValidation.validate(input))
      .doesNotThrowAnyException();
  }

}