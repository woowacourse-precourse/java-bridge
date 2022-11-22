package bridge;

import org.junit.jupiter.api.Test;

import java.util.InputMismatchException;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class InputViewTest {

    private final InputView inputView = new InputView();

    @Test
    public void readBridgeSizeTest(){
        String input = new String("18");

        assertThat(inputView.validateBridgeSize(input)).isEqualTo(18);
    }

    @Test
    public void readBridgeExceptionTest(){
        String[] inputs = new String[]{"21", "asdf"};

        for(String input : inputs) {
            assertThatThrownBy(() -> inputView.validateBridgeSize(input)).isInstanceOf(InputMismatchException.class);
        }
    }

    @Test
    public void readCommandExceptionTest(){
        String[] inputs = new String[]{"UU", "asdf", "U"};

        for(String input : inputs) {
            assertThatThrownBy(() -> inputView.validateCommand(input)).isInstanceOf(IllegalArgumentException.class);
        }
    }

    @Test
    public void readMovingExceptionTest(){
        String[] inputs = new String[]{"UU", "asdf"};

        for(String input : inputs) {
            assertThatThrownBy(() -> inputView.validateMoving(input)).isInstanceOf(IllegalArgumentException.class);
        }
    }
}
