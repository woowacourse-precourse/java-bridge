package bridge;

import bridge.view.InputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class InputViewTest extends NsTest {
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

    @Override
    protected void runMain() {
        Application.main(new String[]{});
    }

    static class TestInput implements Input{
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
        public String inputString() {
            return this.inputStr;
        }
    }
}
