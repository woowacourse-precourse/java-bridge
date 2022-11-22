package bridge.dto;

import java.util.ArrayList;
import java.util.List;

public class ResultDto {
    public List<Boolean> result = new ArrayList<>();

    public ResultDto(List<Boolean> result) {
        this.result = result;
    }
}
