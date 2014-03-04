package fr.w3blog.zpl;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import junit.framework.TestCase;
import fr.w3blog.zpl.constant.ZebraFont;
import fr.w3blog.zpl.model.ZebraLabel;
import fr.w3blog.zpl.model.ZebraPrintException;
import fr.w3blog.zpl.model.ZebraUtils;
import fr.w3blog.zpl.model.element.ZebraBarCode39;
import fr.w3blog.zpl.model.element.ZebraText;

/**
 * These test will print example on printer 300dpi
 * 
 * Try to print 2 label in same socket
 * 
 * @author ttropard
 * 
 */
public class ZebraPrinterMultipleTest extends TestCase {

	private String ip = "155.132.246.4";
	private int port = 9100;

	/**
	 * Test with many label to print in same socket
	 * 
	 * @throws IOException
	 * @throws ZebraPrintException
	 */
	public void testZebraLibrary1() throws IOException, ZebraPrintException
	{
		ZebraLabel zebraLabel = new ZebraLabel(912, 912);
		zebraLabel.setDefaultZebraFont(ZebraFont.ZEBRA_ZERO);

		zebraLabel.addElement(new ZebraText(10, 84, "Product:", 14));
		zebraLabel.addElement(new ZebraText(395, 85, "Camera", 14));

		zebraLabel.addElement(new ZebraText(10, 161, "CA201212AA", 14));

		zebraLabel.addElement(new ZebraBarCode39(10, 297, "CA201212AA", 118, 2, 2));

		zebraLabel.addElement(new ZebraText(10, 365, "Qté:", 11));
		zebraLabel.addElement(new ZebraText(180, 365, "3", 11));
		zebraLabel.addElement(new ZebraText(317, 365, "QA", 11));

		zebraLabel.addElement(new ZebraText(10, 520, "Ref log:", 11));
		zebraLabel.addElement(new ZebraText(180, 520, "0035", 11));
		zebraLabel.addElement(new ZebraText(10, 596, "Ref client:", 11));
		zebraLabel.addElement(new ZebraText(180, 599, "1234", 11));

		List<ZebraLabel> zebraLabels = new ArrayList<ZebraLabel>();
		zebraLabels.add(zebraLabel);
		zebraLabels.add(zebraLabel);

		ZebraUtils.printZpl(zebraLabels, ip, port);
	}
}
