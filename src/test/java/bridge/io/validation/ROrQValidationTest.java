package bridge.io.validation;

import bridge.enums.ExceptionMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class ROrQValidationTest {

  @ParameterizedTest
  @ValueSource(strings = {"r", "q", "A", "R ", " Q", "RR", "QQ", "2424", "0", "-2497", "wooteco"})
  void 입력값이_R또는_Q가_아니라면_예외를_던지는가(String input) {
    ROrQValidation rOrQValidation = new ROrQValidation(new NullValidation());
    assertThatThrownBy(() -> rOrQValidation.validate(input))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessageContaining(ExceptionMessage.ERROR.getMessage() + ExceptionMessage.NOT_R_OR_Q.getMessage());
  }

  @ParameterizedTest
  @ValueSource(strings = {"R", "Q"})
  void 입력값이_R혹은_Q라면_정상적으로_작동하는가(String input) {
    ROrQValidation rOrQValidation = new ROrQValidation(new NullValidation());
    assertThatCode(() -> rOrQValidation.validate(input))
      .doesNotThrowAnyException();
  }

}