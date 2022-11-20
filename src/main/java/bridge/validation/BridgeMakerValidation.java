package bridge.validation;

import java.util.List;

public class BridgeMakerValidation {
    private static final int RANDOM_NUM_LOWER = 0;
    private static final int RANDOM_NUM_UPPER = 1;

    public void validateGeneratedNumValue(int generatedNum) {
        if (generatedNum != RANDOM_NUM_LOWER && generatedNum != RANDOM_NUM_UPPER) {
            throw new IllegalArgumentException("[ERROR] 0 또는 1의 값만 생성되어야 합니다.");
        }
    }

    public void validateCorrespondingBoxAddedToBridge(int generatedNum, List<String> bridge) {
        validateGeneratedNumZeroAndLastBoxLower(generatedNum, bridge);
        validateGeneratedNumOneAndLastBoxUpper(generatedNum, bridge);
    }

    public void validateGeneratedNumZeroAndLastBoxLower(int generatedNum, List<String> bridge) {
        int lastIdx = bridge.size() - 1;

        if (generatedNum == RANDOM_NUM_LOWER) {
            if (! bridge.get(lastIdx).equals("D")) {
                throw new IllegalArgumentException("[ERROR] 랜덤값이 0일 경우, 다리에 아래 칸이 추가되어야 합니다.");
            }
        }
    }

    public void validateGeneratedNumOneAndLastBoxUpper(int generatedNum, List<String> bridge) {
        int lastIdx = bridge.size() - 1;

        if (generatedNum == RANDOM_NUM_UPPER) {
            if (! bridge.get(lastIdx).equals("U")) {
                throw new IllegalArgumentException("[ERROR] 랜덤값이 1일 경우, 다리에 위 칸이 추가되어야 합니다.");
            }
        }
    }
}
