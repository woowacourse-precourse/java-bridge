package bridge.dto.output;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.game.BridgeTile;
import bridge.domain.player.Player;
import bridge.dto.controller.ExitDto;
import bridge.helper.common.CommonBridgeField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PrintResultDtoTest {

    @Nested
    @DisplayName("getPrintMapDto 메소드는")
    class DescribeGetPrintMapDtoMethodTest extends CommonBeforeEach {

        @Nested
        @DisplayName("만약 호출하면")
        class ContextWithoutParameterTest {

            @Test
            @DisplayName("플레이어의 이동 경로가 있는 PrintMapDto를 반환한다")
            void it_returns_printMapDto() {
                PrintMapDto printMapDto = printResultDto.getPrintMapDto();

                assertThat(printMapDto.getUpBridgeHistory()).contains("X");
                assertThat(printMapDto.getDownBridgeHistory()).contains("O");
            }
        }
    }

    @Nested
    @DisplayName("getPrintGameInfoDto 메소드는")
    class DescribeGetPrintGameInfoDtoMethodTest extends CommonBeforeEach {

        @Nested
        @DisplayName("만약 호출하면")
        class ContextWithoutParameterTest {

            @Test
            @DisplayName("게임 종료 정보가 있는 PrintGameInfoDto를 반환한다")
            void it_returns_printGameInfoDto() {
                PrintGameInfoDto printGameInfoDto = printResultDto.getPrintGameInfoDto();

                assertThat(printGameInfoDto.getTryCount()).isOne();
                assertThat(printGameInfoDto.isSuccess()).isFalse();
            }
        }
    }

    private abstract class CommonBeforeEach extends CommonBridgeField {

        protected PrintResultDto printResultDto;

        @BeforeEach
        void initPrintGameInfoDto() {
            Player player = new Player(3);
            player.move(bridge, BridgeTile.DOWN);
            player.move(bridge, BridgeTile.UP);

            ExitDto exitDto = new ExitDto(player, bridge);
            printResultDto = new PrintResultDto(exitDto);
        }
    }
}
