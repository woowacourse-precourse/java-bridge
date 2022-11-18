package bridge.ui;

import static bridge.BridgeExpression.UP;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class InputViewTest {

    private InputView inputView;

    @BeforeEach
    void setUp() {
        inputView = new InputView();
    }

    @Test
    public void 다리_길이_입력() {
        //given
        int assertSize = 3;

        int readBridgeSize = inputView.readBridgeSize();

        //when

        //then
        Assertions.assertEquals(assertSize, readBridgeSize);
    }


    @Test
    void 이동할_칸_입력() throws Exception {
        //given

        String assertUp = UP.expression();
        String up = inputView.readMoving();

        //then
        Assertions.assertEquals(assertUp, up);
    }

    @Test
    public void 커맨드_입력() throws Exception {
        //given
        String reTry = "R";
        String exit = "Q";

        //then
        String commandReTry = inputView.readGameCommand();
        String commandExit = inputView.readGameCommand();

        Assertions.assertEquals(reTry, commandReTry);
        Assertions.assertEquals(exit, commandExit);
    }

}