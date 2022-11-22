package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class PlayerBridgeTest {


    @Test
    @DisplayName("위로 이동이 맞을 경우")
    void addUpRootRight() {
        PlayerBridge playerBridge = new PlayerBridge();
        playerBridge.addUpRootRight();
        assertThat(playerBridge.makePlayerBridgeForm()).contains("[ O ]\n[   ]");
    }

    @Test
    @DisplayName("아래 이동이 맞을 경우")
    void addDownRootRight() {
        PlayerBridge playerBridge = new PlayerBridge();
        playerBridge.addDownRootRight();
        assertThat(playerBridge.makePlayerBridgeForm()).contains("[  ]\n[ O ]");
    }

    @Test
    @DisplayName("위로 이동이 틀렸을 경우")
    void addUpRootWrong() {
        PlayerBridge playerBridge = new PlayerBridge();
        playerBridge.addUpRootWrong();
        assertThat(playerBridge.makePlayerBridgeForm()).contains("[ X ]\n[   ]");
    }

    @Test
    @DisplayName("아래 이동이 틀렸을 경우")
    void addDownRootWrong() {
        PlayerBridge playerBridge = new PlayerBridge();
        playerBridge.addDownRootWrong();
        assertThat(playerBridge.makePlayerBridgeForm()).contains("[   ]\n[ X ]");
    }

    @Test
    @DisplayName("출력 형태 만들기")
    void makePlayerBridgeForm() {
        PlayerBridge playerBridge = new PlayerBridge();
        assertThat(playerBridge.makePlayerBridgeForm()).contains("]");
    }

    @Test
    @DisplayName("X가 포함되는 경우")
    void successRoot() {
        PlayerBridge playerBridge = new PlayerBridge();
        playerBridge.addDownRootWrong();
        assertThat(playerBridge.successRoot()).isFalse();
    }

    @Test
    @DisplayName("X가 포함 되지 않는 경우")
    void failRoot() {
        PlayerBridge playerBridge = new PlayerBridge();
        playerBridge.addDownRootRight();
        assertThat(playerBridge.successRoot()).isTrue();
    }
}