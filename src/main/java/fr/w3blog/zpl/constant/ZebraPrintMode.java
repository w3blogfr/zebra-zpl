package fr.w3blog.zpl.constant;

/**
 * Command to determine this action the printer takes after a label or group of label has been printed.
 * 
 * ZPL command : ^MM
 * 
 * @author ttropard
 * 
 */
public enum ZebraPrintMode {

	TEAR_OFF("T"), REWIND("R"), PEEL_OFF_SELECT("P", true), PEEL_OFF_NOSELECT("P", false), CUTTER("C");

	String desiredMode;
	String prePeelSelect;

	private ZebraPrintMode(String desiredMode) {
		this.desiredMode = desiredMode;
		this.prePeelSelect = "";
	}

	private ZebraPrintMode(String desiredMode, boolean prePeelSelectB) {
		this.desiredMode = desiredMode;
		if (prePeelSelectB) {
			prePeelSelect = ",Y";
		} else {
			prePeelSelect = ",N";
		}
	}

	/**
	 * @return the desiredMode
	 */
	public String getDesiredMode() {
		return desiredMode;
	}

	/**
	 * @return the prePeelSelect
	 */
	public String getPrePeelSelect() {
		return prePeelSelect;
	}

	/**
	 * Function which return ^MM command
	 * 
	 * @return
	 */
	public String getZplCode() {
		return "^MM" + desiredMode + prePeelSelect + "\n";
	}
}
