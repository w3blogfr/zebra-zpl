package fr.w3blog.zpl.model.element;

import junit.framework.TestCase;
import fr.w3blog.zpl.model.element.ZebraGraficBox;

public class ZebraGraficBoxTest extends TestCase {

    public void testZplOutput() {
        ZebraGraficBox zebraGraficBox = new ZebraGraficBox(10, 10, 50, 760, 3, "B");
        assertEquals("^FO10,10\n^GB50,760,3,B^FS\n", zebraGraficBox.getZplCode(null));
    }
}
