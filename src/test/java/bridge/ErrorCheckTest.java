package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class ErrorCheckTest {

    @Test
    void TestErrorCheckReadBridgeSize() {
        ErrorCheck errorCheck = new ErrorCheck();
        boolean b = errorCheck.errorCheckReadBridgeSize("21");  //x>20
        assertThat(b).isEqualTo(false);
        boolean b2 = errorCheck.errorCheckReadBridgeSize("2");//x<3
        assertThat(b2).isEqualTo(false);
        boolean b3 = errorCheck.errorCheckReadBridgeSize("a");// not a number
        assertThat(b3).isEqualTo(false);
        boolean b4 = errorCheck.errorCheckReadBridgeSize("4");// ok
        assertThat(b4).isEqualTo(true);
    }

    @Test
    void TestErrorCheckReadMovig() {
        ErrorCheck errorCheck = new ErrorCheck();
        boolean u = errorCheck.errorCheckReadMovig("U");
        assertThat(u).isEqualTo(true);
        boolean u2 = errorCheck.errorCheckReadMovig("D");
        assertThat(u2).isEqualTo(true);
        boolean u3 = errorCheck.errorCheckReadMovig("a");
        assertThat(u3).isEqualTo(false);
    }

    @Test
    void TestErrorCheckReadGameCommand() {
        ErrorCheck errorCheck = new ErrorCheck();
        boolean r = errorCheck.errorCheckReadGameCommand("R");
        assertThat(r).isEqualTo(true);
        boolean r2 = errorCheck.errorCheckReadGameCommand("Q");
        assertThat(r2).isEqualTo(true);
        boolean r3 = errorCheck.errorCheckReadGameCommand("a");
        assertThat(r3).isEqualTo(false);
    }
}