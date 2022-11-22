package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayName("GamePlayCount 클래스")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class GamePlayCountTest {

    @Test
    void firstGame_메서드는_1의_count_값을_가지고_있는_인스턴스를_반환한다() {
        GamePlayCount gamePlayCount = GamePlayCount.firstGame();

        assertThat(gamePlayCount.getCount()).isEqualTo(1);
    }

    @Test
    void nextGame_메서드는_count_값을_1_늘린다() {
        GamePlayCount gamePlayCount = GamePlayCount.firstGame();
        gamePlayCount.nextGame();

        assertThat(gamePlayCount.getCount()).isEqualTo(2);
    }

    @Test
    void getCount_메서드는_count_값을_반환한다() {
        GamePlayCount gamePlayCount = GamePlayCount.firstGame();

        assertThat(gamePlayCount.getCount()).isEqualTo(1);
    }
}
