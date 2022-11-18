package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

  @DisplayName("1, 0으로 생성된 난수에 따라 U, D로 치환되어 반환되는지 테스트")
  @Test
  void makeBridge() {
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    List<String> bridgeMap =  bridgeMaker.makeBridge(10);
    for (int i = 0; i < 10; i++) {
      assertThat(bridgeMap).contains("U").contains("D");
    }
  }
}