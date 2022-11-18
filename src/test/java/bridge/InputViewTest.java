package bridge;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.view.InputView;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.List;

public class InputViewTest extends NsTest{
    private final InputView inputView = new InputView();

    private Runnable inputBridgeSizeAction = new Runnable() {
        @Override
        public void run() {
            inputView.readBridgeSize();
        }
    };

    private Runnable inputMovingAction = new Runnable() {
        @Override
        public void run() {
            inputView.readMoving();
        }
    };

    private Runnable inputGameCommandAction = new Runnable() {
        @Override
        public void run() {
            inputView.readGameCommand();
        }
    };

    private void inputSetting(String userInput) {
        final byte[] buf = String.join("\n",userInput).getBytes();
        System.setIn(new ByteArrayInputStream(buf));
    }

    private void userInputTest(String userInput,Runnable inputAction) {
        inputSetting(userInput);
        inputAction.run();
    }

    private void illegalArgumentTest(String invalidUserInput,Runnable inputAction)
    {
        assertThatThrownBy(() -> {
            userInputTest(invalidUserInput,inputAction);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validBridgeInputTest()
    {
        List<String> validUserInputList = List.of("3","20");
        for (String validUserInput : validUserInputList) {
            userInputTest(validUserInput,inputBridgeSizeAction);
        }
    }

    @Test
    void invalidBridgeInputTest() {
        List<String> invalidUserInputList = List.of("-1","21","2");
        for (String invalidUserInput : invalidUserInputList) {
            illegalArgumentTest(invalidUserInput,inputBridgeSizeAction);
        }
    }

    @Test
    void movingInputTest()
    {
        List<String> userInputList = List.of("U", "D");
        for (String validUserInput : userInputList) {
            userInputTest(validUserInput,inputMovingAction);
        }
    }

    @Test
    void invalidMovingInputTest()
    {
        List<String> invalidUserInputList = List.of("Q", "UU", "DD","1234");
        for (String invalidUserInput : invalidUserInputList) {
            illegalArgumentTest(invalidUserInput,inputMovingAction);
        }
    }

    @Test
    void gameCommandInputTest()
    {
        List<String> userInputList = List.of("R", "Q");
        for (String validUserInput : userInputList) {
            userInputTest(validUserInput,inputGameCommandAction);
        }
    }

    @Test
    void invalidGameCommandInputTest() {
        List<String> invalidUserInputList = List.of("QQ", "RR", "-","1234");
        for (String invalidUserInput : invalidUserInputList) {
            illegalArgumentTest(invalidUserInput,inputGameCommandAction);
        }
    }

    @Test
    void emptyInputTest() {
        illegalArgumentTest(new String(" "),inputBridgeSizeAction);
        illegalArgumentTest(new String(" "),inputMovingAction);
        illegalArgumentTest(new String(" "),inputGameCommandAction);
    }

    @Override
    protected void runMain() {
    }
}
