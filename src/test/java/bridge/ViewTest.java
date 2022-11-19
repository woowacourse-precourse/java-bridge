package bridge;

import bridge.view.Input;
import bridge.view.InputView;
import bridge.view.OutputView;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class ViewTest extends ApplicationTest {
    private static final Integer TEST_INT = 3;
    private static final String TEST_STR = "U";
    private TestInput testInput = new TestInput(TEST_INT, TEST_STR);
    private Integer outputInt;
    private String outputStr;
    @Test
    void InputTest(){
        InputView inputView = new InputView(testInput);
        outputInt = inputView.readBridgeSize();
        outputStr = inputView.readMoving();
        assertThat(outputInt).isEqualTo(TEST_INT);
        assertThat(outputStr).isEqualTo(TEST_STR);
    }
    @Test
    void printMapTest(){
        List<String> bridgeList = newArrayList("U","D","U","U");
        OutputView outputView = new OutputView(bridgeList);
        outputView.printMap(false,2,"U");
        assertThat(output()).contains(
                "[ O |   |   ]",
                "[   | O | X ]"
                );
    }
    @Test
    void printFirstMapTest(){
        List<String> bridgeList = newArrayList("U","D","U","U");
        OutputView outputView = new OutputView(bridgeList);
        outputView.printMap(true,0,"U");
        assertThat(output()).contains(
                "[ O ]",
                "[   ]"
        );
    }
    @Test
    void printSecondMapTest(){
        List<String> bridgeList = newArrayList("U","D","U","U");
        OutputView outputView = new OutputView(bridgeList);
        outputView.printMap(false,1,"U");
        assertThat(output()).contains(
                "[ O | X ]",
                "[   |   ]"
        );
    }
    @Test
    void printResultTest(){
        List<String> bridgeList = newArrayList("U","D","U","U");
        OutputView outputView = new OutputView(bridgeList);
        outputView.printResult(true,3,"U");
        assertThat(output()).contains(
                "[ O |   | O | O ]",
                "[   | O |   |   ]",
                "게임 성공 여부: 성공",
                "총 시도한 횟수: 3"
        );
    }
    static class TestInput implements Input {
        private Integer inputInt;
        private String inputStr;
        TestInput(Integer inputInt,String inputStr){
            this.inputInt = inputInt;
            this.inputStr = inputStr;
        }
        @Override
        public Integer inputInteger() {
            return this.inputInt;
        }

        @Override
        public String inputMove() {
            return this.inputStr;
        }
        @Override
        public String inputRetry() {
            return this.inputStr;
        }
    }
}
