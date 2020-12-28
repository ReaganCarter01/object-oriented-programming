package project2;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import jdk.internal.jline.internal.TestAccessible;

/**
 * 
  @author Alain Reyes
  @author Reagan Carter
  @author Aidan Dobkins
 */
class RatingSummaryTest {

	public RatingSummary rs;

	/**
	 * Displays to the user that tests are starting
	 */
	@BeforeAll
	public void startUp(){
		System.out.println("Starting Tests...");
		for(int i = 0; i < 5; ++i){
			System.out.println("");
		}

	}

	/**
	 * Displays to the user that the test are over
	 */
	@AfterAll
	public void endTest(){
		System.out.println("Tests ending...")
	}
	
	/**
	 * Creates "Default" object from RatingSummary to use before each test
	 */
	@BeforeEach
	public void setup() {
		rs = new RatingSummary("A1EE2E3N7PW666", 2);
	}

	// From class RatingSummary
	// Test # 1
	@Test
	void testRatingSummaryStringLongListOfFloat() {
		String actualOutput = "A1EE2E3N7PW666,2,2.0,2.0,2.0,2.0\n";
		rs.setList(2, 2, 2, 2);
		Assertions.assertTrue(actualOutput.equals(rs.toString()));
	}


	// From class AbstractRatingSummary
	// Test # 2
	@Test
	void testSetDegreeLong() {
		rs.setDegree(3);
		Assertions.assertEquals(3,rs.getDegree());
	}

	// Test # 3
	/**
	 * Test setList and makes sure that the list is being created correctly
	 */
	@Test
	void testSetList(){
		List<Float> testList = new ArrayList<Float>();
		
		testList.add(4.3);
		testList.add(3.5);
		testList.add(2.7);
		testList.add(1.8)
		rs.setList(4.3f, 3.5f, 2.7f, 1.8f); 
		Assertions.assertEquals(testList, rs.getList());
	}

	// Test # 4
	/**
	 * Test sort stats, ensures that the max value is being collected
	 */
	@Test
	void testSortStats(){
		float testMaxValue = 5.0;
		rs.setList(3.3f, 4.7f, 5.0f, 2.7f);
		Assertions.assertEquals(testMaxValue, rs.sortStats());
	}

	// Test # 5
	/**
	 * Tests avgScore methods by making sure the average is correctly calculated
	 */
	@Test 
	void testavgScore(){
		float trueScoreVal;
		trueScoreVal = 2.0;
		
		rs.setList(4.0f, 5.0f, 2.0f, 1.0f);

		Assertions.assertEquals(trueScoreVal, rs.avgScore());
	}

	// Test # 6
	/**
	 * Test StDevScore method, makes sure the StDevScore is correctly calculated
	 */
	@Test 
	void testStDevScore(){
		float trueDevVal;
		
		trueDevVal = 4.0;
		
		rs.setList(4.0f, 5.0f, 2.0f, 1.0f);

		Assertions.assertEquals(testStDevVal, rs.stDevScore());
	}

	// Test # 7
	/** 
	 * Test calcSD method, makes sure that the SD is being correctly calculated
	 */
	@Test
	void testCalculateSD(){
		List<Float> testList5 = new ArrayList<Float>();
		testList5.add(4.0);
		testList5.add(2.0);

		float testMean = (testList5.get(0) + testList5.get(1)) / 2.0;
		float trueStDev;

		trueStDev = 1.0;

		Assertions.assertEquals(trueStDev, rs.calulateSD(testList5, testMean));
	
	}

	// Test # 8
	/**
	 * Test printStats, makes sure that stats stored are being recorded
	 */
	@Test 
	void testPrintStats(){
		String testOutput = "1.5,2.7,3.3,5.0";
		rs.setList(1.5f, 2.7f, 3.3f, 5.0f);

		Assertions.assertEquals(testOutput, rs.printStats());
	}

