package bridge;

import static bridge.controller.BridgeGameController.getCount;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;

import bridge.ApplicationTest.TestNumberGenerator;
import bridge.domain.BridgeGame;
import bridge.domain.BridgeMaker;

import camp.nextstep.edu.missionutils.test.NsTest;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class BridgeGameTest extends NsTest {
    private final BridgeGame bridgeGame = new BridgeGame();
    private final BridgeNumberGenerator bridgeNumberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
    private final BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    private final List<String> bridge = bridgeMaker.makeBridge(3);

    @DisplayName("이동 결과 O, X 테스트")
    @Test
        // bridge 현재 값은 [U, D, D]
    void moveTest() {
        String firstMove = bridgeGame.move(bridge.get(0), "U");
        String secondMove = bridgeGame.move(bridge.get(1), "D");
        String thirdMove = bridgeGame.move(bridge.get(2), "U");
        assertEquals("O", firstMove);
        assertEquals("O", secondMove);
        assertNotEquals("O", thirdMove);
    }

    @DisplayName("재시작 테스트")
    @Test
    void retryTest() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "U", "R", "U", "D", "D");
            assertThat(output()).contains(
                    "[ O |   | X ]",
                    "[   | O |   ]",
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                    "이동할 칸을 선택해주세요. (위: U, 아래: D)",
                    "최종 게임 결과",
                    "[ O |   |   ]",
                    "[   | O | O ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );

            int count = getCount();
            assertEquals(2, count);
        }, 1, 0, 0);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
