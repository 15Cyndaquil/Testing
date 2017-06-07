package homework.csc202.CoinStack;

import java.text.DecimalFormat;

/**
 * Created by Cyndaquil on 6/1/2017.
 */
public class PrintCoinStacks {
    public static String print(CoinStackInterface penny, CoinStackInterface nickel, CoinStackInterface dime, CoinStackInterface quarter){
        DecimalFormat format = new DecimalFormat("'#'000");
        StringBuilder out = new StringBuilder("");

        int pennySize = 0;
        int nickelSize = 0;
        int dimeSize = 0;
        int quarterSize = 0;

        while(!penny.isEmpty()){            pennySize++;
            penny.pop();}
        while(!nickel.isEmpty()){            nickelSize++;
            nickel.pop();
        }
        while(!dime.isEmpty()){            dimeSize++;
            dime.pop();
        }
        while(!quarter.isEmpty()){            quarterSize++;
            quarter.pop();
        }


        int largestStack = pennySize;
        if(nickelSize>largestStack){largestStack=nickelSize;}
        if(dimeSize>largestStack){largestStack=dimeSize;}
        if(quarterSize>largestStack){largestStack=quarterSize;}

        largestStack=largestStack+4;
        out.append("Penny     Nickel     Dime     Quarter\n");
        out.append("|    |    |    |    |    |    |    |\n");
        for(int i=0; i<largestStack; i++){
            out.append(toPrint(pennySize, largestStack-i)+"    ");
            out.append(toPrint(nickelSize, largestStack-i)+"    ");
            out.append(toPrint(dimeSize, largestStack-i)+"    ");
            out.append(toPrint(quarterSize, largestStack-i)+"\n");
        }
        out.append("|"+format.format(pennySize)+"|    |"+format.format(nickelSize)+"|    |"+format.format(dimeSize)+"|    |"+format.format(quarterSize)+"|\n");
        return out.toString();
    }

    private static String toPrint(int currentCoin, int currentSize){
        if(currentSize<=currentCoin){
            return "|----|";
        }else {
            return "|    |";
        }
    }
}
