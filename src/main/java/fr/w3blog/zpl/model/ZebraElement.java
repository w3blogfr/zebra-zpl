package fr.w3blog.zpl.model;

import fr.w3blog.zpl.utils.ZplUtils;

public abstract class ZebraElement {

	/**
	 * x-axis location (in dots)
	 */
	protected Integer positionX;
	/**
	 * y-axis location (in dots)
	 */
	protected Integer positionY;

	/**
	 * @return the positionX
	 */
	public int getPositionX() {
		return positionX;
	}

	/**
	 * @param positionX
	 *            the positionX to set
	 */
	public ZebraElement setPositionX(int positionX) {
		this.positionX = positionX;
		return this;
	}

	/**
	 * @return the positionY
	 */
	public int getPositionY() {
		return positionY;
	}

	/**
	 * @param positionY
	 *            the positionY to set
	 */
	public ZebraElement setPositionY(int positionY) {
		this.positionY = positionY;
		return this;
	}

	/**
	 * Return Zpl code for this Element
	 * 
	 * @return
	 */
	public String getZplCode(PrinterOptions printerOptions) {
		return "";
	}

	/**
	 * Function used by child class if you want to set position before draw your element.
	 * 
	 * @return
	 */
	protected String getZplCodePosition() {

		StringBuffer zpl = new StringBuffer("");
		if (positionX != null && positionY != null) {
			zpl.append(ZplUtils.zplCommand("FT", positionX, positionY));
		}
		return zpl.toString();

	}
}
