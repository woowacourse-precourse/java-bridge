package bridge.domain;

import bridge.BridgeMaker;
import bridge.BridgeNumberGenerator;
import bridge.BridgeRandomNumberGenerator;
import bridge.setting.Setting;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private BridgeMaker bridgeMaker;
    private Bridge bridge;

    // 다리 생성 기능
    public void createBridge(int size) {
        BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
        this.bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
        List<String> createdBridge = bridgeMaker.makeBridge(size);
        bridge = new Bridge(createdBridge);
    }

    // Bridge 객체 유저가 입력할 키 리스트 초기화
    public void initBridgeUserKeyList() {
        bridge.initUserKeyList();
    }

    // 다리를 건너는 기능
    public Bridge move(String key) {
        bridge.move(key);
        return bridge;
    }

    // 사용자 입력값이 만든 다리와 길이기 일치할경우 boolean값 반환
    public boolean isBridgeEnd() {
        return bridge.isBridgeEnd();
    }

    // 정답 인지 아닌지 boolean값 반환 기능
    public boolean isAnswer() {
        return bridge.isAnswer();
    }

    // 게임 재시작 여부 boolean값 반환 기능
    public boolean retry(String input) {
        if (input.equals(Setting.RETRY_BUTTON)) {
            return false;
        }
        return true;
    }

    // Bridge 객체 반환
    public Bridge getBridge() {
        return this.bridge;
    }
}
