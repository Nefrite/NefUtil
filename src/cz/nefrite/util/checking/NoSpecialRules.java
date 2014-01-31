package cz.nefrite.util.checking;

import java.util.Collection;

/**
 * Prázdná implementace pravidel chování. Reakce vychází ze základního chování
 * {@link cz.nefrite.util.Checks}
 * @author Jirka Drozd
 */
public class NoSpecialRules implements CheckRules {

	/** {@inheritDoc } */
	@Override
	public void isNull() {
	}

	/** {@inheritDoc } */
	@Override
	public void isNull(String msg) {
	}

	/** {@inheritDoc } */
	@Override
	public void nullFatal() {
	}

	/** {@inheritDoc } */
	@Override
	public void nullFatal(String msg) {
	}

	/** {@inheritDoc } */
	@Override
	public void nullFatal(int errorID) {
	}

	/** {@inheritDoc } */
	@Override
	public void isEmpty() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/** {@inheritDoc } */
	@Override
	public void isEmpty(String msg) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/** {@inheritDoc } */
	@Override
	public void emptyFatal(Collection c) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/** {@inheritDoc } */
	@Override
	public void emptyFatal(Collection c, int errorID) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	/** {@inheritDoc } */
	@Override
	public void emptyFatal(Collection c, String msg) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
}
