package bridge.validation;

public class BridgeMakerValidation {
    public void validateGeneratedNumValue(int generatedNum) {
        if (generatedNum != 0 && generatedNum != 1) {
            throw new IllegalArgumentException("[ERROR] 0 또는 1의 값만 생성되어야 합니다.");
        }
    }
}
