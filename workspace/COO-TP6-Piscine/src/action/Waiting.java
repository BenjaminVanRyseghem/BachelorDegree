package action;


// TODO: Auto-generated Javadoc
/**
 * The Class Waiting.
 */
public class Waiting extends Action {

	
	String originalMessage;
	/* (non-Javadoc)
	 * @see Action#internalStep()
	 */
	@Override
	public void internalStep(){
		numberOfStepsAlreadyDone ++;
		this.updateMessage();
		System.out.print(""+this.getMessage());
	}
	
	/* (non-Javadoc)
	 * @see Action#stopCondition()
	 */
	@Override
	public boolean stopCondition(){
		return numberOfStepsAlreadyDone >= steppingTime;
	}

	/** The stepping time. @uml.property  name="steppingTime" */
	private int steppingTime;
	private int numberOfStepsAlreadyDone = 0;

	/**
	 * Getter of the property <tt>steppingTime</tt>.
	 *
	 * @return  Returns the steppingTime.
	 * @uml.property  name="steppingTime"
	 */
	public int getSteppingTime() {
		return steppingTime;
	}
	

	/**
	 * Setter of the property <tt>steppingTime</tt>.
	 *
	 * @param steppingTime  The steppingTime to set.
	 * @uml.property  name="steppingTime"
	 */
	public void setSteppingTime(int steppingTime) {
		this.steppingTime = steppingTime;
	}

	
	/**
	 * Instantiates a new waiting.
	 *
	 * @param time the time
	 */
	public Waiting(int time){
		super();
		this.steppingTime = time;
	}
	
		
	private void updateMessage(){
		this.setMessage(originalMessage+"("+(steppingTime-numberOfStepsAlreadyDone)+")\n");
	}
	
		/**
		 * Instantiates a new waiting.
		 *
		 * @param message the message
		 * @param time the time
		 */
	public Waiting(String message, int time){
		super(message);
		originalMessage = message;
		this.steppingTime = time;
		this.updateMessage();
	}

}
