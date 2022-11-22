package bridge.domain.bridge_game;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class NumberOfChallengesTest {

    @ParameterizedTest(name = "increase()를 호출하면 값이 1 증가된 NumberOfChallenges가 반환된다. 입력: {0}")
    @ValueSource(ints = {0, 10, 50})
    void increaseSuccess(int value) {
        NumberOfChallenges numberOfChallenges = new NumberOfChallenges(value);
        NumberOfChallenges increaseNumberOfChallenges = numberOfChallenges.increase();
        assertThat(increaseNumberOfChallenges.value()).isEqualTo(value + 1);
    }
}