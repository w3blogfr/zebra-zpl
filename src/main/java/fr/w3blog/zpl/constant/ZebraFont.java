package fr.w3blog.zpl.constant;

public enum ZebraFont {

	ZEBRA_ZERO("0"),
	ZEBRA_ONE("1"),
	ZEBRA_TWO("2"),
	ZEBRA_THREE("3"),
	ZEBRA_FOUR("4"),
	ZEBRA_FIVE("5"),
	ZEBRA_SIX("6"),
	ZEBRA_SEVEN("7"),
	ZEBRA_EIGHT("8"),
	ZEBRA_NINE("9"),
	ZEBRA_TEN("10"),
	ZEBRA_A("A"),
	ZEBRA_B("B"),
	ZEBRA_C("C"),
	ZEBRA_D("D"),
	ZEBRA_F("F"),
	ZEBRA_G("G");

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

	static public ZebraFont getFont(String letter)
	{
		ZebraFont myFont = ZebraFont.ZEBRA_ZERO;
		switch(letter){
			case "0" :
				myFont = ZebraFont.ZEBRA_ZERO;
				break;
			case "A" :
				myFont = ZebraFont.ZEBRA_A;
				break;
			case "B" :
				myFont = ZebraFont.ZEBRA_B;
				break;
			case "C" :
				myFont = ZebraFont.ZEBRA_C;
				break;
			case "D" :
				myFont = ZebraFont.ZEBRA_D;
				break;
			case "F" :
				myFont = ZebraFont.ZEBRA_F;
				break;
			case "G" :
				myFont = ZebraFont.ZEBRA_G;
				break;
			default :
				myFont = ZebraFont.ZEBRA_ZERO;
				break;
		}
		return myFont;
	}
}
