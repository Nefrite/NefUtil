package cz.nefrite.util;

import cz.nefrite.util.logging.Debug;
import cz.nefrite.util.logging.Errors;
import cz.nefrite.util.logging.Info;
import cz.nefrite.util.logging.LogLevel;
import cz.nefrite.util.logging.LogSystem;
import cz.nefrite.util.logging.NullLog;
import cz.nefrite.util.logging.StdOutLogging;
import cz.nefrite.util.logging.Warnings;

/**
 * Globální logování. Úrovně logování: - DEBUG - INFO - WARNINGS - ERRORS Standardně nastaven výpis
 * zpráv na standardní výstup (System.out) od úrovně WARNING. Třída dává možnost vytvoření vlastní
 * logovací úrovně.
 * @author Jirka Drozd
 */
public class Log {

	/** Název systémové proměnné pro změnu úrovně logování. Použití: -Dcz.nefrite.loglevel=info */
	public static final String LOGLEVEL_PROPERTY = "cz.nefrite.log.level";
	/** Logovány nebudou žádné zprávy */
	public static final LogLevel NONE = new NullLog();
	/** Logování zpráv DEBUG, INFO, WARNING a ERROR */
	public static final LogLevel DEBUG = new Debug();
	/** Logování zpráv INFO, WARNING a ERROR */
	public static final LogLevel INFO = new Info();
	/** Logování zpráv WARNING a ERROR */
	public static final LogLevel WARNINGS = new Warnings();
	/** Logování zpráv ERROR */
	public static final LogLevel ERRORS = new Errors();
	private static LogLevel logLevel;

	static {
		String level = System.getProperty(LOGLEVEL_PROPERTY);
		if (level != null) {
			level = level.trim().toLowerCase();
		} else {
			level = "default";
		}
		setLogLevel(level);
		//System.out.println("Log level set to: " + level.toUpperCase());
		LogLevel.setLogSystem(new StdOutLogging());
	}

	private Log() {
	}

	/**
	 * Změní výpisy na daný logovací systém
	 * @param logs logovací systém
	 */
	public static void setLogSystem(LogSystem logs) {
		if (logs == null) {
			throw new IllegalArgumentException("LogSystem can not be null!");
		}
		LogLevel.setLogSystem(logs);
	}

	/**
	 * Nastaví úroveň logování. Vypisovat se budou zprávy stejné a vyšší úrovně. Úrovně od nejnižší:
	 * DEBUG, INFO, WARNINGS, ERRORS, NONE
	 * @param level vybraná úroveň.
	 */
	public static void setLogLevel(LogLevel level) {
		if (level == null) {
			throw new IllegalArgumentException("LogLevel can not be null!");
		}
		logLevel = level;
	}

	/**
	 * Nastaví úroveň logování. Vypisovat se budou zprávy stejné a vyšší úrovně. Úrovně od nejnižší:
	 * DEBUG, INFO, WARNINGS, ERRORS, NONE
	 * @param level vybraná úroveň.
	 */
	public static void setLogLevel(String level) {
		switch (level) {
			case "none":
				logLevel = NONE;
				break;
			case "debug":
				logLevel = DEBUG;
				break;
			case "info":
				logLevel = INFO;
				break;
			case "warnings":
				logLevel = WARNINGS;
				break;
			case "errors":
				logLevel = ERRORS;
				break;
			default:
				logLevel = WARNINGS;
		}
	}

	/**
	 * Zapíše zprávu na úrovni DEBUG.
	 * @param msg zpráva
	 */
	public static void debug(String msg) {
		logLevel.debug(msg);
	}

	/**
	 * Na úrovni DEBUG vypíše textovou podobu objektu.
	 * @param obj objekt k vypsání
	 */
	public static void debug(Object obj) {
		logLevel.debug(obj);
	}

	/**
	 * Zapíše zprávu na úrovni INFO.
	 * @param msg zpráva
	 */
	public static void info(String msg) {
		logLevel.info(msg);
	}

	/**
	 * Zapíše zprávu na úrovni INFO.
	 * @param msg zpráva
	 */
	public static void notice(String msg) {
		logLevel.info(msg);
	}

	/**
	 * Zapíše zprávu na úrovni WARNING.
	 * @param msg zpráva
	 */
	public static void warn(String msg) {
		logLevel.warn(msg);
	}

	/**
	 * Zapíše zprávu a vyjímku na úrovni WARNING.
	 * @param msg zpráva
	 * @param e   Výjimka
	 */
	public static void warn(String msg, Exception e) {
		logLevel.warn(msg, e);
	}

	/**
	 * Zapíše zprávu na úrovni ERROR.
	 * @param msg zpráva
	 */
	public static void error(String msg) {
		logLevel.error(msg);
	}

	/**
	 * Vypíše výjimku.
	 * @param e Výjimka
	 */
	public static void error(Exception e) {
		logLevel.error(e);
	}

	/**
	 * Zapíše zprávu a vyjímku na úrovni ERROR.
	 * @param msg zpráva
	 * @param e   Výjimka
	 */
	public static void error(String msg, Exception e) {
		logLevel.error(msg, e);
	}
}
