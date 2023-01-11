package fr.w3blog.zpl.constant;

public enum ZebraFieldPosition {
	/**
	 * Field Origin means that the field block will be filled from top to bottom.
	 * 
	 * Set the field origin, relative to the label home. Set the upper-left corner of the field area by defining points along the x-axis and y-axis independent of the rotation.
	 * 
	 * Increasing the font size causes the text block to increase in size from top to bottom.
	 */
	FIELD_ORIGIN("FO"), 

	/**
	 * Field Typeset for your data takes the baseline origin of the last possible line of text, meaning that the field block will be filled from bottom to top.
	 * 
	 * Set the field position, relative to the home position of the label designated by the ^LH command. The typeset origin of the field is fixed with respect to the contents of the field and does not change with rotation.
	 * 
	 * Increasing the font size causes the text block to increase in size from bottom to top. This could cause a label to print past its top margin.
	 */
	FIELD_TYPESET("FT")
	;

	private String zpl;

	ZebraFieldPosition(String zpl) {
		this.zpl = zpl;
	}

	public String getZpl() {
		return zpl;
	}
}
