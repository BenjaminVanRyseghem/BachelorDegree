import java.util.Map;


public class ScrutinRelatif extends Scrutin {

	private int treshold(){
		return this.nombreDeVotes()*15/100;
	}
	
	private BulletinVote getMax(){
		Map<BulletinVote,Integer> map = this.getResultats();
		BulletinVote max = this.votesPossibles().iterator().next();
		for(BulletinVote bv : map.keySet()){
			if((map.get(bv)) > (map.get(max))){
				max = bv;
			}
		}
		return max;
	}
	
	@Override
	protected BulletinVote internalRule() {
		Map<BulletinVote,Integer> map = this.getResultats();
		BulletinVote max = this.getMax();
		if(map.get(max) > this.treshold()){
			return max;
		}
		return null;
	}

}
