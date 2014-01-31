package cz.nefrite.util.logging;

/**
 * Třída určující úroveň logování ERRORS.
 * Zápisy nižší úrovně jsou ignorovány.
 * @author Jirka Drozd
 */
public class Errors extends LogLevel {

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

	/** {@inheritDoc } */
	@Override
	public void warn(String msg) {
		// prikaz teto urovne neni logovan
	}

	/** {@inheritDoc } */
	@Override
	public void warn(String msg, Exception e) {
		// prikaz teto urovne neni logovan
	}
	
}
