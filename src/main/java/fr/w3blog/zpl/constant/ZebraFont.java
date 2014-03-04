package fr.w3blog.zpl.constant;

public enum ZebraFont {

	ZEBRA_ZERO("0"), ZEBRA_A("A"), ZEBRA_B("B"), ZEBRA_C("C"), ZEBRA_D("D"), ZEBRA_F("F"), ZEBRA_G("G");

	String letter;

	private ZebraFont(String letter) {
		this.letter = letter;
	}

	/**
	 * @return the letter
	 */
	public String getLetter() {
		return letter;
	}

	/**
	 * Fonction use for preview to find an equivalent font compatible with Graphic2D
	 * 
	 * @param zebraFont
	 * @return
	 */
	public static String findBestEquivalentFontForPreview(ZebraFont zebraFont) {
		return "Arial";
	}

}
