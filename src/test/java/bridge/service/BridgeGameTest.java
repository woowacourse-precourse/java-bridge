package bridge.service;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.List;

import static bridge.utils.status.GameStatus.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

class BridgeGameTest {
    List<String> bridge = List.of("U", "U", "U", "U", "U", "U", "U");
    List<String> invalidBridge = List.of("U", "D", "a", "kk", "U", "U", "U");

    BridgeGame bridgeGame;

    @BeforeEach
    void setBridgeGame() {
        bridgeGame = new BridgeGame(
                bridge
        );
    }

    @Test
    @DisplayName("게임의 초기값은 status: PLAYING, 시도횟수: 1이다.")
    void initTest() {
        assertEquals(bridgeGame.getStatus(), PLAYING);
        assertEquals(bridgeGame.getTryCount(), 1);
    }

    @Nested
    @DisplayName("게임 진행 상태는 ")
    class gameStatusTest {
        @Test
        @DisplayName("떨어졌을 때 LOSE")
        void loseTest() {
            bridgeGame.move("D");
            assertEquals(bridgeGame.getStatus(), LOSE);
        }

        @Test
        @DisplayName("진행중일 때 PLAYING")
        void playingTest() {
            for (int i = 0; i < bridge.size(); i++) {
                assertEquals(bridgeGame.getStatus(), PLAYING);
                bridgeGame.move("U");
            }
        }

        @Test
        @DisplayName("끝까지 도달했을 때 WIN")
        void winTest() {
            for (int i = 0; i < bridge.size(); i++) {
                bridgeGame.move("U");
            }
            assertEquals(bridgeGame.getStatus(), WIN);
        }
    }

    @DisplayName("재시작횟수에 따른 시도횟수")
    @ParameterizedTest(name = "재시작: {0}번, 시도횟수: {1}번")
    @CsvSource(value = {"1:2", "3:4", "6:7"}, delimiter = ':')
    void tryCountTest(int count, int result) {
        for (int i = 0; i < count; i++) {
            bridgeGame.retry();
        }
        assertEquals(bridgeGame.getTryCount(), result);
    }

    @Nested
    @DisplayName("UDU Bridge에서 ")
    class resultMapTest {
        BridgeGame game = new BridgeGame(
                List.of("U", "D", "U")
        );

        @Test
        @DisplayName("이동 방향이 U D U 일때 출력형태")
        void testOnUDU() {

            game.move("U");
            game.move("D");
            game.move("U");

            String resultMap = game.getResultMap();
            System.out.println(resultMap);
            assertThat(resultMap).contains("[ O |   | O ]");
            assertThat(resultMap).contains("[   | O |   ]");
        }

        @Test
        @DisplayName("U U 일때 출력형태")
        void testUU() {
            BridgeGame game = new BridgeGame(
                    List.of("U", "D", "U")
            );

            game.move("U");
            game.move("U");

            String resultMap = game.getResultMap();
            System.out.println(resultMap);
            assertThat(resultMap).contains("[ O | X ]");
            assertThat(resultMap).contains("[   |   ]");
        }
    }


    @Nested
    @DisplayName("예외상황으로는 ")
    class exceptionTest {
        @DisplayName("생성 시 잘못된 다리 형식이 들어오는 경우가 있다.")
        @Test
        void createWithWrongBridge() {
            assertThrows(IllegalArgumentException.class, () -> {
                BridgeGame game = new BridgeGame(invalidBridge);
            });
        }

        @DisplayName("move 수행간 U, D가 아닌 다른값이 들어오는 경우가 있다.")
        @ParameterizedTest(name = "입력값: {0}")
        @CsvSource({"1", "2", "u", "d", "hello world"})
        void moveTest(String input) {
            assertThrows(IllegalArgumentException.class, () -> {
                bridgeGame.move(input);
            });
        }
    }
}