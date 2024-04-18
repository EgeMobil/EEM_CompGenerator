package EEM_CompGenerator;

public class Runable 
{
	private String[] runableNames;
	private String[] runableReturnTypes; 
	private String[][] runableVarTypes;
	private String[][] runableVarNames;
	private String[] runableDescriptions;
	
	public Runable(String[] _runableNames, String[] _runableReturnTypes, String[][] _runableVarTypes, String[][] _runableVarNames, String[] _runableDescriptions)
	{
		this.runableNames = _runableNames;
		this.runableReturnTypes = _runableReturnTypes;
		this.runableVarTypes = _runableVarTypes;
		this.runableVarNames = _runableVarNames;
		this.runableDescriptions =_runableDescriptions;
	}
	
	public String[] getRunableNames() {
		return runableNames;
	}
	public void setRunableNames(String[] runableNames) {
		this.runableNames = runableNames;
	}
	public String[] getRunableReturnTypes() {
		return runableReturnTypes;
	}
	public void setRunableReturnTypes(String[] runableReturnTypes) {
		this.runableReturnTypes = runableReturnTypes;
	}
	public String[][] getRunableVarTypes() {
		return runableVarTypes;
	}
	public void setRunableVarTypes(String[][] runableVarTypes) {
		this.runableVarTypes = runableVarTypes;
	}
	public String[][] getRunableVarNames() {
		return runableVarNames;
	}
	public void setRunableVarNames(String[][] runableVarNames) {
		this.runableVarNames = runableVarNames;
	}

	public String[] getRunableDescriptions() {
		return runableDescriptions;
	}

	public void setRunableDescriptions(String[] runableDescriptions) {
		this.runableDescriptions = runableDescriptions;
	}
	
	
}
