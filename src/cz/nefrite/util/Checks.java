package cz.nefrite.util;

import cz.nefrite.util.checking.CheckRules;
import cz.nefrite.util.checking.NoSpecialRules;
import java.util.Collection;

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

	/**
	 * Zkontroluje danou kolekci, zda není prázdná. Reaguje podle nastavených pravidel.
	 * @param c Kontrolovaná kolekce
	 * @return Vrací {@code true} pokud kolekce obsahuje nějaké prvky.
	 */
	public static boolean isNotEmpty(Collection c) {
		if (c.isEmpty()) {
			rules.isEmpty();
			return false;
		}
		return true;
	}

	/**
	 * Zkontroluje danou kolekci, zda není prázdná. Reaguje podle nastavených pravidel.
	 * @param c   Kontrolovaná kolekce
	 * @param msg Zpráva případné chybové hlášky.
	 * @return Vrací {@code true} pokud kolekce obsahuje nějaké prvky.
	 */
	public static boolean isNotEmpty(Collection c, String msg) {
		if (c.isEmpty()) {
			rules.isEmpty(msg);
			return false;
		}
		return true;
	}

	/**
	 * Provede test na existenci objektu
	 * ({@link cz.nefrite.util.Checks#nullFatal(java.lang.Object)}), následně pak kolekci
	 * zkontroluje, zda obsahuje nějaké prvky.
	 * @param c Kontrolovaná kolekce
	 * @throws IllegalStateException Vyhodí vyjímku
	 *                                  {@link java.lang.IllegalStateException},
	 *                                  pokud pravidla neurčí jiný typ.
	 */
	public static void emptyFatal(Collection c) {
		nullFatal(c);
		if (c.isEmpty()) {
			rules.emptyFatal(c);
			throw new IllegalStateException();
		}
	}

	/**
	 * Provede test na existenci objektu ({@link cz.nefrite.util.Checks#nullFatal(java.lang.Object, int), následně pak kolekci
	 * zkontroluje, zda obsahuje nějaké prvky.
	 * @param c       Kontrolovaná kolekce
	 * @param errorID Číslo chyby(pokud bude daný objekt {@code null} bude číslo chyby postoupeno kontrolující mětodě).
	 * @throws IllegalStateException Vyhodí vyjímku
	 *                                  {@link java.lang.IllegalStateException},
	 *                                  pokud pravidla neurčí jiný typ.
	 */
	public static void emptyFatal(Collection c, int errorID) {
		nullFatal(c, errorID);
		if (c.isEmpty()) {
			rules.emptyFatal(c, errorID);
			throw new IllegalStateException("Fatal Error: " + errorID);
		}
	}

	/**
	 * Provede test na existenci objektu ({@link cz.nefrite.util.Checks#nullFatal(java.lang.Object, java.lang.String), následně pak kolekci
	 * zkontroluje, zda obsahuje nějaké prvky.
	 * @param c   Kontrolovaná kolekce
	 * @param msg Zpráva případné chybové hlášky.
	 */
	public static void emptyFatal(Collection c, String msg) {
		nullFatal(c, msg);
		if (c.isEmpty()) {
			rules.emptyFatal(c, msg);
			throw new IllegalStateException(msg);
		}
	}
}
