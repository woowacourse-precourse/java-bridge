package bridge.model;

import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class BridgeGameTest {

    static class DDDgenerator implements BridgeNumberGenerator {
        @Override
        public int generate() {
            return 0;
        }
    }

    static class UUUgenerator implements BridgeNumberGenerator {
        @Override
        public int generate() {
            return 1;
        }
    }

    @DisplayName("다리 건너기에 성공한다면 true반환")
    @Test
    void moveReturnTrue() {
        BridgeGame bridgeGame = new BridgeGame(3, new UUUgenerator());
        boolean result = bridgeGame.move("U");
        Assertions.assertThat(result).isTrue();
    }

    @DisplayName("다리 건너기에 실패한다면 false반환")
    @Test
    void moveReturnFalse() {
        BridgeGame bridgeGame = new BridgeGame(3, new UUUgenerator());
        boolean result = bridgeGame.move("D");
        Assertions.assertThat(result).isFalse();
    }

    @DisplayName("다리의 끝에 도달한다면 true를 반환한다.")
    @Test
    void isOverTrue() {
        class generator implements BridgeNumberGenerator {
            @Override
            public int generate() {
                return 0;
            }
        }
        BridgeGame bridgeGame = new BridgeGame(3, new generator());
        bridgeGame.move("D");
        bridgeGame.move("D");
        bridgeGame.move("D");
        boolean result = bridgeGame.isOver();

        Assertions.assertThat(result).isTrue();
    }

    @DisplayName("다리의 끝에 도달한다면 true를 반환한다.")
    @Test
    void isOverFalse() {

        BridgeGame bridgeGame = new BridgeGame(3, new DDDgenerator());
        bridgeGame.move("D");
        bridgeGame.move("D");
        boolean result = bridgeGame.isOver();

        Assertions.assertThat(result).isFalse();
    }

}