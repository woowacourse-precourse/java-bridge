package bridge.domain;

import bridge.dto.SuccessOrFailureDto;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class UserCharactersTest {

    @Test
    void getFootPrintSize() {
        UserCharacters userCharacters = new UserCharacters(new ArrayList<>(Arrays.asList("D", "D", "D")));
        assertThat(userCharacters.getFootPrintSize()).isEqualTo(3);
    }

    @Test
    void getFootPrintLastIndex() {
        UserCharacters userCharacters = new UserCharacters(new ArrayList<>(Arrays.asList("D", "D", "D")));
        assertThat(userCharacters.getFootPrintLastIndex()).isEqualTo(2);
    }

    @Test
    void createSuccessDto() {
        UserCharacters userCharacters = new UserCharacters(new ArrayList<>(Arrays.asList("D", "D", "D")));
        SuccessOrFailureDto successDto = new SuccessOrFailureDto("[   |   |   ]\n[ O | O | O ]\n", "성공");
        assertThat(userCharacters.createSuccessDto()).isEqualTo(successDto);
    }

    @Test
    void createFailDto() {
        UserCharacters userCharacters = new UserCharacters(new ArrayList<>(Arrays.asList("D", "D", "D")));
        SuccessOrFailureDto failureDto = new SuccessOrFailureDto("[   |   |   ]\n[ O | O | X ]\n", "실패");
        assertThat(userCharacters.createFailDto()).isEqualTo(failureDto);
    }
}