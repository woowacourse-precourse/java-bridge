package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.*;

class BridgeGameTest extends NsTest {
    final String error = "[ERROR]";

    @Nested
    @DisplayName("올바른 다리를 생성하는 기능을 테스트")
    class MakeBridgeTest {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);

        @Test
        @DisplayName("다리의 길이가 3일 때")
        void case1() {
            int size = 3;
            List<String> bridge = bridgeMaker.makeBridge(size);
            assertThat(bridge.size()).isEqualTo(size);
            assertThat(bridge).containsAnyOf("U", "D");
        }

        @Test
        @DisplayName("다리의 길이가 20일 때")
        void case2() {
            int size = 20;
            List<String> bridge = bridgeMaker.makeBridge(size);
            assertThat(bridge.size()).isEqualTo(size);
            assertThat(bridge).containsAnyOf("U", "D");
        }
    }

    @Nested
    @DisplayName("다리 길이를 입력받을 때 테스트")
    class BridgeSizeTest {
        @DisplayName("올바르지 않은 다리 길이가 입력될 때")
        @ValueSource(strings = {"012", "a", "1", "23"})
        @ParameterizedTest
        void case1(String input) {
            assertSimpleTest(() -> {
                runException(input);
                assertThat(output()).contains(error);
            });
        }

        @Test
        @DisplayName("올바른 다리 길이가 입력될 때")
        void case2() {
            assertSimpleTest(() -> {
               runException("4");
               assertThat(output()).contains("이동할 칸을 선택해주세요.");
            });
        }
    }

    @Nested
    @DisplayName("발판 선택으로 올바른 입력이 들어오는지 테스트")
    class MovingTest {
        @Test
        @DisplayName("발판 선택으로 U나 D가 아닌 문자가 입력될 떄_1")
        void case1() {
            assertSimpleTest(() -> {
                runException("4", "1");
                assertThat(output()).contains(error);
            });
        }

        @Test
        @DisplayName("발판 선택으로 U나 D가 아닌 문자가 입력될 떄_2")
        void case2() {
            assertSimpleTest(() -> {
                runException("4", "u");
                assertThat(output()).contains(error);
            });
        }

        @Test
        @DisplayName("발판 선택으로 올바른 문자가 입력될 떄")
        void case3() {
            assertSimpleTest(() -> {
                runException("4", "U");
                assertThat(output()).contains("[   ]");
            });
        }
    }

    @Nested
    @DisplayName("BridgeGame 클래스의 메소드를 테스트")
    class BridgeGameMethodTest {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "U", "U", "D"));
        @Test
        @DisplayName("move 메소드 테스트_1")
        void move1() {
            bridgeGame.move("U");
            assertThat(bridgeGame.getUpperRoad()).isEqualTo(List.of("O"));
            assertThat(bridgeGame.getLowerRoad()).isEqualTo(List.of(" "));
        }

        @Test
        @DisplayName("move 메소드 테스트_2")
        void move2() {
            bridgeGame.move("D");
            assertThat(bridgeGame.getLowerRoad()).isEqualTo(List.of("X"));
            assertThat(bridgeGame.getUpperRoad()).isEqualTo(List.of(" "));
        }

        @Test
        @DisplayName("move 메소드 테스트_3")
        void move3() {
            bridgeGame.move("U");
            bridgeGame.move("U");
            assertThat(bridgeGame.getUpperRoad()).isEqualTo(List.of("O", "X"));
            assertThat(bridgeGame.getLowerRoad()).isEqualTo(List.of(" ", " "));
        }

        @Test
        @DisplayName("isGameEnd 메소드 테스트_1")
        void isGameEnd1() {
            bridgeGame.move("U");
            bridgeGame.move("D");
            bridgeGame.move("U");
            bridgeGame.move("U");
            bridgeGame.move("D");
            assertThat(bridgeGame.isGameEnd()).isEqualTo(true);
        }

        @Test
        @DisplayName("isGameEnd 메소드 테스트_2")
        void isGameEnd2() {
            bridgeGame.move("U");
            bridgeGame.move("D");
            bridgeGame.move("D");
            assertThat(bridgeGame.isGameEnd()).isEqualTo(false);
        }

        @Test
        @DisplayName("isGameEnd 메소드 테스트_3")
        void isGameEnd3() {
            bridgeGame.move("U");
            bridgeGame.move("D");
            bridgeGame.move("U");
            bridgeGame.move("U");
            bridgeGame.move("U");
            assertThat(bridgeGame.isGameEnd()).isEqualTo(false);
        }
    }

    @Override
    public void runMain() {
        Application.main(new String[]{});
    }
}