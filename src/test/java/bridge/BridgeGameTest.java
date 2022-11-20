package bridge;

import bridge.constant.Constant;
import bridge.domain.Bridge;
import bridge.domain.Command;
import bridge.domain.Moving;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {
    private BridgeGame bridgeGame;
    @BeforeEach
    void initialize() {
        bridgeGame = new BridgeGame(new Bridge(List.of("U", "D", "D")));
    }

    @DisplayName("canMove 메서드는 움직일 수 있다면 true를, 없다면 false를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"U:true", "D:false"}, delimiter = ':')
    void canMove(String input, boolean expected) {
        bridgeGame.move(new Moving(input));
        Assertions.assertThat(bridgeGame.canMove()).isEqualTo(expected);
    }

    @DisplayName("사용자가 모두 정답을 입력하면 게임은 성공으로 종료된다.")
    @Test
    void isSuccessFinish() {
        bridgeGame.move(new Moving("U"));
        bridgeGame.move(new Moving("D"));
        bridgeGame.move(new Moving("D"));
        Assertions.assertThat(bridgeGame.isSuccess()).isEqualTo(Constant.SUCCESS);
    }

    @DisplayName("사용자가 연속하여 정답을 입력했지만, 마지막 움직임이 실패하면 실패한다.")
    @Test
    void isSFailureFinish() {
        bridgeGame.move(new Moving("U"));
        bridgeGame.move(new Moving("D"));
        bridgeGame.move(new Moving("U"));
        Assertions.assertThat(bridgeGame.isSuccess()).isEqualTo(Constant.FAILURE);
    }

    @DisplayName("명령어 R 입력 시 재시작하여 시도 횟수가 1증가하고, 이동 지도가 초기화 된다.")
    @Test
    void retryTest() {
        bridgeGame.move(new Moving("U"));
        bridgeGame.move(new Moving("D"));
        bridgeGame.retry(new Command("R"));
        Assertions.assertThat(bridgeGame.getTryCount()).isEqualTo(2);
        Assertions.assertThat(bridgeGame.getMap()).isEqualTo(List.of(Collections.emptyList(),Collections.emptyList()));
    }

    @DisplayName("명령어 Q입력 시 retry 메서드는 false를 반환한다.")
    @Test
    void retryQuitTest() {
        bridgeGame.move(new Moving("U"));
        bridgeGame.move(new Moving("D"));
        boolean result = bridgeGame.retry(new Command("Q"));
        Assertions.assertThat(result).isFalse();
    }
}