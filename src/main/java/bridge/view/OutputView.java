package bridge.view;

import static bridge.view.Delimiter.closeBracket;
import static bridge.view.Delimiter.joinWithVerticalLine;
import static bridge.view.Delimiter.openBracket;

import bridge.dto.BridgeResponseDto;
import java.util.List;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public class OutputView {

    public static final String START_GAME = "다리 건너기 게임을 시작합니다.";
    public static final String INPUT_SIZE = "다리의 길이를 입력해주세요.";
    public static final String INPUT_MOVING = "이동할 칸을 선택해주세요. (위: U, 아래: D)";
    public static final String INPUT_COMMAND = "게임을 다시 시도할지 여부를 입력해주세요. (재시도: R, 종료: Q)";
    public static final String GAME_RESULT = "최종 게임 결과";
    public static final String SUCCESS_RESULT = "게임 성공 여부: ";
    public static final String TRY_COUNT = "총 시도한 횟수: ";

    public void printMap(BridgeResponseDto bridgeResponseDto) {
        printWithLine(convert(bridgeResponseDto.getUpsideBridge()));
        printWithLine(convert(bridgeResponseDto.getDownsideBridge()));
    }

    public void printResult(int tryCount, String result) {
        printWithLine(SUCCESS_RESULT + result);
        printWithLine(TRY_COUNT + tryCount);
    }

    private String convert(List<String> bridge){
        String sentence = "";
        sentence += openBracket(sentence) + joinWithVerticalLine(bridge) + closeBracket(sentence);
        return sentence;
    }

    public void printWithLine(String message){
        System.out.println(message);
    }
}
