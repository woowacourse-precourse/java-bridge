package bridge;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatCode;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import bridge.domain.game.Bridge;
import bridge.domain.game.BridgeGame;
import bridge.domain.player.Player;
import bridge.dto.controller.ExitDto;
import bridge.dto.controller.MoveDto;
import bridge.dto.controller.RetryDto;
import bridge.dto.input.ReadGameCommandDto;
import bridge.dto.input.ReadMovingDto;
import bridge.exception.domain.WrongGeneratorException;
import bridge.helper.common.CommonStubBridgeGeneratorField;
import bridge.helper.stub.StubBridgeNumberGenerator;
import bridge.utils.game.GameStatus;
import java.util.List;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class BridgeGameTest {

    private final int defaultSize = 3;

    @Nested
    @DisplayName("int size, BridgeNumberGenerator generator를 매개변수로 받는 생성자는")
    class DescribeIntGeneratorConstructorTest {

        private final BridgeNumberGenerator validGenerator = new BridgeRandomNumberGenerator();

        @Nested
        @DisplayName("만약 유효한 다리의 크기와 다리를 생성하는 전략이 주어지면")
        class ContextWithValidSizeAndGeneratorTest {

            @Test
            @DisplayName("다리를 생성해 Bridge를 초기화하고 반환한다.")
            void it_returns_bridgeGame() {
                assertThatCode(() -> new BridgeGame(defaultSize, validGenerator))
                    .doesNotThrowAnyException();
            }
        }

        @Nested
        @DisplayName("만약 유효한 다리의 크기와 유효하지 않은 다리를 생성하는 전략이 주어지면")
        class ContextWithSizeAndInvalidGeneratorTest {

            @Test
            @DisplayName("WrongGeneratorException 예외가 발생한다")
            void it_throws_exception() {
                BridgeNumberGenerator invalidGenerator = new StubBridgeNumberGenerator(List.of(2, 3, 4));

                assertThatThrownBy(() -> new BridgeGame(defaultSize, invalidGenerator))
                    .isInstanceOf(WrongGeneratorException.class);
            }
        }

        @Nested
        @DisplayName("만약 유효하지 않은 다리의 크기와 유효한 다리를 생성하는 전략이 주어지면")
        class ContextWithInvalidSizeAndGeneratorTest {

            @ParameterizedTest
            @ValueSource(ints = {-1, 0, 1, 2, 21})
            @DisplayName("IllegalArgumentException 예외가 발생한다")
            void it_throws_exception(int input) {
                assertThatThrownBy(() -> new BridgeGame(input, validGenerator))
                    .isInstanceOf(IllegalArgumentException.class);
            }
        }
    }

    @Nested
    @DisplayName("move 메소드는")
    class DescribeMoveMethodTest extends CommonBeforeEach {

        @Nested
        @DisplayName("만약 마지막 다리가 아닌 상태에서 유효한 ReadMovingDto가 주어지면")
        class ContextWhenNotEndBridgeWithReadMovingDtoTest {

            @ParameterizedTest
            @CsvSource(
                value = {
                    "U:GAME_OVER",
                    "D:GAME_PLAY"
                },
                delimiter = ':'
            )
            @DisplayName("입력한 다리로 플레이어가 이동할 수 있는지를 계산해 MoveDto로 반환한다")
            void it_returns_moveDto(String validInput, GameStatus expected) {
                ReadMovingDto readMovingDto = new ReadMovingDto(validInput);

                MoveDto move = bridgeGame.move(readMovingDto);

                assertThat(move.getNextGameStatus()).isSameAs(expected);
            }
        }

        @Nested
        @DisplayName("만약 마지막 다리에서 유효한 ReadMovingDto가 주어지면")
        class ContextWhenEndBridgeWithReadMovingDtoTest {

            @Test
            @DisplayName("입력한 다리로 플레이어가 이동할 수 있는지를 계산해 MoveDto로 반환한다")
            void it_returns_moveDto() {
                ReadMovingDto readMovingDto = new ReadMovingDto("D");
                bridgeGame.move(readMovingDto);
                bridgeGame.move(readMovingDto);

                MoveDto move = bridgeGame.move(readMovingDto);

                assertThat(move.getNextGameStatus()).isSameAs(GameStatus.GAME_EXIT);
            }
        }

        @Nested
        @DisplayName("만약 유효하지 않은 ReadMovingDto가 주어지면")
        class ContextWithInvalidReadMovingDtoTest {

            @ParameterizedTest
            @ValueSource(strings = {"u", "d", "0", "@", "ud", "UD"})
            @DisplayName("IllegalArgumentException 예외가 발생한다")
            void it_throws_exception(String invalidInput) {
                ReadMovingDto readMovingDto = new ReadMovingDto(invalidInput);

                assertThatThrownBy(() -> bridgeGame.move(readMovingDto))
                    .isInstanceOf(IllegalArgumentException.class);
            }
        }
    }

    @Nested
    @DisplayName("retry 메소드는")
    class DescribeRetryMethodTest extends CommonBeforeEach {

        @Nested
        @DisplayName("만약 유효한 ReadGameCommandDto가 주어지면")
        class ContextWithReadGameCommandDto {

            @ParameterizedTest
            @CsvSource(
                value = {
                    "R:GAME_PLAY",
                    "Q:GAME_EXIT"
                },
                delimiter = ':'
            )
            @DisplayName("입력한 커맨드에 따라 다음 진행할 GameStatus를 계산해 RetryDto를 반환한다")
            void itReturns(String input, GameStatus expected) {
                ReadGameCommandDto readGameCommandDto = new ReadGameCommandDto(input);

                RetryDto retryDto = bridgeGame.retry(readGameCommandDto);

                assertThat(retryDto.getNextGameStatus()).isSameAs(expected);
            }
        }

        @Nested
        @DisplayName("만약 유효하지 않은 ReadGameCommandDto가 주어지면")
        class ContextWithInvalidReadGameCommandDtoTest {

            @ParameterizedTest
            @ValueSource(strings = {"r", "q", "0", "@",  "RQ", "0"})
            @DisplayName("IllegalArgumentException 예외가 발생한다")
            void itThrowsException(String invalidInput) {
                ReadGameCommandDto readGameCommandDto = new ReadGameCommandDto(invalidInput);

                assertThatThrownBy(() -> bridgeGame.retry(readGameCommandDto))
                    .isInstanceOf(IllegalArgumentException.class);
            }
        }
    }

    @Nested
    @DisplayName("exit 메소드는")
    class DescribeExitMethodTest extends CommonBeforeEach {

        @Nested
        @DisplayName("만약 호출하면")
        class ContextWithoutParameterTest {

            @Test
            @DisplayName("Player 정보와 Bridge 정보를 가진 ExitDto를 반환한다")
            void it_returns_exitDto() {
                ExitDto exitDto = bridgeGame.exit();

                assertThat(exitDto.getBridge()).isNotNull().isInstanceOf(Bridge.class);
                assertThat(exitDto.getPlayer()).isNotNull().isInstanceOf(Player.class);
            }
        }
    }

    private abstract class CommonBeforeEach extends CommonStubBridgeGeneratorField {

        protected BridgeGame bridgeGame;

        @BeforeEach
        void initBridgeGame() {
            bridgeGame = new BridgeGame(defaultSize, stubGenerator);
        }
    }
}
