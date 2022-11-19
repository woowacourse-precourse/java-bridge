package bridge;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.junit.jupiter.api.Assertions.*;

import dto.BridgeDto;
import bridge.BridgeGame;

import dto.BridgeGameDto;
import java.util.Arrays;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BridgeTest {
    static Bridge bridge;
    static BridgeGame bridgeGame;

    @BeforeAll
    public static void init() {
        bridge = new Bridge(Arrays.asList("U", "D", "D"));
        bridgeGame = new BridgeGame();
    }


    @Nested
    @DisplayName("정오판단 함수 테스트")
    class isCorrectGuessTest {
        BridgeGameDto bridgeGameDto;

        @BeforeEach
        void 한번_이동() {
            bridgeGame.move("U");
            bridgeGameDto = bridgeGame.sendDto();
        }


        @Test
        @DisplayName("누적 한번 정답 고른 케이스")
        void 누적_한번_이동_기능_테스트() {
            assertThat(bridge.isCorrectGuess(bridgeGameDto))
                    .isEqualTo(true);
        }


        @Test
        @DisplayName("누적 두번 정답 고른 케이스")
        void 누적_두번_이동_기능_테스트() {
            bridgeGame.move("D");
            bridgeGameDto = bridgeGame.sendDto();
            assertThat(bridge.isCorrectGuess(bridgeGameDto))
                    .isEqualTo(true);
        }
    }


    @Test
    @DisplayName("DTO 기능 테스트")
    void sendDto() {
        BridgeDto bridgeDto = bridge.sendDto();
        assertThat(bridgeDto.bridge)
                .isEqualTo(
                        Arrays.asList("U", "D", "D")
                );
    }
}
