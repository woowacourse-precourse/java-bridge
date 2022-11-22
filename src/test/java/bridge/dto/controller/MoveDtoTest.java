package bridge.dto.controller;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.game.BridgeTile;
import bridge.domain.player.Player;
import bridge.dto.output.PrintMapDto;
import bridge.helper.common.CommonBridgeField;
import bridge.utils.game.GameStatus;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class MoveDtoTest {

    @Nested
    @DisplayName("getPrintMapDto 메소드는")
    class DescribeGetPrintMapDtoMethodTest extends CommonBeforeEach {

        @Nested
        @DisplayName("만약 호출되면")
        class ContextWithoutParameterTest {

            @Test
            @DisplayName("printMapDto를 반환한다")
            void it_returns_printMapDto() {
                PrintMapDto printMapDto = moveDto.getPrintMapDto();

                assertThat(printMapDto.getUpBridgeHistory()).contains("X");
                assertThat(printMapDto.getDownBridgeHistory()).contains("O");
            }
        }
    }

    private abstract class CommonBeforeEach extends CommonBridgeField {

        protected MoveDto moveDto;

        @BeforeEach
        void initMoveDto() {
            Player player = new Player(3);
            player.move(bridge, BridgeTile.DOWN);
            player.move(bridge, BridgeTile.UP);

            PrintMapDto printMapDto = new PrintMapDto(player);
            moveDto = new MoveDto(GameStatus.GAME_PLAY, printMapDto);
        }
    }
}