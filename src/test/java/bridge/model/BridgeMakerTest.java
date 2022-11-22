package bridge.model;

import bridge.BridgeMaker;
import bridge.BridgeRandomNumberGenerator;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;


public class BridgeMakerTest {
    BridgeMaker bridgeMaker = new BridgeMaker(new BridgeRandomNumberGenerator());

    @Test
    void makeBridgeTest() {
        assertThat(bridgeMaker.makeBridge(2)).hasSize(2).isInstanceOf(List.class);
        assertThat(bridgeMaker.makeBridge(2).get(0)).isInstanceOf(String.class).doesNotContain(returnExceptionAlphabet());
    }// makeBridgeTest

    List<String> returnExceptionAlphabet() {
        List<String> exceptionAlphabet = new ArrayList<>();
        int asciiEnd = 127;
        int asciiStart = 33;
        for (int ascii = asciiStart; ascii < asciiEnd; ascii++) {
            if (ascii == 'D' || ascii == 'U') {
                continue;
            }
            exceptionAlphabet.add(String.valueOf((char) ascii));
        }//for
        return exceptionAlphabet;
    }// returnExceptionAlphabet
}// end class
