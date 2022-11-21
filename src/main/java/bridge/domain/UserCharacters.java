package bridge.domain;

import bridge.generator.SuccessOrFailureDtoGenerator;
import bridge.dto.SuccessOrFailureDto;

import java.util.Collections;
import java.util.List;

public class UserCharacters {
    private List<String> footprints;

    private SuccessOrFailureDtoGenerator successBridgeStringGenerator = new SuccessOrFailureDtoGenerator();

    public UserCharacters(List<String> footprints) {
        this.footprints = footprints;
    }

    private void validateDirection(String direction) {
        if (!direction.equals("U") && !direction.equals("D")) throw new IllegalArgumentException("U나 D를 입력해주십시오");
    }

    public void clearFootprints() {
        footprints.clear();
    }

    public void move(String direction) {
        validateDirection(direction);
        footprints.add(direction);
    }

    public int getFootPrintSize() {
        return footprints.size();
    }

    public int getFootPrintLastIndex() {
        return getFootPrintSize() - 1;
    }

    public List<String> getFootprints() {
        return Collections.unmodifiableList(footprints);
    }

    public SuccessOrFailureDto createSuccessDto() {
        return successBridgeStringGenerator.createSuccessDto(footprints);
    }

    public SuccessOrFailureDto createFailDto() {
        return successBridgeStringGenerator.createFailDto(footprints);
    }
}