package bridge.repository;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertAll;

@DisplayName("Bridge 저장소와 관련된 기능을 테스트한다.")
class BridgeRepositoryTest {

    @DisplayName("저장 기능을 테스트한다.")
    @Test
    void saveSuccessWhenGivenList() {
        //given
        BridgeRepository bridgeRepository = new BridgeRepository();

        //when
        bridgeRepository.save(List.of("O", " "));

        //then
        assertAll(
                () -> assertThat(bridgeRepository.getUpBridges()).isEqualTo(List.of("O")),
                () -> assertThat(bridgeRepository.getDownBridges()).isEqualTo(List.of(" "))
        );
    }
}