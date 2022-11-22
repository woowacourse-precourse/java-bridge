package bridge.model;

import bridge.BridgeRandomNumberGenerator;
import bridge.view.InputView;
import bridge.view.OutputView;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.mockito.Mockito;

import static camp.nextstep.edu.missionutils.test.Assertions.*;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.when;

public class BridgeMakerTest {

    private BridgeMaker bridgeMaker;
    private GameStatistics gameStatistics;

    @BeforeEach
    void init() {
        bridgeMaker = Mockito.mock(BridgeMaker.class);
        gameStatistics = Mockito.mock(GameStatistics.class);
        when(bridgeMaker.makeBridge(3)).thenReturn(List.of("U", "D", "D"));
    }

    @Nested
    @DisplayName("입력 값 일치여부 테스트")
    class test1 {

        @DisplayName("다리 길이 입력 값과 정답 경로 다리 길이 일치 테스트")
        @Test
        void 정답경로_다리_길이_테스트() {
            assertThat(gameStatistics.getAnswerRoad().size()).isEqualTo(3);
        }

        @DisplayName("위 칸의 경우 U, 아래 칸의 경우 D값 확인 테스트")
        @Test
        void 무작위_값에_따른_U_또는_D_체크_테스트() {
            BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
            ArrayList<String> answerBridge = new ArrayList<>();
            bridgeMaker.makeAnswerRoad(answerBridge, List.of(1, 1, 0, 0, 1));

            assertRandomNumberInListTest(
                    () -> {
                        assertThat(answerBridge).isEqualTo(
                                (List.of("U", "U", "D", "D", "U")));
                    }, 1, 1, 0, 0, 1);
        }
    }
}
