package bridge.utilTest;
import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.HashSet;
import java.util.Set;

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
        assertThat(new HashSet<>(bridgeMaker.makeBridge(3)))
                .isEqualTo(Set.of("U", "D"));
    }
}
