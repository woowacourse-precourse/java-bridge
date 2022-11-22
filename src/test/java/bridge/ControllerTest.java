package bridge;

import bridge.controller.Controller;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ControllerTest {

    ByteArrayOutputStream stream = new ByteArrayOutputStream();

    @BeforeEach
    public void init() {
        System.setOut(new PrintStream(stream));
    }

    @AfterEach
    protected void clear() {
        System.setOut(System.out);
        stream.reset();
    }

    @Test
    void test1() {
        String expect =
              "[   ]\n"
            + "[ X ]\n"
            + "\n"
            + "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)\n"
            + "Q\n"
            + "최종 게임 결과\n"
            + "[   ]\n"
            + "[ X ]\n"
            + "\n"
            + "게임 성공 여부: 실패\n"
            + "총 시도한 횟수: 1";
        InputViewMock inputView = new InputViewMock();
        BridgeGameServiceMock service = new BridgeGameServiceMock();
        OutputViewMock outputView = new OutputViewMock();
        Controller controller = new Controller(service, inputView, outputView);
        controller.play();
        controller.print();
        Assertions.assertEquals(expect, stream.toString());
    }
}
