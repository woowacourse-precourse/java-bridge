package bridge;

import bridge.exception.InvalidBridgeShapeException;
import bridge.exception.LengthOutOfRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class BridgeValidatorTest {
  @ParameterizedTest(name = "{index}: {displayName} length:{0}")
  @DisplayName("옳바른 다리 길이 입력 시")
  @ValueSource(ints = {3, 5, 20})
  void inputValidBridgeLength(int length) {
    assertDoesNotThrow(() -> BridgeValidator.validateLength(length));
  }

  @ParameterizedTest(name = "{index}: {displayName} length:{0}")
  @DisplayName("범위를 벗어난 다리 길이 입력 시 예외 발생")
  @ValueSource(ints = {-1, 2, 21})
  void inputOutOfRangeBridgeLength(int length) {
    assertThrows(LengthOutOfRangeException.class, () -> BridgeValidator.validateLength(length));
  }

  @ParameterizedTest(name = "{index}: {displayName}")
  @DisplayName("옳바른 다리 모양인지 검증")
  @MethodSource("validBridgeShapes")
  void checkValidBridgeShape(List<String> bridgeShape) {
    assertDoesNotThrow(() -> BridgeValidator.validateBridgeShape(bridgeShape));
  }

  @ParameterizedTest(name = "{index}: {displayName}")
  @DisplayName("다리 모양이 잘못되면 예외 발생")
  @MethodSource("invalidBridgeShapes")
  void checkInvalidBridgeShape(List<String> bridgeShape) {
    assertThrows(InvalidBridgeShapeException.class, () -> BridgeValidator.validateBridgeShape(bridgeShape));
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
