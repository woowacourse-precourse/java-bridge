package bridge;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class BridgeGameTest {
    private static final String ERROR_MSG = "[ERROR]";
    private final BridgeGame bridgeGame = new BridgeGame();

    @BeforeEach
    void clear() {
        bridgeGame.clear();
    }

    @Test
    @DisplayName("같으면 O, 다르면 X를 반환한다.")
    void testGetPaintGame() throws Exception {
        Bridge player = new Bridge(List.of("U", "D", "U", "U", "D", "U"));
        Bridge answer = new Bridge(List.of("D", "D", "U", "D", "U", "U"));
        List<String> expected = List.of("X", "O", "O", "X", "X", "O");
        Method method = bridgeGame.getClass().getDeclaredMethod("getPaintGame", Bridge.class, Bridge.class, int.class);
        method.setAccessible(true);
        for (int i = 0; i < player.getBridge().size(); i++) {
            assertThat(method.invoke(bridgeGame, player, answer, i)).isEqualTo(expected.get(i));
        }
    }

    @DisplayName("U면 D, D면 U를 반환한다.")
    @CsvSource(value = {"U:D", "D:U"}, delimiter = ':')
    @ParameterizedTest(name = "{index} {displayName} test={0}")
    void testGetOtherPosition(String position, String expected) throws Exception {
        Method method = bridgeGame.getClass().getDeclaredMethod("getOtherPosition", String.class);
        method.setAccessible(true);
        assertEquals(method.invoke(bridgeGame, position), expected);
    }

    @DisplayName("게임 결과 리스트에 반영")
    @Test
    void testPaintBridgeGameResult() throws Exception {
        List<String> position = List.of("U", "D", "U", "U", "D", "U");
        List<String> otherPosition = List.of("D", "U", "D", "D", "U", "D");
        List<String> paintGame = List.of("X", "O", "O", "X", "X", "O");
        bridgeGame.setBridgeGameResult();
        HashMap<String, List<String>> expected = paintExpected();
        invokePaintBridgeGameResult(position, otherPosition, paintGame);
        assertEquals(expected, bridgeGame.getBridgeGameResult());
    }

    HashMap<String, List<String>> paintExpected() {
        HashMap<String, List<String>> expected = new HashMap<>();
        expected.put("U", List.of("X", " ", "O", "X", " ", "O"));
        expected.put("D", List.of(" ", "O", " ", " ", "X", " "));
        System.out.println("U: " + Arrays.toString(expected.get("U").toArray()));
        System.out.println("D: " + Arrays.toString(expected.get("D").toArray()));
        return expected;
    }

    private void invokePaintBridgeGameResult(List<String> position, List<String> otherPosition, List<String> paintGame) throws Exception {
        for (int i = 0; i < position.size(); i++) {
            Method method = bridgeGame.getClass().getDeclaredMethod("paintBridgeGameResult", String.class, String.class, String.class);
            method.setAccessible(true);
            method.invoke(bridgeGame, position.get(i), otherPosition.get(i), paintGame.get(i));
        }
    }

    @DisplayName("R이면 true, Q면 false를 반환한다.")
    @CsvSource(value = {"R:true", "Q:false"}, delimiter = ':')
    @ParameterizedTest
    void testRetry(String answer, boolean retry) {
        assertEquals(bridgeGame.retry(answer), retry);
    }
}
