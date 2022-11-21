package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

class BridgeRandomNumberGeneratorTest {

    private final BridgeRandomNumberGenerator  bridgeRandomNumberGenerator =
            new BridgeRandomNumberGenerator();

    @Test
    @DisplayName("0 ,1 둘 중 랜덤 출력")
    void generateTest(){
        List<Integer> randomNumbers = new ArrayList<>();
        for (int i = 0 ; i < 100; i++){
            int randomNumber = bridgeRandomNumberGenerator.generate();
            randomNumbers.add(randomNumber);
        }
        randomNumbers.contains(0);
        randomNumbers.contains(1);
    }

}