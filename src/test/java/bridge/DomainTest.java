package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DomainTest {

    private InputView inputView = null;
    private BridgeGame bridgeGame = null;

    ArrayList<String> bridgeSet() {
        ArrayList<String> bridge = new ArrayList<>();
        bridge.add("U");
        bridge.add("U");
        bridge.add("D");
        return bridge;
    }

    @BeforeEach
    void setUp() {
        inputView = new InputView();
        bridgeGame = new BridgeGame(bridgeSet());
    }

    @DisplayName("다리 길이 3 테스트")
    @Test
    void length3Test() {
        String testData = "3";
        InputStream in = new ByteArrayInputStream(testData.getBytes());
        System.setIn(in);
        assertThat(inputView.readBridgeSize()).isEqualTo(3);
    }

    @DisplayName("다리 길이 잘못된 값 입력 한글")
    @Test
    void lengthWrongChar() {
        assertThat(inputView.checkMessage("안녕", ErrorMessage.BRIDGELENGTHERROREXCEPTION)).contains("[ERROR]");
    }

    @DisplayName("다리 길이 잘못된 값 입력 숫자")
    @Test
    void lengthWrongNumber() {
        assertThat(inputView.checkMessage("2", ErrorMessage.BRIDGELENGTHERROREXCEPTION)).contains("[ERROR]");
    }


    @Test
    void bridge_generate() {
        BridgeNumberGenerator numberGenerator = new ApplicationTest.TestNumberGenerator(newArrayList(0, 1, 1));
        BridgeMaker bridgeMaker = new BridgeMaker(numberGenerator);
        List<String> bridge = bridgeMaker.makeBridge(3);
        assertThat(bridge).containsExactly("D", "U", "U");
    }

    @DisplayName("위아래 입력")
    @Test
    void inputUpValue() {
        assertThat(inputView.checkMessage("U", ErrorMessage.WRONGMOVEINPUTEXCEPTION)).contains("PASS");
        assertThat(inputView.checkMessage("D", ErrorMessage.WRONGMOVEINPUTEXCEPTION)).contains("PASS");
        assertThat(inputView.checkMessage("dkfjsdkf", ErrorMessage.WRONGMOVEINPUTEXCEPTION)).contains("ERROR");
    }

    @DisplayName("재시작 종료 입력 받는 것 체크")
    @Test
    void restartOrQuitValue() {
        assertThat(inputView.checkMessage("R", ErrorMessage.WRONGGAMEENDINPUTEXCEPTION)).contains("PASS");
        assertThat(inputView.checkMessage("Q", ErrorMessage.WRONGGAMEENDINPUTEXCEPTION)).contains("PASS");
        assertThat(inputView.checkMessage("dfddf", ErrorMessage.WRONGGAMEENDINPUTEXCEPTION)).contains("ERROR");
    }

    @DisplayName("다리만큼 다왔으면 게임 오버")
    @Test
    void gameOverCheck() {
        bridgeGame.gameOverChecker(3);
        assertThat(bridgeGame.isGameOver()).isTrue();
    }

    @DisplayName("이동 틀렸을 때 체크")
    @Test
    void moveWrong() {
        bridgeGame.move("D");
        assertThat(bridgeGame.isGameOver()).isTrue();
    }

    @DisplayName("이동 맞았을 때 체크")
    @Test
    void moveRight() {
        bridgeGame.move("U");
        assertThat(bridgeGame.isGameOver()).isFalse();
    }

    @DisplayName("게임 오버시 재시작 체크")
    @Test
    void restartCheck() {
        assertThat(bridgeGame.retry("R")).isTrue();
        assertThat(bridgeGame.retry("F")).isFalse();
    }

    @DisplayName("이겼는지 판단")
    @Test
    void winCheck() {
        assertThat(bridgeGame.isWin()).isFalse();
        bridgeGame = new BridgeGame(new ArrayList<>());
        assertThat(bridgeGame.isWin()).isTrue();
    }

}
