package bridge.domain;


import bridge.BridgeGame;
import bridge.InputView;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class BridgeGameTest {

    private BridgeGame bridgeGame;
    private InputView inputView;

    @BeforeEach
    void setUp(){

        bridgeGame = new BridgeGame();

    }

    @Test
    void 칸_이동() throws Exception{
        //given
        bridgeGame.createPosition();
        //when
//        int move = bridgeGame.move();
        int square = 1;
        //then
//        Assertions.assertEquals(move, square);

    }

    @Test
    void 게임_재시작() throws Exception{
        //given
        //when

        //then
    }

    @Test
    void 다리_생성(){
        //given

        //when

        //then
    }

}