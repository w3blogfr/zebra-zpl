package fr.w3blog.zpl.model.element;

import fr.w3blog.zpl.constant.ZebraFont;
import fr.w3blog.zpl.constant.ZebraRotation;
import fr.w3blog.zpl.model.PrinterOptions;
import fr.w3blog.zpl.model.ZebraElement;
import fr.w3blog.zpl.utils.ZplUtils;

/**
 * Element to set a font and size (explain in dot).
 * 
 * This command is apply only on the next element (in zebraElements list).
 * 
 * This command could be use when your font and PPP is not yet implemented
 * 
 * @author ttropard
 * 
 */
public class ZebraAFontElement extends ZebraElement {

	private ZebraFont zebraFont;

	private ZebraRotation zebraRotation = ZebraRotation.NORMAL;

	private int dotHeigth;
	private int dotsWidth;

	public ZebraAFontElement(ZebraFont zebraFont) {
		super();
		this.zebraFont = zebraFont;
	}

	public ZebraAFontElement(ZebraFont zebraFont, int dotHeigth, int dotsWidth) {
		super();
		this.zebraFont = zebraFont;
		this.dotHeigth = dotHeigth;
		this.dotsWidth = dotsWidth;
	}

	public ZebraAFontElement(ZebraFont zebraFont, ZebraRotation zebraRotation, int dotHeigth, int dotsWidth) {
		super();
		this.zebraFont = zebraFont;
		this.zebraRotation = zebraRotation;
		this.dotHeigth = dotHeigth;
		this.dotsWidth = dotsWidth;
	}

	/* (non-Javadoc)
	 * @see fr.w3blog.zpl.model.ZebraElement#getZplCode(fr.w3blog.zpl.model.PrinterOptions)
	 */
	@Override
	public String getZplCode(PrinterOptions printerOptions) {
		return ZplUtils.zplCommand("A", zebraFont.getLetter(), zebraRotation.getLetter(), dotHeigth, dotsWidth).toString();
	}
}
