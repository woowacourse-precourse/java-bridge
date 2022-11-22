package bridge.controller;

import bridge.model.BridgeGame;
import bridge.view.InputView;
import bridge.view.OutputView;
import camp.nextstep.edu.missionutils.Randoms;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

import java.io.*;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("컨트롤러 메소드를 실행하는 통합 테스트")
public class ControllerTest {
    static BridgeGameController bridgeGameController;
    static MockedStatic<Randoms> randomsMockedStatic;
    static OutputStream out;


    @BeforeAll
    static void beforeAll() {
        randomsMockedStatic = Mockito.mockStatic(Randoms.class);
        Mockito.when(Randoms.pickNumberInRange(0,1)).thenReturn(1,0,1);

        InputView inputView = new InputView();
        OutputView outputView = new OutputView();
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGameController = new BridgeGameController(inputView, outputView, bridgeGame);
        out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));
    }

    @DisplayName("게임 시작 시 출력 테스트")
    @Test
    void startNewGameTest() {
        bridgeGameController.startNewGame();

        String expectedOutput = "다리 건너기 게임을 시작합니다.";

        assertThat(out.toString().trim()).isEqualTo(expectedOutput);
    }

    @DisplayName("새로운 다리 만들기 테스트")
    @Test
    void createNewBridgeTest() {

    }

    @DisplayName("새로운 다리 만들기 예외(다시 입력) 테스트")
    @Test
    void createNewBridgeExceptionTest() {

    }

    @DisplayName("발판 선택 테스트")
    @Test
    void selectPlateTest() {

    }

    @DisplayName("발판 선택 예외(다시 입력) 테스트")
    @Test
    void selectPlateExceptionTest() {

    }

    @DisplayName("다리 완전히 건널 때 까지 라운드 반복 여부 테스트")
    @Test
    void playRoundSuccessTest() {

    }

    @DisplayName("다리 떨어지면 라운드 반복 멈추는 테스트 ")
    @Test
    void playRoundFailTest() {

    }

    @DisplayName("다리 떨어지면 다시 진행 여부 묻는 테스트")
    @Test
    void askRetryTest() {

    }

    @DisplayName("재시작 선택 시 게임 재시작 테스트")
    @Test
    void decideRetryOrQuitTest() {

    }

    @DisplayName("다리 건너기 성공하면 게임 종료 테스트")
    @Test
    void playGameSuccessTest() {

    }

    @DisplayName("전체 게임 통합 테스트")
    @Test
    void playGameTest() {

    }
}
