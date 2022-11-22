package bridge.domain.result;

import java.util.ArrayList;
import java.util.List;

public class Map {
    private final List<ResultType> upBlocks = new ArrayList<>();
    private final List<ResultType> downBlocks = new ArrayList<>();

    protected void addUpBlock(ResultType resultType) {
        upBlocks.add(resultType);
        downBlocks.add(ResultType.BLANK);
    }

    protected void addDownBlock(ResultType resultType) {
        downBlocks.add(resultType);
        upBlocks.add(ResultType.BLANK);
    }

    protected void retry() {
        this.upBlocks.clear();
        this.downBlocks.clear();
    }

    @Override
    public String toString() {
        return create(upBlocks) + create(downBlocks);
    }

    private String create(List<ResultType> blocks) {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append("[ ");
        for (int i = 0; i < blocks.size(); i++) {
            if (i > 0) {
                stringBuilder.append(" | ");
            }
            stringBuilder.append(blocks.get(i));
        }
        stringBuilder.append(" ]\n");
        return stringBuilder.toString();
    }
}
