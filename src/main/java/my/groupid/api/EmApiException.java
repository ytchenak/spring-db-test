package my.groupid.api;


public class EmApiException extends Exception{
	/**
	 * 
	 */
	private static final long serialVersionUID = -2174637728997742359L;
	private int majorCode;
	private int minorCode;

	public EmApiException (int major, int minor, String message) {
		super(message);
		this.setMajorCode(major);
		this.minorCode = minor;
	}
	
	public EmApiException (String message) {
		super(message);
		this.setMajorCode(99);
		this.setMinorCode(0);
	}	
	

	public EmApiException (Exception ex) {
		super(ex);
		this.setMajorCode(99);
		this.setMinorCode(0);
	}

	public int getMinorCode() {
		return minorCode;
	}

	public void setMinorCode(int minorCode) {
		this.minorCode = minorCode;
	}

	public int getMajorCode() {
		return majorCode;
	}

	public void setMajorCode(int majorCode) {
		this.majorCode = majorCode;
	}

	
	
}
