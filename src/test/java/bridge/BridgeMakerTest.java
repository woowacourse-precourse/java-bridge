package bridge;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

/**
 * packageName : bridge
 * fileName : BridgeMakerTest
 * author : gim-yeong-geun
 * date : 2022/11/19
 * description :
 * ===========================================================
 * DATE            AUTHOR             NOTE
 * -----------------------------------------------------------
 * 2022/11/19         gim-yeong-geun          최초 생성
 */
class BridgeMakerTest {

    @Test
    void makeBridge() {
        assertRandomNumberInRangeTest(() -> {
            BridgeRandomNumberGenerator br = new BridgeRandomNumberGenerator();
            BridgeMaker bridgeMaker = new BridgeMaker(br);
            int size = 3;
            List<String> result = new ArrayList<>();
            result = bridgeMaker.makeBridge(size);
            System.out.println(result);
            assertThat(result.toString()).isEqualTo("[U, U, U]");
        },1,1,1);
    }
}