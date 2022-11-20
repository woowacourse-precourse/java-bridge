package bridge.domain;

import static bridge.constant.Moving.LOWER_SIDE;
import static bridge.constant.Moving.UPPER_SIDE;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class BridgeGameTest {
    BridgeGame bridgeGame;

    @BeforeEach
    void initBridgeGame() {
        bridgeGame = new BridgeGame(List.of(UPPER_SIDE, LOWER_SIDE, UPPER_SIDE));
    }

    @DisplayName("게임 상태가 진행 중인지 확인한다.")
    @Nested
    class IsOnWay {

        @DisplayName("진행 중인 경우")
        @Test
        void should_BeTrue_When_StatusIsOnWay() {
            // given
            bridgeGame.move(UPPER_SIDE);
            // when
            boolean isOnWay = bridgeGame.isOnWay();
            // then
            assertThat(isOnWay).isTrue();
        }

        @DisplayName("실패 상태인 경우")
        @Test
        void should_BeFalse_When_StatusIsFail() {
            // given
            bridgeGame.move(LOWER_SIDE);
            // when
            boolean isOnWay = bridgeGame.isOnWay();
            // then
            assertThat(isOnWay).isFalse();
        }
    }

    @DisplayName("게임 상태가 실패 상태인지 확인한다.")
    @Nested
    class IsFail {

        @DisplayName("실패 상태인 경우")
        @Test
        void should_BeTrue_When_StatusIsFail() {
            // given
            bridgeGame.move(LOWER_SIDE);
            // when
            boolean isOnWay = bridgeGame.isFail();
            // then
            assertThat(isOnWay).isTrue();
        }

        @DisplayName("진행 중인 경우")
        @Test
        void should_BeFalse_When_StatusIsOnWay() {
            // given
            bridgeGame.move(UPPER_SIDE);
            // when
            boolean isOnWay = bridgeGame.isFail();
            // then
            assertThat(isOnWay).isFalse();
        }
    }

    @DisplayName("게임 상태가 종료 상태인지 확인한다.")
    @Nested
    class IsEnd {

        @DisplayName("종료 상태인 경우")
        @Test
        void should_BeTrue_When_StatusIsEnd() {
            // given
            bridgeGame.move(UPPER_SIDE);
            bridgeGame.move(LOWER_SIDE);
            bridgeGame.move(UPPER_SIDE);
            // when
            boolean isOnWay = bridgeGame.isEnd();
            // then
            assertThat(isOnWay).isTrue();
        }

        @DisplayName("진행 중인 경우")
        @Test
        void should_BeFalse_When_StatusIsOnWay() {
            // given
            bridgeGame.move(UPPER_SIDE);
            // when
            boolean isOnWay = bridgeGame.isEnd();
            // then
            assertThat(isOnWay).isFalse();
        }
    }
}