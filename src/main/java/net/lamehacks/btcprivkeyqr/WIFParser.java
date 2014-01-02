package net.lamehacks.btcprivkeyqr;

import java.util.ArrayList;

public class WIFParser {

    public static ArrayList<String[]> parseWIFtext(String walletText){
         ArrayList<String[]> keyAddressPairs = new ArrayList<String[]>();
        
        String trimedInputString = walletText.trim();
        String[] lines = trimedInputString.split("\n");

        for (String line : lines) {
            String trimedLine = line.trim();
            if(trimedLine.equals("") || trimedLine.charAt(0)=='#'){
                continue;
            }
            String trimedLineWithoutTabs = trimedLine.replace('\t', ' ');
            String privKeyWIF = trimedLineWithoutTabs.split(" ")[0];
            String address = BtcUtils.getb58AddressFromb58PrivKey(privKeyWIF);
            keyAddressPairs.add(new String[]{privKeyWIF,address});
            
        }
        return keyAddressPairs;
    }
    
}
