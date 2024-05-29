// --------------------------------------------------------------------------------------------------------------------------------------
// Title: Flow Devices Class
// Author: R.Pelin Güryuva  
// ID: 4308104342
// Section: 1
// Assignment: 1
//--------------------------------------------------------------------------------------------------------------------------------------

public class FlowDevices extends PackLoads {
    DoublyLinkedList<PackLoads> loadedPack = new DoublyLinkedList<PackLoads>();
    int deviceID;
    public void setLoadedPack(DoublyLinkedList<PackLoads> loadedPack) {
        this.loadedPack = loadedPack;
    }

    public int getDeviceID() {
        return this.deviceID;
    }

    public void setDeviceID(int deviceID) {
        this.deviceID = deviceID;
    }

    public FlowDevices(int packID, String destination) {
        super(packID, destination);
    }

    public void addLoadedPack(PackLoads pl) {
        loadedPack.add(pl);
    }

    public void removeLoadedPack(int index) {
        loadedPack.deleteAt(index);
    }
    public Node<PackLoads> getLoadedPack(int index) {
        return loadedPack.getNode(index);
    }
    public String toString() {
        return "T" + deviceID;
    }
    
}
