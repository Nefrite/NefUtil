package cz.nefrite.util.logging;

/**
 * Třída určující úroveň logování WARNINGS.
 * Zápisy nižší úrovně jsou ignorovány.
 * @author Jirka Drozd
 */
public final class Warnings extends LogLevel {

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
	
	/** {@inheritDoc } */
	@Override
	public void info(String msg) {
		// prikaz teto urovne neni logovan
	}
	
}
