package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeTest {

  private Bridge bridge;

  String firstSection = "U";
  String secondSection = "D";
  String thirdSection = "U";

  @BeforeEach
  void setUp() {
    List<String> bridgeAreasByString = new ArrayList<>(
        List.of(firstSection, secondSection, thirdSection));
    bridge = new Bridge(bridgeAreasByString);
  }

  @Test
  void 이동할_다리위치와_영역_입력시_이동가능여부를_알려준다() {
    int wantMoveLocation = 1;
    BridgeArea moveArea = BridgeArea.of(firstSection);

    boolean canMoveResult = bridge.canMove(wantMoveLocation, moveArea);
    assertThat(canMoveResult).isTrue();
  }


  @Test
  void 다리길이보다_이상이동시_False를리턴한다() {
    int wantMoveLocation = 4;
    BridgeArea moveArea = BridgeArea.U;

    boolean canMoveResult = bridge.canMove(wantMoveLocation, moveArea);
    assertThat(canMoveResult).isFalse();
  }
}