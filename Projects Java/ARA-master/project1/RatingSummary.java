package project1;

//import java.util.Scanner;
//import java.util.ArrayList;
//import java.lang.Math;
//import java.util.Collections;

import java.util.*;
import java.io.*;

/**
* Ratings Summary supporting inner and outer statistics of the review 
  @author Alain Reyes
  @author Reagan Carter
  @author Aidan Dobkins
*/

public class RatingSummary extends AbstractRatingSummary{

	/**
	 * Constructor.
	 * 
	 * @param inNodeID
	 * @param inDegree
	 * @param inList
	 */
	public RatingSummary(final String inNodeID, final long inDegree, final List inList) {
		super(inNodeID, inDegree, inList);
	}



	/**
     * Constructor.
	 * 
     * @param inNodeID
     * @param inDegree
     */
    public RatingSummary(final String inNodeID, final long inDegree) {
		super(inNodeID, inDegree);
	}

	/**
     * Constructor.
     * 
     * @param id        	product/review id
     * @param degree		number of times reviewed
     * @param productAvg    average rating of the product
     * @param productStDev 	standard deviation of the product's rating
     * @param reviewerAvg   average rating of the reviewer
     * @param reviewerStDev standard deviation of the reviewer's ratings
     */
	public RatingSummary(final String id, final long degree, final float productAvg, final float productStDev, final float reviewerAvg,
	final float reviewerStDev) {
		//super(id, degree, productAvg, productStDev, reviewerAvg, reviewerStDev);
		super(id, degree);
	}

	/**
	 * @param id
	 * @param rawRatings
	 */
	public RatingSummary(final String id, final List<Rating> rawRatings) {
		super(id);
		super.setDegree(rawRatings);
	}

	public void setList() {
		super.setList(createList());
	}

	public void setList(float productAvg, float productStDev, float reviewerAvg, float reviewerStDev) {
		super.setList(this.createList(productAvg, productStDev, reviewerAvg, reviewerStDev));
	}

	@Override
	public List<Float> createList(){
		List<Float> arrList = new ArrayList<Float>();
		return arrList;
	}

	public List<Float> createList(float productAvg, float productStDev, float reviewerAvg, float reviewerStDev) {
		List<Float> Stats = new ArrayList<Float>();
		Stats.add(Float.valueOf(productAvg));
		Stats.add(Float.valueOf(productStDev));
		Stats.add(Float.valueOf(reviewerAvg));
		Stats.add(Float.valueOf(reviewerStDev));

		return Stats;
	}


	/**
	 * Prints RatingSummary object as form Id,degree,product avg,product st.dev,reviewer avg,reviewer st.dev\n
	 */
	@Override
	public String toString(){
		String oneLine;
		oneLine = this.getNodeID() + ", " + this.getDegree() + ", " 
				+ (getList().get(0)) + ", " + (getList().get(1))
				+ ", " + (getList().get(2)) + ", " + (getList().get(3));

		return oneLine;	
	}

	private String printStats() {
		String inString = toString();
		
		System.out.println(inString);
		return inString;
	}

	/**
	 * collect the list that keeps statistics 
	 * Make sure the object was initialized 
	 */
	@Override
	public void collectStats(final List<Rating> rawRatings){
		boolean isEmpt = rawRatings.isEmpty();

		if(isEmpt == true){
			System.out.println("List empty no stats to collect");
		}
		else{
			collectProductStats(rawRatings);
			collectReviewerStats(rawRatings);	
		}
	}

	/**
	 * Collects product stats for nodeID -- never call this function directly, only through collectStats
	 * @param rawRatings
	 */
	public void collectProductStats(final List<Rating> rawRatings) {
		float totalStats = 0;
		float productAvg = 0;
		float productStDev = 0;

		for(int i = 2; i < rawRatings.size(); i += 3){
			totalStats += rawRatings.get(i).getRating();
		}

		productAvg = (totalStats) / (rawRatings.size() / 3);

		for(int j = 2; j < rawRatings.size(); j += 3){
			productStDev += Math.pow(rawRatings.get(j).getRating() - productAvg, 2) / rawRatings.size();
		}

		//this.setList(createList(productAvg, productStDev, reviewerAvg, reviewerStDev));

	}

	/**
	 * Collects product stats for nodeID -- never call this function directly, only through collectStats
	 * @param rawRatings
	 */
	public void collectReviewerStats(final List<Rating> rawRatings){
		List<String> reviewerName = new ArrayList<String>();
		List<Float> shown = new ArrayList<Float>();
		List<Float> totScore = new ArrayList<Float>();

		reviewerName.add(rawRatings.get(0).getReviewerID());
		//shown.add(rawRatings.get(0).getRating());
		//totScore.add(rawRatings.get(0).getRating());

		for(int i = 3; i < rawRatings.size(); i += 3){
			for(int k = 0; k < reviewerName.size(); k ++){
				if(reviewerName.get(k) == rawRatings.get(i).getReviewerID()){
					shown.set(k, shown.get(k) + 1);
					totScore.set(k, totScore.get(k) + rawRatings.get(i + 2).getRating());
				}
				else{
					reviewerName.add(rawRatings.get(i).getReviewerID());
					shown.add(0.0f);
					totScore.add(rawRatings.get(i + 2).getRating());
				}
			}
		}

		List<Float> reviewAvg = new ArrayList<Float>();
		List<Float> reviewStDev = new ArrayList<Float>();

		for(int p = 0; p < reviewerName.size(); ++p){
			reviewAvg.add(totScore.get(p) / shown.get(p));

			for(int q = 0; q < reviewerName.size(); ++q){
				reviewStDev.add(0.0f);
				for(int s = 0; s < rawRatings.size(); s += 3){
					if(reviewerName.get(q).equals(rawRatings.get(s))){
						reviewStDev.set(q, ((reviewStDev.get(q) - reviewAvg.get(q)) * (reviewStDev.get(q) - reviewAvg.get(q))) / shown.get(q));
					}
				}
			}

			reviewStDev.set(p, (float)(Math.sqrt(reviewStDev.get(p))));

			//this.setList(createList(productAvg, productStDev, reviewAvg.get(p), reviewStDev.get(p)));
		}		
	}
	

	////////// Statistics block

	/** 
	 * @return sort by biggest difference between product and review average in collection 
	 */
	public Float avgScore(){
		float avScore;
		avScore = 10.0f;//Math.abs(this.getList().get(0).floatValue(),this.getList().get(2).floatValue());
		return Float.valueOf(avScore);
	}

	/** 
	 * @return sort by biggest difference between product and review st.dev. in collection   
	 */
	public Float stDevScore(){
		float stDScore;
		stDScore = 10.0f;//Math.abs(this.getList().get(1).floatValue(),this.getList().get(3).floatValue());
		return Float.valueOf(stDScore);
	}

	/** 
	 * @return summary of statistics as key to sorting the rating summaries 
	 */
	public Float sortStats(){
		return Float.valueOf((float)this.getList().stream().mapToDouble(f -> f).max().getAsDouble());
	}

   //add methods if needed

}
