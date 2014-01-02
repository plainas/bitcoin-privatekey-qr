
package net.lamehacks.btcprivkeyqr;

import com.google.bitcoin.core.Address;
import com.google.bitcoin.core.AddressFormatException;
import com.google.bitcoin.core.DumpedPrivateKey;
import com.google.bitcoin.core.ECKey;
import com.google.bitcoin.core.NetworkParameters;


public class BtcUtils {

    public static String getb58AddressFromb58PrivKey(String privKey){
        try {
            NetworkParameters networkParameters = NetworkParameters.prodNet();           
            DumpedPrivateKey dumpedPrivateKey = new DumpedPrivateKey(null, privKey);
            ECKey eCKey = dumpedPrivateKey.getKey();
            Address address = eCKey.toAddress(networkParameters);
            return address.toString();
        } catch (AddressFormatException e) {
            return "error";
        }
    }
    
}
