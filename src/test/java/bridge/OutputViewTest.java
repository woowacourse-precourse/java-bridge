package bridge;

import bridge.view.OutputView;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

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

    @Test
    @DisplayName("최종 게임 결과 출력 테스트")
    public void printResultV1() throws Exception{
        String map = "OOO   ";
        StringBuffer builder = new StringBuffer();
        int len = map.length();
        builder.append("최종 게임 결과\n");
        builder.append(printMap(map,0,len / 2) + "\n");
        builder.append(printMap(map,len / 2  ,len) +"\n");
        builder.append("\n");
        builder.append("게임 성공 여부: ");
        builder.append(isSuccess(map) + "\n");
        builder.append("총 시도한 횟수: ");
        builder.append(1 + "\n");

        Assertions.assertThat(builder.toString())
                .isEqualTo("최종 게임 결과\n" +
                        "[ O | O | O ]\n" +
                        "[   |   |   ]\n" +
                        "\n" +
                        "게임 성공 여부: 성공\n" +
                        "총 시도한 횟수: 1\n");
    }

    @Test
    @DisplayName("최종 게임 결과 출력 테스트")
    public void printResultV2() throws Exception{
        String map = "OO   X";
        StringBuffer builder = new StringBuffer();
        int len = map.length();
        builder.append("최종 게임 결과\n");
        builder.append(printMap(map,0,len / 2) + "\n");
        builder.append(printMap(map,len / 2  ,len) +"\n");
        builder.append("\n");
        builder.append("게임 성공 여부: ");
        builder.append(isSuccess(map) + "\n");
        builder.append("총 시도한 횟수: ");
        builder.append(3 + "\n");

        Assertions.assertThat(builder.toString())
                .isEqualTo("최종 게임 결과\n" +
                        "[ O | O |   ]\n" +
                        "[   |   | X ]\n" +
                        "\n" +
                        "게임 성공 여부: 실패\n" +
                        "총 시도한 횟수: 3\n");
    }
    private String isSuccess(String map){
        if(map.contains("X"))return "실패";
        return "성공";
    }

}