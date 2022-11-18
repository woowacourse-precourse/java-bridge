package bridge;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    @DisplayName("건널 수 없는 칸을 선택하면 IMMOVABLE 메세지를 응답한다.")
    @Test
    void moveThenReturnImmovable() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U"));

        String responseMessage = bridgeGame.move("D");

        Assertions.assertThat(responseMessage).isEqualTo(BridgeGame.IMMOVABLE);
    }

    @DisplayName("건널 수 있는 칸을 선택하면 SUCCESS 메세지를 응답한다.")
    @Test
    void moveThenReturnSuccess() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D"));

        String responseMessage = bridgeGame.move("U");

        Assertions.assertThat(responseMessage).isEqualTo(BridgeGame.SUCCESS);
    }

    @DisplayName("다리를 다 건너면 FINISHED 메세지를 응답한다.")
    @Test
    void moveThenReturnFinished() {
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D"));

        bridgeGame.move("U");
        String responseMessage = bridgeGame.move("D");

        Assertions.assertThat(responseMessage).isEqualTo(BridgeGame.FINISH);
    }
}
