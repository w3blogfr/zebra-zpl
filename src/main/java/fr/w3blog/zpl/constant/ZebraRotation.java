package fr.w3blog.zpl.constant;

public enum ZebraRotation {

	NORMAL("N"), ROTATE_90("R"), INVERTED("I"), READ_FROM_BOTTOM("B");

	String letter;

	private ZebraRotation(String letter) {
		this.letter = letter;
	}

	/**
	 * @return the letter
	 */
	public String getLetter() {
		return letter;
	}

}
