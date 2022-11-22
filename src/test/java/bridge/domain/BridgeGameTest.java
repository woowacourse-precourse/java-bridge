package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
    private BridgeGame bridgeGame;

    @BeforeEach
    void setUp() {
        bridgeGame = new BridgeGame(List.of("U", "U"));
    }

    @Test
    void 사용자가_칸을_이동할_때_인덱스가_증가_하는지_확인() {
        bridgeGame.move();
        assertThat(bridgeGame).extracting("bridgeIndex").isEqualTo(1);
    }

    @Nested
    class addJudgment {

        @Test
        void 플레이어가_U를_입력하였을_경우_다리와_비교하여_같다면_윗칸에_O가_출력_되는지_확인() {
            bridgeGame.addJudgment("U", "O");

            BridgeState state = bridgeGame.currentBridgeState();
            String upBridge = state.upBridgeGenerate();
            String downBridge = state.downBridgeGenerate();

            assertThat(upBridge).isEqualTo("[ O ]");
            assertThat(downBridge).isEqualTo("[   ]");
        }

        @Test
        void 플레이어가_U를_입력하였을_경우_다리와_비교하여_틀리다면_윗칸에_X가_출력_되는지_확인() {
            bridgeGame.addJudgment("U", "X");

            BridgeState state = bridgeGame.currentBridgeState();
            String upBridge = state.upBridgeGenerate();
            String downBridge = state.downBridgeGenerate();

            assertThat(upBridge).isEqualTo("[ X ]");
            assertThat(downBridge).isEqualTo("[   ]");
        }

        @Test
        void 플레이어가_D를_입력하였을_경우_다리와_비교하여_같다면_아래_칸에_O가_출력_되는지_확인() {
            bridgeGame.addJudgment("D", "O");

            BridgeState state = bridgeGame.currentBridgeState();
            String upBridge = state.upBridgeGenerate();
            String downBridge = state.downBridgeGenerate();

            assertThat(upBridge).isEqualTo("[   ]");
            assertThat(downBridge).isEqualTo("[ O ]");
        }

        @Test
        void 플레이어가_D를_입력하였을_경우_다리와_비교하여_틀리다면_아래_칸에_X가_출력_되는지_확인() {
            bridgeGame.addJudgment("D", "X");

            BridgeState state = bridgeGame.currentBridgeState();
            String upBridge = state.upBridgeGenerate();
            String downBridge = state.downBridgeGenerate();

            assertThat(upBridge).isEqualTo("[   ]");
            assertThat(downBridge).isEqualTo("[ X ]");
        }
    }

    @Nested
    class retry {

        @Test
        void 플레이어의_입력값이_R이라면_R을_반환하는지_확인() {
            String result = "R";

            String retry = bridgeGame.retry("R");

            assertThat(retry).isEqualTo(result);
        }

        @Test
        void 플레이어의_입력값이_Q이라면_Q을_반환하는지_확인() {
            String result = "Q";

            String retry = bridgeGame.retry("Q");

            assertThat(retry).isEqualTo(result);
        }
    }

    @Nested
    class JudgmentTest {

        @Test
        void 플레이어와_다리를_비교하여_같으면_O가_되는지_확인() {
            String judgment = bridgeGame.judgment("U");
            assertThat(judgment).isEqualTo("O");
        }

        @Test
        void 플레이어와_다리를_비교하여_틀리다면_X가_되는지_확인() {
            String judgment = bridgeGame.judgment("D");
            assertThat(judgment).isEqualTo("X");
        }
    }

    @Nested
    class restartOrQuit {

        @Test
        void 플레이어가_R를_입력_하였다면_gameCount가_증가되었는지_확인() {
            int result = 2;
            bridgeGame.restartOrQuit("R");

            int gameCount = bridgeGame.totalGameCount();
            assertThat(gameCount).isEqualTo(result);
        }

        @Test
        void 플레이어가_Q를_입력_하였다면_gameSuccess가_false인지_확인() {
            bridgeGame.restartOrQuit("Q");

            boolean success = bridgeGame.determiningSuccess();
            assertThat(success).isFalse();
        }
    }

    @Nested
    class isNotGameEnd {

        @Test
        void 게임을_끝내는_조건_확인() {
            boolean notGameEnd = bridgeGame.isNotGameEnd("Q");
            assertThat(notGameEnd).isFalse();
        }

        @Test
        void 게임을_끝내지_않는_조건_확인() {
            boolean notGameEnd = bridgeGame.isNotGameEnd("");
            assertThat(notGameEnd).isTrue();
        }
    }

    @Test
    void 필드에_지정된_gameCount_값을_불러와_지는지_확인() {
        int result = 1;
        int gameCount = bridgeGame.totalGameCount();
        assertThat(gameCount).isEqualTo(result);
    }

    @Test
    void determiningSuccess() {
        boolean result = true;
        boolean success = bridgeGame.determiningSuccess();
        assertThat(success).isTrue();
    }
}