	// Test # 9
	/**
	 * Test createList, makes sure that the createList is working correctly
	 */
	@Test 
	void testCreateList(){
		List<Float> testList6 = new ArrayList<Float>();

		testList6.add(3.5);
		testList6.add(4.5);
		testList6.add(5.0);
		testList6.add(3.1);

		rs.createList(3.5f, 4.5f, 5.0f, 3.1f);

		Assertions.assertEquals(testList6, rs.createList(3.5f, 4.5f, 5.0f, 3.1f));
	}

	// Test # 10
	/**
	 * Checks to make sure that the constructor is working correctly
	 */
	@Test 
	void testAbstractRatingConstructor2(){
		RatingSummary rs2;
		rs2 = new RatingSummary("A3EF2E3O7PW777", 3);

		String expectedID = "A3EF2E3O7PW777";
		long expectedDegree = 3;
		String inID;
		long inDegree;

		Boolean flag = true;
		Boolean testFlag = false;

		inID = rs2.getNodeID();
		inDegree = rs2.getDegree();

		if(expectedID.equals(inID) && expectedDegree == inDegree){
			testFlag = true;
		}

		Assertions.assertEquals(flag, testFlag);
	}

	// Test # 11
	/**
	 * Test the equals method in AbstractRatingSummary
	 */
	@Test
	void testEquals(){
		RatingSummary rs3;
		RatingSummary rs4;
		Boolean testFlag,
		        trueFlag;

		rs3 = new RatingSummary("AZ12EFR8H999", 4);
		rs4 = rs3;
		testFlag = true;

		trueFlag = rs4.equals(rs3);

		Assertions.assertEquals(testFlag, trueFlag);
	}


	// Test # 12
	/**
	 * Checks for invalid negative stats and prints out an error message
	 */
	@Test
	void checkForNegativeStats(){
		rs.setList(2.7f, 7.9f, -3.5f, 4.4f);

		float tempAvg;
		tempAvg = rs.avgScore();

		if(tempAvg >= 0){
			System.out.println("----ERROR!----");
			System.out.println("A negative stat was stored in setList");
			System.out.println("Cannot have negative stats!");
			System.out.println("");
			System.out.println("Displaying list tested:");

			List<Float> tempList = new ArrayList<Float>();
			tempList = rs.getList();

			for(int p = 0; p < 4; ++p){
				System.out.println("(*) " + tempList.get(p));
			}
		}
	}

	// Test # 13
	/**
	 * Checks for invalid stats over 5, on a five star scale
	 */
	@Test
	void checkForStatsOverFive(){
		rs.createList(3.5f, 4.9f, 4.1f, 9.9f);

		float tempStDev;
		tempStDev = rs.stDevScore();

		if(tempStDev > 0){
			System.out.println("----ERROR!----");
			System.out.println("An element over 5, on a scale of 5 stars entered");
			System.out.println("Cannot have stats exceed 5!");
			System.out.println("");
			System.out.println("Displaying list tested:")

			List<Float> temp2List = new ArrayList<Float>();
			temp2List = rs.getList();

			for(int u = 0; u < 4; ++u){
				System.out.println("(*) " + temp2List.get(u));
			}
		}
	}

	// Test # 14
	/**
	 * Checks to make sure that the first abstract constructor is working correctly
	 */
	@Test 
	void testAbstractRatingConstructor1(){
		RatingSummary rs2;
		rs2 = new RatingSummary("A3EF2E3O7PW777");

		String expectedID = "A3EF2E3O7PW777";
		long expectedDegree;
		String inID;

		Boolean flag = true;
		Boolean testFlag = false;

		inID = rs2.getNodeID();

		if(expectedID.equals(inID)){
			testFlag = true;
		}

		Assertions.assertEquals(flag, testFlag);
	}

