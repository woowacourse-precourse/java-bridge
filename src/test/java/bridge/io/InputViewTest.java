package bridge.io;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class InputViewTest {

  @ParameterizedTest
  @CsvSource(value = {"3,3", "20,20"})
  void 다리_길이_입력값을_검증하고_올바른_다리의_길이를_입력받아_정수로_반환하는가(String input, int expectedInt) {
    // given
    InputView inputView = new InputView();
    InputStream inputStream = readUserInput(input);
    System.setIn(inputStream);

    // when
    int resultInt = inputView.readBridgeSize();

    // then
    assertEquals(expectedInt, resultInt);
  }

  @ParameterizedTest
  @CsvSource(value = {"U,U", "D,D"})
  void 움직일_방향의_입력값을_검증하고_올바른_방향을_입력받아_반환하는가(String input, String expectedOutput) {
    // given
    InputView inputView = new InputView();
    InputStream inputStream = readUserInput(input);
    System.setIn(inputStream);

    // when
    String resultOutput = inputView.readMoving();

    // then
    assertEquals(expectedOutput, resultOutput);
  }

  private InputStream readUserInput(String input) {
    return new ByteArrayInputStream(input.getBytes());
  }


}