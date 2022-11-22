package bridge.domain.bridge;

import static org.assertj.core.api.Assertions.assertThat;

import bridge.BridgeMaker;
import bridge.domain.bridge.maker.BridgeMakerFake;
import bridge.domain.code.BridgePosition;
import bridge.domain.code.SurviveStatus;
import bridge.utils.TestUtils;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class BridgeTest {

    private Bridge bridge;

    @BeforeEach
    void setUp() {
        var fakeGenerator = new BridgeMakerFake(TestUtils.convertStringToListNumber("1,0,1,0"));
        var makeBridge = new BridgeMaker(fakeGenerator);
        var bridgeSize = new BridgeSize("4");
        this.bridge = new Bridge(makeBridge, bridgeSize);
    }

    @AfterEach
    void tearDown() {
        this.bridge = null;
    }

    @Test
    void 한칸을_건널때_생존상태를_반환합니다() {
        assertThat(bridge.next(BridgePosition.UP)).isEqualTo(SurviveStatus.SURVIVE);
        assertThat(bridge.next(BridgePosition.DOWN)).isEqualTo(SurviveStatus.SURVIVE);
        assertThat(bridge.next(BridgePosition.UP)).isEqualTo(SurviveStatus.SURVIVE);
        assertThat(bridge.next(BridgePosition.DOWN)).isEqualTo(SurviveStatus.SURVIVE);
    }

    @Test
    void 한칸을_건널때_생존실패상태를_반환합니다() {
        assertThat(bridge.next(BridgePosition.DOWN)).isEqualTo(SurviveStatus.DIE);
        assertThat(bridge.next(BridgePosition.UP)).isEqualTo(SurviveStatus.DIE);
        assertThat(bridge.next(BridgePosition.DOWN)).isEqualTo(SurviveStatus.DIE);
        assertThat(bridge.next(BridgePosition.UP)).isEqualTo(SurviveStatus.DIE);
    }


}