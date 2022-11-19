package bridge.dto.output;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.domain.game.BridgeTile;
import bridge.domain.player.Player;
import bridge.helper.common.CommonBridgeField;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

class PrintMapDtoTest {

    @Nested
    @DisplayName("getUpBridgeHistory 메소드는")
    class DescribeGetUpBridgeHistoryMethodTest extends CommonBeforeEach {

        @Nested
        @DisplayName("만약 호출하면")
        class ContextWithoutParameterTest {

            @Test
            @DisplayName("플레이어가 위쪽 다리로 이동한 경로를 반환한다")
            void it_returns_upHistory() {
                String actual = printMapDto.getUpBridgeHistory();

                assertThat(actual).contains("X");
            }
        }
    }

    @Nested
    @DisplayName("getDownBridgeHistory 메소드는")
    class DescribeGetDownBridgeHistoryMethodTest extends CommonBeforeEach {

        @Nested
        @DisplayName("만약 호출하면")
        class ContextWithoutParameterTest {

            @Test
            @DisplayName("플레이어가 아래쪽 다리로 이동한 경로를 반환한다")
            void it_returns_downHistory() {
                String actual = printMapDto.getDownBridgeHistory();

                assertThat(actual).contains("O");
            }
        }
    }

    private abstract class CommonBeforeEach extends CommonBridgeField {

        protected PrintMapDto printMapDto;

        @BeforeEach
        void initPrintMapDto() {
            Player player = new Player(3);
            player.move(bridge, BridgeTile.DOWN);
            player.move(bridge, BridgeTile.UP);

            printMapDto = new PrintMapDto(player);
        }
    }
}
