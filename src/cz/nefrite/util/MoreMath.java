package cz.nefrite.util;

/**
 * Třída z knihy Vývoj her v jazyku Java
 * *** com.brackeen.javagamebook.util *** 
 * @author David Brackeen
 * @author Jirka Drozd
 */
public class MoreMath {
	
	// trigonometrická tabulka s 4096 položkami
	private static final int TABLE_SIZE_BITS = 12;
	private static final int TABLE_SIZE = 1 << TABLE_SIZE_BITS;
	private static final int TABLE_SIZE_MASK = TABLE_SIZE - 1;
	private static final int HALF_PI = TABLE_SIZE / 4;
	private static final float CONVERSION_FACTOR = (float) (TABLE_SIZE / (2 * Math.PI));
	private static float[] sinTable;

	// inicializace tabulky
	static {
		init();
	}

	private static void init() {
		sinTable = new float[TABLE_SIZE];
		for (int i = 0; i < TABLE_SIZE; i++) {
			sinTable[i] = (float) Math.sin(i / CONVERSION_FACTOR);
		}
	}

	/**
	 * Funkce kosinu, kde úhel je v rozsahu 0 až 4096 namísto 0 až 2PI.
	 * 
	 * @param angle úhel v rozsahu 0 až 4096 bodů
	 * @return kosinus úhlu
	 */
	public static float cos(int angle) {
		return sinTable[(HALF_PI - angle) & TABLE_SIZE_MASK];
	}

	/**
	 * Funkce sinu, kde úhel je v rozsahu 0 až 4096 namísto 0 až 2PI.
	 * 
	 * @param angle úhel v rozsahu 0 až 4096 bodů
	 * @return sinus úhlu 
	 */
	public static float sin(int angle) {
		return sinTable[angle & TABLE_SIZE_MASK];
	}

	/**
	 * Převede úhel v radiánech na přepočtový systém (0 až 2pi se stává 0 až 4096).
	 * 
	 * @param angleInRadians úhel v radiánech
	 * @return úhel v přepočtových bodech
	 */
	public static int angleConvert(float angleInRadians) {
		return (int) (angleInRadians * CONVERSION_FACTOR);
	}
	
	/**
        Returns the sign of the number. Returns -1 for negative,
        1 for positive, and 0 otherwise.
		* @param v number as {@code short}
		* @return -1 if negative | 0 if zero | 1 if positive 
		*/
    public static int sign(short v) {
        return (v>0)?1:(v<0)?-1:0;
    }


    /**
        Returns the sign of the number. Returns -1 for negative,
        1 for positive, and 0 otherwise.
		* @param v number as {@code int}
		* @return -1 if negative | 0 if zero | 1 if positive 
		*/
    public static int sign(int v) {
        return (v>0)?1:(v<0)?-1:0;
    }


    /**
        Returns the sign of the number. Returns -1 for negative,
        1 for positive, and 0 otherwise.
		* @param v number as {@code long}
		* @return -1 if negative | 0 if zero | 1 if positive  
		*/
    public static int sign(long v) {
        return (v>0)?1:(v<0)?-1:0;
    }


    /**
        Returns the sign of the number. Returns -1 for negative,
        1 for positive, and 0 otherwise.
		* @param v number as {@code float}
		* @return -1 if negative | 0 if zero | 1 if positive  
		*/
    public static int sign(float v) {
        return (v>0)?1:(v<0)?-1:0;
    }


    /**
        Returns the sign of the number. Returns -1 for negative,
        1 for positive, and 0 otherwise.
		* @param v  number as {@code double}
		* @return -1 if negative | 0 if zero | 1 if positive 
		*/
    public static int sign(double v) {
        return (v>0)?1:(v<0)?-1:0;
    }


    /**
        Faster ceil function to convert a float to an int.
        Contrary to the java.lang.Math ceil function, this
        function takes a float as an argument, returns an int
        instead of a double, and does not consider special cases.
		* @param f  number as {@code float}
		* @return  
		*/
    public static int ceil(float f) {
        if (f > 0) {
            return (int)f + 1;
        }
        else {
           return (int)f;
        }
    }


    /**
        Faster floor function to convert a float to an int.
        Contrary to the java.lang.Math floor function, this
        function takes a float as an argument, returns an int
        instead of a double, and does not consider special cases.
		* @param f  number as {@code float}
		* @return  
		*/
    public static int floor(float f) {
        if (f >= 0) {
            return (int)f;
        }
        else {
           return (int)f - 1;
        }
    }


    /**
        Returns true if the specified number is a power of 2.
		* @param n 
		* @return  
		*/
    public static boolean isPowerOfTwo(int n) {
        return ((n & (n-1)) == 0);
    }


    /**
        Gets the number of "on" bits in an integer.
		* @param n
		* @return  
		*/
    public static int getBitCount(int n) {
        int count = 0;
        while (n > 0) {
            count+=(n & 1);
            n>>=1;
        }
        return count;
    }
}
