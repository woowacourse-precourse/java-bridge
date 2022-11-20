package bridge.validation;

import java.util.List;

public class BridgeMakerValidation {
    public void validateGeneratedNumValue(int generatedNum) {
        if (generatedNum != 0 && generatedNum != 1) {
            throw new IllegalArgumentException("[ERROR] 0 또는 1의 값만 생성되어야 합니다.");
        }
    }

    public void validateCorrespondingBoxAddedToBridge(int generatedNum, List<String> bridge) {
        validateGeneratedNumZeroAndLastBoxLower(generatedNum, bridge);

        if (generatedNum == 1) {
            if (! bridge.get(bridge.size() - 1).equals("U")) {
                throw new IllegalArgumentException("[ERROR] 랜덤값이 1일 경우, 다리에 위 칸이 추가되어야 합니다.");
            }
        }
    }

    public void validateGeneratedNumZeroAndLastBoxLower(int generatedNum, List<String> bridge) {
        int lastIdx = bridge.size() - 1;

        if (generatedNum == 0) {
            if (! bridge.get(lastIdx).equals("D")) {
                throw new IllegalArgumentException("[ERROR] 랜덤값이 0일 경우, 다리에 아래 칸이 추가되어야 합니다.");
            }
        }
    }

}
