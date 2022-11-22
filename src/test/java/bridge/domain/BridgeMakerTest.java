package bridge.domain;

import bridge.DownNumberGenerator;
import bridge.UpNumberGenerator;
import bridge.BridgeMaker;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeMakerTest {

    @Test
    @DisplayName("숫자를 입력 받으면 숫자만큼 1또는 0을 생성하고 1은 U로 바꾼 후 0은 D로 변환한 후 List로 반환한다.")
    void makeBridge() {
        BridgeMaker upBridgeMake = new BridgeMaker(new UpNumberGenerator());
        BridgeMaker downBridgeMaker = new BridgeMaker(new DownNumberGenerator());

        List<String> upBridge = upBridgeMake.makeBridge(3);
        List<String> downBridge = downBridgeMaker.makeBridge(3);

        assertAll(() -> assertThat(upBridge).hasSize(3),
                () -> assertThat(upBridge).containsOnly("U"),
                () -> assertThat(downBridge).hasSize(3),
                () -> assertThat(downBridge).containsOnly("D"));
    }
}