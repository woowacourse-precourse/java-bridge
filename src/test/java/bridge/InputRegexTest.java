package bridge;

import static org.assertj.core.api.Assertions.*;
import org.junit.jupiter.api.Test;

public class InputRegexTest {

    @Test
    void testBridgeSizeRegexTrue() {
        String input1="1";
        String input2="12";
        String regex=InputRegex.BridgeSize.getRegex();

        assertThat(input1.matches(regex)).isEqualTo(true);
        assertThat(input2.matches(regex)).isEqualTo(true);
    }
    @Test
    void testBridgeSizeRegexFalse() {
        String input1="123";
        String input2="I Love Java";
        String regex=InputRegex.BridgeSize.getRegex();

        assertThat(input1.matches(regex)).isEqualTo(false);
        assertThat(input2.matches(regex)).isEqualTo(false);
    }
    @Test
    void testMovingRegexTrue(){
        String input1="U";
        String input2="D";
        String regex=InputRegex.Moving.getRegex();

        assertThat(input1.matches(regex)).isEqualTo(true);
        assertThat(input2.matches(regex)).isEqualTo(true);

    }
    @Test
    void testMovingRegexFalse(){

        String input1="A";
        String input2="I Love Wooteco";
        String regex=InputRegex.Moving.getRegex();

        assertThat(input1.matches(regex)).isEqualTo(false);
        assertThat(input2.matches(regex)).isEqualTo(false);
    }
    @Test
    void testGameCommandRegexTrue(){
        String input1="R";
        String input2="Q";
        String regex=InputRegex.GameCommand.getRegex();

        assertThat(input1.matches(regex)).isEqualTo(true);
        assertThat(input2.matches(regex)).isEqualTo(true);

    }
    @Test
    void testGameCommandRegexFalse(){
        String input1="D";
        String input2="I Love Java";
        String regex=InputRegex.GameCommand.getRegex();

        assertThat(input1.matches(regex)).isEqualTo(false);
        assertThat(input2.matches(regex)).isEqualTo(false);

    }



}
