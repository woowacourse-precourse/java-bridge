package bridge;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class BridgeRandomNumberGeneratorTest {

    @Test
    void 랜덤_숫자_생성() {
        BridgeRandomNumberGenerator ranNumGenerator = new BridgeRandomNumberGenerator();
        List<Integer> ranNums = new ArrayList<>();
        for (int i=0; i<3; i++) {
            ranNums.add(ranNumGenerator.generate());
        }
        System.out.println(ranNums);
    }
}