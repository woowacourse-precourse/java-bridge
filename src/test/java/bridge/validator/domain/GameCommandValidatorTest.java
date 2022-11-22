package bridge.validator.domain;

import static org.junit.jupiter.api.Assertions.*;

import bridge.domain.GameCommand;
import bridge.exception.InvalidGameCommandException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameCommandValidatorTest {
  @Test
  @DisplayName("잘못된 명령어를 입력하면 예외가 반환된다.")
  void invalidGameCommandInputTest() {
    assertThrows(InvalidGameCommandException.class, () -> GameCommandValidator.validate("D"));
    assertThrows(InvalidGameCommandException.class, () -> GameCommandValidator.validate("QQ"));
    assertThrows(InvalidGameCommandException.class, () -> GameCommandValidator.validate(" "));
  }

  @Test
  @DisplayName("옳바른 명령어를 입력한다.")
  void validGameCommandInputTest() {
    assertDoesNotThrow(() -> GameCommandValidator.validate(GameCommand.QUIT.getCommand()));
    assertDoesNotThrow(() -> GameCommandValidator.validate(GameCommand.RETRY.getCommand()));
  }
}
