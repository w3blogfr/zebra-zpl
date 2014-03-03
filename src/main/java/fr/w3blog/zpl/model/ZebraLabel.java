package fr.w3blog.zpl.model;

import java.util.ArrayList;
import java.util.List;

import fr.w3blog.zpl.constant.ZebraFont;
import fr.w3blog.zpl.constant.ZebraPrintMode;
import fr.w3blog.zpl.utils.ZplUtils;

public class ZebraLabel {

	/**
	 * Width explain in dots
	 */
	private Integer width;
	/**
	 * Height explain in dots
	 */
	private Integer height;

	private ZebraPrintMode zebraPrintMode = ZebraPrintMode.TEAR_OFF;

	private PrinterOptions printerOptions = new PrinterOptions();

	private List<ZebraElement> zebraElements = new ArrayList<ZebraElement>();

	public ZebraLabel() {
		super();
		zebraElements = new ArrayList<ZebraElement>();
	}

	public ZebraLabel(PrinterOptions printerOptions) {
		super();
		this.printerOptions = printerOptions;
	}

	public ZebraLabel(int width, int height) {
		super();
		this.width = width;
		this.height = height;
	}

	public ZebraLabel(Integer width, Integer height, PrinterOptions printerOptions) {
		super();
		this.width = width;
		this.height = height;
		this.printerOptions = printerOptions;
	}

	/**
	 * Function to add Element on etiquette.
	 * 
	 * Element is abstract, you should use one of child Element( ZebraText, ZebraBarcode, etc)
	 * 
	 * @param zebraElement
	 * @return
	 */
	public ZebraLabel addElement(ZebraElement zebraElement) {
		zebraElements.add(zebraElement);
		return this;
	}

	/**
	 * Use to define a default Zebra font on the label
	 * 
	 * @param defaultZebraFont
	 *            the defaultZebraFont to set
	 */
	public ZebraLabel setDefaultZebraFont(ZebraFont defaultZebraFont) {
		printerOptions.setDefaultZebraFont(defaultZebraFont);
		return this;
	}

	/**
	 * Use to define a default Zebra font size on the label (11,13,14).
	 * Not explain in dots (convertion is processed by library)
	 * 
	 * @param defaultFontSize
	 *            the defaultFontSize to set
	 */
	public ZebraLabel setDefaultFontSize(Integer defaultFontSize) {
		printerOptions.setDefaultFontSize(defaultFontSize);
		return this;
	}

	/**
	 * @return the width
	 */
	public int getWidth() {
		return width;
	}

	/**
	 * @param width
	 *            the width to set
	 */
	public ZebraLabel setWidth(int width) {
		this.width = width;
		return this;
	}

	/**
	 * @return the height
	 */
	public int getHeight() {
		return height;
	}

	/**
	 * @param height
	 *            the height to set
	 */
	public ZebraLabel setHeight(int height) {
		this.height = height;
		return this;
	}

	/**
	 * @return the zebraPrintMode
	 */
	public ZebraPrintMode getZebraPrintMode() {
		return zebraPrintMode;
	}

	/**
	 * @param zebraPrintMode
	 *            the zebraPrintMode to set
	 */
	public ZebraLabel setZebraPrintMode(ZebraPrintMode zebraPrintMode) {
		this.zebraPrintMode = zebraPrintMode;
		return this;
	}

	/**
	 * @return the zebraElements
	 */
	public List<ZebraElement> getZebraElements() {
		return zebraElements;
	}

	/**
	 * @param zebraElements
	 *            the zebraElements to set
	 */
	public void setZebraElements(List<ZebraElement> zebraElements) {
		this.zebraElements = zebraElements;
	}

	public String getZplCode() {
		StringBuilder zpl = new StringBuilder();

		zpl.append(ZplUtils.zplCommand("XA"));//Start Label
		zpl.append(zebraPrintMode.getZplCode());

		if (width != null) {
			//Define width for label
			zpl.append(ZplUtils.zplCommand("PW", width));
		}

		if (height != null) {
			zpl.append(ZplUtils.zplCommand("LL", height));
		}

		//Default Font and Size
		if (printerOptions.getDefaultZebraFont() != null && printerOptions.getDefaultFontSize() != null) {
			zpl.append(ZplUtils.zplCommand("CF", ZplUtils.extractDotsFromFont(printerOptions.getDefaultZebraFont(), printerOptions.getDefaultFontSize(), printerOptions.getZebraPPP())));
		}

		for (ZebraElement zebraElement : zebraElements) {
			zpl.append(zebraElement.getZplCode(printerOptions));
		}
		zpl.append(ZplUtils.zplCommand("XZ"));//End Label
		return zpl.toString();
	}
}
