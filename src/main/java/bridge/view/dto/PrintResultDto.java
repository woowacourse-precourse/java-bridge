package bridge.view.dto;

public class PrintResultDto {
    public Boolean isSuccess;
    public Integer gameTry;

    public String result;

    public PrintResultDto(Boolean isSuccess, Integer gameTry) {
        this.isSuccess = isSuccess;
        this.gameTry = gameTry;
    }

    public PrintResultDto(String result) {
        this.result = result;
    }
}
