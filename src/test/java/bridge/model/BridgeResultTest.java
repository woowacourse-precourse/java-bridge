//package bridge.model;
//
//import static org.assertj.core.api.Assertions.assertThat;
//
//import java.util.List;
//import org.junit.jupiter.api.Test;
//
//class BridgeResultTest {
//
//    @Test
//    void canMove() {
//        Bridge bridge = new Bridge(List.of("U", "D", "D"));
//        assertThat(new BridgeResult(List.of(false)).canMove(bridge)).isEqualTo(false);
//        assertThat(new BridgeResult(List.of(true, true)).canMove(bridge)).isEqualTo(true);
//        assertThat(new BridgeResult(List.of(true, true, false)).canMove(bridge)).isEqualTo(false);
//        assertThat(new BridgeResult(List.of(true, true, true)).canMove(bridge)).isEqualTo(false);
//    }
//
//}