package bridge.domain;

import bridge.constant.ViewStatus;
import bridge.dto.GameResult;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class BridgeGameTest {
    private BridgeGame bridgeGame;
    private List<String> arr = new ArrayList<>(List.of("U", "D", "U"));

    @BeforeEach
    void setup() {
        bridgeGame = BridgeGame.from(Bridge.from(arr));
    }

    @DisplayName("잘못된 move 명령어를 입력하면 오류를 반환한다.")
    @ValueSource(strings = {"A", "s", "t"})
    @ParameterizedTest
    void throwErrorWhenInputInvalidMoveCommand(String command) {
        assertThatThrownBy(() -> bridgeGame.move(command))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("올바른 move 명령어를 입력한다.")
    @CsvSource(value = {"U,true","D,false"})
    @ParameterizedTest
    void returnResultWhenInputValidMoveCommand(String command, boolean result) {
        Assertions.assertThat(bridgeGame.move(command)).isEqualTo(result);
    }

    @DisplayName("정답을 맞춘 경우 그에 맞는 결과를 반환한다.")
    @Test
    void returnGameResultWhenGiveCorrectMoveCommand() {
        GameResult result = bridgeGame.resultOfMove(true);
        assertThat(result.getNextViewStatus()).isEqualTo(ViewStatus.DETERMINE_MOVE);
    }

    @DisplayName("정답을 맞추지 못한 경우 그에 맞는 결과를 반환한다.")
    @Test
    void returnGameResultWhenGiveWrongMoveCommand() {
        GameResult result = bridgeGame.resultOfMove(false);

        assertThat(result.getNextViewStatus()).isEqualTo(ViewStatus.DETERMINE_CONTINUE);
    }

    @DisplayName("모든 정답을 맞춘 경우 그에 맞는 결과를 반환한다.")
    @Test
    void returnWinStatusWhenGiveCorrectMoveCommand() {
        GameResult result = moveUntilWin(bridgeGame);

        List<String> partialBridge = result.getResult();

        assertThat(result.getNextViewStatus()).isEqualTo(ViewStatus.WIN);
        assertThat(partialBridge.size()).isEqualTo(3);
    }

    private GameResult moveUntilWin(BridgeGame bridgeGame) {
        boolean isMatch = true;
        for (String position : arr) {
            isMatch = bridgeGame.move(position);
        }
        return bridgeGame.resultOfMove(isMatch);
    }
}