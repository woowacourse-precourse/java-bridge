package bridge.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class ResultsTest {
    Results results;
    @BeforeEach
    void setUp(){
        results = new Results();
    }

    @Test
    @DisplayName("addCurrentResult 메소드 테스트")
    void addCurrentResultTest(){
        //Given
        RoundResult roundResult = new RoundResult("U","O");
        //When
        results.addCurrentResult(roundResult);
        //Then
        assertThat(results.getResults().size()).isEqualTo(1);
        assertThat(results.getUp()).isEqualTo("[ O");
        assertThat(results.getDown()).isEqualTo("[  ");
    }
    @Test
    @DisplayName("deleteAll 메소드 테스트")
    void deleteAllTest(){
        //Given
        RoundResult roundResult1 = new RoundResult("U","O");
        RoundResult roundResult2 = new RoundResult("D","X");
        results.addCurrentResult(roundResult1);
        results.addCurrentResult(roundResult2);
        //When
        results.deleteAll();
        //Then
        assertThat(results.getResults().size()).isEqualTo(0);
        assertThat(results.getUp()).isEqualTo("[ ");
        assertThat(results.getDown()).isEqualTo("[ ");

    }

}