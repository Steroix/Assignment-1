public class Mission {
    private BaseStation sourceBaseStation;
    private BaseStation middleBaseStation;
    private BaseStation destinationBaseStation;
    private int loadFromSource;
    private int loadFromMiddle;
    private DoublyLinkedList<Integer> dropOffIndices;

    public Mission(String sourceBaseStation, String middleBaseStation, String destinationBaseStation,
                   int loadFromSource, int loadFromMiddle, DoublyLinkedList<Integer> dropOffIndices) {
        this.sourceBaseStation= new BaseStation(sourceBaseStation);
        this.middleBaseStation= new BaseStation(middleBaseStation);
        this.destinationBaseStation= new BaseStation(destinationBaseStation);
        this.loadFromSource= loadFromSource;
        this.loadFromMiddle=loadFromMiddle;
        this.dropOffIndices = dropOffIndices;
    }

    public String getSourceBaseStation() {
        return sourceBaseStation.getCity();
    }

    public String getMiddleBaseStation() {
        return middleBaseStation.getCity();
    }

    public String getDestinationBaseStation() {
        return destinationBaseStation.getCity();
    }

    public int getLoadFromSource() {
        return loadFromSource;
    }

    public int getLoadFromMiddle() {
        return loadFromMiddle;
    }

    public DoublyLinkedList<Integer> getDropOffIndices() {
        return dropOffIndices;
    }
    public void setSourceBaseStation(BaseStation sourceBaseStation) {
        this.sourceBaseStation = sourceBaseStation;
    }
    public void setMiddleBaseStation(BaseStation middleBaseStation) {
        this.middleBaseStation = middleBaseStation;
    }
    public void setDestinationBaseStation(BaseStation destinationBaseStation) {
        this.destinationBaseStation = destinationBaseStation;
    }
    public void setLoadFromSource(int loadFromSource) {
        this.loadFromSource = loadFromSource;
    }
    public void setLoadFromMiddle(int loadFromMiddle) {
        this.loadFromMiddle = loadFromMiddle;
    }
    public void setDropOffIndices(DoublyLinkedList<Integer> dropOffIndices) {
        this.dropOffIndices = dropOffIndices;
    }

}