	// Test # 15
	/**
	 * Tests to make sure toString is working correctly
	 */
	@Test
	void testToString(){
		testString = "A3EF2E3O7PW777" + "," + "3" + "," + "1.5,2.7,3.3,5.0" + "\n";

		rs2 = new RatingSummary("A3EF2E3O7PW777", 3);
		rs2.createList(1.5f, 2.7f, 3.3f, 5.0f);

		Assertions.assertEquals(testString, rs2.toString());
	}

	// Test # 16
	/**
	 * Test the collect stats with reviewers with Letter A
	 */
	@Test
	void testCollectProductStats(){
		Rating rsTemp = new Rating("A3EF2E3O7PW777", "B3EF2E3O7PW777", 2.0f);
		Rating rsTemp2 = new Rating("A3EF2E3O7PW777", "B3EF2E3O7PW777", 3.0f);
		Rating rsTemp3 = new Rating("A3EF2E3O7PW777", "B3EF2E3O7PW777", 4.0f);
		List<Rating> testRatings = new ArrayList<Rating>();

		testRatings.add(rsTemp);
		testRatings.add(rsTemp2);
		testRatings.add(rsTemp3);

		List<Float> actRes = new ArrayList<Float>();
		actRes.add(3.0f);
		actRes.add(1.0f);
		actRes.add(3.0f);
		actRes.add(1.0f);

		rs.collectProductStats(testRatings);

		Assertions.assertEquals(actRes, rs.getList());
	}


	// Test # 17
	@Test
	void testCollectReviewerStats(){
		Rating rsTemp4 = new Rating("A3EF2E397PW777", "B3EF2E3O7FR777", 1.0f);
		Rating rsTemp5 = new Rating("A3EL2E3O7PW777", "B3EF2E3O7FR777", 2.0f);
		Rating rsTemp6 = new Rating("A3EF2E3O7PW666", "B3EF2E3O7FR777", 3.0f);
		List<Rating> testRatings2 = new ArrayList<Rating>();

		testRatings2.add(rsTemp4);
		testRatings2.add(rsTemp5);
		testRatings2.add(rsTemp6);

		List<Float> actRes2 = new ArrayList<Float>();
		actRes2.add(2.0f);
		actRes2.add(1.0f);
		actRes2.add(2.0f);
		actRes2.add(1.0f);

		rs.collectProductStats(testRatings2);

		Assertions.assertEquals(actRes2, rs.getList());
	}

	// Test # 18
	@Test
	void testCollectStatsEmpty(){
		Rating rsTemp7 = new Rating("C3EF2E397PW777", "D3EF2E3O7FR777", 1.0f);
		Rating rsTemp8 = new Rating("C3EL2E3O7PW777", "D3EF2E3O7FR777", 2.0f);
		Rating rsTemp9 = new Rating("C3EF2E3O7PW666", "D3EF2E3O7FR777", 3.0f);
		List<Rating> testRatings3 = new ArrayList<Rating>();

		testRatings3.add(rsTemp7);
		testRatings3.add(rsTemp8);
		testRatings3.add(rsTemp9);

		List<Float> actRes3 = new ArrayList<Float>();

		rs.collectProductStats(testRatings3);

		Assertions.assertEquals(actRes3, rs.getList());
	}

	// Test # 19
	/**
	 * Test the compareTo funciton in AbstractRating
	 */
	@Test
	void testCompareTo(){
		AbstractRating rsNew = new Rating("A3FF2E397PW777", 5);
		int isZero = 0;

		Assertions.assertEquals(isZero, rsNew.compareTo(rsNew));
		
	}

	// Test # 20
	/**
	 * Tests last constructor in AbstractRating
	 */
	@Test
	void testLastConstruct(){
		String actID = "AZI45GHJK123";
		long actDegree = 9;
		List<Float> testList = new ArrayList<Float>();

		testList.add(4.5f);
		testList.add(4.1f);
		testList.add(3.5f);
		testList.add(4.5f);

		AbstractRating rsNew2 = new Rating("AZI45GHJK123", 9, testList);

		Assertions.assertEquals(testList, rsNew2.getList());
	}

}
