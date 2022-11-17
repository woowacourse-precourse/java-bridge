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
    private final MoveResults moveResults = new MoveResults();
    private BridgeGame bridgeGame;

    @BeforeEach
    void init() {
        player = new Player(INIT_VALUE_OF_POSITION, INIT_VALUE_OF_CHALLENGES);
        bridgeGame = new BridgeGame(bridge, player, moveResults);
    }

    @DisplayName("U를 입력 받으면 O를 반환한다.")
    @Test
    void moveTestTrue() {
        String sign = bridgeGame.matchResult("U");
        assertThat(sign).isEqualTo("O");
    }

    @DisplayName("D를 입력 받으면 X를 반환한다.")
    @Test
    void moveTestFalse() {
        String sign = bridgeGame.matchResult("D");
        assertThat(sign).isEqualTo("X");
    }

//    @DisplayName("move() 메서드를 호출하면 Player의 position이 1 증가한다.")
//    @Test
//    void increasePosition() {
//        bridgeGame.move();
//        int position = player.position();
//        assertThat(position).isEqualTo(1);
//    }

    @ParameterizedTest(name = "{0}회 retry하면 Player의 총 시도 횟수가 {1}회가 된다.")
    @CsvSource({"1,2", "5,6", "10,11"})
    void increaseNumberOfChallenges(int tryNum, int result) {
        for (int i = 0; i < tryNum; i++) {
            bridgeGame.retry();
        }
        assertThat(player.totalNumberOfChallenges()).isEqualTo(result);
    }

//    @DisplayName("retry하면 Player의 position이 초기화 된다.")
//    @Test
//    void initPosition() {
//        player.move();
//        player.move();
//        bridgeGame.retry();
//        assertThat(player.position()).isEqualTo(INIT_VALUE_OF_POSITION);
//    }
}