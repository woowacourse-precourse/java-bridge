package exception;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.Test;

import bridge.Application;
import bridge.BridgeNumberGenerator;
import camp.nextstep.edu.missionutils.test.NsTest;

class ExceptionTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 종합_예외_기능_테스트() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "T", "U", "U", "E", "R", "U", "D", "U");
            assertThat(output()).contains(
            	ERROR_MESSAGE,
                "최종 게임 결과",
                "[ O |   | O ]",
                "[   | O |   ]",
                "게임 성공 여부: 성공"
            );

            int upSideIndex = output().indexOf("[ O |   | O ]");
            int downSideIndex = output().indexOf("[   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }

    @Test
    void 다리_이동_예외_테스트() {
        assertSimpleTest(() -> {
            runException("3","T");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    
    @Test
    void 재시작_예외_테스트() {
    	assertRandomNumberInRangeTest(() -> {
            run("3", "U", "U", "E", "R", "U", "D", "U");
            assertThat(output()).contains(
            	ERROR_MESSAGE,
                "최종 게임 결과",
                "[ O |   | O ]",
                "[   | O |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 2"
            );
    	}, 1, 0, 1);
    }
    
    @Test
    void 재시작_종료_테스트() {
    	assertRandomNumberInRangeTest(() -> {
    		run("3", "U", "U", "Q");
    		assertThat(output()).contains(
    				"최종 게임 결과",
    				"[ O | X ]",
    				"[   |   ]",
    				"게임 성공 여부: 실패"
    				);
    	}, 1, 0, 1);
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

    static class TestNumberGenerator implements BridgeNumberGenerator {

        private final List<Integer> numbers;

        TestNumberGenerator(List<Integer> numbers) {
            this.numbers = numbers;
        }

        @Override
        public int generate() {
            return numbers.remove(0);
        }
    }
}
