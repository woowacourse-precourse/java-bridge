package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.constants.GameResult;
import bridge.domain.model.GameResultInformation;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class GameResultInformationTest {

    @DisplayName("게임 성공 여부를 설정하고, 반환받을 수 있다.")
    @Test
    void setAndGetGameResultTest() {
        GameResultInformation.setGameResult(GameResult.SUCCESS);

        assertThat(GameResultInformation.getGameResult()).isEqualTo(GameResult.SUCCESS);
    }

    @DisplayName("시도한 횟수를 증가시키고, 반환받을 수 있다.")
    @Test
    void increaseAndGetCountOfTry() {
        int expected = 3;

        GameResultInformation.increaseCountOfTry();
        GameResultInformation.increaseCountOfTry();

        assertThat(GameResultInformation.getCountOfTry()).isEqualTo(expected);
    }
}
