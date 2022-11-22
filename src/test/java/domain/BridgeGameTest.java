package domain;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    BridgeGame bridgeGame;

    @BeforeEach
    void setup(){
        List<String> bridge = List.of("U","D","U");
        bridgeGame = new BridgeGame(bridge);
    }


    @Test
    void 지도그리기_테스트(){
        assertThat(bridgeGame.move(0,"U")).isEqualTo(true);
        assertThat(bridgeGame.move(0,"D")).isEqualTo(false);
    }

    @Test
    void 재시작_테스트(){
        assertThat(bridgeGame.retry("R")).isEqualTo(true);
        assertThat(bridgeGame.retry("Q")).isEqualTo(false);
    }

    @Test
    void 문자열_초기화_테스트(){
        bridgeGame.move(0," U ");
        bridgeGame.move(1,"U");
        bridgeGame.move(2,"U");
        bridgeGame.refresh();
        assertThat(bridgeGame.getUpperLine().size()).isEqualTo(0);
    }
}

