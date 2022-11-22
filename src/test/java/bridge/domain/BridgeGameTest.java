package bridge.domain;


import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


class BridgeGameTest extends NsTest {
    @DisplayName("재시작 조건 잘못 입력했을 때 에러메시지 출력")
    @Test
    void checkGameCommandErrorMessage() {
        assertRandomNumberInRangeTest(() -> {
            run("D", "T", "R", "U", "U", "U", "U", "U");
            assertThat(output()).contains(
                    "[ X ]",
                    "[   ]",
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                    "[ERROR] 재시도: R, 종료: Q 외에 다른 값을 입력했습니다.",
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                    "최종 게임 결과",
                    "[ O | O | O | O | O ]",
                    "[   |   |   |   |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );
        }, 1, 1, 1, 1, 1);
    }

    @Override
    public void runMain() {
        BridgeGame game = new BridgeGame(5);
        game.play();
    }
}
