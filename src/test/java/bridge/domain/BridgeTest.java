package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.*;

class BridgeTest {

    Bridge bridge;
    private List<Integer> testNumbers;

    @BeforeEach
    void init(){
        testNumbers = new ArrayList<>(Arrays.asList(0,1,0,1));
        bridge = new Bridge(testNumbers.size(),new BridgeTestNumberGenerator(testNumbers));
    }

    @Test
    void createFalseByInputU(){
        assertThat(bridge.isCanCross(0,"U")).isEqualTo(false);
    }

    @Test
    void createTrueBySameInput(){
        List<String> answers = new ArrayList<>(Arrays.asList("D","U","D","U"));
        List<Boolean> actual = new ArrayList<>();
        for (int i = 0; i < answers.size(); i++) {
            actual.add(bridge.isCanCross(i,answers.get(i)));
        }
        assertThat(actual).isEqualTo(List.of(true,true,true,true));
    }

}