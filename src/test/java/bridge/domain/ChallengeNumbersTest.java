package bridge.domain;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class ChallengeNumbersTest {
    @ParameterizedTest(name = "increase()를 호출시 값이 1 증가된 ChallengeNumbers 반환. 입력: {0}")
    @ValueSource(ints = {0, 5, 20})
    void increaseSuccess(int value) {
        ChallengeNumbers challengeNumbers = new ChallengeNumbers(value);
        ChallengeNumbers increaseNumberOfChallenges = challengeNumbers.increase();
        assertThat(increaseNumberOfChallenges.value()).isEqualTo(value + 1);
    }
}