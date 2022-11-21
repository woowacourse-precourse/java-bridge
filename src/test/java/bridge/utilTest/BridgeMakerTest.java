package bridge.utilTest;
import bridge.util.BridgeMaker;
import bridge.util.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Set;
import java.util.stream.Collectors;

import static org.assertj.core.api.Assertions.*;

public class BridgeMakerTest {

    BridgeMaker bridgeMaker;

    @BeforeEach
    void initializeClass(){
        bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());
    }

    @DisplayName("사이즈의 입력만큼 U, D로 이루어진 문자열 리스트 반환")
    @Test
    void makeBridgeSizeTest(){
        assertThat(bridgeMaker.makeBridge(3).size()).isEqualTo(3);
    }

    @DisplayName("사이즈의 입력만큼 U, D로 이루어진 문자열 리스트 반환")
    @Test
    void makeBridgeComponentTest(){
        assertThat(bridgeMaker.makeBridge(3).stream().collect(Collectors.toSet()))
                .isEqualTo(Set.of("U", "D"));
    }
}
