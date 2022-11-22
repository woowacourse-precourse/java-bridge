package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class UpAndDownTest {

    @Test
    @DisplayName("랜덤값(0,1)이 주어지면 알맞은 UpAndDown을 찾아 반환할 수 있다.")
    void tryFindUpAndDown() {
        UpAndDown down = UpAndDown.findUpAndDown(0);
        UpAndDown up = UpAndDown.findUpAndDown(1);

        assertThat(down).isEqualTo(UpAndDown.DOWN);
        assertThat(up).isEqualTo(UpAndDown.UP);
    }

    @Test
    @DisplayName("랜덤값(0,1)이 주어지면 알맞은 UpAndDown의 command(D,U)를 찾아 반환할 수 있다.")
    void tryConvertRandomValueToCommand() {
        String upCommand = UpAndDown.convertRandomValueToCommand(1);
        String downCommand = UpAndDown.convertRandomValueToCommand(0);

        assertThat(upCommand).isEqualTo("U");
        assertThat(downCommand).isEqualTo("D");
    }

    @ParameterizedTest
    @CsvSource({"U,true","D,true","u,false","d,false","I,false"})
    @DisplayName("입력값이 주어지면 해당 입력 값이 UpAndDown내에 있는지 확인할 수 있다.")
    void tryIsUpOrDown(String moving, boolean result) {
        boolean isUpOrDown = UpAndDown.isUpOrDown(moving);

        assertThat(isUpOrDown).isEqualTo(result);
    }
}