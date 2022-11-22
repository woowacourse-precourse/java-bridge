package bridge.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class MapTest {

    @DisplayName("움직임 기록하기")
    @Test
    void drawMovement() {
        Map map = new Map();
        map.drawMovement("U");
        map.drawMovement("U");
        map.drawMovement("D");

        assertThat(map.getMap()).isEqualTo(List.of("[ O | O |   ]", "[   |   | O ]"));
    }

    @DisplayName("마지막 움직임 실패면 실패로 바꾸기")
    @Test
    void replaceLastToFailMark() {
        Map map = new Map();
        map.drawMovement("U");
        map.drawMovement("U");
        map.drawMovement("D");
        map.replaceLastToFailMark(false);

        assertThat(map.getMap()).isEqualTo(List.of("[ O | O |   ]", "[   |   | X ]"));
    }

    @DisplayName("맵 길이 가져오기")
    @Test
    void getLength() {
        Map map = new Map();
        map.drawMovement("U");
        map.drawMovement("U");

        assertThat(map.getLength()).isEqualTo(2);
    }

    @DisplayName("맵 초기화 하기")
    @Test
    void clear() {
        Map map = new Map();
        map.drawMovement("U");
        map.drawMovement("U");
        map.clear();

        assertThat(map.getMap()).isEqualTo(List.of("[ ]", "[ ]"));
    }

    @DisplayName("실패 마크가 있는지 확인하기")
    @Test
    void hasFailMark(){
        Map map = new Map();
        map.drawMovement("U");
        map.drawMovement("U");
        map.drawMovement("D");
        map.replaceLastToFailMark(false);

        assertThat(map.hasFailMark()).isEqualTo(true);
    }

    @DisplayName("문자열 양쪽에 괄호 넣기")
    @Test
    void addBracket() {
        Map map = new Map();
        String result = map.addBracket("hello", "[", "]");
        assertThat(result).isEqualTo("[hello]");
    }

    @DisplayName("문자열을 구분자로 구분하기")
    @Test
    void sperateByDelimiter() {
        Map map = new Map();
        String result = map.sperateByDelimiter("hello", "!");
        assertThat(result).isEqualTo("h!e!l!l!o");
    }

    @DisplayName("결과를 맵 형식으로 변환하기")
    @Test
    void toMap() {
        Map map = new Map();
        String result = map.toMap("hello");
        assertThat(result).isEqualTo("[ h | e | l | l | o ]");
    }

}



