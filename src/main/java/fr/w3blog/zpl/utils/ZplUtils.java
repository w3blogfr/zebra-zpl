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
			zpl.append(variables[0]);
			for (int i = 1; i < variables.length; i++) {
				zpl.append(",");
				if (variables[i] != null) {
					zpl.append(variables[i]);
				}
			}
		} else if (variables.length == 1) {
			//Only one element in variables
			zpl.append(variables[0]);
		}
		zpl.append("\n");
		return zpl;
	}

	/**
	 * Extract from font, size and PPP the height and width in dots.
	 * 
	 * Fonts and PPP are not all supported.
	 * Please complete this method or use dot in yous params
	 * 
	 * @param zebraFont
	 * @param fontSize
	 * @param zebraPPP
	 * @return array[height,width]
	 */
	public static Integer[] extractDotsFromFont(ZebraFont zebraFont, int fontSize, ZebraPPP zebraPPP) {
		Integer[] array = new Integer[2];

		if (ZebraFont.ZEBRA_ZERO.equals(zebraFont) && ZebraPPP.DPI_300.equals(zebraPPP)) {
			//We use ratio to converted (based on ratio used by Zebra Designer Tools)
			array[0] = Math.round(fontSize * 4.16F);//Heigth
			array[1] = Math.round(fontSize * 4.06F);//With
		} else {
			throw new UnsupportedOperationException("This PPP and this font are not yet supported");
		}
		return array;
	}
}
