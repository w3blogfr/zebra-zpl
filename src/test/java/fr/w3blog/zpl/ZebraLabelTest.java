package fr.w3blog.zpl;

import junit.framework.TestCase;
import fr.w3blog.zpl.model.ZebraLabel;

/**
 * Unit test for simple App.
 */
public class ZebraLabelTest
		extends TestCase
{

	/**
	 * Test with only label without element
	 */
	public void testZebraLabelAlone()
	{
		ZebraLabel zebraLabel = new ZebraLabel();
		assertEquals("^XA\n^MMT\n^XZ", zebraLabel.getZplCode());
	}
}
