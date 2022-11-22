package bridge;

import static org.junit.jupiter.api.Assertions.assertEquals;

import camp.nextstep.edu.missionutils.test.NsTest;

import org.junit.jupiter.api.Test;

class BridgeGameTest extends NsTest {

    @Test
    void 브릿지_리스트와_유저_인풋이_맞을_때_ox_값이_O인지_확인() {
        BridgeGame bridgeGame = new BridgeGame();
        run("D");
        assertEquals(bridgeGame.getOX(),"O");
    }

    @Test
    void 브릿지_리스트와_유저_인풋이_틀렸을_때_ox_값이_x인지_확인() {
        BridgeGame bridgeGame = new BridgeGame();
        run("U");
        assertEquals(bridgeGame.getOX(),"X");
    }

    @Test
    void 브릿지_리스트와_유저_인풋이_맞을_때_map_값_확인() {
        BridgeGame bridgeGame = new BridgeGame();
        run("D");
        assertEquals(bridgeGame.getMap().toString(), "[   ]\n[ O ]\n");
    }

    @Test
    void 브릿지_리스트와_유저_인풋이_틀릴_때_map_값_확인() {
        BridgeGame bridgeGame = new BridgeGame();
        run("U");
        assertEquals(bridgeGame.getMap().toString(), "[ X ]\n[   ]\n");
    }

    @Override
    protected void runMain() {
        BridgeGame bridgeGame = new BridgeGame();
        bridgeGame.move("D",0);

    }

}