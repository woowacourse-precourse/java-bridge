package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

public class ApplicationTest2 extends NsTest {

    @Test
    void 기능_테스트2() {
    	assertRandomNumberInRangeTest(() -> {
            run("4", "U", "D", "U", "U");
            assertThat(output()).contains(
            	"최종 게임 결과",
                "[ O |   | O | O ]",
                "[   | O |   |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 1"
            );
            
        }, 1, 0, 1, 1);
    	
    	assertRandomNumberInRangeTest(() -> {
            run("6", "U", "D", "D", "D", "R", "U", "D", "D", "U", "D", "R", "U", "D", "D", "U", "U", "U", "Q");
            assertThat(output()).contains(
            	"최종 게임 결과",
                "[ O |   |   | O | O | X ]",
                "[   | O | O |   |   |   ]",
                "게임 성공 여부: 실패",
                "총 시도한 횟수: 3"
            );

        }, 1, 0, 0, 1, 1, 0);
        
        assertRandomNumberInRangeTest(() -> {
            run("3", "D", "D", "D", "R", "D", "U", "R", "D", "D", "U");
            assertThat(output()).contains(
            	"최종 게임 결과",
                "[   |   | O ]",
                "[ O | O |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 3"
            );

        }, 0, 0, 1);
        
        assertRandomNumberInRangeTest(() -> {
            run("20", "D", "D", "U", "D", "D", "U", "D", "U", "U", "D", 
            			"U", "U", "U", "D", "D", "D", "D", "U", "U", "D");
            assertThat(output()).contains(
            	"최종 게임 결과",
                "[   |   | O |   |   | O |   | O | O |   | O | O | O |   |   |   |   | O | O |   ]",
                "[ O | O |   | O | O |   | O |   |   | O |   |   |   | O | O | O | O |   |   | O ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 1"
            );

        }, 0, 0, 1, 0, 0, 1, 0, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0, 1, 1, 0);
        
    }

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

	
}
