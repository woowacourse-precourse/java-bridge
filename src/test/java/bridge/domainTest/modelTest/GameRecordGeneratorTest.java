package bridge.domainTest.modelTest;
import bridge.domain.constant.BridgeDirection;
import bridge.domain.model.GameRecordGenerator;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class GameRecordGeneratorTest {

    static GameRecordGenerator gameRecordGenerator;
    @BeforeAll
    public static void initialize(){
        gameRecordGenerator= new GameRecordGenerator();
    }
    @Test
    @DisplayName("현재 게임 상태를 포맷에 맞춰 생성하는지 확인한다.")
    public void generateCurrentGameRecord(){
        boolean crossedState=true;
        BridgeDirection direction = BridgeDirection.UP;
        gameRecordGenerator.generate(crossedState, direction);
        assertThat(gameRecordGenerator.getCurrentGameRecord()).containsExactlyElementsOf(List.of("O", " "));
    }

    @Test
    @DisplayName("게임 기록 형식에 따라 2번째부터 역슬래시가 포함된 포맷으로 출력되는지 확인한다.")
    public void checkFormatAfterSecondTrial(){
        gameRecordGenerator.generate(true, BridgeDirection.UP);
        gameRecordGenerator.updateCurrentRecord(2);

        assertThat(gameRecordGenerator.getCurrentGameRecord()).isEqualTo(List.of(" | O", " |  "));
    }



}
