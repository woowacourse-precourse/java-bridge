package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

  @DisplayName("1, 0으로 생성된 난수에 따라 U, D로 치환되어 반환되는지 테스트")
  @Test
  void makeBridge() {
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    assertThat(bridgeMaker.makeBridge(10).contains("U"));
    assertThat(bridgeMaker.makeBridge(10).contains("D"));
  }
}