package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.NoSuchElementException;

import static bridge.Message.MSG_GET_RETRY;
import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

public class GameControllerTest extends NsTest {

    @DisplayName("움직임이 잘 적용되는지 확인: 짧은 경우")
    @Test
    void testShortNormalCase() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U");
            assertThat(output()).contains(
                    "[ O | X ]",
                    "[   |   ]"
            );
        }, 1, 0, 1);
    }

    @DisplayName("움직임이 잘 적용되는지 확인: 긴 경우")
    @Test
    void testLongNormalCase() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "R", "U", "D", "U");
            assertThat(output()).contains(
                    MSG_GET_RETRY,
                    "최종 게임 결과",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 2"
            );
            int upSideIndex = output().indexOf("[ O |   | O ]");
            int downSideIndex = output().indexOf("[   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }

    @DisplayName("다리 길이의 입력이 잘못된 경우 다시 입력을 받는지 확인")
    @Test
    void repeatReadSize() {
        assertRandomNumberInRangeTest(() -> {
            run("A", "1", "3", "U");
            assertThat(output()).contains(
                    "[ O ]",
                    "[   ]"
            );
        }, 1, 0, 1);
    }

    @DisplayName("이동 입력이 잘못된 경우 다시 입력을 받는지 확인")
    @Test
    void repeatReadMoving() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "A", "100", "U");
            assertThat(output()).contains(
                    "[ O ]",
                    "[   ]"
            );
        }, 1, 0, 1);
    }

    @DisplayName("재시작 입력이 잘못된 경우 다시 입력을 받는지 확인")
    @Test
    void repeatReadRetry() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "A", "100", "R", "U");
            assertThat(output()).contains(
                    "[   ]",
                    "[ X ]"
            );
        }, 1, 0, 1);
    }


    @Override
    protected void runMain() {
        try{
            Application.main(new String[]{});
        }catch(NoSuchElementException e){
        }
    }

}
