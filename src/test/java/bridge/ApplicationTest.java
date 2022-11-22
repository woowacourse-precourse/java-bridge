package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import camp.nextstep.edu.missionutils.test.NsTest;

import java.io.InputStream;
import java.io.StringBufferInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

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

    @Test
    void 다리_사이즈_생성() {
        assertSimpleTest(() -> {
            runException("21");
            assertThat(output()).contains(ERROR_MESSAGE);
        });
    }

    @Test
    void 다리_생성_테스트2(){
        BridgeNumberGenerator numberGenerator = new BridgeRandomNumberGenerator();
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        if (!bridge.contains("D")){assertThat(bridge).contains("U");}
        if (!bridge.contains("U")){assertThat(bridge).contains("D");}
    }

    @Test
    void move_메소드_test() {
        BridgeNumberGenerator numberGenerator = new TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        BridgeGame game = new BridgeGame();
        assertThat(game.move(0,bridge, "D").retry).isEqualTo(Boolean.FALSE);
    }

    @Test
    void input_instruction_테스트() {
        InputStream input = new StringBufferInputStream("U");
        System.setIn(input);
        InputView inputv = new InputView();
        assertThat(inputv.readMoving()).isEqualTo("U");
        input = new StringBufferInputStream("sdsd");
        System.setIn(input);
        inputv.readMoving();
        assertThat(output()).contains(ERROR_MESSAGE);
    }

    @Test
    void input_restart_테스트() {
        InputStream input = new StringBufferInputStream("R");
        System.setIn(input);
        InputView inputv = new InputView();
        assertThat(inputv.readGameCommand()).isEqualTo("R");
        input = new StringBufferInputStream("sdsd");
        System.setIn(input);
        inputv.readGameCommand();
        assertThat(output()).contains(ERROR_MESSAGE);
    }
    @Test
    void printMap_테스트(){
        List<String> bridge = Arrays.asList("U", "D", "U");
        int index_num = 1;
        String instruction = "D";
        String result1 = "[ O |   ]";
        String result2 = "[   | O ]";
        OutputView out = new OutputView();
        out.printMap(index_num, instruction, bridge);
        assertThat(output()).contains(result1);
        assertThat(output()).contains(result2);
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
