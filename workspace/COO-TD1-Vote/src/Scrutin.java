import java.util.ArrayList;
import java.util.Map;
import java.util.Set;


public abstract class Scrutin {

	/**
	 * @param args
	 */
	
	private Set<BulletinVote> votesPossibles;
	private ArrayList<BulletinVote> votesExprimes = new ArrayList<BulletinVote>();
	private boolean estClos = false;
	private Map<BulletinVote,Integer> resultats;
/*

+getVainqueur():BulletinVote
+aﬃcheResultats(
*/	
	public boolean estClos(){
		return this.estClos;
	}
	
	public void voteExprime(BulletinVote bv) throws ScrutinClosException{
		if(this.estClos()){
			throw new ScrutinClosException();
		}
		votesExprimes.add(bv);
	}
	
	protected abstract BulletinVote internalRule();
	
	public BulletinVote getVainqeur() throws ScrutinNonClosException{
		if(! this.estClos()){
			throw new ScrutinNonClosException();
		}
		return internalRule();
	}
	
	public int nombreDeVotes(){
		return this.votesExprimes.size();
	}
		
	public void clot(){
		this.estClos = true;
		this.depouilleResultats();
	}
	
	private void initializeResults(){
		for (BulletinVote bv : this.votesPossibles()){
			resultats.put(bv, 0);
		}
	}
	
	private void depouilleResultats(){
		this.initializeResults();
		for (BulletinVote bv : this.votesExprimes){
			BulletinVote tmp = bv;
			Map<BulletinVote,Integer> map = this.resultats;
			if(!this.votesPossibles.contains(bv)){
				tmp = BulletinVote.NUL;
			}
			map.put(tmp, map.get(bv)+1);
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public Set<BulletinVote> votesPossibles() {
		return votesPossibles;
	}

	public void setVotesPossibles(Set<BulletinVote> votesPossibles) {
		this.votesPossibles = votesPossibles;
	}

	public ArrayList<BulletinVote> getVotesExprimes() {
		return votesExprimes;
	}

	public void setVotesExprimes(ArrayList<BulletinVote> votesExprimes) {
		this.votesExprimes = votesExprimes;
	}

	public Map<BulletinVote, Integer> getResultats() {
		return resultats;
	}

	public void setResultats(Map<BulletinVote, Integer> resultats) {
		this.resultats = resultats;
	}

	public Set<BulletinVote> getVotesPossibles() {
		return votesPossibles;
	}

}
