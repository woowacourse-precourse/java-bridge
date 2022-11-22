package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BridgeCharacterGeneratorTest {

    @Test
    @DisplayName("다리 한 칸 데이터 생성 테스트")
    void 다리_한_칸_생성_테스트() {
        BridgeCharacterGenerator testGenerator = new BridgeCharacterGenerator();
        assertEquals("D", testGenerator.generate(0));
        assertEquals("U", testGenerator.generate(1));
    }
}