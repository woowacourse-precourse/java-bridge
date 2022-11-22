package bridge.view;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    OutputView outputView;

    @BeforeEach
    void beforeEach() {
        outputView = new OutputView();
    }

    @Test
    void test() {
        StringBuilder sb = new StringBuilder();
        String str = "x";
        sb.append(String.format("%s", str));
        System.out.println(sb.toString());
    }



}