package bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.controller.Controller;
import bridge.domain.BridgeGame;
import bridge.domain.User;
import java.util.List;
import org.junit.jupiter.api.Test;

public class ControllerTest {
    @Test
    void GoRetry_메소드에_R을_넣으면_True가_나오는지_테스트() {
        Controller controller = new Controller();
        String string="R";
        assertThat(controller.GoRetry(string)).isEqualTo(true);
    }

    @Test
    void RetryOrQuit에서_Retry() {
        String retryInput = "R";
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "U"));
        User user = new User();

        Controller controller = new Controller();
        controller.RetryOrQuit(retryInput, bridgeGame, user);

        assertThat(bridgeGame.getPosition()).isEqualTo(0);
        assertThat(user.getPlayingCount()).isEqualTo(2);
    }

    @Test
    void RetryOrQuit에서_Quit(){
        String retryInput = "Q";
        BridgeGame bridgeGame = new BridgeGame(List.of("U", "D", "U"));
        User user = new User();

        Controller controller = new Controller();
        controller.RetryOrQuit(retryInput, bridgeGame, user);

       assertThat(user.getQuit()).isEqualTo(true);
    }


}
