package bridge;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import static org.assertj.core.api.Assertions.assertThat;

class UserResultTest {
    @Test
    void createUpperResultByUserResult() {
        UserResult userResult = new UserResult();
        String expect = "[ O |   | O |   ]";

        userResult.plusResult("U", true);
        userResult.plusResult("D", true);
        userResult.plusResult("U", true);
        userResult.plusResult("D", false);

        assertThat(userResult.getFinalUpperResult()).isEqualTo(expect);
    }

    @Test
    void createLowerResultByUserResult() {
        UserResult userResult = new UserResult();
        String expect = "[   | O |   | X ]";

        userResult.plusResult("U", true);
        userResult.plusResult("D", true);
        userResult.plusResult("U", true);
        userResult.plusResult("D", false);

        assertThat(userResult.getFinalLowerResult()).isEqualTo(expect);
    }
}