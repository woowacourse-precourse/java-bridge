package bridge.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MapTest {
  @ParameterizedTest(name = "{index}: {displayName}")
  @DisplayName("업데이트되는 지도에 따라서 출력되는 지도의 모양이 다르다.")
  @MethodSource("inputDirectionsAndExpectedMap")
  void getLineStringTest(String firstDir, String secondDir, String expectedMap) {
    Map map = new Map();
    map.updateMap(firstDir, "U");
    map.updateMap(secondDir, "D");
    assertEquals(expectedMap, map.getMapString());
  }

  @Test
  @DisplayName("지도를 초기화하면 빈 배열이 된다.")
  void clearMapTest(){
    Map map = new Map();
    map.updateMap("U", "U");
    map.updateMap("U", "D");
    map.clearMap();
    assertEquals("[  ]\n[  ]", map.getMapString());
  }

  private static Stream<Arguments> inputDirectionsAndExpectedMap() {
    return Stream.of(
        Arguments.of("U", "U", "[ O | X ]\n[   |   ]"),
        Arguments.of("U", "D", "[ O |   ]\n[   | O ]"));
  }
}
