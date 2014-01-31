package cz.nefrite.util.checking;

import java.util.Collection;

/**
 * Standardní implementace pravidel reakcí na chybové stavy.
 * @author Jirka Drozd
 */
public class StandardRules implements CheckRules {

	/** Standardní zpráva pro výskyt hodnoty {@code null} */
	public static final String IS_NULL_MSG = "The Object can not be null!";
	/** Standardní zpráva pro prázdnou kolekci */
	public static final String IS_EMPTY_MSG = "The Collection can not be null!";

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
		throw new NullPointerException(msg);
	}

	/** {@inheritDoc } */
	@Override
	public void nullFatal(int errorID) {
		throw new NullPointerException("Error " + errorID + ": " + IS_NULL_MSG);
	}

	/** {@inheritDoc } */
	@Override
	public void isEmpty() {
		System.err.println(IS_EMPTY_MSG);
	}

	/** {@inheritDoc } */
	@Override
	public void isEmpty(String msg) {
		System.err.println(msg);
	}

	/** {@inheritDoc } */
	@Override
	public void emptyFatal(Collection c) {
		throw new IllegalStateException(IS_EMPTY_MSG + " (" + c.toString() + ")");
	}

	/** {@inheritDoc } */
	@Override
	public void emptyFatal(Collection c, int errorID) {
		throw new IllegalStateException("Error " + errorID + ": " + IS_EMPTY_MSG + " (" + c.toString() + ")");
	}

	/** {@inheritDoc } */
	@Override
	public void emptyFatal(Collection c, String msg) {
		throw new IllegalStateException(msg);
	}
}
