package cz.nefrite.util.logging;

/**
 * Vnitřní řešení úrovně logování,
 *
 * @author Jirka Drozd
 */
public abstract class LogLevel implements LogSystem {

	private static LogSystem logger;

	/**
	 * Nastavení Logovacího systému pro všechny úrovně logování
	 * @param logs Logovací systém
	 */
	public static void setLogSystem(LogSystem logs) {
		if (logs == null) {
			throw new IllegalArgumentException("LogSystem can not be null!");
		}
		logger = logs;
	}

	/** {@inheritDoc } */
	@Override
	public void debug(Object obj) {
		logger.debug(obj);
	}

	/** {@inheritDoc } */
	@Override
	public void debug(String msg) {
		logger.debug(msg);
	}

	/** {@inheritDoc } */
	@Override
	public void info(String msg) {
		logger.info(msg);
	}

	/** {@inheritDoc } */
	@Override
	public void warn(String msg) {
		logger.warn(msg);
	}

	/** {@inheritDoc } */
	@Override
	public void warn(String msg, Exception e) {
		logger.warn(msg, e);
	}

	/** {@inheritDoc } */
	@Override
	public void error(String msg) {
		logger.error(msg);
	}

	/** {@inheritDoc } */
	@Override
	public void error(Exception e) {
		logger.error(e);
	}

	/** {@inheritDoc } */
	@Override
	public void error(String msg, Exception e) {
		logger.error(msg, e);
	}
}
