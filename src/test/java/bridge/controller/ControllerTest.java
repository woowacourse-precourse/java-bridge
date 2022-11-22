package bridge.controller;

import camp.nextstep.edu.missionutils.Randoms;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.mockito.MockedStatic;
import org.mockito.Mockito;

public class ControllerTest {

    static MockedStatic<Randoms> randomsMockedStatic;

    @BeforeAll
    static void beforeAll() {
        randomsMockedStatic = Mockito.mockStatic(Randoms.class);
        Mockito.when(Randoms.pickNumberInRange(0,1)).thenReturn(1,0,1);
    }

    @DisplayName("게임 시작 시 출력 테스트")
    @Test
    void startNewGameTest() {

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
