package bridge;

import camp.nextstep.edu.missionutils.test.NsTest;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import java.security.Signature;
import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
public class OutputViewTest extends NsTest {

    OutputView outputView=new OutputView();
    @Override
    protected void runMain(){}

    @DisplayName("입력받은 singleMap이 출력양식에 따라 출력되는지 확인")
    @ParameterizedTest
    @CsvSource(value = {"O O:'[ O |   | O ]'","'OX':[ O | X ]","O:'[ O ]'","OOO:[ O | O | O ]"},delimiter = ':')
    public void success(String value,String expected){
        outputView.printMap(value);
        assertThat(output()).contains(expected);
    }
}
