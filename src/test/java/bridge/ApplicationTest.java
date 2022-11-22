package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.Model.BridgeMaker;
import camp.nextstep.edu.missionutils.test.NsTest;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class ApplicationTest extends NsTest {

    private static final String ERROR_MESSAGE = "[ERROR]";

    @Test
    void 다리_생성_테스트() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("U", "D", "D");
    }

    @Test
    void 기능_테스트() {
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

    @Test
    void 예외_테스트() {
        assertSimpleTest(() -> {
            runException("a");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

//    @Test
//    void 다리_생성_테스트() {
//        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0, 0, 1, 0, 1));
//        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
//        List<String> bridge = bridgeMaker.makeBridge(7);
//        assertThat(bridge).containsExactly("U", "D", "D", "D", "U", "D", "U");
//    }
//
//    @DisplayName("3이상 20이하 외 값 입력")
//    @ParameterizedTest
//    @ValueSource(strings = {"a", "ㄷ", "21", "0", " ", "$", "!", "2"})
//    void 다리_값_예외_테스트(String input) {
//        assertSimpleTest(() -> {
//            runException(input);
//            assertThat(output()).contains(ERROR_MESSAGE);
//        });
//    }
//
//    @Test
//    void 기능_테스트() {
//        assertRandomNumberInRangeTest(() -> {
//            run("3", "U", "D", "U");
//            assertThat(output()).contains(
//              "최종 게임 결과",
//              "[ O |   | O ]",
//              "[   | O |   ]",
//              "게임 성공 여부: 성공",
//              "총 시도한 횟수: 1"
//            );
//
//            int upSideIndex = output().indexOf("[ O |   | O ]");
//            int downSideIndex = output().indexOf("[   | O |   ]");
//            assertThat(upSideIndex).isLessThan(downSideIndex);
//        }, 1, 0, 1);
//    }

//    @DisplayName("재시도로 성공된 게임 종료")
//    @Test
//    void 재시도로_성공된_게임() {
//        assertRandomNumberInRangeTest(() -> {
//            run("3", "U", "R", "U", "R", "D", "D", "D");
//            assertThat(output()).contains(
//              "다리 건너기 게임을 시작합니다.",
//              "다리의 길이를 입력해주세요.",
//              "이동할 칸을 선택해주세요.",
//              "[ X ]",
//              "[   ]",
//              "게임을 다시 시도할지 여부를 입력해주세요.",
//              "최종 게임 결과",
//              "[   |   |   ]",
//              "[ O | O | O ]",
//              "게임 성공 여부: 성공",
//              "총 시도한 횟수: 3"
//            );
//
//            int upSideIndex = output().indexOf("[   |   |   ]");
//            int downSideIndex = output().indexOf("[ O | O | O ]");
//            assertThat(upSideIndex).isLessThan(downSideIndex);
//        }, 0, 0, 0);
//    }
//
//    @DisplayName("재시도로 실패된 게임 종료")
//    @Test
//    void 재시도로_실패된_게임() {
//        assertRandomNumberInRangeTest(() -> {
//            run("3", "U", "U", "R", "U", "U", "Q");
//            assertThat(output()).contains(
//              "다리 건너기 게임을 시작합니다.",
//              "다리의 길이를 입력해주세요.",
//              "이동할 칸을 선택해주세요.",
//              "[ O ]",
//              "[   ]",
//              "게임을 다시 시도할지 여부를 입력해주세요.",
//              "최종 게임 결과",
//              "[ O | X ]",
//              "[   |   ]",
//              "게임 성공 여부: 실패",
//              "총 시도한 횟수: 2"
//            );
//            int upSideIndex = output().indexOf("[ O | X ]");
//            int downSideIndex = output().indexOf("[   |   ]");
//            assertThat(upSideIndex).isLessThan(downSideIndex);
//        }, 1, 0, 1);
//    }

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
