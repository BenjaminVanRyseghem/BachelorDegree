package action;

// TODO: Auto-generated Javadoc
/**
 * The Class Action.
 */
public abstract class Action {

	
	/**
	 * The Enum ActionState.
	 */
	private enum ActionState { 
 /** The INITIAL. */
 INITIAL, 
 /** The OVER. */
 OVER, 
 /** The PENDING. */
 PENDING; }

	/**
	 * Checks for begun.
	 *
	 * @return true, if successful
	 */
	protected boolean hasBegun(){
		return this.getState() == ActionState.INITIAL;
	}
	
	/**
	 * Sets the state over.
	 */
	protected void setStateOver(){
		this.setState(ActionState.OVER);
	}
	
	/**
	 * Sets the state pending.
	 */
	protected void setStatePending(){
		this.setState(ActionState.PENDING);
	}
	
	/**
	 * Step.
	 */
	public void step(){
		if (this.isOver()){
			throw new IllegalStateException("Action over");
		}
		if(!this.hasBegun()){
			this.setStatePending();
		}
		this.internalStep();
		if(this.stopCondition()){
			this.setStateOver();
		}
	}

	/** The message. @uml.property  name="message" */
	private String message = "";

	/**
	 * Getter of the property <tt>message</tt>.
	 *
	 * @return  Returns the message.
	 * @uml.property  name="message"
	 */
	public String getMessage() {
		return message;
	}

	/**
	 * Setter of the property <tt>message</tt>.
	 *
	 * @param message  The message to set.
	 * @uml.property  name="message"
	 */
	public void setMessage(String message) {
		this.message = message;
	}

	/** The state. @uml.property  name="state" */
	private ActionState state;

	/**
	 * Getter of the property <tt>state</tt>.
	 *
	 * @return  Returns the state.
	 * @uml.property  name="state"
	 */
	public ActionState getState() {
		return state;
	}

	/**
	 * Setter of the property <tt>state</tt>.
	 *
	 * @param state  The state to set.
	 * @uml.property  name="state"
	 */
	public void setState(ActionState state) {
		this.state = state;
	}

	
	/**
	 * Checks if it's over.
	 *
	 * @return true, if it's over
	 */
	public boolean isOver(){
		return this.getState() == ActionState.OVER;
	}

	
	/**
	 * Internal step.
	 */
	public abstract void internalStep();
		
		/**
		 * Stop condition.
		 *
		 * @return true, if this action should be stopped
		 */
	public abstract boolean stopCondition();
	
		
		/**
		 * Instantiates a new action.
		 */
	public Action(){
	}
	
		
		/**
		 * Instantiates a new action.
		 *
		 * @param message the message
		 */
	public Action(String message){
	this.message = message; }
}
