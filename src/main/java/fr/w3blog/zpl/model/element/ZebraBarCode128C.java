package fr.w3blog.zpl.model.element;

import fr.w3blog.zpl.model.PrinterOptions;
import fr.w3blog.zpl.utils.ZplUtils;

/**
 * Element to create a bar code 128 subset C
 * <p>
 * Zpl command ^BC
 * <p>
 * add >; after the ^FD
 *
 * @author foameraserblue
 */
public class ZebraBarCode128C extends ZebraBarCode {

    private boolean checkDigit43 = false;

    public ZebraBarCode128C(int positionX, int positionY, String text) {
        super(positionX, positionY, text);
    }

    public ZebraBarCode128C(int positionX, int positionY, String text, int barCodeHeigth) {
        super(positionX, positionY, text, barCodeHeigth);
    }

    public ZebraBarCode128C(int positionX, int positionY, String text, int barCodeHeigth, int moduleWidth, int wideBarRatio) {
        super(positionX, positionY, text, barCodeHeigth, moduleWidth, wideBarRatio);
    }

    public ZebraBarCode128C(int positionX, int positionY, String text, int barCodeHeigth, boolean showTextInterpretation, int moduleWidth, int wideBarRatio) {
        super(positionX, positionY, text, barCodeHeigth, showTextInterpretation, moduleWidth, wideBarRatio);
    }

    public ZebraBarCode128C(int positionX, int positionY, String text, int barCodeHeigth, boolean showTextInterpretation, int moduleWidth, int wideBarRatio, boolean checkDigit43) {
        super(positionX, positionY, text, barCodeHeigth, showTextInterpretation, moduleWidth, wideBarRatio);
        this.checkDigit43 = checkDigit43;
    }

    public ZebraBarCode128C(int positionX, int positionY, String text, int barCodeHeigth, boolean showTextInterpretation, boolean showTextInterpretationAbove) {
        super(positionX, positionY, text, barCodeHeigth, showTextInterpretation, showTextInterpretationAbove);
    }

    @Override
    public String getZplCode(PrinterOptions printerOptions) {
        StringBuilder zpl = getStartZplCodeBuilder();
        zpl.append(ZplUtils.zplCommandSautLigne("BC", zebraRotation.getLetter(), barCodeHeigth, showTextInterpretation, showTextInterpretationAbove, checkDigit43));
        zpl.append("^FD");
        zpl.append(">;");
        zpl.append(text);
        zpl.append(ZplUtils.zplCommandSautLigne("FS"));
        return zpl.toString();
    }

    public boolean isCheckDigit43() {
        return checkDigit43;
    }

    public void setCheckDigit43(boolean checkDigit43) {
        this.checkDigit43 = checkDigit43;
    }
}
