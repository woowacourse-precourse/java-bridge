package bridge.controller;

import static bridge.data.Message.ERROR_COMMAND;
import static bridge.data.Message.ERROR_MOVE;
import static bridge.data.Message.ERROR_SIZE;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;



import bridge.view.BridgeView;
import java.io.ByteArrayInputStream;
import java.io.InputStream;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class ExceptionHandlerTest{
    ExceptionHandler exc = new ExceptionHandler();
    BridgeView view = new BridgeView();
    StringFunction sf;

    interface StringFunction{
        String valid(String param);
    }

    public void setInput(String input){
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    } // Scanner에 input을 미리 입력해둔다

    public void thrownBy(String input, StringFunction sf){
        Assertions.assertThatThrownBy(() -> sf.valid(input))
                .isInstanceOf(IllegalArgumentException.class);
    }

    public void testReEnter(IllegalArgumentException error, String correctInput){
        setInput(correctInput); // size로 적합한 값을 입력

        assertThat(exc.reEnter(view,error)).isEqualTo(correctInput); // reEnter가 다시 입력을 받아 input을 리턴하는지 확인
    }

    @Test
    void 에러를_받으면_에러를_호출한_인자에_적합한_값을_얻기_위해_해당_입력을_다시_받는지() {

        IllegalArgumentException sizeError = new IllegalArgumentException(ERROR_SIZE.OF());
        IllegalArgumentException moveError = new IllegalArgumentException(ERROR_MOVE.OF());
        IllegalArgumentException commandError = new IllegalArgumentException(ERROR_COMMAND.OF());

        testReEnter(sizeError, "3");
        testReEnter(moveError, "U");
        testReEnter(commandError, "Q");
    }

    @Test
    void 다리_사이즈로_적합하지_않은_값이_입력되면_알맞은_오류를_던지는지() {

        sf = (String param)->exc.validBridgeSize(param);
        thrownBy("bridge size에 적합하지 않은 입력", sf);
    }

    @Test
    void 이동으로_적합하지_않은_값이_입력되면_알맞은_오류를_던지는지() {
        sf = (String param)->exc.validMoving(param);
        thrownBy("move에 적합하지 않은 입력", sf);
    }

    @Test
    void 커멘드로_적합하지_않은_값이_입력되면_알맞은_오류를_던지는지() {
        sf = (String param)->exc.validMoving(param);
        thrownBy("move에 적합하지 않은 입력", sf);
    }

    @Test
    void 정수_이외의_값을_입력하면_IllegalArgumentException을_던지는지() {
        assertThrows(IllegalArgumentException.class, ()->{
            ExceptionHandler.excParseInt("a");
            ExceptionHandler.excParseInt("@");
        });
    }
}