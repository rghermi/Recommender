package upc.bdam.recommender.neo4j.books.relation2;

import upc.bdam.recommender.neo4j.Head;

public class RdfRelationResult {
	
	public Head head;
	

	public upc.bdam.recommender.neo4j.books.relation2.Result results;	
	
	public Head getHead() {
		return head;
	}
	public Result getResult() {
		return results;
	}
	public void setHead(Head head) {
		this.head = head;
	}
	public void setResult(Result result) {
		this.results = result;
	}
}
