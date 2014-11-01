package fr.w3blog.zpl.model.element;

import junit.framework.TestCase;
import fr.w3blog.zpl.model.element.ZebraBarCode128;

public class ZebraBarCode128Test extends TestCase {

    public void testZplOutput() {
        ZebraBarCode128 barcode = new ZebraBarCode128(70, 1000, "0235600703875191516022937128", 190, false, 4, 2);
        assertEquals("^FT70,1000\n^BY4,2,190\n^BCN,190,N,N,N\n^FD0235600703875191516022937128^FS\n", barcode.getZplCode(null));
    }
}
