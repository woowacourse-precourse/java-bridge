package bridge.domain;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;
import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class BridgeGameTest {

    BridgeGame bridgeGame;

    @BeforeEach
    void beforEach(){
        bridgeGame = new BridgeGame(List.of("U","D","D"));
    }

    @Test
    void 이동명령과_정답다리와_비교(){

        boolean result =bridgeGame.compare("U");
        assertThat(result).isTrue();

    }

}