package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeGameTest {

    private Round round = new Round();
    private GameAttempt gameAttempt = new GameAttempt();
    private BridgeState bridgeState = new BridgeState(round);
    private BridgeGame bridgeGame = new BridgeGame(round, gameAttempt, bridgeState);

    @DisplayName("마지막 라운드에 맞은 경우 성공을 그 전에 혹은 마지막에 틀린 경우에는 실패를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"D:성공", "U:실패"}, delimiter = ':')
    void createSuccessORFail(String userInput, String output) {
        // given
        List<String> bridge = new ArrayList<>(List.of("U", "U", "D"));
        for (int play = 1; play <= 3; play++) {
            round.plusRound();
        }
        // when
        String result = bridgeGame.checkGameSuccess(userInput, bridge);

        // then
        assertThat(result).isEqualTo(output);
    }

    @DisplayName("사용자의 이동입력이 다리와 같고 라운드가 다리이 길이보다 작으면 true를 아니면 false를 반환한다.")
    @ParameterizedTest
    @CsvSource(value = {"D : true", "U : false"}, delimiter = ':')
    void discriminateNextRound(String userInput, boolean output) {
        // given
        List<String> bridge = new ArrayList<>(List.of("D", "U", "U"));
        round.plusRound();

        // when
        boolean result = bridgeGame.checkPlayNextRound(userInput, bridge);

        // then
        assertThat(result).isEqualTo(output);
    }
}