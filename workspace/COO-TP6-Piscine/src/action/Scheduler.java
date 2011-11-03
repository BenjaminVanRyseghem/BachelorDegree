package action;


public class Scheduler extends Ordonnanceur {

	@Override
	public void internalStep() {
		Action action;
		action = this.getActions().get(this.incrementIndex());
		action.step();
		if(action.isOver()){
			this.getActions().remove(action);
			this.decrementIndex();
		}
		System.out.print(""+this.getMessage());
	}
	
	/**
	 */
	public void add(Action action){
		this.getActions().add(this.getCurrentActionIndex(), action);
		this.incrementIndex();
	}
	
}
