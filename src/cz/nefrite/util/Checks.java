package cz.nefrite.util;

import cz.nefrite.util.checking.CheckRules;
import cz.nefrite.util.checking.NoSpecialRules;

/**
 * Třída, jež definuje chybové stavy a umožňuje změnu pravidel reakcí.
 * @author Jirka Drozd
 */
public class Checks {

	/** Pravidla reakcí na chyby */
	private static CheckRules rules = new NoSpecialRules();

	private Checks() {
		//jedna se o knihovni tridu
	}

	/**
	 * Nastaví pravidla reakcí na chybové stavy.
	 * @param rules Nová pravidla.
	 */
	public static void setCheckRules(CheckRules rules) {
		if (rules != null) {
			Checks.rules = rules;
		}
	}

	/**
	 * Zkontroluje zda daný objekt je {@code null}. Reaguje podle nastavených pravidel.
	 * @param obj Kontrolovaný objekt.
	 * @return {@code true} pokud daný objekt není {@code null}
	 */
	public static boolean isNotNull(Object obj) {
		if (obj == null) {
			rules.isNull();
			return false;
		}
		return true;
	}

	/**
	 * Zkontroluje zda daný objekt je {@code null}. Reaguje podle nastavených pravidel.
	 * @param obj Kontrolovaný objekt.
	 * @param msg Zpráva případné chybové hlášky.
	 * @return {@code true} pokud daný objekt není {@code null}
	 */
	public static boolean isNotNull(Object obj, String msg) {
		if (obj == null) {
			rules.isNull(msg);
			return false;
		}
		return true;
	}

	/**
	 * Zkontroluje objekt a pokud je {@code null} vyhodí vyjímku.
	 * @param obj Kontrolovaný objekt.
	 * @throws NullPointerException Vyhodí vyjímku {@link java.lang.NullPointerException},
	 *                                 pokud pravidla neurčí jiný typ.
	 */
	public static void nullFatal(Object obj) {
		if (obj == null) {
			rules.nullFatal();
			throw new NullPointerException();
		}
	}

	/**
	 * Zkontroluje objekt a pokud je {@code null} vyhodí vyjímku s číslem dané chyby.
	 * @param obj     Kontrolovaný objekt.
	 * @param errorID Číslo chyby.
	 * @throws NullPointerException Vyhodí vyjímku {@link java.lang.NullPointerException},
	 *                                 pokud pravidla neurčí jiný typ.
	 */
	public static void nullFatal(Object obj, int errorID) {
		if (obj == null) {
			rules.nullFatal(errorID);
			throw new NullPointerException("Fatal Error: " + errorID);
		}
	}

	/**
	 * Zkontroluje objekt a pokud je {@code null} vyhodí vyjímku s danou
	 * zprávou.
	 * @param obj Kontrolovaný objekt.
	 * @param msg Zpráva vyjímky.
	 * @throws NullPointerException Vyhodí vyjímku {@link java.lang.NullPointerException},
	 *                                 pokud pravidla neurčí jiný typ.
	 */
	public static void nullFatal(Object obj, String msg) {
		if (obj == null) {
			rules.nullFatal(msg);
			throw new NullPointerException(msg);
		}
	}
}
