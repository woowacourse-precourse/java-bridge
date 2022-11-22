package bridge.service;

import bridge.BridgeMaker;
import org.junit.jupiter.api.Test;
import org.mockito.MockedConstruction;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.*;

public class BridgeGameTest {

    @Test
    void getMap_메서드_테스트() {
        List<String> bridge = List.of("U", "D", "U");
        try (MockedConstruction<BridgeMaker> m = mockConstruction(BridgeMaker.class, (mock, context) -> {
            when(mock.makeBridge(any(Integer.class))).thenReturn(bridge);
        })) {
            BridgeGame bridgeGame = new BridgeGame(3);

            bridgeGame.move("U");
            bridgeGame.move("D");
            bridgeGame.move("D");
            List<List<String>> EXPECTED_RESULT = List.of(List.of("O", " ", " "), List.of(" ", "O", "X"));
            assertThat(bridgeGame.getMaps()).isEqualTo(EXPECTED_RESULT);
        }
    }

    @Test
    void retry_메서드_테스트() {
        List<String> bridge = List.of("U", "D", "U");
        try (MockedConstruction<BridgeMaker> m = mockConstruction(BridgeMaker.class, (mock, context) -> {
            when(mock.makeBridge(any(Integer.class))).thenReturn(bridge);
        })) {
            BridgeGame bridgeGame = new BridgeGame(3);


            bridgeGame.move("U");
            bridgeGame.move("D");
            bridgeGame.move("D");
            bridgeGame.retry();
            List<List<String>> EXPECTED_RESULT = List.of(List.of(), List.of());
            assertThat(bridgeGame.getMaps()).isEqualTo(EXPECTED_RESULT);
        }
    }
    @Test
    void getAttemptCount_메서드_시도_횟수_테스트() {
        List<String> bridge = List.of("U", "D", "U");
        try (MockedConstruction<BridgeMaker> m = mockConstruction(BridgeMaker.class, (mock, context) -> {
            when(mock.makeBridge(any(Integer.class))).thenReturn(bridge);
        })) {
            BridgeGame bridgeGame = new BridgeGame(3);

            bridgeGame.retry();
            bridgeGame.retry();
            bridgeGame.retry();

            int EXPECTED_RESULT = 4;
            assertThat(bridgeGame.getAttemptCount()).isEqualTo(EXPECTED_RESULT);
        }
    }
    @Test
    void isValidLastStep_메서드_마지막_이동이_실패할_경우_false_리턴() {
        List<String> bridge = List.of("U", "D", "U");
        try (MockedConstruction<BridgeMaker> m = mockConstruction(BridgeMaker.class, (mock, context) -> {
            when(mock.makeBridge(any(Integer.class))).thenReturn(bridge);
        })) {
            BridgeGame bridgeGame = new BridgeGame(3);
            String FINAL_STEP = "D";

            bridgeGame.move("U");
            bridgeGame.move("D");
            bridgeGame.move(FINAL_STEP);
            Boolean EXPECTED_RESULT = false;
            assertThat(bridgeGame.isValidLastStep(FINAL_STEP)).isEqualTo(EXPECTED_RESULT);
        }
    }

    @Test
    void isValidLastStep_메서드_마지막_이동이_성공할_경우_true_리턴() {
        List<String> bridge = List.of("U", "D", "U");
        try (MockedConstruction<BridgeMaker> m = mockConstruction(BridgeMaker.class, (mock, context) -> {
            when(mock.makeBridge(any(Integer.class))).thenReturn(bridge);
        })) {
            BridgeGame bridgeGame = new BridgeGame(3);
            String FINAL_STEP = "D";

            bridgeGame.move("U");
            bridgeGame.move(FINAL_STEP);

            Boolean EXPECTED_RESULT = true;
            assertThat(bridgeGame.isValidLastStep(FINAL_STEP)).isEqualTo(EXPECTED_RESULT);
        }
    }

    @Test
    void isGameSuccess_메서드_게임_결과_성공_테스트() {
        List<String> bridge = List.of("U", "D", "U", "U", "D");
        try (MockedConstruction<BridgeMaker> m = mockConstruction(BridgeMaker.class, (mock, context) -> {
            when(mock.makeBridge(any(Integer.class))).thenReturn(bridge);
        })) {
            BridgeGame bridgeGame = new BridgeGame(3);

            bridgeGame.move("U");
            bridgeGame.move("D");
            bridgeGame.move("U");
            bridgeGame.move("U");
            bridgeGame.move("D");

            Boolean EXPECTED_RESULT = true;
            assertThat(bridgeGame.getSuccessStatus()).isEqualTo(EXPECTED_RESULT);
        }
    }

    @Test
    void isGameSuccess_메서드_게임_결과_실패_테스트() {
        List<String> bridge = List.of("U", "D", "U", "U", "D");
        try (MockedConstruction<BridgeMaker> m = mockConstruction(BridgeMaker.class, (mock, context) -> {
            when(mock.makeBridge(any(Integer.class))).thenReturn(bridge);
        })) {
            BridgeGame bridgeGame = new BridgeGame(5);

            bridgeGame.move("U");
            bridgeGame.move("D");
            bridgeGame.move("U");
            bridgeGame.move("U");
            bridgeGame.move("U");

            Boolean EXPECTED_RESULT = false;
            assertThat(bridgeGame.getSuccessStatus()).isEqualTo(EXPECTED_RESULT);
        }
    }
}
