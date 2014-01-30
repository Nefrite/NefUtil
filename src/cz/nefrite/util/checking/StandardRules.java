package cz.nefrite.util.checking;

/**
 * Standardní implementace pravidel reakcí na chybové stavy.
 * @author Jirka Drozd
 */
public class StandardRules implements CheckRules {

	public static final String IS_NULL_MSG = "The Object can not be null!";
	
	/** {@inheritDoc } */
	@Override
	public void isNull() {
		System.err.println(IS_NULL_MSG);
	}

	/** {@inheritDoc } */
	@Override
	public void isNull(String msg) {
		System.err.println(msg);
	}

	/** {@inheritDoc } */
	@Override
	public void nullFatal() {
		throw new NullPointerException(IS_NULL_MSG);
	}

	/** {@inheritDoc } */
	@Override
	public void nullFatal(String msg) {
		
	}

	/** {@inheritDoc } */
	@Override
	public void nullFatal(int errorID) {
		throw new NullPointerException("Error " + errorID + ": " + IS_NULL_MSG);
	}

}
