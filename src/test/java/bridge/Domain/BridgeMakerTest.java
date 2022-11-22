package bridge.Domain;


import bridge.BridgeMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeMakerTest {

    @Nested
    @DisplayName("getRandomPosition 메소드 테스트")
    class TestGetRandomPosition {

        @Test
        @DisplayName("랜덤 값 1이 생성되었을 때 U 리턴")
        void getRandomPosition_randomValueIsOne_returnStringU() {
            BridgeMaker bridgeMaker = new BridgeMaker(() -> 1);
            String expect = "U";
            assertThat(bridgeMaker.getRandomPosition()).isEqualTo(expect);
        }

        @Test
        @DisplayName("랜덤 값 0이 생성되었을 때 D 리턴")
        void getRandomPosition_randomValueIsZero_returnStringD() {
            BridgeMaker bridgeMaker = new BridgeMaker(() -> 0);
            String expect = "D";
            assertThat(bridgeMaker.getRandomPosition()).isEqualTo(expect);
        }
    }

    @Nested
    @DisplayName("makeBridge 메소드 테스트")
    class TestMakeBridge {

        @Test
        @DisplayName("사이즈 6을 입력했을 때, 길이 6의 리스트 리턴")
        void makeBridge_bridgeSizeIsSix_returnSixSizeList() {
            BridgeMaker bridgeMaker = new BridgeMaker(() -> 1);
            List<String> expect = List.of("U", "U", "U", "U", "U", "U");
            int size = 6;
            assertThat(bridgeMaker.makeBridge(size)).isEqualTo(expect);
        }
    }
}