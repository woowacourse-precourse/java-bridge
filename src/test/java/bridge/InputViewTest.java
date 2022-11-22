package bridge;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class InputViewTest {
    InputView inputView;
    InputViewTest(){
        this.inputView = new InputView();
    }
    @Test
    void testValidateBridgeSizeTrue(){
        String input ="12";
        assertThat(inputView.validateBridgeSize(input)).isEqualTo(12);
    }

    @Test
    void testValidateBridgeSizeFalse(){
        String input1 ="123";
        String input2 ="Z";
        assertThatThrownBy(
                ()->inputView.validateBridgeSize(input1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(
                ()->inputView.validateBridgeSize(input2))
                .isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void testValidateMovingTrue(){
        String inputUp ="U";
        String inputDown ="D";
        assertThatCode(
                ()-> inputView.validateMoving(inputUp))
                .doesNotThrowAnyException();
        assertThatCode(
                ()-> inputView.validateMoving(inputDown))
                .doesNotThrowAnyException();
    }

    @Test
    void testValidateMovingFalse(){
        String input1 ="UD";
        String input2 ="Z";
        assertThatThrownBy(
                ()->inputView.validateMoving(input1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(
                ()->inputView.validateMoving(input2))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void testValidateGameCommandTrue(){
        String inputRetry ="R";
        String inputQuit ="Q";
        assertThatCode(
                ()-> inputView.validateGameCommand(inputRetry))
                .doesNotThrowAnyException();
        assertThatCode(
                ()-> inputView.validateGameCommand(inputQuit))
                .doesNotThrowAnyException();
    }
    @Test
    void testValidateGameCommandFalse(){
        String input1 ="RR";
        String input2 ="Z";
        assertThatThrownBy(
                ()->inputView.validateGameCommand(input1))
                .isInstanceOf(IllegalArgumentException.class);
        assertThatThrownBy(
                ()->inputView.validateGameCommand(input2))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
