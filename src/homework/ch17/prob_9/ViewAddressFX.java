package homework.ch17.prob_9;

/**
 * Created by 15Cyndaquil on 4/25/2017.
 */
public class ViewAddressFX {

    public static void showAddress(){
        for(int i=0; i<AddressInOut.getTotalAddresses(); i++){
            System.out.println("Name: "+AddressInOut.getFirstNameList().get(i).trim()+" "+AddressInOut.getLastNameList().get(i).trim());
            System.out.println("Street: "+AddressInOut.getBuildingLongList().get(i)+" "+AddressInOut.getStreetList().get(i).trim());
            System.out.println("State: "+AddressInOut.getStateList().get(i).trim()+" City: "+AddressInOut.getCityList().get(i).trim());
            System.out.println("Zip: "+AddressInOut.getZipList().get(i));
            System.out.println("");
        }
    }
}
