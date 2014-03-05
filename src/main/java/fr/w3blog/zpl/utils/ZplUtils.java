package fr.w3blog.zpl.utils;

import fr.w3blog.zpl.constant.ZebraFont;
import fr.w3blog.zpl.constant.ZebraPPP;

/**
 * Common method used to manipulate ZPL
 * 
 * @author ttropard
 * 
 */
public class ZplUtils {

	/**
	 * Fonction called by zplCommand to cast variable object and ajust for zpl code
	 * 
	 * @param object
	 */
	private static String variableObjectToZplCode(Object object) {
		if (object != null) {
			if (object instanceof Integer) {
				return (Integer.toString((Integer) object));
			} else if (object instanceof Boolean) {
				if (((Boolean) object).booleanValue()) {
					return "Y";
				} else {
					return "N";
				}
			} else {
				return object.toString();
			}
		} else {
			return "";
		}
	}

	/**
	 * Method to quickly generate zpl code with command and variable
	 * 
	 * @param command
	 *            Command (without ^)
	 * @param variables
	 *            list variable
	 * @return
	 */
	public static StringBuilder zplCommand(String command) {
		StringBuilder zpl = new StringBuilder();
		zpl.append("^");
		zpl.append(command);
		return zpl;
	}

	/**
	 * Method to quickly generate zpl code with command and variable
	 * 
	 * @param command
	 *            Command (without ^)
	 * @param variables
	 *            list variable
	 * @return
	 */
	public static StringBuilder zplCommandSautLigne(String command) {
		StringBuilder zpl = zplCommand(command);
		zpl.append("\n");
		return zpl;
	}

	/**
	 * Method to quickly generate zpl code with command and variable
	 * 
	 * @param command
	 *            Command (without ^)
	 * @param variables
	 *            list variable
	 * @return
	 */
	public static StringBuilder zplCommand(String command, Object... variables) {
		StringBuilder zpl = new StringBuilder();
		zpl.append("^");
		zpl.append(command);
		if (variables.length > 1) {
			zpl.append(variableObjectToZplCode(variables[0]));
			for (int i = 1; i < variables.length; i++) {
				zpl.append(",");
				zpl.append(variableObjectToZplCode(variables[i]));
			}
		} else if (variables.length == 1) {
			//Only one element in variables
			zpl.append(variableObjectToZplCode(variables[0]));
		}
		return zpl;
	}

	/**
	 * Method to quickly generate zpl code with command and variable
	 * 
	 * @param command
	 *            Command (without ^)
	 * @param variables
	 *            list variable
	 * @return
	 */
	public static StringBuilder zplCommandSautLigne(String command, Object... variables) {
		StringBuilder zpl = zplCommand(command, variables);
		zpl.append("\n");
		return zpl;
	}

	/**
	 * Extract from font, fontSize and PPP the height and width in dots.
	 * 
	 * Fonts and PPP are not all supported.
	 * Please complete this method or use dot in yous params
	 * 
	 * @param zebraFont
	 * @param fontSize
	 * @param zebraPPP
	 * @return array[height,width] in dots
	 */
	public static Integer[] extractDotsFromFont(ZebraFont zebraFont, int fontSize, ZebraPPP zebraPPP) {
		Integer[] array = new Integer[2];

		if (ZebraFont.ZEBRA_ZERO.equals(zebraFont) && ZebraPPP.DPI_300.equals(zebraPPP)) {
			//We use ratio to converted (based on ratio used by Zebra Designer Tools)
			array[0] = Math.round(fontSize * 4.16F);//Heigth
			array[1] = Math.round(fontSize * 4.06F);//With
		} else {
			throw new UnsupportedOperationException("This PPP and this font are not yet supported. Please use ZebraAFontElement.");
		}
		return array;
	}

	/**
	 * Convert point(pt) in pixel(px)
	 * 
	 * @param point
	 * @return
	 */
	public static Integer convertPointInPixel(int point) {
		return Math.round(point * 1.33F);
	}

	/**
	 * Function used to converted ASCII >127 in \hexaCode accepted by ZPL language
	 * 
	 * @param str
	 *            str
	 * @return string with charactere remove
	 */
	public static String convertAccentToZplAsciiHexa(String str) {
		if (str != null) {
			str = str.replace("é", "\\82");
			str = str.replace("à", "\\85");
			str = str.replace("è", "\\8A");
		}
		return str;
	}
}
