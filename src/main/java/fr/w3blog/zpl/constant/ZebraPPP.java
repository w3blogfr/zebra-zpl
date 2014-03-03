package fr.w3blog.zpl.constant;

/**
 * Contante used to define printed precision
 * 
 * @author ttropard
 * 
 */
public enum ZebraPPP {

	DPI_203(8), DPI_300(12), DPI_600(23.5F);

	private float dotByMm;

	private ZebraPPP(float dotByMm) {
		this.dotByMm = dotByMm;
	}

	/**
	 * @return the dotByMm
	 */
	public float getDotByMm() {
		return dotByMm;
	}
}
