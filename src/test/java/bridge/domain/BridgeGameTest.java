package bridge.domain;

import static bridge.Constants.COMPLETE;
import static bridge.Constants.FAIL;
import static org.assertj.core.api.Assertions.assertThat;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
    BridgeGame bridgeGame;

    @BeforeEach
    void initAll() {
        List<String> bridge = new ArrayList<>(Arrays.asList("U", "D", "U", "D"));
        bridgeGame = new BridgeGame(bridge);
    }

    @DisplayName("bridge 와 동일한 position 으로 이동하면 true 를 반환한다.")
    @Test
    void moveTest1() {
        boolean result1 = bridgeGame.move("U");
        boolean result2 = bridgeGame.move("D");
        assertThat(result1).isEqualTo(true);
        assertThat(result2).isEqualTo(true);
    }

    @DisplayName("bridge 와 다른 position 으로 이동하면 false 를 반환한다.")
    @Test
    void moveTest2() {
        boolean result = bridgeGame.move("D");
        assertThat(result).isEqualTo(false);
    }

    @DisplayName("bridge 가 U 일때 같은 position 으로 이동하면 upBridge 에 ' O ', downBridge 에 '   ' 를 저장한다.")
    @Test
    void moveTest3() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U"));
        bridgeGame.move("U");
        try {
            Field field1 = bridgeGame.getClass().getDeclaredField("upBridge");
            field1.setAccessible(true);
            Field field2 = bridgeGame.getClass().getDeclaredField("downBridge");
            field2.setAccessible(true);
            List<String> value1 = (List<String>) field1.get(bridgeGame);
            List<String> value2 = (List<String>) field2.get(bridgeGame);
            assertThat(value1).isEqualTo(List.of(" O "));
            assertThat(value2).isEqualTo(List.of("   "));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @DisplayName("bridge 가 U 일때 다른 position 으로 이동하면 upBridge 에 '   ', downBridge 에 ' X ' 를 저장한다.")
    @Test
    void moveTest4() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U"));
        bridgeGame.move("D");
        try {
            Field field1 = bridgeGame.getClass().getDeclaredField("upBridge");
            field1.setAccessible(true);
            Field field2 = bridgeGame.getClass().getDeclaredField("downBridge");
            field2.setAccessible(true);
            List<String> value1 = (List<String>) field1.get(bridgeGame);
            List<String> value2 = (List<String>) field2.get(bridgeGame);
            assertThat(value1).isEqualTo(List.of("   "));
            assertThat(value2).isEqualTo(List.of(" X "));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @DisplayName("bridge 가 D 일때 같은 position 으로 이동하면 upBridge 에 '   ', downBridge 에 ' O ' 를 저장한다.")
    @Test
    void moveTest5() {
        BridgeGame bridgeGame = new BridgeGame(List.of("D"));
        bridgeGame.move("D");
        try {
            Field field1 = bridgeGame.getClass().getDeclaredField("upBridge");
            field1.setAccessible(true);
            Field field2 = bridgeGame.getClass().getDeclaredField("downBridge");
            field2.setAccessible(true);
            List<String> value1 = (List<String>) field1.get(bridgeGame);
            List<String> value2 = (List<String>) field2.get(bridgeGame);
            assertThat(value1).isEqualTo(List.of("   "));
            assertThat(value2).isEqualTo(List.of(" O "));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @DisplayName("bridge 가 D 일때 다른 position 으로 이동하면 upBridge 에 ' X ', downBridge 에 '   ' 를 저장한다.")
    @Test
    void moveTest6() {
        BridgeGame bridgeGame = new BridgeGame(List.of("D"));
        bridgeGame.move("U");
        try {
            Field field1 = bridgeGame.getClass().getDeclaredField("upBridge");
            field1.setAccessible(true);
            Field field2 = bridgeGame.getClass().getDeclaredField("downBridge");
            field2.setAccessible(true);
            List<String> value1 = (List<String>) field1.get(bridgeGame);
            List<String> value2 = (List<String>) field2.get(bridgeGame);
            assertThat(value1).isEqualTo(List.of(" X "));
            assertThat(value2).isEqualTo(List.of("   "));
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @DisplayName("move()를 통해 증가한 index 값이 retry()를 통해 0으로 초기화 된다.")
    @Test
    void retryTest() {
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("D");
        try {
            Field field = bridgeGame.getClass().getDeclaredField("index");
            field.setAccessible(true);
            int value = (int) field.get(bridgeGame);
            assertThat(value).isEqualTo(2);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
        bridgeGame.retry();
        try {
            Field field = bridgeGame.getClass().getDeclaredField("index");
            field.setAccessible(true);
            int value = (int) field.get(bridgeGame);
            assertThat(value).isEqualTo(0);
        } catch (NoSuchFieldException | IllegalAccessException e) {
            e.printStackTrace();
        }
    }

    @DisplayName("게임 성공시 checkCompleteOrFail()가 COMPLETE 를 반환한다.")
    @Test
    void checkCompleteOrFailTest1() {
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");
        bridgeGame.move("D");
        assertThat(bridgeGame.checkCompleteOrFail()).isEqualTo(COMPLETE);
    }

    @DisplayName("게임 실패시 checkCompleteOrFail()가 FAIL 을 반환한다.")
    @Test
    void checkCompleteOrFailTest2() {
        bridgeGame.move("U");
        bridgeGame.move("D");
        bridgeGame.move("U");
        bridgeGame.move("U");
        assertThat(bridgeGame.checkCompleteOrFail()).isEqualTo(FAIL);
    }

}