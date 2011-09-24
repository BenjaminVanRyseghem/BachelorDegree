
public class BulletinVote {

	protected String name;
	
	public BulletinVote (String name){
		this.name = name;
	}
	
	public String name(){
		return this.name;
	}
	
	public void name(String newName){
		this.name = newName;
	}
	
	public String toString(){
		return "a" + this.getClass().getName() + " (" + this.name()+")";
	}
	
	public static void main(String[] args){
		BulletinVote bv = new BulletinVote("test");
		System.out.println(bv);
	}
	
}
