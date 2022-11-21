//package bridge.domain;
//
//import org.junit.jupiter.api.DisplayName;
//import org.junit.jupiter.api.Test;
//
//import java.util.List;
//
//import static org.assertj.core.api.Assertions.assertThat;
//import static org.junit.jupiter.api.Assertions.*;
//
//class BridgeTest {
//
//    @DisplayName("가지고 있는 다리 길이를 반환한다.")
//    @Test
//    void getBridgeLength() {
//        Bridge bridge = new Bridge(List.of("U","D","D"));
//        assertThat(bridge.getBridgeLength()).isEqualTo(3);
//    }
//
//    @DisplayName("이동하고자 하는 위치가 건널 수 있는 위치이면 true를 반환한다.")
//    @Test
//    void inputCanCross() {
//        Bridge bridge = new Bridge(List.of("U","D","D"));
//        assertThat(bridge.judgeMoving("U",0)).isEqualTo("O");
//    }
//
//    @DisplayName("이동하고자 하는 위치가 건널 수 없는 위치이면 false를 반환한다.")
//    @Test
//    void inputCanNotCross() {
//        Bridge bridge = new Bridge(List.of("U","D","D"));
//        assertThat(bridge.judgeMoving("U",0)).isEqualTo("X");
//    }
//}