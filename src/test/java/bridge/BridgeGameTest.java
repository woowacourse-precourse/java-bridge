package bridge;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    @DisplayName("int bridgeSize 를 입력받아 U 또는 R 로만 이루어진 List<String> bridge 를 생성한다.")
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

    @DisplayName("유저가 입력한 moving 의 값인 U 또는 D 가 bridge 의 값과 일치하면 O 를 리턴한다.")
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

    @DisplayName("유저가 입력한 moving 의 값인 U 또는 D 가 bridge 의 값과 일치하지 않으면 X  를 리턴한다.")
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

    @DisplayName("생성된 다리 길이와 BridgeGame 의 필드변수 level 이 같으면 게임 성공 메세지를 출력한다.")
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

    @DisplayName("생성된 다리 길이와 BridgeGame 의 필드변수 level 이 다르면 게임 실패 메세지를 출력한다.")
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

    @DisplayName("BridgeGame 의 필드변수 level 이 0이면 BridgeGame 의 필드변수 sb1, sb2 에 START_BRACKET([) 를 추가한다.")
    @Test
    public void isStart() {
        //given
        BridgeGame bridgeGame = new BridgeGame();
        int level = 0;

        //when
        bridgeGame.isStart(level);

        //then
        Assertions.assertThat(bridgeGame.getSb1().toString()).isEqualTo("[");
        Assertions.assertThat(bridgeGame.getSb2().toString()).isEqualTo("[");
    }

    @DisplayName("bridge 의 값이 U 일경우 유저가 입력한 moving 의 값과 같으면 sb1에 IS_CORRECT(O) 를 sb2 에 SPACE 를 추가한다.")
    @Test
    public void isUp1() {
        //given
        BridgeGame bridgeGame = new BridgeGame();
        List<String> bridge = List.of("U", "U", "U");
        int level = 0;
        String moving = "U";

        //when
        bridgeGame.isUp(bridge,moving,level);

        //then
        Assertions.assertThat(bridgeGame.getSb1().toString()).isEqualTo(" O ");
        Assertions.assertThat(bridgeGame.getSb2().toString()).isEqualTo("   ");
    }

    @DisplayName("bridge 의 값이 U 일경우 유저가 입력한 moving 의 값과 다르면 sb1에 IS_NOT_CORRECT(X) 를 sb2 에 SPACE 를 추가한다.")
    @Test
    public void isUp2() {
        //given
        BridgeGame bridgeGame = new BridgeGame();
        List<String> bridge = List.of("U", "U", "U");
        int level = 0;
        String moving = "D";

        //when
        bridgeGame.isUp(bridge,moving,level);

        //then
        Assertions.assertThat(bridgeGame.getSb1().toString()).isEqualTo("   ");
        Assertions.assertThat(bridgeGame.getSb2().toString()).isEqualTo(" X ");
    }

    @DisplayName("bridge 의 값이 D 일경우 유저가 입력한 moving 의 값과 같으면 BridgeGame 의 필드변수 sb1 에 SPACE sb2 에 IS_CORRECT(O) 를 추가한다.")
    @Test
    public void isDown1() {
        //given
        BridgeGame bridgeGame = new BridgeGame();
        List<String> bridge = List.of("D", "D", "U");
        int level = 0;
        String moving = "D";

        //when
        bridgeGame.isDown(bridge,moving,level);

        //then
        Assertions.assertThat(bridgeGame.getSb1().toString()).isEqualTo("   ");
        Assertions.assertThat(bridgeGame.getSb2().toString()).isEqualTo(" O ");
    }

    @DisplayName("bridge 의 값이 D 일경우 유저가 입력한 moving 의 값과 다르면 BridgeGame 의 필드변수 sb1 에 IS_NOT_CORRECT(X) sb2 에 SPACE 를 추가한다.")
    @Test
    public void isDown2() {
        //given
        BridgeGame bridgeGame = new BridgeGame();
        List<String> bridge = List.of("D", "D", "U");
        int level = 0;
        String moving = "U";

        //when
        bridgeGame.isDown(bridge,moving,level);

        //then
        Assertions.assertThat(bridgeGame.getSb1().toString()).isEqualTo(" X ");
        Assertions.assertThat(bridgeGame.getSb2().toString()).isEqualTo("   ");
    }

    @DisplayName("bridge 의 크기와 level 이 다르면 (최종 라운드가 아니면) BridgeGame 의 필드변수 sb1,sb2 에 MIDDLE_BRACKET(|)을 추가한다. ")
    @Test
    public void isLastNo() {
        //given
        BridgeGame bridgeGame = new BridgeGame();
        List<String> bridge = List.of("D", "D", "U");
        int level = 0;

        //when
        bridgeGame.isLast(bridge,level);

        //then
        Assertions.assertThat(bridgeGame.getSb1().toString()).isEqualTo("|");
        Assertions.assertThat(bridgeGame.getSb2().toString()).isEqualTo("|");
    }

    @DisplayName("bridge 의 크기와 level 이 다르면 (최종 라운드가 아니면) BridgeGame 의 필드변수 sb1,sb2 에 END_BRACKET(])을 추가한다. ")
    @Test
    public void isLastOK() {
        //given
        BridgeGame bridgeGame = new BridgeGame();
        List<String> bridge = List.of("D", "D", "U");
        int level = 2;

        //when
        bridgeGame.isLast(bridge,level);

        //then
        Assertions.assertThat(bridgeGame.getSb1().toString()).isEqualTo("]");
        Assertions.assertThat(bridgeGame.getSb2().toString()).isEqualTo("]");
    }

    @DisplayName("bridge 의 값과 moving 의 값을 비교하여 IS_CORRECT 또는 IS_NOT_CORRECT 를 리턴한다.")
    @Test
    public void compareBridgeAndMoving() {
        //given
        BridgeGame bridgeGame = new BridgeGame();
        List<String> bridge = List.of("D", "D", "U");

        //when
        String result1 = bridgeGame.compareBridgeAndMoving(bridge, "D", 0);
        String result2 = bridgeGame.compareBridgeAndMoving(bridge, "U", 0);

        //then
        Assertions.assertThat(result1).isEqualTo(" O ");
        Assertions.assertThat(result2).isEqualTo(" X ");
    }
}