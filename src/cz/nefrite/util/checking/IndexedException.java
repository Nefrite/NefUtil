package cz.nefrite.util.checking;

/**
 * Vyjímka obsahující ID chyby
 * @author Jirka Drozd
 */
public class IndexedException extends Exception {

	public static final int DEFAULT_ERR = 0;
	private final int errorID;

	public IndexedException() {
		this(DEFAULT_ERR);
	}

	public IndexedException(String message) {
		super(message);
		errorID = DEFAULT_ERR;
	}

	public IndexedException(String message, Throwable cause) {
		super(message, cause);
		errorID = DEFAULT_ERR;
	}

	public IndexedException(Throwable cause) {
		super(cause);
		errorID = DEFAULT_ERR;
	}

	public IndexedException(int errorID) {
		this.errorID = errorID;
	}

	public IndexedException(int errorID, String message) {
		super(message);
		this.errorID = errorID;
	}

	public IndexedException(int errorID, String message, Throwable cause) {
		super(message, cause);
		this.errorID = errorID;
	}

	public IndexedException(int errorID, Throwable cause) {
		super(cause);
		this.errorID = errorID;
	}
}
