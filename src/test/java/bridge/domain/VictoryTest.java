package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Victory Enum")
@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class VictoryTest {

    @Test
    void getEnum_메서드는_실패_값을_입력받아_0개인_경우_VICTORY를_반환한다() {
        assertThat(Victory.getEnum(0L)).isEqualTo(Victory.VICTORY);
    }

    @Test
    void getEnum_메서드는_실패_값을_입력받아_1개_이상인_경우_DEFEAT를_반환한다() {
        assertThat(Victory.getEnum(1L)).isEqualTo(Victory.DEFEAT);
    }

    @ParameterizedTest(name = "Victory.{0}의경우 getResult 메서드가 {1}를 반환한다")
    @CsvSource({"VICTORY, 성공", "DEFEAT, 실패"})
    void getResult_메서드는_성공_또는_실패를_반환한다(Victory victory, String result) {
        assertThat(victory.getResult()).isEqualTo(result);
    }
}
