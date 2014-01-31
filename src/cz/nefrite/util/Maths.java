package cz.nefrite.util;

/**
 * Doplňující matematické operace, optimalizované funkce a vyhledávací tabulky. Sin/Cos optimalizace 
 * převzata z com.brackeen.javagamebook.util.MoreMath
 * @author Jirka Drozd
 */
public class Maths extends MoreMath {

	/** {@code PI} v přesnosti {@code float} */
	public static final float PIf = (float) Math.PI;
	/** {@code 2*PI} v přesnosti {@code float} */
	public static final float PI2f = (PIf * 2);
	
	/** {@code 2*PI} v přesnosti {@code double}*/
	public static final double PI2d = (Math.PI * 2);
	
	/** odmocnina {@code 2} */
	public static final float SQRT_2 = (float) Math.sqrt(2);
	/** odmocnina {@code 3} */
	public static final float SQRT_3 = (float) Math.sqrt(3);

	/**
	 * Převede úhel v radiánech do základní velikosti v rozsahu {@code 0} až {@code 2PI}
	 * @param angle úhel v radiánech
	 * @return úhel v radiánech v rozsahu {@code 0 >= angle < 2PI}
	 */
	public static double angleToBasicRange(double angle) {
		if (angle < 0) {
			return angleToBasicRange(angle + PI2d);
		}
		if (angle >= PI2d) {
			return angleToBasicRange(angle - PI2d);
		}
		return angle;
	}
	
	/**
	 * Převede úhel v radiánech do základní velikosti v rozsahu {@code 0} až {@code 2PI}
	 * @param angle úhel v radiánech
	 * @return úhel v radiánech v rozsahu {@code 0 >= angle < 2PI}
	 */
	public static float angleToBasicRange(float angle) {
		if (angle < 0) {
			return angleToBasicRange(angle + PI2f);
		}
		if (angle >= PI2f) {
			return angleToBasicRange(angle - PI2f);
		}
		return angle;
	}

	/**
	 * Vrátí opačný úhel v rozsahu {@code 0} až {@code 2PI}
	 * @param angle úhel v radiánech
	 * @return daný úhel - {@code PI}
	 */
	public static double getOppositeAngle(double angle) {
		return angleToBasicRange(angle - Math.PI);
	}
	
	/**
	 * Vrátí opačný úhel v rozsahu {@code 0} až {@code 2PI}
	 * @param angle úhel v radiánech
	 * @return daný úhel - {@code PI}
	 */
	public static float getOppositeAngle(float angle) {
		return angleToBasicRange(angle - PIf);
	}

	/**
	 * Vrátí délku odvěsny podle Pythagorovy věty {@code a^2 + b^2 = c^2}
	 * @param a přepona a
	 * @param b přepona b
	 * @return délka odvěsny c
	 */
	public static double ordinate(double a, double b) {
		return Math.sqrt(a * a + b * b);
	}
	
	/**
	 * Vrátí délku odvěsny podle Pythagorovy věty {@code a^2 + b^2 = c^2}
	 * @param a přepona a
	 * @param b přepona b
	 * @return délka odvěsny c
	 */
	public static float ordinate(float a, float b) {
		return (float) Math.sqrt(a * a + b * b);
	}
	
	/**
	 * Funkce kosinu pomocí optimalizační tabulky.
	 * @param angle úhel v radiánech v rozsahu {@code 0} až {@code 2PI}
	 * @return sinus úhlu 
	 */
	public static float sin(double angle) {
		return sin(angleConvert((float)angle));
	}
	
	/**
	 * Funkce kosinu pomocí optimalizační tabulky.
	 * @param angle úhel v radiánech v rozsahu {@code 0} až {@code 2PI}
	 * @return sinus úhlu 
	 */
	public static float sin(float angle) {
		return sin(angleConvert(angle));
	}
	
	/**
	 * Funkce kosinu pomocí optimalizační tabulky.
	 * @param angle úhel v radiánech v rozsahu {@code 0} až {@code 2PI}
	 * @return kosinus úhlu 
	 */
	public static float cos(double angle) {
		return cos(angleConvert((float)angle));
	}
	
	/**
	 * Funkce kosinu pomocí optimalizační tabulky.
	 * @param angle úhel v radiánech v rozsahu {@code 0} až {@code 2PI}
	 * @return kosinus úhlu
	 */
	public static float cos(float angle) {
		return cos(angleConvert(angle));
	}
}
