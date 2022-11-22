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
            buffer.get(i).add(BridgeBuffer.START);
        }
    }

    public void addColumn(Column answer){
        if(buffer.get(0).get(buffer.get(0).size()-1) == BridgeBuffer.END){
            setLastBufferToContour();
        }
        buffer.get(answer.getIndex()).add(BridgeBuffer.RIGHT);
        buffer.get(answer.getOppositeIndex()).add(BridgeBuffer.BLANK);
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
        if (buffer.get(0).get(buffer.get(0).size()-1) != BridgeBuffer.END){
            return firstFail(step,bridgeGame);
        }
        setLastBufferToContour();
        buffer.get(bridgeGame.getIndexByColumns(step)).add(BridgeBuffer.BLANK);
        buffer.get(bridgeGame.getOppositeIndexByColumns(step)).add(BridgeBuffer.WRONG);
        addLastBufferToEnd();
        return buffer;
    }
    public List<List<String>> firstFail(int step, BridgeGame bridgeGame){
        buffer.get(bridgeGame.getIndexByColumns(step)).add(BridgeBuffer.WRONG);
        buffer.get(bridgeGame.getOppositeIndexByColumns(step)).add(BridgeBuffer.BLANK);
        addLastBufferToEnd();
        return buffer;
    }


    private void setLastBufferToContour(){
        buffer.get(0).set(buffer.get(0).size()-1,BridgeBuffer.CONTOUR);
        buffer.get(1).set(buffer.get(1).size()-1,BridgeBuffer.CONTOUR);
    }
    private void addLastBufferToContour(){
        buffer.get(0).add(BridgeBuffer.CONTOUR);
        buffer.get(1).add(BridgeBuffer.CONTOUR);
    }
    private void addLastBufferToEnd(){
        buffer.get(0).add(BridgeBuffer.END);
        buffer.get(1).add(BridgeBuffer.END);
    }
    private void setLastBufferToEnd(){
        buffer.get(0).set(buffer.get(0).size()-1,BridgeBuffer.END);
        buffer.get(1).set(buffer.get(1).size()-1,BridgeBuffer.END);
    }
}
