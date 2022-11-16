package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class BridgeGameTest {

    private static final int INIT_VALUE_OF_POSITION = 0;
    private static final int INIT_VALUE_OF_CHALLENGES = 1;

    private Player player;
    private final Bridge bridge = new Bridge(List.of("U", "D", "U"));
    private BridgeGame bridgeGame;

    @BeforeEach
    void init() {
        player = new Player(INIT_VALUE_OF_POSITION, INIT_VALUE_OF_CHALLENGES);
        bridgeGame = new BridgeGame(bridge, player);
    }

    @DisplayName("U를 입력 받으면 true를 반환한다.")
    @Test
    void moveTestTrue() {
        String sign = bridgeGame.move("U");
        assertThat(sign).isEqualTo("O");
    }

    @DisplayName("U를 입력 받으면 Player의 position이 1 증가한다.")
    @Test
    void increasePosition() {
        bridgeGame.move("U");
        int position = player.position();
        assertThat(position).isEqualTo(1);
    }

    @DisplayName("U, D를 연속적으로 입력 받으면 Player의 position이 2 증가한다.")
    @Test
    void doubleIncreasePosition() {
        bridgeGame.move("U");
        bridgeGame.move("D");
        int position = player.position();
        assertThat(position).isEqualTo(2);
    }

    @DisplayName("D를 입력 받으면 X를 반환한다.")
    @Test
    void moveTestFalse() {
        String sign = bridgeGame.move("D");
        assertThat(sign).isEqualTo("X");
    }

    @DisplayName("D를 입력 받으면 Player의 position이 아무런 변동이 없다.")
    @Test
    void nonChangedPosition() {
        bridgeGame.move("D");
        int position = player.position();
        assertThat(position).isEqualTo(0);
    }

    @ParameterizedTest(name = "{0}회 retry하면 Player의 총 시도 횟수가 {1}회가 된다.")
    @CsvSource({"1,2", "5,6", "10,11"})
    void increaseNumberOfChallenges(int tryNum, int result) {
        for (int i = 0; i < tryNum; i++) {
            bridgeGame.retry();
        }
        assertThat(player.totalNumberOfChallenges()).isEqualTo(result);
    }

    @DisplayName("retry하면 Player의 position이 초기화 된다.")
    @Test
    void initPosition() {
        player.move();
        player.move();
        bridgeGame.retry();
        assertThat(player.position()).isEqualTo(INIT_VALUE_OF_POSITION);
    }
}