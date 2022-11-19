package bridge.dto.output;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.player.Player;
import bridge.dto.controller.ExitDto;
import bridge.helper.common.CommonBridgeField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PrintGameInfoDtoTest {

    @Nested
    @DisplayName("getTryCount 메소드는")
    class DescribeGetTryCountMethodTest extends CommonBeforeEach {

        @Nested
        @DisplayName("만약 호출하면")
        class ContextWithoutParameter {

            @Test
            @DisplayName("플레이어의 게임 시도 횟수를 반환한다")
            void itReturnsLong() {
                assertThat(printGameInfoDto.getTryCount()).isOne();
            }
        }
    }

    @Nested
    @DisplayName("getTryCount 메소드는")
    class DescribeIsSuccessMethodTest extends CommonBeforeEach {

        @Nested
        @DisplayName("만약 호출하면")
        class ContextWithoutParameter {

            @Test
            @DisplayName("플레이어의 게임 시도 횟수를 반환한다")
            void itReturnsBoolean() {
                assertThat(printGameInfoDto.isSuccess()).isFalse();
            }
        }
    }

    private abstract class CommonBeforeEach extends CommonBridgeField {

        protected PrintGameInfoDto printGameInfoDto;

        @BeforeEach
        void initPrintGameInfoDto() {
            Player player = new Player(3);

            ExitDto exitDto = new ExitDto(player, bridge);
            printGameInfoDto = new PrintGameInfoDto(exitDto);
        }
    }
}
