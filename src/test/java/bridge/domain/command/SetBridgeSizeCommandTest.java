package bridge.domain.command;


import static org.assertj.core.api.Assertions.*;


import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class SetBridgeSizeCommandTest {


  @ParameterizedTest
  @ValueSource(strings = {"12z", " ", "-zxc"})
  void 숫자가아닌값이입력되면_에러가발생한다(String input) {
    assertThatThrownBy(() -> new SetBridgeSizeCommand(input))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @ValueSource(strings = {"1", "2", "0", "21"})
  void 길이가3에서_20이하가_아니면_에러가_발생한다(String input) {
    assertThatThrownBy(() -> new SetBridgeSizeCommand(input))
        .isInstanceOf(IllegalArgumentException.class);
  }

  @ParameterizedTest
  @ValueSource(strings = {"3", "4", "5", "20"})
  void 길이가3에서_20이하면_정상적으로_성공한다(String input) {
    SetBridgeSizeCommand command = new SetBridgeSizeCommand(input);

    assertThat(command.getSize()).isEqualTo(Integer.parseInt(input));
  }
}