package bridge;

import org.assertj.core.api.Assert;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {

    @DisplayName("문자열 게임에 맞는 출력으로 변환")
    @Test
    void printMap() {
        OutputView.printMap(Arrays.asList("O O"," X "),2);
    }
}