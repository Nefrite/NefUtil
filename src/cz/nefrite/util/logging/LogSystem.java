package cz.nefrite.util.logging;

/**
 * Rozhraní pro vnitřní řešení způsobu logování
 *
 * @author Jirka Drozd
 */
public interface LogSystem {

	/**
	 * Zapíše zprávu na úrovni DEBUG.
	 * @param msg zpráva
	 */
	public void debug(String msg);

	/**
	 * Na úrovni DEBUG vypíše textovou podobu objektu.
	 * @param obj objekt k vypsání
	 */
	public void debug(Object obj);

	/**
	 * Zapíše zprávu na úrovni INFO.
	 * @param msg zpráva
	 */
	public void info(String msg);

	/**
	 * Zapíše zprávu na úrovni WARNING.
	 * @param msg zpráva
	 */
	public void warn(String msg);

	/**
	 * Zapíše zprávu a vyjímku na úrovni WARNING.
	 * @param msg zpráva
	 * @param e   Výjimka
	 */
	public void warn(String msg, Exception e);

	/**
	 * Zapíše zprávu na úrovni ERROR.
	 * @param msg zpráva
	 */
	public void error(String msg);

	/**
	 * Vypíše výjimku.
	 * @param e Výjimka
	 */
	public void error(Exception e);

	/**
	 * Zapíše zprávu a vyjímku na úrovni ERROR.
	 * @param msg zpráva
	 * @param e   Výjimka
	 */
	public void error(String msg, Exception e);
}
