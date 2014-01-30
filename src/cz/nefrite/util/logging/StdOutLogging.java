package cz.nefrite.util.logging;

import java.io.PrintStream;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Standardní logovací systém s výstupem na stdout.
 *
 * @author Jirka Drozd
 */
public class StdOutLogging implements LogSystem {

	/**
	 * Název systémové proměnné pro změnu řádku určujícího zdroj logované zprávy, číslo určuje
	 * pořadí ve {@code stackTrace}. Použití: {@code -Dcz.nefrite.log.stackline=5 }
	 */
	public static final String STACKLINE_PROPERTY = "cz.nefrite.log.stackline";
	/** Standardní řádek výpisu ze {@code stackTrace} */
	public static final int DEF_STACKLINE = 5;
	private static final String CLASSNAME;
	private static final String SOURCEMETHOD = "getSourceDynamicaly";
	private static final String NOTFOUND_MSG = " Source not found! Check STACKLINE_PROPERTY! ";
	private static final int ENCAP_LEVEL = 4;
	private static int STACKLINE;
	private static String MASK;
	private static PrintStream out = System.out;
	private SimpleDateFormat df;

	static {
		CLASSNAME = StdOutLogging.class.getName();
		String line = System.getProperty(STACKLINE_PROPERTY);
		int stackLine = DEF_STACKLINE;
		try {
			stackLine = Integer.parseInt(line);
		} catch (NumberFormatException e) {
		}
		STACKLINE = stackLine;
		//System.out.println("LogSystem: STACKLINE set to " + STACKLINE);
	}

	/**
	 * Vytvoří nový logovací systém s časovou maskou HH:mm:ss:S, formátem výstupu "%-12s %s\n".
	 */
	public StdOutLogging() {
		init("HH:mm:ss.S", "%-12s %s\n");
	}

	/**
	 * Vytvoří nový logovací systém s danou časovou maskou.
	 * @param datePattern formátovací maska pro datum a čas.
	 * @param outMask     formátovací maska pro podobu celého výstupu.
	 * @see http://docs.oracle.com/javase/6/docs/api/java/text/SimpleDateFormat.html
	 */
	public StdOutLogging(String datePattern, String outMask) {
		init(datePattern, outMask);
	}

	/**
	 * Vytvoří nový logovací systém s časovou maskou HH:mm:ss:S, formátem výstupu "%-12s %s\n" a
	 * zadaným indexem pro nalezení zdroje zprávy.
	 * @param stackLine Označení řádku z stackTrace jež se bude vypisovat jako zdroj zprávy.
	 */
	public StdOutLogging(int stackLine) {
		this(stackLine, "HH:mm:ss.S", "%-12s %s\n");
	}

	/**
	 * Vytvoří nový logovací systém s danou časovou maskou. Parametr stackLine použijte v případě,
	 * že se vypisuje jiný řádek zdroje zprávy, než který potřebujete.
	 * @param stackLine   Označení řádku z stackTrace jež se bude vypisovat jako zdroj zprávy.
	 * @param datePattern formátovací maska pro datum a čas.
	 * @param outMask     formátovací maska pro podobu celého výstupu.
	 * @see http://docs.oracle.com/javase/6/docs/api/java/text/SimpleDateFormat.html
	 */
	public StdOutLogging(int stackLine, String datePattern, String outMask) {
		if (stackLine >= 0) {
			STACKLINE = stackLine;
		} else {
			STACKLINE = DEF_STACKLINE;
		}
		init(datePattern, outMask);
	}

	private void init(String datePattern, String outMask) {
		if (outMask == null || outMask.isEmpty()) {
			throw new IllegalArgumentException("Output mask can not be empty!");
		}
		df = new SimpleDateFormat(datePattern);
		MASK = outMask;
	}

	/** {@inheritDoc } */
	@Override
	public void debug(Object obj) {
		out.printf(MASK, df.format(new Date()), "DEBUG: " + getSourceDynamicaly() + " > " + obj);
	}
	
