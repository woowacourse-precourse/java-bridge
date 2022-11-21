package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ListTest {
    @Test
    @DisplayName("순서가 같으면 같다.")
    void equals_test1(){
        List<Integer> listA = List.of(1, 2, 3);
        List<Integer> listB = List.of(1, 2, 3);
        assertThat(listA.equals(listB)).isEqualTo(true);
    }

    @Test
    @DisplayName("순서가 다르면 같지 않다.")
    void equals_test2(){
        List<Integer> listA = List.of(1, 2, 3);
        List<Integer> listB = List.of(3, 2, 1);
        assertThat(listA.equals(listB)).isEqualTo(false);
    }
}
