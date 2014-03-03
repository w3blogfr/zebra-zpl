package fr.w3blog.zpl.model;

import fr.w3blog.zpl.constant.ZebraFont;
import fr.w3blog.zpl.constant.ZebraPPP;

/**
 * Object about printer type and model,sended to each element to adapt zpl (Heigth, Width)
 * 
 * 
 * @author ttropard
 * 
 */
public class PrinterOptions {

	private ZebraPPP zebraPPP = ZebraPPP.DPI_300;

	private ZebraFont defaultZebraFont = null;

	private Integer defaultFontSize = null;

	public PrinterOptions() {
		super();
	}

	public PrinterOptions(ZebraPPP zebraPPP) {
		super();
		this.zebraPPP = zebraPPP;
	}

	/**
	 * @return the zebraPPP
	 */
	public ZebraPPP getZebraPPP() {
		return zebraPPP;
	}

	/**
	 * @param zebraPPP
	 *            the zebraPPP to set
	 */
	public PrinterOptions setZebraPPP(ZebraPPP zebraPPP) {
		this.zebraPPP = zebraPPP;
		return this;
	}

	/**
	 * @return the defaultZebraFont
	 */
	public ZebraFont getDefaultZebraFont() {
		return defaultZebraFont;
	}

	/**
	 * @return the defaultFontSize
	 */
	public Integer getDefaultFontSize() {
		return defaultFontSize;
	}

	/**
	 * @param defaultZebraFont
	 *            the defaultZebraFont to set
	 */
	public PrinterOptions setDefaultZebraFont(ZebraFont defaultZebraFont) {
		this.defaultZebraFont = defaultZebraFont;
		return this;
	}

	/**
	 * @param defaultFontSize
	 *            the defaultFontSize to set
	 */
	public PrinterOptions setDefaultFontSize(Integer defaultFontSize) {
		this.defaultFontSize = defaultFontSize;
		return this;
	}

}
