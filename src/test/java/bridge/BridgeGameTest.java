package bridge;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

  private final BridgeGame bridgeGame = new BridgeGame(new InputView(), new OutputView(), new ArrayList<>());

  @Test
  void 맵_그리기_테스트() {
    List<List<String>> maps = bridgeGame.initialMap();
    bridgeGame.makeX(maps, "U");
    assertThat(maps.get(0).get(0)).isEqualTo("X");
    assertThat(maps.get(1).get(0)).isEqualTo(" ");
    bridgeGame.makeO(maps, "D");
    assertThat(maps.get(1).get(1)).isEqualTo("O");
    assertThat(maps.get(0).get(1)).isEqualTo(" ");
  }
}
