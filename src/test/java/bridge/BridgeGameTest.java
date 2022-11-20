package bridge;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    @Test
    public void makeBridge() {
        //given
        BridgeGame bridgeGame = new BridgeGame();
        int bridgeSize = 20;

        //when
        List<String> bridge = bridgeGame.makeBridge(bridgeSize);

        //then
        Assertions.assertThat(bridge.size()).isEqualTo(bridgeSize);
        Assertions.assertThat(bridge.contains("A")).isEqualTo(false);
        Assertions.assertThat(bridge.contains("1")).isEqualTo(false);
        Assertions.assertThat(bridge.contains("U")).isEqualTo(true);
        Assertions.assertThat(bridge.contains("D")).isEqualTo(true);
    }

    @RepeatedTest(10)
    public void move() {
        //given
        BridgeGame bridgeGame = new BridgeGame();
        List<String> bridge = bridgeGame.makeBridge(3);
        int level = 0;
        String result = "";

        //when
        if (bridge.get(0).equals("U")) {
            result = bridgeGame.move(bridge, "U", level);
        }

        if (bridge.get(0).equals("D")) {
            result = bridgeGame.move(bridge, "D", level);
        }

        //then
        Assertions.assertThat(result.contains("O")).isEqualTo(true);
    }

    @RepeatedTest(10)
    public void move2() {
        //given
        BridgeGame bridgeGame = new BridgeGame();
        List<String> bridge = bridgeGame.makeBridge(3);
        int level = 0;
        String result = "";

        //when
        if (bridge.get(0).equals("U")) {
            result = bridgeGame.move(bridge, "D", level);
        }

        if (bridge.get(0).equals("D")) {
            result = bridgeGame.move(bridge, "U", level);
        }

        //then
        Assertions.assertThat(result.contains("O")).isEqualTo(false);
    }

    @Test
    public void isSuccessOK() {
        //given
        BridgeGame bridgeGame = new BridgeGame();
        List<String> bridge = bridgeGame.makeBridge(10);
        int level = bridge.size();

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));

        //when
        bridgeGame.isSuccess(bridge,level);

        //then
        Assertions.assertThat(byteArrayOutputStream.toString().trim()).isEqualTo(GameMessage.GAME_SUC_MESSAGE.getMessage());
    }

    @Test
    public void isSuccessFail() {
        //given
        BridgeGame bridgeGame = new BridgeGame();
        List<String> bridge = bridgeGame.makeBridge(10);
        int level = bridge.size()-1;

        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(byteArrayOutputStream));

        //when
        bridgeGame.isSuccess(bridge,level);

        //then
        Assertions.assertThat(byteArrayOutputStream.toString().trim()).isEqualTo(GameMessage.GAME_FAIL_MESSAGE.getMessage());
    }
}