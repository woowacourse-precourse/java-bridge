package bridge;

import bridge.domain.BridgeGame;
import bridge.domain.User;
import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class DomainTest {
    @DisplayName("BridgeGame의 매개변수 List에 값이 잘 들어가는지 확인")
    @Test
    public void BridgeTest() {
        List<String> list= List.of("U", "U", "D");
        BridgeGame bridgeGame = new BridgeGame(list);

        assertThat(bridgeGame.getBridge()).isEqualTo(list);
    }

    @DisplayName("BridgeGame에 매개변수 position이 증가하는지 확인")
    @Test
    public void MoveTest() {
        List<String> list= new ArrayList<>();
        BridgeGame bridgeGame = new BridgeGame(list);
        int count=3;

        for(int i=0; i<3; i++) {
            bridgeGame.move();
        }

        assertThat(bridgeGame.getPosition()).isEqualTo(count);
    }

    @DisplayName("User의 playingCount의 초기값과 증가하는지 확인")
    @Test
    public void PlayingCountTest() {
        User user = new User();
        assertThat(user.getPlayingCount()).isEqualTo(1);
        user.addPlayingCount();
        assertThat(user.getPlayingCount()).isEqualTo(2);
    }

    @DisplayName("User의 quit의 초기값과 변환되는지 확인")
    @Test
    public void QuitTest() {
        User user = new User();
        assertThat(user.getQuit()).isEqualTo(false);
        user.setQuit();
        assertThat(user.getQuit()).isEqualTo(true);
    }
}
