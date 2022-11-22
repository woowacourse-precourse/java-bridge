package bridge;

import bridge.view.BridgeView;
import bridge.view.InputView;
import bridge.view.OutputView;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.assertj.core.api.Assertions.assertThat;


public class BridgeTest {

  @DisplayName("입력된 길이에 맞게 다리를 생성할 때, 0은 D, 1은 U로 나타난다.")
  @Test
  void makeBridge() {

    // given
    BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
    BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
    InputView inputView = new InputView();
    OutputView outputView = new OutputView();
    int size = 3;

    // when
    GameController gameController = new GameController(bridgeMaker, inputView, outputView);
    Bridge bridge = gameController.makeBridge(size);

    // then
    assertThat(bridge.getDirections()).containsExactly(Direction.U, Direction.D, Direction.D);
  }
  
}
