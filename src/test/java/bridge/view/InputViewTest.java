package bridge.view;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

class InputViewTest {
    InputView inputView = new InputView();

    @Test
    void isValidBridgeSize_다리_길이_유효성_검사_정상_최소값() {
        boolean validBridgeSize = inputView.isValidBridgeSize("3");
        assertThat(validBridgeSize).isTrue();
    }

    @Test
    void isValidBridgeSize_다리_길이_유효성_검사_정상_최대값() {
        boolean validBridgeSize = inputView.isValidBridgeSize("20");
        assertThat(validBridgeSize).isTrue();
    }

    @Test
    void isValidBridgeSize_다리_길이_유효성_검사_정상_중간값() {
        boolean validBridgeSize = inputView.isValidBridgeSize("10");
        assertThat(validBridgeSize).isTrue();
    }

    @Test
    void isValidBridgeSize_다리_길이_유효성_검사_실패_범위초과() {
        boolean validBridgeSize = inputView.isValidBridgeSize("100");
        assertThat(validBridgeSize).isFalse();
    }

    @Test
    void isValidBridgeSize_다리_길이_유효성_검사_실패_문자_입력() {
        boolean validBridgeSize = inputView.isValidBridgeSize("a");
        assertThat(validBridgeSize).isFalse();
    }

    @Test
    void validateInteger_정수_유효성_검사_예외_발생() {
        assertThatThrownBy(() -> inputView.validateInteger("a")).
                isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void validateBridgeSizeRange_범위_유효성_검사_예외_발생() {
        assertThatThrownBy(() -> inputView.validateBridgeSizeRange(100)).
                isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    void isValidMoveCommand_움직임_유효성_검사_성공_UP() {
        boolean validMoveCommand = inputView.isValidMoveCommand("U");

        assertThat(validMoveCommand).isTrue();
    }

    @Test
    void isValidMoveCommand_움직임_유효성_검사_성공_DOWN() {
        boolean validMoveCommand = inputView.isValidMoveCommand("D");

        assertThat(validMoveCommand).isTrue();
    }

    @Test
    void isValidMoveCommand_움직임_유효성_검사_실패() {
        boolean validMoveCommand = inputView.isValidMoveCommand("q");
        assertThat(validMoveCommand).isFalse();
    }

    @Test
    void validateMoveFormat_잘못된_움직임_명령_예외_발생() {
        assertThatThrownBy(() -> inputView.validateMoveFormat("Q")).
                isInstanceOf(IllegalArgumentException.class);

    }

    @Test
    void isValidFailCommand_프로그램_종료_입력_정상_재시작() {
        boolean failCommand = inputView.isValidFailCommand("R");

        assertThat(failCommand).isTrue();
    }

    @Test
    void isValidFailCommand_프로그램_종료_입력_정상_종료() {
        boolean failCommand = inputView.isValidFailCommand("Q");

        assertThat(failCommand).isTrue();
    }

    @Test
    void isValidFailCommand_프로그램_종료_입력_실패() {
        boolean failCommand = inputView.isValidFailCommand("1");

        assertThat(failCommand).isFalse();
    }

    @Test
    void validateGameFailFormat_Q_또는_R_을_입력하지_않으면_예외발생() {
        assertThatThrownBy(() -> inputView.validateGameFailFormat("ㅈ")).
                isInstanceOf(IllegalArgumentException.class);
    }
}