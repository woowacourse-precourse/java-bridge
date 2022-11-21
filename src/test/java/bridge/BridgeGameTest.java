package bridge;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeGameTest {

    @Test
    void move_사용자가_아래다리로_한칸_이동에_성공했을때() {
        //given
        BridgeGame bridgeGame = new BridgeGame();
        List<String> upperBridge = new ArrayList<>();
        List<String> lowerBridge = new ArrayList<>();
        boolean isUpper = false;
        String OorX = "O";

        //when
        upperBridge = bridgeGame.move(upperBridge, isUpper, OorX);
        lowerBridge = bridgeGame.move(lowerBridge, !isUpper, OorX);

        //then
        assertThat(upperBridge).contains(" ");
        assertThat(lowerBridge).contains("O");
    }

    @Test
    void move_사용자가_위다리로_한칸_이동에_성공했을때() {
        //given
        BridgeGame bridgeGame = new BridgeGame();
        List<String> upperBridge = new ArrayList<>();
        List<String> lowerBridge = new ArrayList<>();
        boolean isUpper = true;
        String OorX = "O";

        //when
        upperBridge = bridgeGame.move(upperBridge, isUpper, OorX);
        lowerBridge = bridgeGame.move(lowerBridge, !isUpper, OorX);

        //then
        assertThat(upperBridge).contains("O");
        assertThat(lowerBridge).contains(" ");
    }

    @Test
    void move_사용자가_아래다리로_한칸_이동에_실패했을때() {
        //given
        BridgeGame bridgeGame = new BridgeGame();
        List<String> upperBridge = new ArrayList<>();
        List<String> lowerBridge = new ArrayList<>();
        boolean isUpper = false;
        String OorX = "X";

        //when
        upperBridge = bridgeGame.move(upperBridge, isUpper, OorX);
        lowerBridge = bridgeGame.move(lowerBridge, !isUpper, OorX);

        //then
        assertThat(upperBridge).contains(" ");
        assertThat(lowerBridge).contains("X");
    }

    @Test
    void move_사용자가_위다리로_한칸_이동에_실패했을때() {
        //given
        BridgeGame bridgeGame = new BridgeGame();
        List<String> upperBridge = new ArrayList<>();
        List<String> lowerBridge = new ArrayList<>();
        boolean isUpper = true;
        String OorX = "X";

        //when
        upperBridge = bridgeGame.move(upperBridge, isUpper, OorX);
        lowerBridge = bridgeGame.move(lowerBridge, !isUpper, OorX);

        //then
        assertThat(upperBridge).contains("X");
        assertThat(lowerBridge).contains(" ");
    }

    @Test
    void retry_올바른입력() {
        //given
        BridgeGame bridgeGame = new BridgeGame();
        String command = "R";

        //when
        boolean retryMethodResult = bridgeGame.retry(command);

        //then
        assertThat(retryMethodResult).isEqualTo(true);
    }

    @Test
    void retry_잘못된입력() {
        //given
        BridgeGame bridgeGame = new BridgeGame();
        String command = "ㄲ";

        //when
        boolean retryMethodResult = bridgeGame.retry(command);

        //then
        assertThat(retryMethodResult).isFalse();
    }

    @Test
    void countGameNum_올바른입력으로_계산성공() {
        //given
        BridgeGame bridgeGame = new BridgeGame();
        int cnt = 128;
        String command = "R";

        //when
        int calculatedGameNum = bridgeGame.countGameNum(command, cnt);

        //then
        assertThat(calculatedGameNum).isEqualTo(129);
    }

    @Test
    void countGameNum_잘못된입력으로_계산실패() {
        //given
        BridgeGame bridgeGame = new BridgeGame();
        int cnt = 128;
        String command = "ㅁㅇㅎㅁ111";

        //when
        int calculatedGameNum = bridgeGame.countGameNum(command, cnt);

        //then
        assertThat(calculatedGameNum).isNotSameAs(129);
        assertThat(calculatedGameNum).isEqualTo(128);
    }

    @Test
    void canGo_사용자가_건널수_있는_다리를_선택했을때() {
        //given
        BridgeGame bridgeGame = new BridgeGame();

        //when
        String OorX = bridgeGame.canGo(true);

        //then
        assertThat(OorX).isEqualTo("O");
    }

    @Test
    void canGo_사용자가_건널수_없는_다리를_선택했을때() {
        //given
        BridgeGame bridgeGame = new BridgeGame();

        //when
        String OorX = bridgeGame.canGo(false);

        //then
        assertThat(OorX).isEqualTo("X");
    }

    @Test
    void upperOrLower_사용자가_U를_입력했을때() {
        //given
        BridgeGame bridgeGame = new BridgeGame();
        String userChoice = "U";

        //when
        boolean upOrLow = bridgeGame.upperOrLower(userChoice);

        //then
        assertThat(upOrLow).isTrue();
    }

    @Test
    void upperOrLower_사용자가_D를_입력했을때() {
        //given
        BridgeGame bridgeGame = new BridgeGame();
        String userChoice = "D";

        //when
        boolean upOrLow = bridgeGame.upperOrLower(userChoice);

        //then
        assertThat(upOrLow).isFalse();
    }

    @Test
    void isBlank_사용자가_선택한다리에_문자열을_반환() {
        //given
        BridgeGame bridgeGame = new BridgeGame();
        boolean upper = true;
        String OorX = "O";

        //when
        String result = bridgeGame.isBlank(upper, OorX);

        //then
        assertThat(result).isEqualTo("O");
    }

    @Test
    void isBlank_사용자가_선택하지않은_다리에_공백넣기() {
        //given
        BridgeGame bridgeGame = new BridgeGame();
        boolean upper = false;
        String OorX = "O";

        //when
        String result = bridgeGame.isBlank(upper, OorX);

        //then
        assertThat(result).isEqualTo(" ");
    }
}