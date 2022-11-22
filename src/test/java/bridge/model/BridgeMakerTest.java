package bridge.model;

import bridge.BridgeRandomNumberGenerator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static camp.nextstep.edu.missionutils.test.Assertions.*;

import java.util.ArrayList;
import java.util.List;


public class BridgeMakerTest {

    private BridgeMaker bridgeMaker;
    private GameStatistics gameStatistics;

    @BeforeEach
    void init() {
        this.bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
        this.gameStatistics = new GameStatistics();
    }

    @Nested
    @DisplayName("입력 값 일치여부 테스트")
    class test1 {

        @DisplayName("다리 길이 입력 값과 정답 경로 다리 길이 일치 테스트")
        @Test
        void 정답경로_다리_길이_테스트() {
            gameStatistics.setAnswerRoad(bridgeMaker.makeBridge(3));
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
