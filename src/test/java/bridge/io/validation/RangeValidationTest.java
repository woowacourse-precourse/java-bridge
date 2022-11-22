package bridge.io.validation;

import bridge.enums.ExceptionMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class RangeValidationTest {

  @ParameterizedTest
  @ValueSource(strings = {"0", "1", "2", "-1", "21", "22", "-2837", "2387"})
  void 입력값이_3에서_20사이의_숫자가_아니라면_예외를_던지는가(String input) {
    RangeValidation rangeValidation = new RangeValidation(new NullValidation());
    assertThatThrownBy(() -> rangeValidation.validate(input))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessageContaining(ExceptionMessage.ERROR.getMessage() + ExceptionMessage.NOT_IN_RANGE.getMessage());
  }

}