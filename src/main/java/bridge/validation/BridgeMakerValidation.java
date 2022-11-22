package bridge.validation;

import java.util.List;

import static bridge.validation.ErrorMessage.*;

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
                throw new IllegalArgumentException(LOWER_BRIDGE_IF_RANDOM_VALUE_ZERO.getMessage());
            }
        }
    }

    private void validateGeneratedNumOneAndLastBoxUpper(int generatedNum, List<String> bridge) {
        int lastIdx = bridge.size() - 1;

        if (generatedNum == RANDOM_NUM_UPPER) {
            if (! bridge.get(lastIdx).equals(UPPER_BOX)) {
                throw new IllegalArgumentException(UPPER_BRIDGE_IF_RANDOM_VALUE_ONE.getMessage());
            }
        }
    }
}
