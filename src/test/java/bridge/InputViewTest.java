package bridge;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class InputViewTest {

    @Nested
    @DisplayName("readBridgeSize 테스트")
    class ReadBridgeSizeTest {

        @ParameterizedTest
        @DisplayName("성공")
        @ValueSource(strings = {"3", "4", "19", "20"})
        void readBridgeSize_validInput_returnInt(String string) {
            // given
            InputStream in = new ByteArrayInputStream(string.getBytes());
            InputView inputView = new InputView();

            // when
            System.setIn(in);

            // then
            Assertions.assertThat(inputView.readBridgeSize()).isEqualTo(Integer.parseInt(string));
        }
    }
}
