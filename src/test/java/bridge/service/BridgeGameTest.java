package bridge.service;

import bridge.support.BridgeLogger;
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

@DisplayName("BridgeGame 객체를 테스트한다.")
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
    @DisplayName("BridgeGame 객체의 초기값은 status = PLAYING, tryCount =  1이다.")
    void initTest() {
        assertEquals(bridgeGame.getStatus(), PLAYING);
        assertEquals(bridgeGame.getTryCount(), 1);
    }

    @DisplayName("BridgeGame의 생성자에 잘못된 값이 포함되어있으면 예외")
    @Test
    void createWithWrongBridge() {
        assertThrows(IllegalArgumentException.class, () -> {
            BridgeGame game = new BridgeGame(invalidBridge);
        });
    }

    @Nested
    @DisplayName("게임 상태 테스트")
    class gameStatusTest {
        @Test
        @DisplayName("주어진 bridge와 동일하지 않은 방향으로 이동 시 LOSE")
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
        @DisplayName("주어진 bridge와 동일한 방향으로 이동 시 LOSE")
        void winTest() {
            for (int i = 0; i < bridge.size(); i++) {
                bridgeGame.move("U");
            }
            assertEquals(bridgeGame.getStatus(), WIN);
        }
    }

    @DisplayName("move 함수에 U, D 이외의 값이 입력되면 예외")
    @ParameterizedTest(name = "입력값: {0}")
    @CsvSource({"1", "2", "u", "d", "hello world"})
    void moveTest(String input) {
        assertThrows(IllegalArgumentException.class, () -> {
            bridgeGame.move(input);
        });
    }

    @DisplayName("retry 함수 테스트")
    @Nested
    class retryTest {
        @DisplayName("retry 함수를 호출하면 tryCount가 1 증가한다.")
        @ParameterizedTest(name = "{0}회 호출")
        @CsvSource(value = {"1:2", "3:4", "6:7"}, delimiter = ':')
        void tryCountTest(int count, int result) {
            for (int i = 0; i < count; i++) {
                bridgeGame.retry();
            }
            assertEquals(bridgeGame.getTryCount(), result);
        }

        @DisplayName("retry 함수를 호출하면 status는 PLAYING이다.")
        @Test
        void retryStatusTest() {
            bridgeGame.move("U");
            bridgeGame.move("D");
            bridgeGame.retry();
            assertEquals(bridgeGame.getStatus(), PLAYING);
        }

        @DisplayName("retry 함수를 호출하면 ResultMap은 비어있다.")
        @Test
        void retryResultMapTest() {
            BridgeLogger bridgeLoggerInit = new BridgeLogger();
            String initResultMap = bridgeLoggerInit.toString();

            bridgeGame.move("U");
            bridgeGame.move("D");
            bridgeGame.retry();
            String resultMap = bridgeGame.getResultMap();
            
            assertEquals(initResultMap, resultMap);
        }
    }


    @Nested
    @DisplayName("getResultMap 함수 테스트")
    class resultMapTest {
        BridgeGame game = new BridgeGame(
                List.of("U", "D", "U")
        );

        @Test
        @DisplayName("주어진 bridge를 모두 통과할 때의 결과 반환")
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
        @DisplayName("주어진 bridge를 통과하지 못할 때의 결과 반환")
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
}