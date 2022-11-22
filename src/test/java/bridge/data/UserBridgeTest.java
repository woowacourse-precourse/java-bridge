package bridge.data;

import static org.assertj.core.api.Assertions.*;


import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

public class UserBridgeTest {
    UserBridge userbridge = new UserBridge();

    @DisplayName("사용자 입력이 위쪽다리를 가르키고 다리 위치가 위쪽 다리일 때 추측값이 true라면 O를 위쪽다리에 삽입한다.")
    @Test
    void createUserUpBridgeUpCompareTrue() {
        userbridge.makeUpBridge("U", true);
        assertThat(userbridge.getUpBridge()).isEqualTo(List.of("O"));
    }

    @DisplayName("사용자 입력이 위쪽다리를 가르키고 다리 위치가 위쪽 다리일 때 추측값이 false라면 X를 위쪽다리에 삽입한다.")
    @Test
    void createUserUpBridgeUpCompareFalse() {
        userbridge.makeUpBridge("U", false);
        assertThat(userbridge.getUpBridge()).isEqualTo(List.of("X"));
    }

    @DisplayName("사용자 입력이 위쪽다리를 가르키고 다리 위치가 아래쪽 다리일 때 추측값이 true라면 빈칸을 아래쪽다리에 삽입한다.")
    @Test
    void createUserUpBridgeDownCompareTrue(){
        userbridge.makeDownBridge("U", true);
        assertThat(userbridge.getDownBridge()).isEqualTo(List.of(" "));
    }

    @DisplayName("사용자 입력이 위쪽다리를 가르키고 다리 위치가 아래쪽 다리일 때 추측값이 false라면 빈칸을 아래쪽다리에 삽입한다.")
    @Test
    void createUserUpBridgeDownCompareFalse() {
        userbridge.makeDownBridge("U", false);
        assertThat(userbridge.getDownBridge()).isEqualTo(List.of(" "));
    }

    @DisplayName("사용자 입력이 아래쪽다리를 가르키고 다리 위치가 위쪽 다리일 때 추측값이 true라면 빈칸을 위쪽다리에 삽입한다.")
    @Test
    void createUserDownBridgeUPCompareTrue() {
        userbridge.makeUpBridge("D", true);
        assertThat(userbridge.getUpBridge()).isEqualTo(List.of(" "));
    }

    @DisplayName("사용자 입력이 아래쪽다리를 가르키고 다리 위치가 위쪽 다리일 때 추측값이 false라면 빈칸을 위쪽다리에 삽입한다.")
    @Test
    void createUserDownBridgeUPCompareFalse() {
        userbridge.makeUpBridge("D", false);
        assertThat(userbridge.getUpBridge()).isEqualTo(List.of(" "));
    }

    @DisplayName("사용자 입력이 아래쪽다리를 가르키고 다리 위치가 아래쪽 다리일 때 추측값이 true라면 O를 아래쪽다리에 삽입한다.")
    @Test
    void createUserDownBridgeDownCompareTrue() {
        userbridge.makeDownBridge("D", true);
        assertThat(userbridge.getDownBridge()).isEqualTo(List.of("O"));
    }

    @DisplayName("사용자 입력이 아래쪽다리를 가르키고 다리 위치가 아래쪽 다리일 때 추측값이 false라면 X를 아래쪽다리에 삽입한다.")
    @Test
    void createUserDownBridgeDownCompareFalse() {
        userbridge.makeDownBridge("D", false);
        assertThat(userbridge.getDownBridge()).isEqualTo(List.of("X"));
    }

    @DisplayName("사용자 위쪽 다리를 초기화 시킨다.")
    @Test
    void createClearUpBridge() {
        userbridge.makeClearUpBridge();
        assertThat(userbridge.getUpBridge()).isEmpty();
    }

    @DisplayName("사용자 아래쪽 다리를 초기화 시킨다")
    @Test
    void createClearDownBridge() {
        userbridge.makeClearDownBridge();
        assertThat(userbridge.getDownBridge()).isEmpty();
    }

}
