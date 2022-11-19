package bridge;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OutputViewTest {


    OutputView outputView = new OutputView();


    @Test
    @DisplayName("다리 이동 상태 출력 테스트")
    public void printMapTest() throws Exception{
        Assertions.assertThat(printMap("O   OO",0,3))
                        .isEqualTo("[ O |   |   ]");
        Assertions.assertThat(printMap("O   OO",3,6))
                        .isEqualTo("[   | O | O ]");
    }

    @Test
    @DisplayName("다리 이동 상태 출력 테스트")
    public void printMapTestV2() throws Exception{
        Assertions.assertThat(printMap("O   OX",0,3))
                        .isEqualTo("[ O |   |   ]");
        Assertions.assertThat(printMap("O   OX",3,6))
                        .isEqualTo("[   | O | X ]");
    }

    @Test
    @DisplayName("다리 이동 상태 출력 테스트")
    public void printMapTestV3() throws Exception{
        Assertions.assertThat(printMap("O ",0,1))
                        .isEqualTo("[ O ]");
        Assertions.assertThat(printMap("O ",1,2))
                        .isEqualTo("[   ]");
    }
    @Test
    @DisplayName("다리 이동 상태 출력 테스트")
    public void printMapTestV4() throws Exception{
        Assertions.assertThat(printMap(" X",0,1))
                        .isEqualTo("[   ]");
        Assertions.assertThat(printMap(" X",1,2))
                        .isEqualTo("[ X ]");
    }

    @Test
    @DisplayName("다리 이동 상태 출력 테스트")
    public void printMapTestV5() throws Exception{
        Assertions.assertThat(printMap("OOO   ",0,3))
                        .isEqualTo("[ O | O | O ]");
        Assertions.assertThat(printMap("OOO   ",3,6))
                        .isEqualTo("[   |   |   ]");
    }


    private String printMap(String map,int s,int e){
        StringBuffer builder = new StringBuffer();
        builder.append("[");
        for(int i = s;i < e;i++) {
            builder.append(" " + map.charAt(i) + " ");
            if(i + 1 != e)
                builder.append("|");
        }
        builder.append("]");
        return builder.toString();
    }
}