package bridge.output;

public class MapViewModel {

    private StringBuilder viewBuilder;
    private String viewResult;

    public MapViewModel(StringBuilder viewBuilder, String viewResult) {
        this.viewBuilder = viewBuilder;
        this.viewResult = viewResult;
    }

    public StringBuilder getViewBuilder() {
        return viewBuilder;
    }

    public String getViewResult() {
        return viewResult;
    }
}
