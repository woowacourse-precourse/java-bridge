package bridge.view;

import bridge.data.dto.responseDto.FinalResultResponseDto;
import bridge.data.dto.responseDto.InGameCommandResponseDto;

/**
 * 사용자에게 게임 진행 상황과 결과를 출력하는 역할을 한다.
 */
public interface OutputView {

    /**
     * 사용자에게 전달할 메시지를 출력한다.
     */
    void printMessage(Object message);

    /**
     * 현재까지 이동한 다리의 상태를 정해진 형식에 맞춰 출력한다.
     */
    void printMap(InGameCommandResponseDto responseDto);

    /**
     * 게임의 최종 결과를 정해진 형식에 맞춰 출력한다.
     */
    void printResult(FinalResultResponseDto responseDto);

}
