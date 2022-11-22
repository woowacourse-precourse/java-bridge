package bridge.io.validation;

import bridge.enums.ExceptionMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class NullValidationTest {

  @ParameterizedTest
  @ValueSource(strings = {" ", "", "             "})
  void 입력값이_null인지_테스트(String input) {
    NullValidation nullValidation = new NullValidation();
    assertThatThrownBy(() -> nullValidation.validate(input))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessageContaining(ExceptionMessage.ERROR.getMessage() + ExceptionMessage.NULL.getMessage());
  }

  @ParameterizedTest
  @ValueSource(strings = {"1", "wooteco", "-2938742", "0", "3743892", "*&^%^&$"})
  void 입력값이_null이_아니라면_정상적으로_작동하는가(String input) {
    NullValidation nullValidation = new NullValidation();
    assertThatCode(() -> nullValidation.validate(input))
      .doesNotThrowAnyException();
  }
}