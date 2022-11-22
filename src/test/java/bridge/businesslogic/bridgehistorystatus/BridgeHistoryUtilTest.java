package bridge.businesslogic.bridgehistorystatus;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class BridgeHistoryUtilTest {

    private final BridgeHistoryUtil statusUtil = new BridgeHistoryUtil();

    @Nested
    class CheckLastTest{

        @DisplayName("Last Pick 정답이 아니었을 때, 기존에 저장되어 있던 O가 X로 바뀌어야 한다.")
        @Test
        void checkLast_case1() {
            StringBuilder testBuilder = new StringBuilder().append("O | O");
            statusUtil.checkLast(testBuilder,false);
            assertThat(testBuilder.toString()).isEqualTo("O | X");
        }

        @DisplayName("Last Pick 정답이 아니면서 맨 처음부터 틀렸을 때, 기존에 저장되어 있던 O가 X로 바뀌어야 한다.")
        @Test
        void checkLast_case2() {
            StringBuilder testBuilder = new StringBuilder().append("O");
            statusUtil.checkLast(testBuilder,false);
            assertThat(testBuilder.toString()).isEqualTo("X");
        }

        @DisplayName("Last Pick 이 정답일 때, 여전히 O 인 상태로 남아야 한다.")
        @Test
        void checkLast_case3() {
            StringBuilder testBuilder = new StringBuilder().append("O | O");
            statusUtil.checkLast(testBuilder,true);
            assertThat(testBuilder.toString()).isEqualTo("O | O");
        }

        @DisplayName("Last Pick 이 정답이면서 첫 정답일 때 , 여전히 O 인 상태로 남아야 한다.")
        @Test
        void checkLast_case4() {
            StringBuilder testBuilder = new StringBuilder().append("O");
            statusUtil.checkLast(testBuilder,true);
            assertThat(testBuilder.toString()).isEqualTo("O");
        }

        @DisplayName("testBuilder 에 아무것도 들어있지 않으면, 여전히 비어있는 StringBuilder 를 반환한다.")
        @Test
        void checkLast_case5(){
            StringBuilder testBuilder = new StringBuilder();
            statusUtil.checkLast(testBuilder,true);
            assertThat(testBuilder.toString()).isEqualTo("");
        }
    }


    @Nested
    class CheckLastAndPackingTest{

        @DisplayName("비어 있는 StringBuilder 를 String 으로 내보낼 때, [  ] 이다.")
        @Test
        void checkLastAndPacking_case1(){
            StringBuilder testBuilder = new StringBuilder();
            statusUtil.checkLastAndPacking(testBuilder, true);
            assertThat(testBuilder.toString()).isEqualTo("[  ]");
        }

        @DisplayName("한개의 데이터만 들어 있고 그 데이터가 정답데이터이면, [ O ] 이다.")
        @Test
        void checkLastAndPacking_case2(){
            StringBuilder testBuilder = new StringBuilder("O");
            statusUtil.checkLastAndPacking(testBuilder, true);
            assertThat(testBuilder.toString()).isEqualTo("[ O ]");
        }

        @DisplayName("두개 이상의 데이터가 들어 있고 마지막 데이터가 정답데이터일때")
        @Test
        void checkLastAndPacking_case3(){
            StringBuilder testBuilder = new StringBuilder("O | O");
            statusUtil.checkLastAndPacking(testBuilder, true);
            assertThat(testBuilder.toString()).isEqualTo("[ O | O ]");
        }

        @DisplayName("한개의 데이터만 들어 있고 그 데이터가 정답데이터가 아니면, [ X ] 이다.")
        @Test
        void checkLastAndPacking_case4(){
            StringBuilder testBuilder = new StringBuilder("O");
            statusUtil.checkLastAndPacking(testBuilder, false);
            assertThat(testBuilder.toString()).isEqualTo("[ X ]");
        }

        @DisplayName("두개 이상의 데이터가 들어 있고 마지막 데이터가 정답데이터가 아닐 때")
        @Test
        void checkLastAndPacking_case5(){
            StringBuilder testBuilder = new StringBuilder("O | O");
            statusUtil.checkLastAndPacking(testBuilder, false);
            assertThat(testBuilder.toString()).isEqualTo("[ O | X ]");
        }
    }
    @Nested
    class CheckLineElementsExistsTest{

        @DisplayName("아무것도 없을 때는, | 를 넣어주지 않고 바로 진행한다")
        @Test
        void checkLineElementsExists_case1(){
            StringBuilder testUpLineBuilder = new StringBuilder();
            StringBuilder testDownLineBuilder = new StringBuilder();
            statusUtil.checkLineElementsExists(testUpLineBuilder,testDownLineBuilder);
            assertThat(testUpLineBuilder.toString()).isEqualTo("");
            assertThat(testDownLineBuilder.toString()).isEqualTo("");
        }

        @DisplayName("한쪽(위쪽)이라도 데이터가 있을 때는, | 를 넣어주고 마저 진행한다.")
        @Test
        void checkLineElementsExists_case2(){
            StringBuilder testUpLineBuilder = new StringBuilder("O");
            StringBuilder testDownLineBuilder = new StringBuilder(" ");
            statusUtil.checkLineElementsExists(testUpLineBuilder,testDownLineBuilder);
            assertThat(testUpLineBuilder.toString()).isEqualTo("O | ");
            assertThat(testDownLineBuilder.toString()).isEqualTo("  | ");
        }

        @DisplayName("한쪽(아래쪽)이라도 데이터가 있을 때는, | 를 넣어주고 마저 진행한다.")
        @Test
        void checkLineElementsExists_case3(){
            StringBuilder testUpLineBuilder = new StringBuilder(" ");
            StringBuilder testDownLineBuilder = new StringBuilder("O");
            statusUtil.checkLineElementsExists(testUpLineBuilder,testDownLineBuilder);
            assertThat(testUpLineBuilder.toString()).isEqualTo("  | ");
            assertThat(testDownLineBuilder.toString()).isEqualTo("O | ");
        }
    }
}