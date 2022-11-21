package bridge.domain.game;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class GameProgressTest {

    GameProgress gameProgress;

    @BeforeEach
    void init() {
        gameProgress = new GameProgress();
    }

    @Test
    void getPosition_현재_위치를_가져온다1() {
        //when
        int position = gameProgress.getPosition();

        //then
        assertThat(position).isEqualTo(0);
    }

    @Test
    void getPosition_현재_위치를_가져온다2() {
        //given
        gameProgress.add("U", true);
        gameProgress.add("U", true);

        //when
        int position = gameProgress.getPosition();

        //then
        assertThat(position).isEqualTo(2);
    }

    @Test
    void clear_진행_상황을_초기화_시킨다() {
        //given
        gameProgress.add("U", true);
        gameProgress.add("U", true);
        gameProgress.add("U", true);

        //when
        gameProgress.clear();

        //then
        assertThat(gameProgress.getPosition()).isEqualTo(0);
    }
}