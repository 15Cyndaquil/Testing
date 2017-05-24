package homework.bookProblems.ch17.prob_9;

import javafx.scene.control.Alert;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.ArrayList;

/**
 * Created by 15Cyndaquil on 4/25/2017.
 */
public class AddressInOut {
    private static ArrayList<String> firstNameList = new ArrayList<>();
    private static ArrayList<String> lastNameList = new ArrayList<>();
    private static ArrayList<String> streetList = new ArrayList<>();
    private static ArrayList<String> cityList = new ArrayList<>();
    private static ArrayList<String> stateList = new ArrayList<>();

    private static ArrayList<Integer> zipList = new ArrayList<>();

    private static ArrayList<Long> buildingLongList = new ArrayList<>();

    private static int totalAddresses = 0;

    static void loadAddresses() {
        int zipCode = 0;
        long length = 0;
        File dir = new File("src/homework/ch17/prob_9");
        File file = new File(dir, "address.add");

        try {
            RandomAccessFile inout = new RandomAccessFile(file.toString(), "rw");
            length = inout.length() / 150;

            for (int address = 0; address < length; address++) {
                StringBuilder firsNameS = new StringBuilder("");
                StringBuilder lastNameS = new StringBuilder("");
                long buildingLong = 0;
                StringBuilder streetS = new StringBuilder("");
                StringBuilder cityS = new StringBuilder("");
                StringBuilder stateS = new StringBuilder("");

                for (int firstName = 0; firstName < 16; firstName++) {
                    firsNameS.append(inout.readChar());
                }
                for (int lastName = 0; lastName < 16; lastName++) {
                    lastNameS.append(inout.readChar());
                }
                for (int street = 0; street < 16; street++) {
                    streetS.append(inout.readChar());
                }
                for (int city = 0; city < 21; city++) {
                    cityS.append(inout.readChar());
                }
                for (int state = 0; state < 2; state++) {
                    stateS.append(inout.readChar());
                }
                buildingLong = inout.readLong();
                zipCode = inout.readInt();

                addAddress(firsNameS.toString().trim()
                        , lastNameS.toString().trim()
                        , streetS.toString().trim()
                        , cityS.toString().trim()
                        , stateS.toString().trim()
                        , zipCode
                        , buildingLong);
            }

            inout.close();
        } catch (FileNotFoundException e) {

        } catch (IOException e) {

        }
    }

    public static void saveAddresses(){
        File dir = new File("src/homework/ch17/prob_9");
        File file = new File(dir, "address.add");

        try {
            RandomAccessFile inout = new RandomAccessFile(file.toString(), "rw");
            for(int currentAddress = 0; currentAddress<totalAddresses; currentAddress++) {
                StringBuilder firsNameS = new StringBuilder(firstNameList.get(currentAddress));
                StringBuilder lastNameS = new StringBuilder(lastNameList.get(currentAddress));
                long buildingInt = buildingLongList.get(currentAddress);
                StringBuilder streetS = new StringBuilder(streetList.get(currentAddress));
                StringBuilder cityS = new StringBuilder(cityList.get(currentAddress));
                StringBuilder stateS = new StringBuilder(stateList.get(currentAddress));
                int zipCode = zipList.get(currentAddress);
                int length = 0;

                length = 16 - firsNameS.length();
                for (int i = 0; i < length; i++) {
                    firsNameS.append(" ");
                }
                length = 16 - lastNameS.length();
                for (int i = 0; i < length; i++) {
                    lastNameS.append(" ");
                }
                length = 16 - streetS.length();
                for (int i = 0; i < length; i++) {
                    streetS.append(" ");
                }
                length = 21 - cityS.length();
                for (int i = 0; i < length; i++) {
                    cityS.append(" ");
                }

                inout.writeChars(firsNameS.toString() + lastNameS.toString()
                        + streetS.toString() + cityS.toString() + stateS.toString());
                inout.writeLong(buildingInt);
                inout.writeInt(zipCode);
            }
            inout.close();


        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            System.out.println("IOException");
        }
    }

    public static void addAddress(String firstName, String lastName, String street, String city, String state, Integer zip, Long building) {
        if(firstNameList.contains(firstName.trim())&&lastNameList.contains(lastName.trim())
                &&streetList.contains(street.trim())&&cityList.contains(city.trim())
                &&stateList.contains(state.trim())&&zipList.contains(zip)&&buildingLongList.contains(building)){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Duplicate Address");
            alert.setContentText("Address already in book");
            alert.showAndWait();
        }else {
            firstNameList.add(firstName.trim());
            lastNameList.add(lastName.trim());
            streetList.add(street.trim());
            cityList.add(city.trim());
            stateList.add(state.trim());
            zipList.add(zip);
            buildingLongList.add(building);
            totalAddresses++;
        }
    }


    public static ArrayList<String> getFirstNameList() {
        return firstNameList;
    }
    public static ArrayList<String> getLastNameList() {
        return lastNameList;
    }
    public static ArrayList<String> getStreetList() {
        return streetList;
    }
    public static ArrayList<String> getCityList() {
        return cityList;
    }
    public static ArrayList<String> getStateList() {
        return stateList;
    }
    public static ArrayList<Integer> getZipList() {
        return zipList;
    }
    public static ArrayList<Long> getBuildingLongList() {
        return buildingLongList;
    }
    public static int getTotalAddresses() {
        return totalAddresses;
    }
}