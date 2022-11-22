package bridge;

import bridge.model.User;
import bridge.model.UserDTO;
import bridge.view.Input;
import bridge.view.InputView;
import bridge.view.OutputView;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

public class ViewTest extends ApplicationTest {
    private TestInput testInput = new TestInput(3, "U","R");
    private Integer outputInt;
    private String outputStr;
    @Test
    void InputTest(){
        InputView inputView = new InputView(testInput);
        outputInt = inputView.readBridgeSize();
        outputStr = inputView.readMoving();
        assertThat(outputInt).isEqualTo(3);
        assertThat(outputStr).isEqualTo("U");
    }
    @Test
    void printMapTest(){
        List<String> bridgeList = newArrayList("U","D","U","U");
        OutputView outputView = new OutputView(bridgeList);
        outputView.printMap(false,2,"D");
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
    static class TestInput implements Input {
        private Integer inputInt;
        private String inputMove;
        private String inputRetry;
        TestInput(Integer inputInt,String inputStr,String inputRetry){
            this.inputInt = inputInt;
            this.inputMove = inputStr;
            this.inputRetry = inputRetry;
        }
        @Override
        public Integer getInputInteger() {
            return this.inputInt;
        }

        @Override
        public String getInputMove() {
            return this.inputMove;
        }
        @Override
        public String getInputRetry() {
            return this.inputRetry;
        }
    }
}
