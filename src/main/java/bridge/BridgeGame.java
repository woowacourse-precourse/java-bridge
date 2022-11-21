package bridge;

import bridge.domain.UserCharacters;
import bridge.dto.BridgeStatusDto;
import bridge.dto.SuccessOrFailureDto;
import bridge.generator.FailBridgeStringGenerator;
import bridge.generator.SuccessBridgeStringGenerator;

import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final UserCharacters userCharacters;
    private final List<String> bridge;

    private int count=1;

    public BridgeGame(List<String> bridge,List<String> footprints) {
        this.bridge = bridge;
        this.userCharacters= new UserCharacters(footprints);
    }

    /**
     * 사용자가 칸을 이동할 때 사용하는 메서드
     * <p>
     * 이동을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     *
     * @return
     */
    public BridgeStatusDto move(String direction) {
        userCharacters.move(direction);
        return makeBridgeStatusDto();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String command) {
        validateCommand(command);
        if(command.equals("R")){
            count++;
            return true;
        }
        return false;
    }

    public SuccessOrFailureDto createSuccessOrFailureDto() {
        List<String> footprints = userCharacters.getFootprints();
        if (bridge.get(userCharacters.getFootPrintLastIndex()).equals(footprints.get(userCharacters.getFootPrintLastIndex()))) {
            return new SuccessOrFailureDto(new SuccessBridgeStringGenerator().generate(footprints),"성공");
        }
        return new SuccessOrFailureDto(new FailBridgeStringGenerator().generate(footprints),"실패");
    }

    public BridgeStatusDto makeBridgeStatusDto() {
        SuccessOrFailureDto successOrFailureDto = createSuccessOrFailureDto();
        return new BridgeStatusDto(successOrFailureDto.getBridge(), successOrFailureDto.getSuccessOrFailure(), count);
    }


    public boolean moveRetry(){
        if(userCharacters.getFootPrintSize()==bridge.size()) return false;
        return true;
    }

    public boolean isOverallSuccess() {
        return !moveRetry() && makeBridgeStatusDto().getSuccessOrFailure().equals("성공");
    }

    public boolean isUnitSuccess() {
        return moveRetry() && makeBridgeStatusDto().getSuccessOrFailure().equals("성공");
    }
    public void clearFootprints(){
        userCharacters.clearFootprints();
    }

    private void validateCommand(String command) {
        if (!command.equals("Q") && !command.equals("R")) throw new IllegalArgumentException("U나 D를 입력해주십시오");
    }

}
