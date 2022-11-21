package bridge.constantTest;

import bridge.constant.BridgeDirection;
import bridge.constant.GameRecord;
import bridge.domain.GameRecordGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;


import static org.assertj.core.api.Assertions.assertThat;


public class GameRecordTest {
    @ParameterizedTest
    @MethodSource("provideRecordFormatForFindByBridgeDirection")
    @DisplayName("다리의 현재 방향에 따라서 알맞은 포맷 객체를 선택하는지 확인한다.")
    public void findByBridgeDirectionInstance(BridgeDirection direction, GameRecord gameRecord){
        assertThat(GameRecord.findLocation(direction)).isEqualTo(gameRecord);
    }

    private static Stream<Arguments> provideRecordFormatForFindByBridgeDirection() {
        return Stream.of(
                Arguments.of(BridgeDirection.DOWN, GameRecord.DOWNSIDE),
                Arguments.of(BridgeDirection.UP, GameRecord.UPSIDE)
        );
    }


}
