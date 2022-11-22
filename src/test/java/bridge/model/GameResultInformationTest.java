package bridge.model;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.constants.GameResult;
import bridge.domain.model.GameResultInformation;
import java.lang.reflect.Field;
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
    void increaseAndGetCountOfTry() throws NoSuchFieldException, IllegalAccessException {
        resetCountOfTry();
        int expected = 3;

        GameResultInformation.increaseCountOfTry();
        GameResultInformation.increaseCountOfTry();

        assertThat(GameResultInformation.getCountOfTry()).isEqualTo(expected);
    }

    void resetCountOfTry() throws NoSuchFieldException, IllegalAccessException {
        GameResultInformation gameResultInformation = new GameResultInformation();
        Field countOfTry = GameResultInformation.class.getDeclaredField("countOfTry");

        countOfTry.setAccessible(true);
        countOfTry.set(gameResultInformation, 1);
        countOfTry.setAccessible(false);
    }
}
