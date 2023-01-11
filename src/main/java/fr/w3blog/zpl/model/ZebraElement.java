package fr.w3blog.zpl.model;

import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics2D;
import java.awt.geom.Rectangle2D;

import fr.w3blog.zpl.constant.ZebraFieldPosition;
import fr.w3blog.zpl.constant.ZebraJustification;
import fr.w3blog.zpl.constant.ZebraPPP;
import fr.w3blog.zpl.constant.ZebraRotation;
import fr.w3blog.zpl.utils.ZebraDefaultSettings;
import fr.w3blog.zpl.utils.ZplUtils;

public abstract class ZebraElement<T extends ZebraElement<T>> {

	/**
	 * x-axis location (in dots)
	 */
	protected Integer positionX;
	/**
	 * y-axis location (in dots)
	 */
	protected Integer positionY;

	/**
	 * justification (left, right or auto)
	 */
	protected ZebraJustification justification = ZebraDefaultSettings.DEFAULT_ZEBRA_JUSTIFICATION;

	/**
	 * See possible value in ZebraFieldPosition.
	 */
	protected ZebraFieldPosition fieldPosition = ZebraDefaultSettings.DEFAULT_ZEBRA_FIELD_POSITION;

	/**
	 * May not manage
	 */
	protected ZebraRotation zebraRotation = ZebraDefaultSettings.DEFAULT_ZEBRA_ROTATION;

	/**
	 * Will draw a default box on the graphic if drawGraphic method is not overload
	 * 
	 */
	protected boolean defaultDrawGraphic = true;

	protected abstract T getThis();


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
			if (justification != null) {
				zpl.append(ZplUtils.zplCommand(fieldPosition.getZpl(), positionX, positionY, justification));
			} else {
				zpl.append(ZplUtils.zplCommand(fieldPosition.getZpl(), positionX, positionY));
			}
		}
		return zpl.toString();
	}

	protected String getZplCodePosition(ZebraPPP zebraPPP) {
		StringBuilder zpl = new StringBuilder("");
		if(zebraPPP != null) {
			float factor = this.scale(zebraPPP);
			if (positionX != null && positionY != null) {
				zpl.append(ZplUtils.zplCommand("FO", Math.round(positionX * factor), Math.round(positionY * factor)));
			}
			return zpl.toString();
		}
		return zpl.toString();
	}

	protected float scale(ZebraPPP zebraPPP) {
		if(zebraPPP != null) {
			return zebraPPP.getDotByMm() / ZebraPPP.values()[0].getDotByMm();
		} else {
			return 1.0f;
		}
	}

	/**
	 * Used to draw label preview.
	 * This method should be overloader by child class.
	 * 
	 * Default draw a rectangle
	 * 
	 * @param printerOptions
	 *            TODO
	 * @param graphic
	 */
	public void drawPreviewGraphic(PrinterOptions printerOptions, Graphics2D graphic) {
		if (defaultDrawGraphic) {
			int top = 0;
			int left = 0;
			if (positionX != null) {
				left = Math.round((positionX / printerOptions.getZebraPPP().getDotByMm()) * 10);
			}
			if (positionY != null) {
				top = Math.round((positionY / printerOptions.getZebraPPP().getDotByMm()) * 10);
			}
			graphic.setColor(Color.BLACK);
			graphic.drawRect(left, top, 100, 20);
			drawTopString(graphic, new Font("Arial", Font.BOLD, 11), "Default", left, top);
		}
	}

	/**
	 * Function to draw Element, based on top position.
	 * 
	 * Default drawString write text on vertical middle (Zebra not)
	 * 
	 * @param graphic
	 * @param font
	 * @param text
	 * @param positionX
	 * @param positionY
	 */
	protected void drawTopString(Graphics2D graphic, Font font, String text, int positionX, int positionY) {
		graphic.setFont(font);
		FontMetrics fm = graphic.getFontMetrics(font);
		Rectangle2D rect = fm.getStringBounds(text, graphic);
		int textHeight = (int) (rect.getHeight());
		positionY = positionY + textHeight;
		graphic.drawString(text, positionX, positionY); // Draw the string.
	}

	// Setters / Getters

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
	 * @return the justification
	 */
	public ZebraJustification getJustification() {
		return justification;
	}

	/**
	 * @param justification
	 *            the justification to set
	 */
	public void setJustification(ZebraJustification justification) {
		this.justification = justification;
	}

	public ZebraFieldPosition getFieldPosition() {
		return fieldPosition;
	}

	public void setFieldPosition(ZebraFieldPosition fieldPositition) {
		this.fieldPosition = fieldPositition;
	}

	public ZebraRotation getZebraRotation() {
		return zebraRotation;
	}

	public void setZebraRotation(ZebraRotation zebraRotation) {
		this.zebraRotation = zebraRotation;
	}

	public void setPositionX(Integer positionX) {
		this.positionX = positionX;
	}

	public void setPositionY(Integer positionY) {
		this.positionY = positionY;
	}

	// Fluent setter

	public T withZebraRotation(ZebraRotation zebraRotation) {
		this.setZebraRotation(zebraRotation);
		return getThis();
	}

	public T withZebraJustification(ZebraJustification zebraJustification) {
		this.setJustification(justification);
		return getThis();
	}

	public T withFieldPosition(ZebraFieldPosition zebraFieldPosition) {
		this.setFieldPosition(zebraFieldPosition);
		return getThis();
	}

	public T withPositionX(Integer positionX) {
		this.setPositionX(positionX);
		return getThis();
	}

	public T withPositionY(Integer positionY) {
		this.setPositionX(positionY);
		return getThis();
	}


}
