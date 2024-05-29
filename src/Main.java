// --------------------------------------------------------------------------------------------------------------------------------------
// Title: Main Class
// Author: R.Pelin Güryuva  
// ID: 4308104342
// Section: 1
// Assignment: 1
//--------------------------------------------------------------------------------------------------------------------------------------


import java.io.File;
import java.io.FileWriter;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        DoublyLinkedList<BaseStation> bState = new DoublyLinkedList<>();
        DoublyLinkedList<Mission> missions = new DoublyLinkedList<>();
        Main mainInstance = new Main();
        mainInstance.readDestinations(bState,
                "src\\destinations.txt");

        // Assign flow devices to base stations
        mainInstance.assignFlowDevices(bState,
                "src\\flowdevices.txt");
        mainInstance.assignLoadPackages(bState, "src\\loads.txt");
        mainInstance.readMissions(missions, "src\\missions.txt");
        processBaseStationsAndMissions(bState, missions);
        writeLastLoopToFile(bState, "src\\resuts.txt");

    }

    public void readDestinations(DoublyLinkedList<BaseStation> bState, String filename) {
        try {
            File file = new File(filename);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String cityName = scanner.nextLine();
                BaseStation bs = new BaseStation(cityName);
                bState.add(bs);
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void assignFlowDevices(DoublyLinkedList<BaseStation> bState, String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                if (parts.length == 3) {
                    String deviceCity = parts[1].trim();
                    String deviceIdString = parts[0].trim().substring(1);
                    int deviceId = Integer.parseInt(deviceIdString);
                    FlowDevices flowDevice = new FlowDevices(deviceId, deviceCity);
                    flowDevice.setDeviceID(deviceId);
                    for (int i = 0; i < bState.size(); i++) {
                        BaseStation baseStation = bState.getNode(i).getElement();
                        if (baseStation.getCity().equals(deviceCity)) {
                            baseStation.setFlowDevice(flowDevice);
                            break; // Once assigned, exit the loop
                        }
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void assignLoadPackages(DoublyLinkedList<BaseStation> baseStations, String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(" ");
                if (parts.length == 2) {
                    String city = parts[1].trim();
                    String packIdString = parts[0].trim().substring(1);
                    int packID = Integer.parseInt(packIdString);

                    PackLoads packLoad = new PackLoads(packID, city);

                    for (int i = 0; i < baseStations.size(); i++) {
                        BaseStation baseStation = baseStations.getNode(i).getElement();
                        if (baseStation.getCity().equals(city)) {
                            baseStation.getPackLoad().push(packLoad); // Push the packLoad to the stack
                            break; // Once assigned, exit the loop
                        }
                    }
                }
            }
            scanner.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void readMissions(DoublyLinkedList<Mission> missions, String fileName) {
        try {
            File file = new File(fileName);
            Scanner scanner = new Scanner(file);

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split("-");
                if (parts.length < 6) {
                    System.out.println("Invalid line format: " + line);
                    continue;
                }

                String sourceBaseStation = parts[0];
                String middleBaseStation = parts[1];
                String destinationBaseStation = parts[2];
                int sourceLoadPackages;
                int middleLoadPackages;
                try {
                    sourceLoadPackages = Integer.parseInt(parts[3]);
                    middleLoadPackages = Integer.parseInt(parts[4]);
                } catch (NumberFormatException e) {
                    System.out.println("Invalid number format in line: " + line);
                    continue;
                }
                DoublyLinkedList<Integer> loadPackageIndices = new DoublyLinkedList<>();
                String[] indices = parts[5].split(",");
                for (int index = 0; index < indices.length; index++) {
                    try {
                        loadPackageIndices.add(Integer.parseInt(indices[index].trim()));
                    } catch (NumberFormatException e) {
                        System.out.println("Invalid index format in line: " + line);
                    }
                }

                missions.add(new Mission(sourceBaseStation, middleBaseStation, destinationBaseStation,
                        sourceLoadPackages, middleLoadPackages, loadPackageIndices));
            }

            scanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("File not found: " + e.getMessage());
        }
    }
    public static void processBaseStationsAndMissions(DoublyLinkedList<BaseStation> bState, DoublyLinkedList<Mission> missions) {
        for (int i = 0; i < bState.size(); i++) {
            BaseStation baseStation = bState.getNode(i).getElement();
            Queue<FlowDevices> flowDevicesQueue = baseStation.getFlowDevice();
            Stack<PackLoads> loadStack = baseStation.getPackLoad();
        }
        for (int i = 0; i < missions.size(); i++) {
            Mission mission = missions.getNode(i).getElement();
            BaseStation sBstat = new BaseStation(mission.getSourceBaseStation());
            BaseStation mBstat = new BaseStation(mission.getMiddleBaseStation());
            BaseStation dBstat = new BaseStation(mission.getDestinationBaseStation());
            DoublyLinkedList<Integer> dropOffIndices = mission.getDropOffIndices();
            for (int j = 0; j < bState.size(); j++) {
                BaseStation station = bState.getNode(j).getElement();
                if(station.getCity().equals(sBstat.getCity())){
                    sBstat=station;
                }
                else if(station.getCity().equals(mBstat.getCity())){
                    mBstat=station;
                }
                else if(station.getCity().equals(dBstat.getCity())){
                    dBstat=station;
                }
            }
            FlowDevices sFlow = sBstat.getFlowDevice().dequeue();
            for (int x = 0; x < mission.getLoadFromSource(); x++) {
                PackLoads pack = sBstat.getPackLoad().pop();
                sFlow.addLoadedPack(pack);
            }
            for (int x = 0; x < mission.getLoadFromMiddle(); x++) {
                PackLoads pack = mBstat.getPackLoad().pop();
                sFlow.addLoadedPack(pack);
            }
            for (int x = 0; x < mission.getDropOffIndices().size(); x++) {
                int index = Integer.parseInt(dropOffIndices.get(x));
                Node<PackLoads> pack = sFlow.getLoadedPack(index);
                mBstat.Warehouse(pack.getElement());
            }
            int index = Integer.parseInt(dropOffIndices.get(0));
            for (int x = 0; x < mission.getDropOffIndices().size(); x++) {
                 sFlow.removeLoadedPack(index);
                 }
            for (int x = 0; x < sFlow.loadedPack.size(); x++) {
                Node<PackLoads> pack = sFlow.getLoadedPack(x);
                dBstat.Warehouse(pack.getElement());
            }
           
            dBstat.getFlowDevice().enqueue(sFlow);
        }
        for (int i = 0; i < bState.size(); i++) {
            BaseStation baseStation = bState.getNode(i).getElement();
            Queue<FlowDevices> flowDevicesQueue = baseStation.getFlowDevice();
            Stack<PackLoads> loadStack = baseStation.getPackLoad();

        }
    }
    public static void writeLastLoopToFile(DoublyLinkedList<BaseStation> bState, String filename) {
        try {
            FileWriter writer = new FileWriter(filename);
            for (int i = 0; i < bState.size(); i++) {
                BaseStation baseStation = bState.getNode(i).getElement();
                Queue<FlowDevices> flowDevicesQueue = baseStation.getFlowDevice();
                Stack<PackLoads> loadStack = baseStation.getPackLoad();
                writer.write(baseStation.getCity() + "\n");
                writer.write("Loads:\n");
                while (!loadStack.isEmpty()) {
                    writer.write(loadStack.pop().toString() + "\n");
                }
                writer.write("Flow Devices:\n");
                while (!flowDevicesQueue.isQueueEmpty()) {
                    writer.write(flowDevicesQueue.dequeue().toString() + "\n");
                }
                writer.write("-------------\n");
            }
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}