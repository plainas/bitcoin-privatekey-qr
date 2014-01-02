package net.lamehacks.btcprivkeyqr;

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
    
}
