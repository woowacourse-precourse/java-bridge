package bridge;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameControllerTest {

    @DisplayName("컨트롤러에서 다리 길이를 입력받아 List<String> bridge 를 리턴한다.")
    @Test
    public void makeBridge() {
        //given
        BridgeGameController controller = new BridgeGameController();
        String input = "3";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        //when
        List<String> bridge = controller.makeBridge();

        //then
        Assertions.assertThat(bridge.size()).isEqualTo(3);
        Assertions.assertThat(bridge.contains("U") || bridge.contains("D")).isEqualTo(true);
    }

    @Test
    public void play() {
        //given
        BridgeGameController controller = new BridgeGameController();
        List<String> bridge = List.of("U", "U", "U", "U");

        //when
        controller.playGame(bridge);


        //then
    }
}