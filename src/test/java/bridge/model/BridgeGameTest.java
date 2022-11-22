package bridge.model;

import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeGameTest {

    private BridgeGame bridgeGame = new BridgeGame();
    private Player player = new Player();
    private Referee referee = new Referee();

    @BeforeEach
    @AfterEach
    void setHoleGameCount(){
        BridgeGame.holeGameCount = 1;
    }
    @DisplayName("R을 입력하면 게임이 재시작 되어 전체 게임횟수가 증가한다.")
    @ParameterizedTest
    @ValueSource(strings = {"R"})
    void 게임_종료_테스트(String input){
        bridgeGame.retry(input, player, referee);
        Assertions.assertEquals(BridgeGame.holeGameCount, 2);
    }

    @DisplayName("S를 입력하면 게임이 종료되어 전체 게임 횟수가 증가하지 않는다.")
    @ParameterizedTest
    @ValueSource(strings = {"S"})
    void 게임_재시작_테스트(String input){
        bridgeGame.retry(input, player, referee);
        Assertions.assertEquals(BridgeGame.holeGameCount, 1);
    }

}