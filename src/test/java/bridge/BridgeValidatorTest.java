package bridge;

import static org.junit.jupiter.api.Assertions.*;

import bridge.domain.BridgeMaker;
import bridge.exception.InvalidDirectionException;
import bridge.exception.LengthOutOfRangeException;
import java.util.List;
import java.util.stream.Stream;

import bridge.validator.domain.BridgeValidator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

public class BridgeValidatorTest {
  BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

  @ParameterizedTest(name = "{index}: {displayName} length:{0}")
  @DisplayName("옳바른 다리 길이 입력 시 예외가 발생하지 않는다.")
  @ValueSource(ints = {3, 5, 20})
  void inputValidBridgeLength(int length) {
    assertDoesNotThrow(() -> BridgeValidator.validateLength(length));
  }

  @ParameterizedTest(name = "{index}: {displayName} length:{0}")
  @DisplayName("범위를 벗어난 다리 길이 입력 시 예외가 발생한다.")
  @ValueSource(ints = {-1, 2, 21})
  void inputOutOfRangeBridgeLength(int length) {
    assertThrows(LengthOutOfRangeException.class, () -> BridgeValidator.validateLength(length));
  }

  @ParameterizedTest(name = "{index}: {displayName}")
  @DisplayName("옳바른 다리 모양이면 예외가 발생하지 않는다.")
  @MethodSource("validBridgeShapes")
  void checkValidBridgeShape(List<String> bridgeShape) {
    assertDoesNotThrow(() -> BridgeValidator.validateBridgeShape(bridgeShape));
  }

  @ParameterizedTest(name = "{index}: {displayName}")
  @DisplayName("다리 모양이 잘못되면 예외가 발생한다.")
  @MethodSource("invalidBridgeShapes")
  void checkInvalidBridgeShape(List<String> bridgeShape) {
    assertThrows(
        InvalidDirectionException.class, () -> BridgeValidator.validateBridgeShape(bridgeShape));
  }

  @RepeatedTest(10)
  @DisplayName("무작위로 다리를 생성 시 예외가 발생하지 않는다.")
  void makeBridgeTest() {
    assertDoesNotThrow(() -> bridgeMaker.makeBridge(3));
    assertDoesNotThrow(() -> bridgeMaker.makeBridge(7));
    assertDoesNotThrow(() -> bridgeMaker.makeBridge(20));
  }

  @ParameterizedTest(name = "{index}: {displayName} length:{0}")
  @DisplayName("입력된 다리 길이와 생성된 다리 길이가 같다.")
  @ValueSource(ints = {3, 11, 20})
  void inputLengthEqualBridgeLength(int length) {
    assertEquals(length, bridgeMaker.makeBridge(length).size());
  }

  private static Stream<List<String>> validBridgeShapes() {
    return Stream.of(
        List.of("U", "D", "U"),
        List.of("D", "U", "U"),
        List.of("U", "U", "U"),
        List.of("D", "D", "D"));
  }

  private static Stream<List<String>> invalidBridgeShapes() {
    return Stream.of(
        List.of("U", "D", "W"),
        List.of("DD", "U", "U"),
        List.of("", "U", "U"),
        List.of("D", " ", "D"));
  }
}
