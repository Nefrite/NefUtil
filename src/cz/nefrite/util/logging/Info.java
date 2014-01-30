package cz.nefrite.util.logging;

/**
 * Třída určující úroveň logování INFO. Zápisy nižší úrovně jsou ignorovány.
 * @author Jirka Drozd
 */
public final class Info extends LogLevel {

	/** {@inheritDoc } */
	@Override
	public void debug(String msg) {
		// prikaz teto urovne neni logovan
	}

	/** {@inheritDoc } */
	@Override
	public void debug(Object obj) {
		// prikaz teto urovne neni logovan
	}
}
