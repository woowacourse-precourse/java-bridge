package bridge;

import bridge.controller.BridgeController;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class BridgeControllerTest {
    List<String> bridge = new ArrayList<>();

    BridgeController bridgeController = new BridgeController();

    @BeforeEach
    void setBridge() {
        bridge.add("D");
        bridge.add("D");
        bridge.add("D");
    }

    @Test
    void 실패_후_재시작_테스트() {
        String reply = "R";
        InputStream input = new ByteArrayInputStream(reply.getBytes());
        System.setIn(input);
        String result = bridgeController.replyQuit("실패");
        assertThat(result).isEqualTo("R");
    }

    @Test
    void 실패_후_종료_테스트() {
        String reply = "Q";
        InputStream input = new ByteArrayInputStream(reply.getBytes());
        System.setIn(input);
        String result = bridgeController.replyQuit("실패");
        assertThat(result).isEqualTo("Q");
    }

    @Test
    void 다리건너기_성공_출력_테스트(){
        List<List<String>> bridges = new ArrayList<>();
        List<String> bridgeUp = List.of(" "," "," ");
        List<String> bridgeDown = List.of("0","O","O");

        bridges.add(bridgeUp);
        bridges.add(bridgeDown);

        String result = bridgeController.endGame(bridges);

        assertThat(result).isEqualTo("성공");
    }

    @Test
    void 다리건너기_실패_출력_테스트(){
        List<List<String>> bridges = new ArrayList<>();
        List<String> bridgeUp = List.of(" ","X"," ");
        List<String> bridgeDown = List.of("0"," ","O");

        bridges.add(bridgeUp);
        bridges.add(bridgeDown);

        String result = bridgeController.endGame(bridges);

        assertThat(result).isEqualTo("실패");
    }

    @Test
    void 다리건너기_실패_테스트(){
        String input ="U" +"\n" + "D" + "\n" + "D";
        InputStream i = new ByteArrayInputStream(input.getBytes());

        System.setIn(i);
        String result = bridgeController.crossBridge(bridge);
        assertThat(result).isEqualTo("실패");
    }

    @Test
    void 다리건너기_성공_테스트(){
        String input ="D" +"\n" + "D" + "\n" + "D";
        InputStream i = new ByteArrayInputStream(input.getBytes());

        System.setIn(i);
        String result = bridgeController.crossBridge(bridge);
        assertThat(result).isEqualTo("성공");
    }

    @Test
    void 다리건너기_재시작_테스트(){
        String input = "D" + "\n" + "D" +"\n" + "U"+ "\n" + "R" + "\n" + "D" +"\n" + "D" +"\n" +"D";
        InputStream i = new ByteArrayInputStream(input.getBytes());

        System.setIn(i);
        String result = bridgeController.play(bridge);
        assertThat("Q").isEqualTo(result);
    }
}
