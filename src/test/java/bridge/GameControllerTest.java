package bridge;

import org.junit.jupiter.api.Test;

import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;
import static org.junit.jupiter.api.Assertions.*;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.Test;

class GameControllerTest extends NsTest{
    @Test
    void 재시작_기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "R", "U", "D", "U");
            assertThat(output()).contains(
                    "[ O |   |   ]",
                    "[   | O | X ]",
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                    "이동할 칸을 선택해주세요. (위: U, 아래: D)",
                    "최종 게임 결과",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );
        }, 1, 0, 1);
    }

    @Test
    void 게임_실패_기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "Q");
            assertThat(output()).contains(
                    "[ O |   |   ]",
                    "[   | O | X ]",
                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
                    "최종 게임 결과",
                    "[ O |   |   ]",
                    "[   | O | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );
        }, 1, 0, 1);
    }
//
//    @Test
//    void 예외처리_진행할_때_메시지_출력하고_재입력_받는_기능_테스트() {
//        assertRandomNumberInRangeTest(() -> {
//            run("1", "3", "U", "123", "D", "D", "abc", "Q");
//            assertThat(output()).contains(
//                    "[ERROR] 다리 길이는 3부터 20 사이의 숫자여야 합니다.",
//                    "[ O ]",
//                    "[   ]",
//                    "[ERROR] 이동할 칸에 대한 입력은 'U' 또는 'D'여야 합니다.",
//                    "[ O |   |   ]",
//                    "[   | O | X ]",
//                    "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)",
//                    "[ERROR] 게임 재시작/종료 여부에 대한 입력은 'R' 또는 'Q'여야 합니다.",
//                    "최종 게임 결과",
//                    "[ O |   |   ]",
//                    "[   | O | X ]",
//                    "게임 성공 여부: 실패",
//                    "총 시도한 횟수: 1"
//            );
//        }, 1, 0, 1);
//    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}