package action;


import java.util.ArrayList;

public abstract class Ordonnanceur extends Action {

	
	public int incrementIndex(){
		int result = currentActionIndex;
		this.setCurrentActionIndex(this.nextIndex());
		return result;
	}
	
	public int decrementIndex(){
		int result = currentActionIndex;
		this.setCurrentActionIndex(this.previousIndex());
		return result;
	}
	
	@Override
	public abstract void internalStep();

	@Override
	public boolean stopCondition() {
		return actions.isEmpty();
	}

	/**
	 * @uml.property  name="indexCurrentAction"
	 */
	private int currentActionIndex = 0;

	/**
	 * Getter of the property <tt>indexCurrentAction</tt>
	 * @return  Returns the indexCurrentAction.
	 * @uml.property  name="indexCurrentAction"
	 */
	public int getCurrentActionIndex() {
		return currentActionIndex;
	}

	/**
	 * Setter of the property <tt>indexCurrentAction</tt>
	 * @param indexCurrentAction  The indexCurrentAction to set.
	 * @uml.property  name="indexCurrentAction"
	 */
	public void setCurrentActionIndex(int indexCurrentAction) {
		this.currentActionIndex = indexCurrentAction;
	}

	/**
	 * @uml.property  name="actions"
	 */
	private ArrayList<Action> actions = new ArrayList<Action>();

	/**
	 * Getter of the property <tt>actions</tt>
	 * @return  Returns the actions.
	 * @uml.property  name="actions"
	 */
	public ArrayList<Action> getActions() {
		return actions;
	}

	/**
	 * Setter of the property <tt>actions</tt>
	 * @param actions  The actions to set.
	 * @uml.property  name="actions"
	 */
	public void setActions(ArrayList<Action> actions) {
		this.actions = actions;
	}

		
	protected int previousIndex(){
		return this.currentActionIndex == 0?this.actions.size()-1:(this.currentActionIndex - 1);
	}
	
	protected int nextIndex(){
		return this.currentActionIndex == this.actions.size()-1?0:(this.currentActionIndex + 1);
	}
	
	/**
	 */
	public abstract void add(Action action);
}
