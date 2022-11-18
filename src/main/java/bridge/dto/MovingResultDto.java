package bridge.dto;

import java.util.List;
import java.util.Objects;

public class MovingResultDto {
    private final List<String> result;
    private final int position;
    private final boolean completeness;

    public MovingResultDto(List<String> result, int position, boolean completeness) {
        this.result = result;
        this.position = position;
        this.completeness = completeness;
    }

    public List<String> getResult() {
        return result;
    }


    public boolean getCompleteness() {
        return completeness;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj instanceof MovingResultDto) {
            MovingResultDto resultDto = (MovingResultDto) obj;

            if (resultDto.result.equals(result) && resultDto.position == position
                    && resultDto.completeness == completeness) {
                return true;
            }
        }

        return false;
    }

    @Override
    public int hashCode() {
        return Objects.hash(result, position, completeness);
    }
}
