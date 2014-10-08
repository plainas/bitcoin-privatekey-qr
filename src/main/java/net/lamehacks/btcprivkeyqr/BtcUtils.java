
package net.lamehacks.btcprivkeyqr;

import com.google.bitcoin.core.Address;
import com.google.bitcoin.core.AddressFormatException;
import com.google.bitcoin.core.Base58;
import com.google.bitcoin.core.DumpedPrivateKey;
import com.google.bitcoin.core.ECKey;
import com.google.bitcoin.core.NetworkParameters;
import java.util.logging.Level;
import java.util.logging.Logger;


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
    
    public static String getHexFromb58(String b58String){
        try {
            return Base58.decodeToBigInteger(b58String).toString(16);
        } catch (AddressFormatException ex) {
            return "ERROR CONVERTING TO HEX";
        }
    }
    
}
