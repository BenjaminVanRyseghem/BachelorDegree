
public class BulletinVote {

	private final String name;
	public static final BulletinVote OUI = new BulletinVote("oui");
	public static final BulletinVote NON = new BulletinVote("non");
	public static final BulletinVote BLANC = new BulletinVote("blanc");
	public static final BulletinVote NUL = new BulletinVote("nul");
	
	
			
	public BulletinVote(String name){
		this.name = name;
	}
	
	public int hashCode(){
		return this.name().hashCode();
	}
	
	public boolean equals(Object o){
		if (!(o instanceof BulletinVote)){return false;}
		return ((BulletinVote)o).name() == this.name();
	}
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		BulletinVote bv = new BulletinVote("oui");
		
		System.out.println(bv.equals(BulletinVote.OUI));
		System.out.println(bv.equals("oui"));
		System.out.println(13/2);
	}
	
	public String name() {
		return name;
	}

}
