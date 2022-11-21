package bridge;

import bridge.domain.UserCharacters;
import bridge.dto.BridgeStatusDto;
import bridge.dto.SuccessOrFailureDto;
import java.util.List;

/**
 * 다리 건너기 게임을 관리하는 클래스
 */
public class BridgeGame {

    private final UserCharacters userCharacters;
    private final List<String> bridge;
    private SuccessReader successReader = new SuccessReader();

    private int count = 1;

    public BridgeGame(List<String> bridge, List<String> footprints) {
        this.bridge = bridge;
        this.userCharacters = new UserCharacters(footprints);
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

        if (successReader.isUnitSuccess(userCharacters, bridge)) {
            return makeSuccessBridgeStatusDto();
        }
        return makeFailBridgeStatusDto();
    }

    /**
     * 사용자가 게임을 다시 시도할 때 사용하는 메서드
     * <p>
     * 재시작을 위해 필요한 메서드의 반환 타입(return type), 인자(parameter)는 자유롭게 추가하거나 변경할 수 있다.
     */
    public boolean retry(String command) {
        validateCommand(command);

        if (command.equals("R")) {
            count++;
            return true;
        }
        return false;
    }

    public BridgeStatusDto makeSuccessBridgeStatusDto() {
        SuccessOrFailureDto successDto = userCharacters.createSuccessDto();
        return new BridgeStatusDto(successDto.getBridge(), successDto.getSuccessOrFailure(), count);
    }

    public BridgeStatusDto makeFailBridgeStatusDto() {
        SuccessOrFailureDto failDto = userCharacters.createFailDto();
        return new BridgeStatusDto(failDto.getBridge(), failDto.getSuccessOrFailure(), count);
    }

    public boolean isUnitSuccess() {
        return successReader.isUnitSuccess(userCharacters, bridge);
    }

    public boolean isOverallSuccess() {
        return successReader.isOverallSuccess(userCharacters, bridge);
    }

    public void clearFootprints() {
        userCharacters.clearFootprints();
    }

    private void validateCommand(String command) {
        if (!command.equals("Q") && !command.equals("R")) throw new IllegalArgumentException("U나 D를 입력해주십시오");
    }
}
