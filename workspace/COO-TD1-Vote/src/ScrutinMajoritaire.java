import java.util.Map;


public class ScrutinMajoritaire extends Scrutin {

	
	private int treshold(){
		return this.nombreDeVotes()/2;
	}
	@Override
	protected BulletinVote internalRule() {
		Map<BulletinVote,Integer> map = this.getResultats();
		for (BulletinVote bv : map.keySet()){
			if( map.get(bv) > this.treshold() ){
				if((bv == BulletinVote.NUL) || (bv == BulletinVote.BLANC)){
					return null;
				}
				return bv;
			}
		}
		return null;
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
