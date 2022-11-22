package bridge.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class ChallengeNumbersTest {
    @ParameterizedTest(name = "increase()를 호출하면 값이 1 증가된 NumberOfChallenges가 반환된다. 입력: {0}")
    @ValueSource(ints = {0, 5, 20})
    void increaseSuccess(int value) {
        ChallengeNumbers numberOfChallenges = new ChallengeNumbers(value);
        ChallengeNumbers increaseNumberOfChallenges = numberOfChallenges.increase();
        assertThat(increaseNumberOfChallenges.value()).isEqualTo(value + 1);
    }
}