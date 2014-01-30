package cz.nefrite.util.checking;

/**
 * Množina pravidel reakcí na dané chybové stavy.
 * @author Jirka Drozd
 */
public interface CheckRules {
	
	public void isNull();
	
	public void isNull(String msg);
	
	public void nullFatal();
	
	public void nullFatal(String msg);
	
	public void nullFatal(int errorID);
}
