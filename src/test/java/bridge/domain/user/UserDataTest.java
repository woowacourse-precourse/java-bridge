package bridge.domain.user;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("유저 데이터 테스트")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class UserDataTest {

    private static final int START_POSITION = 0;
    private static final int INITIAL_TRY_COUNT = 1;

    private UserData userData;

    @BeforeEach
    void 객체_생성() {
        userData = new UserData();
        assertThat(userData).isNotNull();
    }

    @Test
    void 유저_데이터_초기값_테스트() {
        assertThat(userData).extracting("position")
                .isEqualTo(START_POSITION);
        assertThat(userData).extracting("tryCount")
                .isEqualTo(INITIAL_TRY_COUNT);
    }

    @Test
    void 위치_증가_테스트() {
        userData.increasePosition();
        int expected = START_POSITION + 1;
        assertThat(userData).extracting("position")
                .isEqualTo(expected);
    }

    @Test
    void 위치_초기화_테스트() {
        userData.increasePosition();
        userData.increasePosition();
        userData.resetPosition();
        int expected = START_POSITION;
        assertThat(userData).extracting("position")
                .isEqualTo(expected);
    }

    @ParameterizedTest
    @CsvSource(value = {"1,true", "0,false"})
    void 같은_위치_검사_테스트(int position, boolean expected) {
        userData.increasePosition();
        boolean actual = userData.isSamePosition(position);
        assertThat(actual).isEqualTo(expected);
    }

    @Test
    void 시도_횟수_증가_테스트() {
        userData.increaseTryCount();
        int expected = INITIAL_TRY_COUNT + 1;
        assertThat(userData).extracting("tryCount")
                .isEqualTo(expected);
    }
}
