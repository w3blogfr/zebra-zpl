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
		assertEquals("^XA\n^MMT\n^XZ\n", zebraLabel.getZplCode());
	}

	/**
	 * Test with only label without element
	 */
	public void testZebraLabelSize()
	{
		ZebraLabel zebraLabel = new ZebraLabel(760, 500);
		assertEquals("^XA\n^MMT\n^PW500\n^LL760\n^XZ\n", zebraLabel.getZplCode());
	}
}
