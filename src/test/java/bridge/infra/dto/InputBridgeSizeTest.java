package bridge.infra.dto;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputBridgeSizeTest {

  @ParameterizedTest
  @ValueSource(strings = {"Z", "K", "1z"})
  void 숫자가아닌_값을입력하면_에러가발생한다(String input) {
    assertThatThrownBy(() -> new InputBridgeSize(input))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @ValueSource(strings = {"1", "2", "33"})
  void 숫자를입력하면_성공한다(String input) {
    InputBridgeSize inputBridgeSize = new InputBridgeSize(input);
    assertThat(inputBridgeSize.getSize()).isEqualTo(Integer.parseInt(input));
  }
}