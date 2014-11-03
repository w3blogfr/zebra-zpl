package fr.w3blog.zpl.model.element;

import fr.w3blog.zpl.model.PrinterOptions;
import fr.w3blog.zpl.utils.ZplUtils;

/**
 * Element to create a bar code 39
 * 
 * Zpl command : ^B3 and ^BY
 * 
 * @author ttropard
 * 
 */
public class ZebraBarCode39 extends ZebraBarCode {

	private boolean checkDigit43 = false;

	public ZebraBarCode39(int positionX, int positionY, String text, int barCodeHeigth) {
		super(positionX, positionY, text, barCodeHeigth);
	}

	public ZebraBarCode39(int positionX, int positionY, String text, int barCodeHeigth, int barCodeWidth, int wideBarRatio) {
		super(positionX, positionY, text, barCodeHeigth, barCodeWidth, wideBarRatio);
	}

	public ZebraBarCode39(int positionX, int positionY, String text, int barCodeHeigth, int barCodeWidth, int wideBarRatio, boolean checkDigit43) {
		super(positionX, positionY, text, barCodeHeigth, barCodeWidth, wideBarRatio);
		this.setCheckDigit43(checkDigit43);
	}

	public ZebraBarCode39(int positionX, int positionY, String text, int barCodeHeigth, boolean showTextInterpretation, boolean showTextInterpretationAbove) {
		super(positionX, positionY, text, barCodeHeigth, showTextInterpretation, showTextInterpretationAbove);
	}

	@Override
	public String getZplCode(PrinterOptions printerOptions) {
		StringBuilder zpl = getStartZplCodeBuilder();
		zpl.append(ZplUtils.zplCommandSautLigne("B3", zebraRotation.getLetter(), barCodeHeigth, checkDigit43, showTextInterpretation, showTextInterpretationAbove));
		zpl.append("^FD");
		zpl.append(text);
		zpl.append(ZplUtils.zplCommandSautLigne("FS"));
		return zpl.toString();
	}

	public boolean isCheckDigit43() {
		return checkDigit43;
	}

	public ZebraBarCode39 setCheckDigit43(boolean checkDigit43) {
		this.checkDigit43 = checkDigit43;
		return this;
	}

}
