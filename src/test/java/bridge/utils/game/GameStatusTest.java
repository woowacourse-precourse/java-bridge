package bridge.utils.game;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class GameStatusTest {

    @Nested
    @DisplayName("findNextGamePlay 메소드는")
    class DescribeFindNextGamePlayMethodTest {

        @Nested
        @DisplayName("만약 플레이어의 게임 성공 여부와 이동했는지에 대한 유무가 주어지면")
        class ContextWithSuccessAndMovableTest {

            @ParameterizedTest
            @CsvSource(
                    value = {
                        "true:true:GAME_EXIT",
                        "false:true:GAME_PLAY",
                        "false:false:GAME_OVER"
                    },
                    delimiter = ':'
            )
            @DisplayName("다음으로 진행할 GameStatus를 반환한다")
            void it_returns_gameStatus(boolean success, boolean movable, GameStatus expected) {
                GameStatus actual = GameStatus.findNextGamePlay(success, movable);

                assertThat(actual).isSameAs(expected);
            }
        }
    }

    @Nested
    @DisplayName("playable 메소드는")
    class DescribePlayableMethodTest {

        @Nested
        @DisplayName("만약 호출되면")
        class ContextWithoutParameterTest {

            @ParameterizedTest
            @CsvSource(
                    value = {
                        "APPLICATION_START:true",
                        "MAKE_BRIDGE:true",
                        "GAME_PLAY:true",
                        "GAME_OVER:true",
                        "GAME_EXIT:true",
                        "APPLICATION_EXIT:false"
                    },
                    delimiter = ':'
            )
            @DisplayName("게임이 계속 진행되는지에 대한 유무를 반환한다")
            void itReturnsBoolean(GameStatus gameStatus, boolean expected) {
                boolean actual = gameStatus.playable();

                assertThat(actual).isSameAs(expected);
            }
        }
    }
}
