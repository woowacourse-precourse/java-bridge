package bridge;

import static camp.nextstep.edu.missionutils.test.Assertions.assertRandomNumberInRangeTest;
import static camp.nextstep.edu.missionutils.test.Assertions.assertSimpleTest;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.util.Lists.newArrayList;

import camp.nextstep.edu.missionutils.test.NsTest;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DomainTest {
    private OutputView outputView = null;
    private InputView inputView = null;
    @BeforeEach
    void SetUp() {
        outputView= new OutputView();
        inputView = new InputView();
    }

    @DisplayName("다리 길이 3 테스트")
    @Test
    void Length3Test() {
        String testData = "3";
        InputStream in = new ByteArrayInputStream(testData.getBytes());
        System.setIn(in);
        assertThat(inputView.readBridgeSize()).isEqualTo(3);
    }

    @DisplayName("다리 길이 잘못된 값 입력 한글")
    @Test
    void lengthWrongChar() {
        assertThat(inputView.checkMessage("안녕",ErrorMessage.BRIDGELENGTHERROREXCEPTION)).contains("[ERROR]");
    }

    @DisplayName("다리 길이 잘못된 값 입력 숫자")
    @Test
    void lengthWrongNumber() {
        assertThat(inputView.checkMessage("2",ErrorMessage.BRIDGELENGTHERROREXCEPTION)).contains("[ERROR]");
    }


}
