package bridge.view;

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

    public void printMap(BridgeResponseDto bridgeResponseDto) {
        List<String> upsideBridge = bridgeResponseDto.getUpsideBridge();
        List<String> downsideBridge = bridgeResponseDto.getDownsideBridge();

        System.out.println(upsideBridge);
        System.out.println(downsideBridge);
    }

    public void printResult(int round, boolean isSuccess) {
        System.out.println("게임 성공 여부 :" + isSuccess); // 게임 성공여부에 대한 String
        System.out.println("총 시도한 횟수 :" + round);
    }

    public void print(String message){
        System.out.print(message);
    }

    public void printWithLine(String message){
        System.out.println(message);
    }
}