	/** {@inheritDoc } */
	@Override
	public void debug(String message) {
		out.printf(MASK, df.format(new Date()), "DEBUG: " + getSourceDynamicaly() + " > " + message);
	}

	/** {@inheritDoc } */
	@Override
	public void info(String message) {
		out.printf(MASK, df.format(new Date()), "INFO: " + message);
	}

	/** {@inheritDoc } */
	@Override
	public void warn(String message) {
		out.printf(MASK, df.format(new Date()), "WARNING: " + getSourceDynamicaly() + " > " + message);
	}

	/** {@inheritDoc } */
	@Override
	public void warn(String message, Exception e) {
		out.printf(MASK, df.format(new Date()), "WARNING: " + getSourceDynamicaly() + " > " + message);
		out.printf(MASK, df.format(new Date()), "WARNING: " + e.getClass().getSimpleName() + ": " + e.getMessage());
	}

	/** {@inheritDoc } */
	@Override
	public void error(String message) {
		out.printf(MASK, df.format(new Date()), "ERROR: " + getSourceDynamicaly() + " > " + message);
	}

	/** {@inheritDoc } */
	@Override
	public void error(String message, Exception e) {
		out.printf(MASK, df.format(new Date()), "ERROR: " + message);
		e.printStackTrace(out);
	}

	/** {@inheritDoc } */
	@Override
	public void error(Exception e) {
		out.printf(MASK, df.format(new Date()), "ERROR: " + e.getMessage());
		e.printStackTrace(out);
	}

	/**
	 * Určí a vrátí zdroj logovaného výpisu pomocí výpisu zásobníku ({@code StackTrace}) aktuálního
	 * vlákna. Pro zjištění zdroje se použije statický přístup, výsledek záleží na nastavení
	 * {@code STACKLINE_PROPERTY}.
	 * @see cz.nefrite.util.logging.StdOutLogging#STACKLINE_PROPERTY
	 * @return odpovídající řádek z výpisu zásobníku ({@code StackTrace}).
	 */
	protected String getSource() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		return getDefTraceEl(stackTrace);
	}

	/**
	 * Určí a vrátí zdroj logovaného výpisu pomocí výpisu zásobníku ({@code StackTrace}) aktuálního
	 * vlákna. Zdroj je hledán dynamicky, pokud se zdroj nepodaří najít spoužije se
	 * {@code STACKLINE_PROPERTY}.
	 * @see cz.nefrite.util.logging.StdOutLogging#STACKLINE_PROPERTY
	 * @return odpovídající řádek z výpisu zásobníku ({@code StackTrace})
	 */
	protected String getSourceDynamicaly() {
		StackTraceElement[] stackTrace = Thread.currentThread().getStackTrace();
		int lineMark = STACKLINE;
		StackTraceElement stackTraceElement;
		for (int i = 0; i < stackTrace.length; i++) {
			stackTraceElement = stackTrace[i];
			if (CLASSNAME.equals(stackTraceElement.getClassName())) {
				if (SOURCEMETHOD.equals(stackTraceElement.getMethodName())) {
					// Gotcha ;)
					lineMark = i + ENCAP_LEVEL;
					break;
				}
			}
		}
		try {
			stackTraceElement = stackTrace[lineMark];
			return stackTraceElement.toString();
		} catch (IndexOutOfBoundsException e) {
			//Nepravděpodobné, ale pro jistotu:
			return getDefTraceEl(stackTrace);
		}
	}

	/**
	 * Vrátí výpis zdroje podle {@code STACKLINE_PROPERTY}. Již neovlivní výsledek
	 * {@code StackTrace} výpisu.
	 * @param stackTrace výpis zásobníku
	 */
	private String getDefTraceEl(StackTraceElement[] stackTrace) {
		StackTraceElement stackTraceElement;
		try {
			stackTraceElement = stackTrace[STACKLINE];
			return stackTraceElement.toString();
		} catch (IndexOutOfBoundsException e) {
			return NOTFOUND_MSG;
		}
	}
}
