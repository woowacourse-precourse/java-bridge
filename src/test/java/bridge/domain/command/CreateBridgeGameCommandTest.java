package bridge.domain.command;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import java.util.List;
import org.junit.jupiter.api.Test;

class CreateBridgeGameCommandTest {

  @Test
  void 다리길이가잘못되면_에러를_발생한다() {
    List<String> givenBridges = List.of("U", "D");

    assertThatThrownBy(() -> new CreateBridgeGameCommand(givenBridges))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @Test
  void 정상적인길이가오면_성공한다() {
    List<String> givenBridges = List.of("U", "D", "U");
    CreateBridgeGameCommand command = new CreateBridgeGameCommand(givenBridges);
    assertThat(command.getBridges().size()).isEqualTo(3);
  }

  @Test
  void 다리를나타내는값이오면_에러를_발생한다() {
    List<String> givenBridges = List.of("U","U","K");
    assertThatThrownBy(() -> new CreateBridgeGameCommand(givenBridges))
        .isInstanceOf(IllegalArgumentException.class);
  }
}