package cz.nefrite.util.logging;

/**
 * Úplné potlačení logování
 * @author Jirka Drozd
 */
public class NullLog extends LogLevel {

	/** {@inheritDoc } */
	@Override
	public void debug(String msg) {
		// neni logovano
	}

	/** {@inheritDoc } */
	@Override
	public void debug(Object obj) {
		// neni logovano
	}
	
	/** {@inheritDoc } */
	@Override
	public void info(String msg) {
		// neni logovano
	}

	/** {@inheritDoc } */
	@Override
	public void warn(String msg) {
		// neni logovano
	}

	/** {@inheritDoc } */
	@Override
	public void warn(String msg, Exception ex) {
		// neni logovano
	}

	/** {@inheritDoc } */
	@Override
	public void error(String msg) {
		// neni logovano
	}

	/** {@inheritDoc } */
	@Override
	public void error(Exception e) {
		// neni logovano
	}

	/** {@inheritDoc } */
	@Override
	public void error(String msg, Exception e) {
		// neni logovano
	}

}
