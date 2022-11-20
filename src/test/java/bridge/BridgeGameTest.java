package bridge;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;

public class BridgeGameTest {

  private final BridgeGame bridgeGame = new BridgeGame(new InputView(), new OutputView());
  @Test
  void 맵_초기화_테스트() {
    char[][] maps = bridgeGame.initialMap(3);
    for(char[] map : maps) {
      for(char m : map) {
        assertThat(m).isEqualTo( ' ');
      }
    }
  }

  @Test
  void 맵_그리기_테스트() {
    char[][] maps = bridgeGame.initialMap(3);
    bridgeGame.makeX(maps, "U", 0);
    assertThat(maps[0][0]).isEqualTo('X');
    assertThat(maps[1][0]).isEqualTo(' ');
    bridgeGame.makeX(maps, "D", 0);
    assertThat(maps[1][0]).isEqualTo('X');
  }
}
