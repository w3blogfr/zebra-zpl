package fr.w3blog.zpl;

import junit.framework.TestCase;
import fr.w3blog.zpl.utils.ZplUtils;

/**
 * Unit test for simple App.
 */
public class ZebraUtilsTest
		extends TestCase
{

	/**
	 * Test with only label without element
	 */
	public void testZebraLabelAlone() {

		assertEquals("^XA\n", ZplUtils.zplCommand("XA").toString());
		assertEquals("^FT5,6\n", ZplUtils.zplCommand("FT", 5, 6).toString());
		assertEquals("^FT5,,6\n", ZplUtils.zplCommand("FT", 5, null, 6).toString());
	}
}
