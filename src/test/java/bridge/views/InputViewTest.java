package bridge.views;

import bridge.InOutStreamTest;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.function.Executable;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class InputViewTest extends InOutStreamTest {

    InputView ui = new InputView();

    @Nested
    class ReadBridgeSizeTest {

        @Test
        void 다리_길이_입력은_정상동작한다() {
            input("4");

            int expected = 4;
            int actual = ui.readBridgeSize();

            assertThat(actual).isEqualTo(expected);
        }

        @Test
        void 다리_길이에_문자가_주어지면_예외처리한다() {
            inputAndExceptionTest("a", ui::readBridgeSize);
        }

        @Test
        void 다리_길이에_공백문자가_주어지면_예외처리한다() {
            inputAndExceptionTest(" ", ui::readBridgeSize);
        }

        @Test
        void 다리_길이에_입력값이_없이_주어지면_예외처리한다() {
            inputAndExceptionTest("", ui::readBridgeSize);
        }
    }

    @Nested
    class ReadMovingTest {

        @Test
        void 이동방향_입력은_정상동작한다(){
            input("A");

            String expected = "A";
            String actual = ui.readMoving();

            assertThat(actual).isEqualTo(expected);
        }

        @Test
        void 이동방향_입력에_숫자가_주어지면_예외처리한다() {
            inputAndExceptionTest("2", ui::readMoving);
        }

        @Test
        void 이동방향_입력에_공백문자가_주어지면_예외처리한다() {
            inputAndExceptionTest(" ", ui::readMoving);
        }

        @Test
        void 이동방향_입력에_특수문자가_주어지면_예외처리한다() {
            inputAndExceptionTest("*", ui::readMoving);
        }

        @Test
        void 이동방향_입력에_입력값이_없이_주어지면_예외처리한다() {
            inputAndExceptionTest("", ui::readMoving);
        }
    }

    @Nested
    class ReadGameCommandTest {

        @Test
        void 재시작_종료_입력은_정상동작한다(){
            input("A");

            String expected = "A";
            String actual = ui.readMoving();

            assertThat(actual).isEqualTo(expected);
        }

        @Test
        void 재시작_종료_입력에_숫자가_주어지면_예외처리한다() {
            inputAndExceptionTest("2", ui::readGameCommand);
        }

        @Test
        void 재시작_종료_입력에_공백문자가_주어지면_예외처리한다() {
            inputAndExceptionTest(" ", ui::readGameCommand);
        }

        @Test
        void 재시작_종료_입력에_특수문자가_주어지면_예외처리한다() {
            inputAndExceptionTest("*", ui::readGameCommand);
        }

        @Test
        void 재시작_종료_입력에_입력값이_없이_주어지면_예외처리한다() {
            inputAndExceptionTest("", ui::readGameCommand);
        }
    }

    void inputAndExceptionTest(String inputMessage, Executable executable){
        input(inputMessage);
        assertThatThrownBy(executable::execute)
                .isInstanceOf(IllegalArgumentException.class);
    }
}