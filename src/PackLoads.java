// --------------------------------------------------------------------------------------------------------------------------------------
// Title: PackLoads Class
// Author: R.Pelin Güryuva  
// ID: 4308104342
// Section: 1
// Assignment: 1
//--------------------------------------------------------------------------------------------------------------------------------------

public class PackLoads {
    private int packID;
    private String destination;

    public PackLoads(int packID, String destination) {
        this.packID = packID;
        this.destination = destination;
    }

    // Getters and Setters for the attributes of the class
    public int getPackID() {
        return packID;
    }

    public void setPackID(int packID) {
        this.packID = packID;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public FlowDevices getFlowDevice() {
        throw new UnsupportedOperationException("Unimplemented method 'getFlowDevice'");
    }
    public String toString() {
        return "P" + packID ;
    }
}
