package fr.w3blog.zpl.constant;

/**
 * Command to determine the type of paper used.
 * 
 * ZPL command : ^MN
 * 
 * @author ltrudu
 * 
 */
public enum ZebraPaperType {

	CONTINUOUS("N"), NON_CONTINUOUS_WEB_SENSING("W"), MARK_SENSING("M");

	String desiredMode;
	int	blackMarkOffsetInDots = 0;

	private ZebraPaperType(String desiredMode) {
		this.desiredMode = desiredMode;
		this.blackMarkOffsetInDots = 0;
	}

	private ZebraPaperType(String desiredMode, int blackMarkOffsetInDots)
	{
		this.desiredMode = desiredMode;
		this.blackMarkOffsetInDots = blackMarkOffsetInDots;
	}

	/**
	 * @return the desiredMode
	 */
	public String getDesiredMode() {
		return desiredMode;
	}


	/**
	 * Function which return ^MN command
	 * 
	 * @return
	 */
	public String getZplCode() {
		if(desiredMode.equalsIgnoreCase("M"))
			return "^MN" + desiredMode +"," + blackMarkOffsetInDots + "\n";
		return "^MN" + desiredMode + "\n";
	}

	static public ZebraPaperType getPaperType(String letter)
	{
		ZebraPaperType myPaperType = ZebraPaperType.CONTINUOUS;
		switch(letter){
			case "CONTINUOUS" :
				myPaperType = ZebraPaperType.CONTINUOUS;
				break;
			case "NON_CONTINUOUS_WEB_SENSING" :
				myPaperType = ZebraPaperType.NON_CONTINUOUS_WEB_SENSING;
				break;
			case "MARK_SENSING" :
				myPaperType = ZebraPaperType.MARK_SENSING;
				break;
			default :
				myPaperType = ZebraPaperType.CONTINUOUS;
				break;
		}
		return myPaperType;
	}
}
