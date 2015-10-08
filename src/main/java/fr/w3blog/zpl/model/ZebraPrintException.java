package fr.w3blog.zpl.model;

/**
 * Exception throwed when Socket communication with printer failed
 * 
 * @author ttropard
 * 
 */
public class ZebraPrintException extends Exception {

	/**
	 * Default Constructor
	 * 
	 * @param message
	 *            message
	 */
	public ZebraPrintException(String message) {
		super(message);
	}

	/**
	 * Default Constructor
	 * 
	 * @param message
	 *            message
	 */
	public ZebraPrintException(String message, Throwable t) {
		super(message, t);
	}
}
