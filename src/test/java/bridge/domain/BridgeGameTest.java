package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    BridgeGame bridgeGame = new BridgeGame(bridgeMaker);

    @BeforeEach
    void makeBridge(){
        bridgeGame.makeBridge(15);
    }


    @DisplayName("잘못된 이동 커맨드 입력 테스트")
    @Test
    void invalidMoveCommandTest() {
        assertThatThrownBy(() -> bridgeGame.move("44")).isInstanceOf(IllegalArgumentException.class);
    }

    @DisplayName("잘못된 재시도 커맨드 입력 테스트")
    @Test
    void invalidRetrialCommandTest() {
        assertThatThrownBy(() -> bridgeGame.retry("44")).isInstanceOf(IllegalArgumentException.class);
    }

}