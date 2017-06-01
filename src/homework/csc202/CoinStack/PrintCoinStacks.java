package homework.csc202.CoinStack;

import java.text.DecimalFormat;

/**
 * Created by Cyndaquil on 6/1/2017.
 */
public class PrintCoinStacks {
    public static String print(CoinStackInterface penny, CoinStackInterface nickel, CoinStackInterface dime, CoinStackInterface quarter){
        DecimalFormat format = new DecimalFormat("'#'000");
        StringBuilder out = new StringBuilder("");
        int largestStack = penny.size();
        if(nickel.size()>largestStack){
            largestStack=nickel.size();
        }
        if(dime.size()>largestStack){
            largestStack=dime.size();
        }
        if(quarter.size()>largestStack){
            largestStack=quarter.size();
        }

        largestStack=largestStack+4;
        out.append("Penny     Nickel     Dime     Quarter\n");
        out.append("|    |    |    |    |    |    |    |\n");
        for(int i=0; i<largestStack; i++){
            out.append(toPrint(penny, largestStack-i)+"    ");
            out.append(toPrint(nickel, largestStack-i)+"    ");
            out.append(toPrint(dime, largestStack-i)+"    ");
            out.append(toPrint(quarter, largestStack-i)+"\n");
        }
        out.append("|"+format.format(penny.size())+"|    |"+format.format(nickel.size())+"|    |"+format.format(dime.size())+"|    |"+format.format(quarter.size())+"|\n");
        return out.toString();
    }

    private static String toPrint(CoinStackInterface currentCoin, int currentSize){
        if(currentSize<=currentCoin.size()){
            return "|----|";
        }else {
            return "|    |";
        }
    }
}
