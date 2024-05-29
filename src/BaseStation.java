// --------------------------------------------------------------------------------------------------------------------------------------
// Title: Base Station Class
// Author: R.Pelin Güryuva  
// ID: 4308104342
// Section: 1
// Assignment: 1
//--------------------------------------------------------------------------------------------------------------------------------------


class BaseStation {
    private String city;
    private Stack<PackLoads> packLoad;
    private Queue<FlowDevices> flowDevice;

    public BaseStation(String city) {
        flowDevice = new Queue<>();
        packLoad= new Stack<>();
        this.city = city;
    }
    public BaseStation() {
        this.city = "";
        this.packLoad = new Stack<>();
    }

    // Getters and setters for city, packLoad, and flowDevice
    
    
    // Warehouse and cityFlowDevice methods to manage packLoad and flowDevice

    /**
     * @return String return the city
     */
    public String getCity() {
        return city;
    }

    /**
     * @param city the city to set
     */
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * @return Stack<PackLoads> return the packLoad
     */
    public Stack<PackLoads> getPackLoad() {
        return packLoad;
    }

    /**
     * @param packLoad the packLoad to set
     */
    public void pushPackLoad(PackLoads packLoad) {
        this.packLoad.push(packLoad);
    }

    /**
     * @return Queue<FlowDevices> return the flowDevice
     */
    public Queue<FlowDevices> getFlowDevice() {
        return flowDevice;
    }

    /**
     * @param flowDevice the flowDevice to set
     */
    public void setFlowDevice(FlowDevices flowDevice) {
        this.flowDevice.enqueue(flowDevice);
    }
    public void Warehouse(PackLoads pack) {
        packLoad.push(pack); // Add the provided PackLoads object to the packLoad stack
    }
    

}