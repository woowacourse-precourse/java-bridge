package bridge.validation;

import java.util.List;

public class BridgeMakerValidation {
    private static final int RANDOM_NUM_LOWER = 0;
    private static final int RANDOM_NUM_UPPER = 1;

    private static final String LOWER_BOX = "D";
    private static final String UPPER_BOX = "U";

    public void validateGeneratedNumValue(int generatedNum) {
        if (generatedNum != RANDOM_NUM_LOWER && generatedNum != RANDOM_NUM_UPPER) {
            throw new IllegalArgumentException("[ERROR] 0 또는 1의 값만 생성되어야 합니다.");
        }
    }

    public void validateCorrespondingBoxAddedToBridge(int generatedNum, List<String> bridge) {
        validateGeneratedNumZeroAndLastBoxLower(generatedNum, bridge);
        validateGeneratedNumOneAndLastBoxUpper(generatedNum, bridge);
    }

    private void validateGeneratedNumZeroAndLastBoxLower(int generatedNum, List<String> bridge) {
        int lastIdx = bridge.size() - 1;

        if (generatedNum == RANDOM_NUM_LOWER) {
            if (! bridge.get(lastIdx).equals(LOWER_BOX)) {
                throw new IllegalArgumentException("[ERROR] 랜덤값이 0일 경우, 다리에 아래 칸이 추가되어야 합니다.");
            }
        }
    }

    private void validateGeneratedNumOneAndLastBoxUpper(int generatedNum, List<String> bridge) {
        int lastIdx = bridge.size() - 1;

        if (generatedNum == RANDOM_NUM_UPPER) {
            if (! bridge.get(lastIdx).equals(UPPER_BOX)) {
                throw new IllegalArgumentException("[ERROR] 랜덤값이 1일 경우, 다리에 위 칸이 추가되어야 합니다.");
            }
        }
    }
}
