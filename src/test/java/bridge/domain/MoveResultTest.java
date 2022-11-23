package bridge.domain;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static bridge.domain.Move.UP;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class MoveResultTest {

    @ParameterizedTest
    @CsvSource({"U,true", "U,false", "D,true", "U,false"})
    void 이동_방향과_성공_여부를_리턴한다(String move, boolean success) {
        //given
        MoveResult result = new MoveResult(move, success);

        //when
        Move resultMove = result.getMove();
        boolean resultSuccess = result.isSuccess();

        //then
        assertThat(resultMove).isEqualTo(Move.from(move));
        assertThat(resultSuccess).isEqualTo(success);
    }
}