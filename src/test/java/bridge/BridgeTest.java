package bridge;

import static bridge.domain.BridgeMoveJudgment.*;
import static org.assertj.core.api.Assertions.*;
import static org.assertj.core.util.Lists.newArrayList;

import bridge.domain.BridgeGame;
import bridge.domain.BridgeMoveJudgment;
import bridge.ui.ValidateInput;
import bridge.ui.ValidateInputBridgeGame;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.BitSet;
import java.util.List;

public class BridgeTest {

    @Test
    @DisplayName("다리 건널 때마다 'O' 또는 'X' 결과 확인")
    void 다리_건너기_테스트() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move(List.of("U", "D", "D"), "U");
        bridgeGame.move(List.of("U", "D", "D"), "D");
        List<BridgeMoveJudgment> moveResult = bridgeGame.move(List.of("U", "D", "D"), "U");

        assertThat(moveResult).isEqualTo(List.of(CORRECT, EMPTY, EMPTY, CORRECT, WRONG, EMPTY));
    }

    @Test
    @DisplayName("게임 재시도 할시 이동 결과 초기화")
    void 다리_게임_재시도_테스트() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move(List.of("U", "D", "D"), "U");
        bridgeGame.move(List.of("U", "D", "D"), "D");
        List<BridgeMoveJudgment> moveResult = bridgeGame.retry("R");

        assertThat(moveResult).isEqualTo(List.of());
    }

    @Test
    @DisplayName("게임 종료 시 이동 결과 확인")
    void 다리_게임_종료_이동_결과_확인_테스트() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move(List.of("U", "D", "D"), "U");
        List<BridgeMoveJudgment> moveResult = bridgeGame.move(List.of("U", "D", "D"), "U");
        List<BridgeMoveJudgment> quit = bridgeGame.retry("Q");
        assertThat(moveResult).isEqualTo(List.of(CORRECT, EMPTY, WRONG, EMPTY));
    }

    @Test
    @DisplayName("게임 건널 때마다 성공 여부 확인")
    void 다리_게임_움직일때마다_성공_여부_테스트() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move(List.of("U", "D", "D"), "U");
        bridgeGame.move(List.of("U", "D", "D"), "U");
        boolean failGame = bridgeGame.isFailGame();

        assertThat(failGame).isTrue();
    }

    @Test
    @DisplayName("다리 게임 최종 결과 성공")
    void 다리_게임_최종_결과_성공_테스트() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move(bridge, "U");
        bridgeGame.move(bridge, "D");
        bridgeGame.move(bridge, "D");
        boolean failGame = bridgeGame.isFailFinalGame(bridge);

        assertThat(failGame).isFalse();
    }

    @Test
    @DisplayName("다리 게임 최종 결과 실패")
    void 다리_게임_최종_결과_실패_테스트() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(1, 0, 0));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move(bridge, "U");
        bridgeGame.move(bridge, "U");
        bridgeGame.move(bridge, "U");
        boolean failGame = bridgeGame.isFailFinalGame(bridge);

        assertThat(failGame).isTrue();
    }

    @Test
    @DisplayName("게임 재시도 횟수 확인")
    void 다리_게임_재시도_횟수_테스트() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.retry("R");
        bridgeGame.retry("R");
        int retryCount = bridgeGame.checkRetryCount();

        assertThat(retryCount).isEqualTo(3);
    }

    @DisplayName("다리 길이 문자 입력 시 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"aaa", "123a", "!!!"})
    void 다리_길이_문자입력시_예외처리_테스트(String number) {
        ValidateInput validateInput = new ValidateInputBridgeGame();
        assertThatThrownBy(() -> validateInput.validateNumber(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이 십의 자리 초과 입력 시 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"123", "10000", "100000000000000"})
    void 다리_길이_십의자리초과_입력시_예외처리_테스트(String number) {
        ValidateInput validateInput = new ValidateInputBridgeGame();
        assertThatThrownBy(() -> validateInput.validateBridgeSizeLength(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("다리 길이 3미만 20초과 입력 시 예외 처리")
    @ParameterizedTest
    @ValueSource(ints = {-1, 0, 1, 2, 21, 123123123})
    void 다리_길이_정해진_범위_초과_입력시_예외처리_테스트(int number) {
        ValidateInput validateInput = new ValidateInputBridgeGame();
        assertThatThrownBy(() -> validateInput.validateBridgeSizeRange(number))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("문자 하나만 입력 안할 시 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"", "AS", "exception"})
    void 문자_하나가_아닐시_예외처리_테스트(String word) {
        ValidateInput validateInput = new ValidateInputBridgeGame();
        assertThatThrownBy(() -> validateInput.validateWordLength(word))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("'U' 또는 'D' 중에 하나를 선택 안할 시 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "R", "Q", "exception"})
    void 문자_선택_U와_D중_예외처리_테스트(String word) {
        ValidateInput validateInput = new ValidateInputBridgeGame();
        assertThatThrownBy(() -> validateInput.validateMovingSpaceWord(word))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("'R' 또는 'Q' 중에 하나를 선택 안할 시 예외 처리")
    @ParameterizedTest
    @ValueSource(strings = {"", " ", "U", "D", "exception"})
    void 문자_선택_R과_Q중_예외처리_테스트(String word) {
        ValidateInput validateInput = new ValidateInputBridgeGame();
        assertThatThrownBy(() -> validateInput.validateGameCommandWord(word))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
