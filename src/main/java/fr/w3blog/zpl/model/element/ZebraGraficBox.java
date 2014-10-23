package fr.w3blog.zpl.model.element;

import fr.w3blog.zpl.model.PrinterOptions;
import fr.w3blog.zpl.model.ZebraElement;
import fr.w3blog.zpl.utils.ZplUtils;

/**
 * Zebra element to create a box (or line)
 * 
 * Zpl command : ^GB
 * 
 * @author matthiasvets
 * 
 */
public class ZebraGraficBox extends ZebraElement {

    private Integer width;
    private Integer height;
    private Integer borderTickness;
    private String lineColor;

    public ZebraGraficBox(int positionX, int positionY,Integer width, Integer height, Integer borderTickness,String lineColor) {
        this.positionX = positionX;
        this.positionY = positionY;
        this.width = width;
        this.height = height;
        this.borderTickness = borderTickness;
        this.lineColor = lineColor;
    }


    /* (non-Javadoc)
	 * @see fr.w3blog.zpl.model.element.ZebraElement#getZplCode(fr.w3blog.zpl.model.PrinterOptions)
	 */
	@Override
	public String getZplCode(PrinterOptions printerOptions) {
	    StringBuilder zpl = new StringBuilder();
        zpl.append(getZplCodePosition());
        zpl.append("\n");
        zpl.append(ZplUtils.zplCommand("GB", width, height, borderTickness, lineColor));
        zpl.append("^FS");
        zpl.append("\n");
        return zpl.toString();
	}
	
	protected String getZplCodePosition() {
        StringBuffer zpl = new StringBuffer("");
        if (positionX != null && positionY != null) {
            zpl.append(ZplUtils.zplCommand("FO", positionX, positionY));
        }
        return zpl.toString();
    }

}
