package bridge.domainTest;
import bridge.model.Bridge;
import bridge.model.Player;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

public class PlayerTest {

    Player player;

    @BeforeEach
    void initializeClass(){
        player = new Player();
    }

    @DisplayName("새로 입력을 넣었을 때 리스트에 추가된다. ")
    @Test
    void addNewBridgeInputTest(){
        player.addNewBridgeInput("U");
        assertThat(player.getBridges()).isEqualTo(List.of("U"));
    }

    @DisplayName("플레이어의 리스트와 다리가 가진 리스트가 같으면 참을 반환")
    @Test
    void isGameFinishedTest(){
        player.addNewBridgeInput("U");
        player.addNewBridgeInput("D");
        player.addNewBridgeInput("U");
        assertThat(player.isGameFinished(new Bridge(List.of("U", "D", "U")))).isTrue();
    }
}
