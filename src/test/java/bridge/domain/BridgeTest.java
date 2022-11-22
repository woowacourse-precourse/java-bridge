package bridge.domain;

import bridge.exception.InvalidDirectionException;
import bridge.exception.LengthOutOfRangeException;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class BridgeTest {
  private static final List<String> sixLengthBridgeShape = List.of("U", "U", "D", "U", "U", "D");
  private static final List<String> fourLengthBridgeShape = List.of("U", "U", "U", "D");
  private static final Bridge sixLengthBridge = new Bridge(sixLengthBridgeShape);
  private static final Bridge fourLengthBridge = new Bridge(fourLengthBridgeShape);

  @Test
  @DisplayName("정상적인 값으로 bridge를 생성한다.")
  void bridgeCreateTest() {
    assertDoesNotThrow(() -> new Bridge(List.of("U", "U", "D")));
  }

  @Test
  @DisplayName("옳바르지 않은 방향으로 bridge를 생성하면 예외가 발생한다.")
  void invalidShapeBridgeCreateTest() {
    assertThrows(InvalidDirectionException.class, () -> new Bridge(List.of("D", "R", "D")));
    assertThrows(InvalidDirectionException.class, () -> new Bridge(List.of("DD", "U", "U")));
  }

  @Test
  @DisplayName("범위를 벗어난 길이의 bridge를 생성하면 예외가 발생한다.")
  void outOfRangeBridgeCreateTest() {
    assertThrows(LengthOutOfRangeException.class, () -> new Bridge(List.of("U", "D")));
    assertThrows(
        LengthOutOfRangeException.class,
        () ->
            new Bridge(
                List.of(
                    "D", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "D", "U", "U", "D",
                    "U", "U", "D", "U", "U")));
  }

  @Test
  @DisplayName("생성할 때의 다리 모양과 메소드로 가져오는 다리모양이 같아야 한다.")
  void getBridgeShapeTest() {
    assertEquals(sixLengthBridgeShape, sixLengthBridge.getBridgeShapes());
    assertEquals(fourLengthBridgeShape, fourLengthBridge.getBridgeShapes());
  }

  @Test
  @DisplayName("다리의 길이와 이동 횟수가 같으면 도착점에 도착한 것이다.")
  void checkArriveFinishLineTest() {
    assertTrue(sixLengthBridge.isArriveFinishLine(sixLengthBridgeShape.size()));
    assertFalse(sixLengthBridge.isArriveFinishLine(4));
    assertTrue(fourLengthBridge.isArriveFinishLine(fourLengthBridgeShape.size()));
    assertFalse(fourLengthBridge.isArriveFinishLine(6));
  }
}
