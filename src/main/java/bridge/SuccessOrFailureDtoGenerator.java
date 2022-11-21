package bridge;

import bridge.dto.SuccessOrFailureDto;
import bridge.generator.FailBridgeStringGenerator;
import bridge.generator.SuccessBridgeStringGenerator;

import java.util.List;

public class SuccessOrFailureDtoGenerator {

    public SuccessOrFailureDto createSuccessDto(List<String> footprints) {
        return new SuccessOrFailureDto(new SuccessBridgeStringGenerator().generate(footprints), "성공");
    }

    public SuccessOrFailureDto createFailDto(List<String> footprints) {
        return new SuccessOrFailureDto(new FailBridgeStringGenerator().generate(footprints), "실패");
    }
}
