package bridge.domainTest.constantTest;

import bridge.domain.constant.BridgeDirection;
import bridge.domain.constant.CrossedState;
import bridge.domain.constant.GameRecord;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;


import static org.assertj.core.api.Assertions.assertThat;


public class GameRecordTest {
    private static Stream<Arguments> provideBridgeDirectionForFindByRecordFormat() {
        return Stream.of(
                Arguments.of(BridgeDirection.DOWN, GameRecord.DOWNSIDE),
                Arguments.of(BridgeDirection.UP, GameRecord.UPSIDE)
        );
    }
    @ParameterizedTest
    @MethodSource("provideBridgeDirectionForFindByRecordFormat")
    @DisplayName("다리의 현재 방향에 따라서 알맞은 포맷 객체를 선택하는지 확인한다.")
    public void findByBridgeDirectionInstance(BridgeDirection direction, GameRecord gameRecord){
        assertThat(GameRecord.findLocation(direction)).isEqualTo(gameRecord);
    }

    @Test
    @DisplayName("다리의 현재 방향과 다리 건넌 상태에 따라 알맞은 포맷으로 변환하는지 확인")
    public void transformByDirectionInstance(){
        boolean crossedState=false;
        BridgeDirection bridgeDirection = BridgeDirection.DOWN;
        String result = CrossedState.transform(crossedState);
        GameRecord gameRecord = GameRecord.findLocation(bridgeDirection);
        assertThat(gameRecord.generate(result)).containsExactlyElementsOf(List.of(" ", "X"));
    }
}
