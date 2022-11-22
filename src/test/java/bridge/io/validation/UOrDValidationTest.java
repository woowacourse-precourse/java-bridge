package bridge.io.validation;

import bridge.enums.ExceptionMessage;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class UOrDValidationTest {

  @ParameterizedTest
  @ValueSource(strings = {"u", "d", "A", "U ", " D", "UU", "DD", "2424", "0", "-2497", "wooteco"})
  void 입력값이_U또는_D가_아니라면_예외를_던지는가(String input) {
    UOrDValidation uOrDValidation = new UOrDValidation(new NullValidation());
    assertThatThrownBy(() -> uOrDValidation.validate(input))
      .isInstanceOf(IllegalArgumentException.class)
      .hasMessageContaining(ExceptionMessage.ERROR.getMessage() + ExceptionMessage.NOT_U_OR_D.getMessage());
  }

  @ParameterizedTest
  @ValueSource(strings = {"U", "D"})
  void 입력값이_U혹은_D라면_정상적으로_작동하는가(String input) {
    UOrDValidation uOrDValidation = new UOrDValidation(new NullValidation());
    assertThatCode(() -> uOrDValidation.validate(input))
      .doesNotThrowAnyException();
  }

}