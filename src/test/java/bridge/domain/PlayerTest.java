package bridge.domain;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class PlayerTest {

    private Player player;

    @BeforeEach
    void init() {
        player = new Player();
    }

    @DisplayName("player의 시도 횟수는 처음에 1로 설정되어 있다.")
    @Test
    void getTryCountTest() {
        int result = player.getTryCount();
        assertThat(result).isEqualTo(1);
    }

    @DisplayName("getter로 찾은 moveHistory를 변경하면 예외가 발생한다.")
    @Test
    void getMoveHistoryTest() {
        List<String> moveHistory = player.getMoveHistory();
        assertThatThrownBy(() -> moveHistory.add("U"))
                .isInstanceOf(UnsupportedOperationException.class);
    }

    @DisplayName("player가 이동하면 moveHistory에 기록이 남는다.")
    @Test
    void moveTest() {
        //given
        String[] directions = {"U","D","U","D","U"};
        //when
        for (String direction : directions) {
            player.move(direction);
        }
        //then
        List<String> moveHistory = player.getMoveHistory();
        assertThat(moveHistory.size()).isEqualTo(directions.length);
        assertThat(moveHistory).containsExactly("U","D","U","D","U");
    }

    @DisplayName("player가 재시도 할 때 시도 횟수는 1 증가하고 moveHistory는 지워진다.")
    @Test
    void initForRetryTest() {
        //given
        String[] directions = {"U","D","U","D","U"};
        //when
        for (String direction : directions) {
            player.move(direction);
        }
        int tryCount = player.getTryCount();
        player.initForRetry();
        //then
        assertThat(player.getTryCount()).isEqualTo(tryCount+1);
        assertThat(player.getMoveHistory().size()).isEqualTo(0);
    }
}
