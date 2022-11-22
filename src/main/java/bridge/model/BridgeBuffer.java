package bridge.model;

import java.util.ArrayList;
import java.util.List;

public class BridgeBuffer {
    public static final String START = "[";
    public static final String CONTOUR = "|";
    public static final String END = "]";
    public static final String RIGHT = " O ";
    public static final String WRONG = " X ";
    public static final String BLANK = "   ";

    private List<List<String>> buffer;

    public BridgeBuffer(){
        initialize();
    }
    public void clear(){
        buffer.clear();
    }
    public void initialize(){
        buffer = new ArrayList<>();
        for(int i = 0; i < 2; i++){
            buffer.add(new ArrayList<>());
            buffer.get(i).add(START);
        }
    }

    public void addColumn(Column answer){
        if(buffer.get(0).get(buffer.get(0).size()-1) == END){
            setLastBufferToContour();
        }
        buffer.get(answer.getIndex()).add(RIGHT);
        buffer.get(answer.getOppositeIndex()).add(BLANK);
        addLastBufferToContour();
    }

    public List<List<String>> running(){
        setLastBufferToEnd();
        return buffer;
    }
    public List<List<String>> over(){
        return buffer;
    }
    public List<List<String>> fail(int step, BridgeGame bridgeGame){
        if (buffer.get(0).get(buffer.get(0).size()-1) != END){
            return firstFail(step,bridgeGame);
        }
        setLastBufferToContour();
        buffer.get(bridgeGame.getIndexByColumns(step)).add(BLANK);
        buffer.get(bridgeGame.getOppositeIndexByColumns(step)).add(WRONG);
        addLastBufferToEnd();
        return buffer;
    }
    public List<List<String>> firstFail(int step, BridgeGame bridgeGame){
        buffer.get(bridgeGame.getIndexByColumns(step)).add(WRONG);
        buffer.get(bridgeGame.getOppositeIndexByColumns(step)).add(BLANK);
        addLastBufferToEnd();
        return buffer;
    }


    private void setLastBufferToContour(){
        buffer.get(0).set(buffer.get(0).size()-1,CONTOUR);
        buffer.get(1).set(buffer.get(1).size()-1,CONTOUR);
    }
    private void addLastBufferToContour(){
        buffer.get(0).add(CONTOUR);
        buffer.get(1).add(CONTOUR);
    }
    private void addLastBufferToEnd(){
        buffer.get(0).add(END);
        buffer.get(1).add(END);
    }
    private void setLastBufferToEnd(){
        buffer.get(0).set(buffer.get(0).size()-1,END);
        buffer.get(1).set(buffer.get(1).size()-1,END);
    }
}
