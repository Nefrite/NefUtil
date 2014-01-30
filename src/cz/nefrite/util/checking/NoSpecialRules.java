package cz.nefrite.util.checking;

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
}
