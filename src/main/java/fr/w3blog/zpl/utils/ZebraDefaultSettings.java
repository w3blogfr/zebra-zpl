package fr.w3blog.zpl.utils;

import fr.w3blog.zpl.constant.ZebraFieldPosition;
import fr.w3blog.zpl.constant.ZebraJustification;
import fr.w3blog.zpl.constant.ZebraRotation;

/**
 * This class defined default value that will be applied to all your ZebraElement
 *
 */
public class ZebraDefaultSettings {

	public static ZebraRotation DEFAULT_ZEBRA_ROTATION = ZebraRotation.NORMAL;

	public static ZebraJustification DEFAULT_ZEBRA_JUSTIFICATION = null;

	public static ZebraFieldPosition DEFAULT_ZEBRA_FIELD_POSITION = ZebraFieldPosition.FIELD_TYPESET; // Kept for backward compatibility with previous version
}
