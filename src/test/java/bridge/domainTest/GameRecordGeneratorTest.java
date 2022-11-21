package bridge.domainTest;
import bridge.constant.BridgeDirection;
import bridge.constant.CrossingState;
import bridge.domain.GameRecordGenerator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.assertj.core.api.InstanceOfAssertFactories.stream;

public class GameRecordGeneratorTest {

    @Test
    @DisplayName("현재 게임 상태를 포맷에 맞춰 생성하는지 확인한다.")
    public void generateCurrentGameRecord(){
        boolean crossedState=true;
        BridgeDirection direction = BridgeDirection.UP;
        GameRecordGenerator gameRecordGenerator = new GameRecordGenerator();
        List<String> result = gameRecordGenerator.generate(crossedState, direction);
        assertThat(result).containsExactlyElementsOf(List.of("O", " "));
    }
}
