package bridge;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class ResultTest {
    @Test
    void 선택한_방향이_위일떄_결과가_원하는_출력으로_나오는지() {
        Result result = new Result("U", false);
        assertThat(result.getUpper()).isEqualTo("X");
        assertThat(result.getDown()).isEqualTo(" ");
    }

    @Test
    void 선택한_방향이_아래일떄_결과가_원하는_출력으로_나오는지(){
        Result result = new Result("D", true);
        assertThat(result.getUpper()).isEqualTo(" ");
        assertThat(result.getDown()).isEqualTo("O");
    }
}
