package bridge.domain.command;


import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.domain.BridgeArea;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeMoveCommandTest {

  @ParameterizedTest
  @ValueSource(strings = {"Z", "K", "1"})
  void Bridge의_영역을_나타내는값이_아닌_값이오면_에러가_발생한다(String input) {
    // Bridge의 영역 -> U or D
    assertThatThrownBy(() -> new BridgeMoveCommand(input))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @ValueSource(strings = {"U", "D"})
  void Bridge의_영역을_나타내는값이오면_성공(String input) {
    // Bridge의 영역 -> U or D
    BridgeMoveCommand command = new BridgeMoveCommand(input);
    assertThat(command.getArea()).isInstanceOf(BridgeArea.class);
  }
}