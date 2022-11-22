package bridge;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.io.Serializable;
import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {
    private final OutputView outputView = new OutputView();

    @Test
    @DisplayName("paint_map_test")
    void print_map_test(){

        outputView.printMap(Arrays.asList("U","U","D"), Arrays.asList("U", "D", "D"));
    }

    @Test
    @DisplayName("print_result_fail_test")
    void print_result_fail_test(){
        outputView.printResult(3,Arrays.asList("U","U","D"), Arrays.asList("U", "D", "D"));
    }

    @Test
    @DisplayName("print_result_success_test")
    void print_result_success_test(){
        outputView.printResult(3,Arrays.asList("U","U","D"), Arrays.asList("U", "U", "D"));
    }





}