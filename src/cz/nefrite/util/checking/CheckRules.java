package cz.nefrite.util.checking;

import java.util.Collection;

/**
 * Množina pravidel reakcí na dané chybové stavy.
 * @author Jirka Drozd
 */
public interface CheckRules {

	/**
	 * Pravidlo definující reakci v případě, že daný objekt kontrolovaný v metodě
	 * {@link cz.nefrite.util.Checks#isNotNull(java.lang.Object)} je {@code null}
	 */
	public void isNull();

	/**
	 * Pravidlo definující reakci v případě, že daný objekt kontrolovaný v metodě
	 * {@link cz.nefrite.util.Checks#isNotNull(java.lang.Object, java.lang.String)} je
	 * {@code null}
	 * @param msg zpráva převzatá z kontrolující metody
	 */
	public void isNull(String msg);

	/**
	 * Změna pravidla pro metodu
	 * {@link cz.nefrite.util.Checks#nullFatal(java.lang.Object)}
	 */
	public void nullFatal();

	/**
	 * Změna pravidla pro metodu
	 * {@link cz.nefrite.util.Checks#nullFatal(java.lang.Object, java.lang.String)}
	 * @param msg zpráva převzatá z kontrolující metody
	 */
	public void nullFatal(String msg);

	/**
	 * Změna pravidla pro metodu
	 * {@link cz.nefrite.util.Checks#nullFatal(java.lang.Object, int)} 
	 * @param errorID číslo chyby převzaté z kontrolující metody
	 */
	public void nullFatal(int errorID);

	public void isEmpty();

	public void isEmpty(String msg);

	public void emptyFatal(Collection c);

	public void emptyFatal(Collection c, int errorID);
	
	public void emptyFatal(Collection c, String msg);
}
