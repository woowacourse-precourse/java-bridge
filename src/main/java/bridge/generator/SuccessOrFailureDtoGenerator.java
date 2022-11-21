package bridge.generator;

import bridge.dto.SuccessOrFailureDto;

import java.util.List;

public class SuccessOrFailureDtoGenerator {

    public SuccessOrFailureDto createSuccessDto(List<String> footprints) {
        return new SuccessOrFailureDto(new SuccessBridgeStringGenerator().generate(footprints), "성공");
    }

    public SuccessOrFailureDto createFailDto(List<String> footprints) {
        return new SuccessOrFailureDto(new FailBridgeStringGenerator().generate(footprints), "실패");
    }
}
