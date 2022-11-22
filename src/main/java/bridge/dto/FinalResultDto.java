package bridge.dto;

public class FinalResultDto {
    private final boolean isSuccess;
    private final int tryCount;

    public FinalResultDto(boolean isSuccess, int tryCount) {
        this.isSuccess = isSuccess;
        this.tryCount = tryCount;
    }

    public StringBuffer getFinalResult() {
        StringBuffer result = new StringBuffer();
        result.append("\n").append("게임 성공 여부: ");
        result.append(whetherSuccess());
        result.append("총 시도한 횟수: ").append(tryCount);
        return result;
    }

    private String whetherSuccess() {
        if (isSuccess) {
            return "성공\n";
        }
        return "실패\n";
    }
}
