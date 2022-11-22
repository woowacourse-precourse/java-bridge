package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import camp.nextstep.edu.missionutils.test.NsTest;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class ApplicationTest extends NsTest {
    
    private static final String ERROR_MESSAGE = "[ERROR]";
    
    @DisplayName("다리 생성 테스트")
    @Test
    void generateBridge() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U", "D", "D");
    }
    
    @DisplayName("기능 테스트")
    @Test
    void start() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "U");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1"
            );
            
            int upSideIndex = output().indexOf("[ O |   | O ]");
            int downSideIndex = output().indexOf("[   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }
    
    @DisplayName("성공 케이스 - 한번에 성공")
    @Test
    void startBySuccess() {
        assertRandomNumberInRangeTest(() -> {
            run("5", "U", "D", "U", "D", "U");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O |   | O ]",
                    "[   | O |   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 1"
            );
            
            int upSideIndex = output().indexOf("[ O |   | O ]");
            int downSideIndex = output().indexOf("[   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1, 0, 1, 0);
    }
    
    @DisplayName("성공 케이스 - 여러번 시도 후 성공")
    @Test
    void startBySuccessTryManyTimes() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "R", "D", "R", "U", "D", "U");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   | O ]",
                    "[   | O |   ]",
                    "게임 성공 여부: 성공",
                    "총 시도한 횟수: 3"
            );
            
            int upSideIndex = output().indexOf("[ O |   |  O ]");
            int downSideIndex = output().indexOf("[   | O |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1, 0);
    }
    
    @DisplayName("실패 케이스 - 한번 실패 후 종료")
    @Test
    void startByFailure() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   |   ]",
                    "[   | O | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 1"
            );
            
            int upSideIndex = output().indexOf("[ O |   |   ]");
            int downSideIndex = output().indexOf("[   | O | X ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }
    
    @DisplayName("실패 케이스 - 여러번 실패 후 종료")
    @Test
    void startByFailureTryManyTimes() {
        assertRandomNumberInRangeTest(() -> {
            run("3", "U", "D", "D", "R", "D", "R", "U", "U", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O |   |   ]",
                    "[   | O | X ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 3"
            );
            
            int upSideIndex = output().indexOf("[ O |   |   ]");
            int downSideIndex = output().indexOf("[   | O | X ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1, 0);
    }
    
    @DisplayName("다리 길이를 1 이하로 입력했을 경우 에러 메시지를 출력한다.")
    @Test
    void startByLessBridgeSize() {
        assertSimpleTest(() -> {
            runException("0");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    
    @DisplayName("이동할 방향을 올바르지 않게 입력했을 경우 에러 메시지를 출력한다.")
    @Test
    void startByInvalidMoveDirection() {
        assertSimpleTest(() -> {
            runException("3", "UP");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    
    @DisplayName("입력이 잘못 되었을 경우 다시 입력을 받고 게임을 진행한다.")
    @Test
    void startByRetryInputInvalid() {
        assertRandomNumberInRangeTest(() -> {
            run("a", "2", "UP", "U", "U", "RETRY", "R", "U", "U", "QUIT", "Q");
            assertThat(output()).contains(
                    "최종 게임 결과",
                    "[ O | X ]",
                    "[   |   ]",
                    "게임 성공 여부: 실패",
                    "총 시도한 횟수: 2"
            );
            
            int upSideIndex = output().indexOf("[ O | X ]");
            int downSideIndex = output().indexOf("[   |   ]");
            assertThat(upSideIndex).isLessThan(downSideIndex);
        }, 1, 0, 1);
    }
    
    @DisplayName("예외 메시지는 [ERROR]를 포함한 내용으로 출력한다.")
    @Test
    void errorMessage() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }
    
    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }
}
