package fr.w3blog.zpl.utils;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.net.SocketTimeoutException;
import java.util.List;

import javax.print.Doc;
import javax.print.DocFlavor;
import javax.print.DocPrintJob;
import javax.print.PrintException;
import javax.print.PrintService;
import javax.print.PrintServiceLookup;
import javax.print.SimpleDoc;
import javax.print.attribute.PrintServiceAttribute;
import javax.print.attribute.standard.PrinterName;

import fr.w3blog.zpl.model.ZebraLabel;
import fr.w3blog.zpl.model.ZebraPrintException;
import fr.w3blog.zpl.model.ZebraPrintNotFoundException;

/**
 * Utilities to print zpl
 * 
 * @author ttropard
 * 
 */
public class ZebraUtils {

	private static final int DEFAULT_TIMEOUT = 0;

	/**
	 * Function to print code Zpl to network zebra
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
	public static void printZpl(String zpl, String ip, int port, int timeout) throws ZebraPrintException {
		try {
			try (Socket clientSocket = new Socket()) {
			    InetSocketAddress address = new InetSocketAddress(ip, port);
			    clientSocket.connect(address, timeout);
				clientSocket.setSoTimeout(timeout);
				DataOutputStream outToServer = new DataOutputStream(clientSocket.getOutputStream());
				outToServer.writeUTF(zpl);
			}
		} catch (SocketTimeoutException socketTimeoutException) {
			throw new ZebraPrintException("Cannot print label on this printer : " + ip + ":" + port + " due to timeout", socketTimeoutException);
		} catch (IOException e1) {
			throw new ZebraPrintException("Cannot print label on this printer : " + ip + ":" + port, e1);
		}
	}
	public static void printZpl(String zpl, String ip, int port) throws ZebraPrintException {
	    printZpl(zpl, ip, port, DEFAULT_TIMEOUT);
    }

	/**
	 * Function to print code Zpl to local zebra(usb)
	 * 
	 * @param zpl
	 *            code Zpl to print
	 * @param printerName
	 *	      name of the selected printer
	 * @throws ZebraPrintException
	 *             if zpl could not be printed
	 */
	public static void printZpl(String zpl, String printerName) throws ZebraPrintException {
		try {

			PrintService psZebra = null;
			String sPrinterName = null;
			PrintService[] services = PrintServiceLookup.lookupPrintServices(null, null);

			for (int i = 0; i < services.length; i++) {
				PrintServiceAttribute attr = services[i].getAttribute(PrinterName.class);
				sPrinterName = ((PrinterName) attr).getValue();
				if (sPrinterName.toLowerCase().indexOf(printerName.toLowerCase()) >= 0) {
					psZebra = services[i];
					break;
				}
			}

			if (psZebra == null) {
				throw new ZebraPrintNotFoundException("Zebra printer not found : " + printerName);
			}
			DocPrintJob job = psZebra.createPrintJob();

			byte[] by = zpl.getBytes();
			DocFlavor flavor = DocFlavor.BYTE_ARRAY.AUTOSENSE;
			Doc doc = new SimpleDoc(by, flavor, null);
			job.print(doc, null);

		} catch (PrintException e) {
			throw new ZebraPrintException("Cannot print label on this printer : " + printerName, e);
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
	public static void printZpl(ZebraLabel zebraLabel, String ip, int port, int timeOut) throws ZebraPrintException {
		printZpl(zebraLabel.getZplCode(), ip, port, timeOut);
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
	public static void printZpl(ZebraLabel zebraLabel, String printerName) throws ZebraPrintException {
		printZpl(zebraLabel.getZplCode(), printerName);
	}

	/**
	 * Fonction to print multiple zebraLabel to network printer
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

	/**
	 * Fonction to print multiple zebraLabel to local printer
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
	public static void printZpl(List<ZebraLabel> zebraLabels, String printerName) throws ZebraPrintException {
		StringBuilder zpl = new StringBuilder();
		for (ZebraLabel zebraLabel : zebraLabels) {
			zpl.append(zebraLabel.getZplCode());
		}
		printZpl(zpl.toString(), printerName);
	}

}
