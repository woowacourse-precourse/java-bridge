package bridge.entity;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.data.entity.BridgeGame;
import bridge.type.FailMenuCommandType;
import bridge.type.InGameCommandType;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;
import org.junit.jupiter.api.TestInstance.Lifecycle;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

@DisplayName("다리 건너기 게임은")
public class BridgeGameTest {

    @DisplayName("시작할 때에")
    @TestInstance(Lifecycle.PER_CLASS)
    @Nested
    class InitTests {

        @DisplayName("U와 D로 이루어진, 길이가 3 ~ 20 이내의 문자열 리스트를 받아야 한다.")
        @ParameterizedTest
        @MethodSource("passingTestParams")
        void passingTest(List<String> bridge) {
            new BridgeGame(bridge);
        }

        private Stream<List<String>> passingTestParams() {
            return Stream.of(
                    Arrays.asList("UUD".split("")),
                    Arrays.asList("UUUU".split("")),
                    Arrays.asList("DDDDDDDDDDDDDDDDDDDD".split(""))
            );
        }

        @DisplayName("길이가 3 ~ 20 범위 이외라면, 실패해야 한다.")
        @ParameterizedTest
        @MethodSource("sizeFailTestParams")
        void sizeFailTest(List<String> bridge) {
            assertThatThrownBy(() -> new BridgeGame(bridge))
                    .isInstanceOf(IllegalStateException.class);
        }

        private Stream<List<String>> sizeFailTestParams() {
            return Stream.of(
                    Arrays.asList("UU".split("")),
                    Arrays.asList("DDDDDDDDDDDDDDDDDDDDD".split(""))
            );
        }

        @DisplayName("문자열 리스트에 U, D 가 아닌 다른 문자가 들어있다면, 실패해야 한다.")
        @ParameterizedTest
        @MethodSource("componentFailTestParams")
        void componentFailTest(List<String> bridge) {
            assertThatThrownBy(() -> new BridgeGame(bridge))
                    .isInstanceOf(IllegalStateException.class);
        }

        private Stream<List<String>> componentFailTestParams() {
            return Stream.of(
                    Arrays.asList("UUu".split("")),
                    Arrays.asList("디DDDDDDDDDDDDDDDDDDD".split("")),
                    Arrays.asList("1111".split("")),
                    Arrays.asList("^_^".split(""))
            );
        }
    }

    @DisplayName("이동을 시도할 때에는")
    @Nested
    class MoveTests {

        private BridgeGame bridgeGame;

        @BeforeEach
        void init() {
            bridgeGame = new BridgeGame(Arrays.asList("UUD".split("")));
        }

        @DisplayName("산 상태로 움직이는 건 성공해야 한다.")
        @Test
        void moveWhileAliveTest() {
            bridgeGame.move(InGameCommandType.MOVE_UP);
            bridgeGame.move(InGameCommandType.MOVE_UP);
            bridgeGame.move(InGameCommandType.MOVE_DOWN);
        }

        @DisplayName("죽은 상태로 움직이면 실패해야 한다.")
        @Test
        void moveWhileDeadTest() {
            bridgeGame.move(InGameCommandType.MOVE_UP);
            bridgeGame.move(InGameCommandType.MOVE_DOWN);
            assertThatThrownBy(() -> bridgeGame.move(InGameCommandType.MOVE_DOWN))
                    .isInstanceOf(IllegalStateException.class);
        }
    }

    @DisplayName("재시작/종료 명령어를 입력할 때에는")
    @Nested
    class RetryTests {

        private BridgeGame bridgeGame;

        @BeforeEach
        void init() {
            bridgeGame = new BridgeGame(Arrays.asList("DUU".split("")));
        }

        @DisplayName("죽은 상태로 재시작하는 건 성공해야 한다.")
        @Test
        void retryWhileDeadTest() {
            bridgeGame.move(InGameCommandType.MOVE_UP);
            bridgeGame.retry(FailMenuCommandType.RETRY);
        }

        @DisplayName("죽은 상태로 중도포기 하는 건 성공해야 한다.")
        @Test
        void quitWhileDeadTest() {
            bridgeGame.move(InGameCommandType.MOVE_UP);
            bridgeGame.retry(FailMenuCommandType.QUIT);
        }

        @DisplayName("산 상태로 재시작 하는 건 실패해야 한다.")
        @Test
        void retryWhileAliveTest() {
            bridgeGame.move(InGameCommandType.MOVE_DOWN);
            assertThatThrownBy(() -> bridgeGame.retry(FailMenuCommandType.RETRY))
                    .isInstanceOf(IllegalStateException.class)
            ;
        }

        @DisplayName("산 상태로 중도포기 하는 건 실패해야 한다.")
        @Test
        void quitWhileAliveTest() {
            assertThatThrownBy(() -> bridgeGame.retry(FailMenuCommandType.QUIT))
                    .isInstanceOf(IllegalStateException.class)
            ;
        }
    }
}
