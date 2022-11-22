package bridge;

import static org.junit.jupiter.api.Assertions.*;

import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.Test;

class BridgeGameTest2 extends NsTest {

    @Test
    void 두개_이상_브릿지_리스트와_유저_인풋이_맞을_때_map_확인() {
        BridgeGame bridgeGame = new BridgeGame();
        String actual = "[   | O | O ]\n[ O |   |   ]\n";

        run("D","U","U");
        assertEquals(bridgeGame.getMap().toString(),actual);
    }

    @Test
    void 두개_이상_브릿지_리스트_중_유저_인풋이_틀렸_때_map_확인() {
        BridgeGame bridgeGame = new BridgeGame();
        String actual = "[   | O |   ]\n[ O |   | X ]\n";

        run("D","U","D");
        assertEquals(bridgeGame.getMap().toString(),actual);
    }

    @Test
    void Reset_Map_메소드_기능_확인() {
        BridgeGame bridgeGame = new BridgeGame();
        String actual = "[  ]\n[  ]\n";

        run("D","U","D");
        bridgeGame.resetMap();
        assertEquals(bridgeGame.getMap().toString(),actual);
    }

    @Test
    void Retry_메소드_기능_확인() {
        BridgeGame bridgeGame = new BridgeGame();

        assertEquals(bridgeGame.retry("성공"),false);
    }



    @Override
    protected void runMain() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.resetMap();
        bridgeGame.move("D",0);
        bridgeGame.move("U",1);
        bridgeGame.move("U",2);
    }

}