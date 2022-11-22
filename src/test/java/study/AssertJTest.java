package study;

import static org.assertj.core.api.Assertions.as;
import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.assertj.core.api.InstanceOfAssertFactories;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class AssertJTest {

    @DisplayName("List containsOnly 테스트")
    @Test
    void containsOnlyTest() {
        List<String> names = List.of("Minjun", "Peter", "James");
        assertThat(names).containsOnly("Minjun", "Peter", "James");
        // assertThat(names).containsOnly("Minjun", "Peter"); // Error
    }

    @DisplayName("private member를 extracting으로 테스트할 수 있다.")
    @Test
    void extractingTest() {
        Human human = new Human("Minjun", 25, List.of("A", "B", "C"));
        assertThat(human).extracting("name").isEqualTo("Minjun");
        assertThat(human).extracting("age").isEqualTo(25);
        assertThat(human).extracting("friend", as(InstanceOfAssertFactories.LIST))
                .hasSize(3)
                .containsExactly("A", "B", "C");

    }

    @DisplayName("as로 정보 표시하기")
    @Test
    void asInformationTest() {
        int count = 10;
        int expected = 100;
//        assertThat(count).as("check count").isEqualTo(expected); // 실패 시 as 정보 출력
    }
}
