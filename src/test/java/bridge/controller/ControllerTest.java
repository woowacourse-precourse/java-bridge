package bridge.controller;

import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.*;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("컨트롤러 메소드를 실행하는 통합 테스트")
public class ControllerTest {
    BridgeGameController bridgeGameController;
    MockedStatic<Randoms> randomsMockedStatic;
    OutputStream out;

    @BeforeEach
    void beforeEach() {
        randomsMockedStatic = Mockito.mockStatic(Randoms.class);
        Mockito.when(Randoms.pickNumberInRange(0, 1)).thenReturn(1, 0, 1);

        bridgeGameController = new BridgeGameController();
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @AfterEach
    void afterEach() {
        randomsMockedStatic.close();
    }

    @DisplayName("한번 실패 후 성공하는 시나리오 테스트")
    @Test
    void successTest() {
        String input = "3\nU\nD\nD\nR\nU\nD\nU";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        bridgeGameController.run();
        assertThat(out.toString().trim()).contains(
                "최종 게임 결과\n[ O |   | O ]\n[   | O |   ]"
                , "게임 성공 여부: 성공"
                , "총 시도한 횟수: 2");
    }

    @DisplayName("각 입력 마다 예외 상황에 재입력하는 시나리오")
    @Test
    void exceptionTest() {
        String input = "3j\n3\nU\n1D\nD\nD\n2R\nR\nU\nD\nU";
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
        bridgeGameController.run();
        assertThat(out.toString().trim()).contains(
                "[ERROR] 숫자 타입을 입력해주세요.",
                "[ERROR] 'R', 'Q' 이 외 문자는 입력할 수 없습니다.",
                "[ERROR] 'R', 'Q' 이 외 문자는 입력할 수 없습니다.");
    }
}
