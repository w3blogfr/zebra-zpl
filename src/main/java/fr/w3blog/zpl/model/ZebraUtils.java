package fr.w3blog.zpl.model;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.util.List;

/**
 * Utilities to print zpl
 * 
 * @author ttropard
 * 
 */
public class ZebraUtils {

	/**
	 * Function to print code Zpl
	 * 
	 * @param zpl
	 *            code Zpl to print
	 * @param ip
	 *            ip adress
	 * @param port
	 *            port
	 * @throws ZebraPrintException
	 *             if zpl could not be printed
	 */
	public static void printZpl(String zpl, String ip, int port) throws ZebraPrintException {
		Socket clientSocket = null;
		try {
			try {
				clientSocket = new Socket(ip, port);
				DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
				outToServer.writeBytes(zpl);
				clientSocket.close();
			} finally {
				if (clientSocket != null) {
					clientSocket.close();
				}
			}
		} catch (IOException e1) {
			throw new ZebraPrintException("Cannot print label on this printer : " + ip + ":" + port, e1);
		}
	}

	/**
	 * Fonction to print zebraLabel
	 * 
	 * @param zebraLabel
	 *            zebraLabel
	 * @param ip
	 *            ip adress
	 * @param port
	 *            port
	 * @throws ZebraPrintException
	 *             if zpl could not be printed
	 */
	public static void printZpl(ZebraLabel zebraLabel, String ip, int port) throws ZebraPrintException {
		printZpl(zebraLabel.getZplCode(), ip, port);
	}

	/**
	 * Fonction to print zebraLabel
	 * 
	 * @param zebraLabels
	 *            list of zebra labels
	 * @param ip
	 *            ip adress
	 * @param port
	 *            port
	 * @throws ZebraPrintException
	 *             if zpl could not be printed
	 */
	public static void printZpl(List<ZebraLabel> zebraLabels, String ip, int port) throws ZebraPrintException {
		StringBuilder zpl = new StringBuilder();
		for (ZebraLabel zebraLabel : zebraLabels) {
			zpl.append(zebraLabel.getZplCode());
		}
		printZpl(zpl.toString(), ip, port);
	}

}
