package bridge;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
    private static BridgeGame bridgeGame;
    private static OutputView outputView;

    @BeforeAll
    static void init(){
        bridgeGame = new BridgeGame();
        outputView = new OutputView();
    }

    @Test
    @DisplayName("move 적상 작동 검증하기")
    void move_검증() {
        String[] ss = "UDUDUUUDD".split("");
        int count = 1;
        for (String s : ss){
            if(bridgeGame.isFailed()) break;
            bridgeGame.move(s, "U");
            System.out.println(count++ + "회차");
            outputView.printMap(bridgeGame.getLines());
        }
    }
}