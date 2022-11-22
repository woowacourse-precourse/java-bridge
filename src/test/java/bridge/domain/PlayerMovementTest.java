package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class PlayerMovementTest {
    private PlayerMovement playerMovement;
    private List<String> playerMoves;

    @BeforeEach
    void initTest() {
        playerMovement = new PlayerMovement();

        playerMoves = new ArrayList<>() {{
            add("U");
            add("D");
            add("D");
            add("U");
        }};
        playerMoves.forEach(move -> playerMovement.addMovement(move));
    }

    @DisplayName("playerMovement 값 가져오기")
    @Test
    void getMovementTest() {
        assertThat(playerMovement.getMovement()).isEqualTo(playerMoves);
    }

    @DisplayName("getMovement 크기 가져오기")
    @Test
    void getMovementCountTest() {
        assertThat(playerMovement.getMovementCount()).isEqualTo(playerMoves.size());
    }

    @DisplayName("addMovement 테스트 - 정상 데이터 추가")
    @ValueSource(strings = {"U", "D"})
    @ParameterizedTest
    void addNormalMovementTest(String playerMove) {
        playerMovement.addMovement(playerMove);
        playerMoves.add(playerMove);
        assertThat(playerMovement.getMovement()).isEqualTo(playerMoves);
    }

    @DisplayName("addMovement 테스트 - 에외 발생 데이터 추가")
    @ValueSource(strings = {"", " ", ".", "E", "u", "d", "2"})
    @ParameterizedTest
    void addExceptionMovementTest(String playerMove) {
        assertThatThrownBy(() -> playerMovement.addMovement(playerMove))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
