package net.lamehacks.btcprivkeyqr;

import com.google.bitcoin.core.AddressFormatException;
import com.google.bitcoin.core.Base58;
import java.util.logging.Level;
import java.util.logging.Logger;
import junit.framework.TestCase;

public class BtcUtilsTest extends TestCase {
    
    public BtcUtilsTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    /**
     * Test of getb58AddressFromb58PrivKey method, of class BtcUtils.
     */
    public void testGetb58AddressFromb58PrivKey() {
        String privKString = "5J8wBGJxiXMyPp3oJ3ffw8CvAYgPyV6tAYDHga22tjqGnkEhKLE";
        System.out.println("Private Key: " + privKString);
        String result = BtcUtils.getb58AddressFromb58PrivKey(privKString);
        System.out.println("Adress: " + result);
        assertEquals(result, "1FZKaok8PeybVQhVcBLVfL21rHKBMntMaE");
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    
    public void testBase58ToHex(){
        String b58ProvKeyExample = "5JrjYMTFcUpu6W64FeE2sjUdWhEUUG3WxtJquPkSq43kdAJn2YH";
        String hexProvKeyExample = BtcUtils.getHexFromb58(b58ProvKeyExample);
        System.out.println("hex:" + hexProvKeyExample);
        assertEquals("808940ee2a9ecb23501e191f76d14e4a1f0f9a4bbccdfcfac655d81bb72f0b4b9f50743a72", hexProvKeyExample);
    }
   
}
