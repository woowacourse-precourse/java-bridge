package bridge;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.RepeatedTest;

class BridgeRandomNumberGeneratorTest {
    private final List<Integer> STANDARD_NUMBER = List.of(1, 0);

    @DisplayName("랜덤한 번호를 생성하면 1과 0 두가지 값을 가진다")
    @RepeatedTest(value = 50, name = " {displayName} : {currentRepetition}/{totalRepetitions}")
    void generateRandomNumber() {
        assertTrue(STANDARD_NUMBER.contains(new BridgeRandomNumberGenerator().generate()));
    }
}