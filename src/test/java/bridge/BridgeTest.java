package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.util.Scanner;


public class BridgeTest {
    BridgeNumberGenerator bridgeNumberGenerator = new BridgeRandomNumberGenerator();
    BridgeMaker bridgeMaker = new BridgeMaker(bridgeNumberGenerator);
    @DisplayName("size에 맞게 List를 생성한다.")
    @Test
    public void bridgeMakerTest1() {
        int num = 5;

        Assertions.assertThat(bridgeMaker.makeBridge(num).size()).isEqualTo(num);
    }
}

class IOTest {
    protected void systemIn(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }
}

class InputTest extends IOTest{
    InputView inputView = new InputView();
    @DisplayName("readMove() 메서드에 U를 입력하면 U가 출력된다.")
    @Test
    public void readMovingTest1() {
        systemIn("U");
        test1();
    }

    void test1() {
        Assertions.assertThat(inputView.readMoving()).isEqualTo("U");
    }

    @DisplayName("readMove() 메서드에 D를 입력하면 D가 출력된다.")
    @Test
    public void readMovingTest2() {
        systemIn("D");
        test2();
    }

    void test2() {
        Assertions.assertThat(inputView.readMoving()).isEqualTo("D");
    }


    @DisplayName("readGameCommand() 메서드에 R를 입력하면 R가 출력된다.")
    @Test
    public void readMovingTest3() {
        systemIn("R");
        test3();
    }

    void test3() {
        Assertions.assertThat(inputView.readGameCommand()).isEqualTo("R");
    }


    @DisplayName("readGameCommand() 메서드에 Q를 입력하면 Q가 출력된다.")
    @Test
    public void readMovingTest4() {
        systemIn("Q");
        test4();
    }

    void test4() {
        Assertions.assertThat(inputView.readGameCommand()).isEqualTo("Q");
    }
}
