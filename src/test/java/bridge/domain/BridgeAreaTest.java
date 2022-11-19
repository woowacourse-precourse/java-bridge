package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeAreaTest {

  @ParameterizedTest
  @ValueSource(strings = {"U", "D"})
  void 다리영역을_표현하는_문자_입력시_변환성공(String input) {
    BridgeArea area = BridgeArea.of(input);
    assertThat(area.name()).isEqualTo(input);
  }

  @ParameterizedTest
  @ValueSource(strings = {"Z", "J", "KKK"})
  void 다리영역을_표현하는_문자가아니면_에러발생(String input) {
    assertThatThrownBy(() -> BridgeArea.of(input))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @ValueSource(ints = {0, 1})
  void 다리영역을_표현하는_숫자_입력시_변환성공(int input) {
    BridgeArea area = BridgeArea.of(input);
    assertThat(area.getBridgeNumber()).isEqualTo(input);
  }

  @ParameterizedTest
  @ValueSource(ints = {21, 45, 111})
  void 다리영역을_표현하는_숫자가아니면_에러발생(int input) {
    assertThatThrownBy(() -> BridgeArea.of(input))
        .isInstanceOf(IllegalArgumentException.class);
  }
}