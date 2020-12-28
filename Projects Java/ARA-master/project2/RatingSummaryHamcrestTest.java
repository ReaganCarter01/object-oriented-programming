package project2;

import org.junit.jupiter.api.Test;

import jdk.internal.jline.internal.TestAccessible;

import static org.hamcrest.MatcherAssert.assertThat; 
import static org.hamcrest.Matchers.*;

/**
 @author Alain Reyes
 @author Reagan Carter
 @author Aidan Dobkins
 */
public class RatingSummaryHamcrestTest {

  // Test 1
  /**
   * Tests the equals function
   */
  @Test 
  public void testEquals() { 
  	RatingSummary rs1 = new RatingSummary("A1EE2E3N7PW666", 2);
	  RatingSummary rs2 = rs1;
	
    assertThat(rs1, equalTo(rs2)); 

  } 

  // Test 2
  /**
   * Tests that the toSTring method
   */
  @Test
  void testRatingSummaryStringLongOfFloat(){
    RatingSummary rsTemp = new RatingSummary("A1EE2E3N7PW667", 2);
    String actualOutput = "A1EE2E3N7PW666,2,2.0,2.0,2.0,2.0\n";
    rsTemp.setList(2, 2, 2, 2);

    assertThat(actualOutput, equalTo(rsTemp.toString()));
  } 

  // Test 3
  /**
   * Tests the setDegree method
   */
  @Test
  void testSetDegreeLong(){
    RatingSummary rsTemp2 = new RatingSummary("A1EE2E3N7PW668", 2);
    rsTemp2.setDegree(5);

    assertThat(3, equalTo(rsTemp2.getDegree()));
  }

  // Test 4
  /**
   * Test the setList method
   */
  @Test
  void testSetList(){
    RatingSummary rsTemp3 = new RatingSummary("A1EE2E3N7PW669", 2);
    List<Float> testList = new ArrayList<Float>();

    testList.add(4.3);
		testList.add(3.5);
    testList.add(2.7);
    testList.add(4.5);
    rsTemp3.setList(4.3f, 3.5f, 2.7f, 4.5f); 
    
    assertThat(testList, equalTo(rsTemp3.getList()));
  }

  // Test 5
  /**
   * Tests sort stats method
   */
  @Test
  void testSortStats(){
    RatingSummary rsTemp4 = new RatingSummary("A1EE2E3N7PW676", 2);
    float testMaxValue = 5.0;

    rsTemp4.setList(3.3f, 4.7f, 5.0f, 2.7f);

    assertThat(testMaxValue, equalTo(rsTemp4.sortStats()));
  }

  // Test 6
  /**
   * Tests the avgScore Method 
   */
  @Test 
  void testAvgScore(){
    RatingSummary rsTemp5 = new RatingSummary("A1EE2E3N7PW686", 2);
    float trueScore;
    trueScore= 2.0;

    rsTemp5.setList(4.0f, 5.0f, 2.0f, 1.0f);
    
    assertThat(trueDevVal, equalTo(rsTemp5.avgScore()));
  }

  // Test 7
  /**
   * Test StDevScore method
   */
  @Test
  void testStDevScore(){
    RatingSummary rsTemp6 = new RatingSummary("A1EE2E3N7PW696", 2);
    float trueDevVal;
    trueDevVal = 4.0;

    rsTemp6.setList(4.0f, 5.0f, 2.0f, 1.0f);

    assertThat(trueDevVal, equalTo(rsTemp6.stDevScore()));
  }

  // Test 8
  /**
   * Test the calculate standard deviation method
   */
  @Test
  void testCalculateSD(){
    RatingSummary rsTemp7 = new RatingSummary("A1EE2E3N7PW766", 2);
    List<Float> temp = new ArrayList<Float>();
    temp.add(4.0);
    temp.add(2.0);

    float testMean = (temp.get(0) + tmep.get(1)) / 2.0;
    float trueStDev = 1.0;

    assertThat(trueStDev, equalTo(rsTemp7.calculateSD(temp, testMean)));
  }

  // Test 9
  /**
   * Test the printStats method
   */
  @Test
  void testPrintStats(){
    RatingSummary rsTemp8 = new RatingSummary("A1EE2E3N7PW866", 2);
    String expectOut = "1.5,2.7,3.3,5.0";

    rsTemp8.setList(1.5f, 2.7f, 3.3f, 5.0f);

    assertThat(expectOut, equalTo(rsTemp8.printStats()));
  }
  
  // Test 10
  /**
   * Test the createList method
   */
  @Test
  void testCreateList(){
    RatingSummary rsTemp9 = new RatingSummary("A1EE2E3N7PW966", 2);
    List<Float> temp2 = new ArrayList<Float>();

    temp2.add(3.5);
		temp2.add(4.5);
		temp2.add(5.0);
    temp2.add(3.1);
    
    assertThat(temp2, rsTemp9.createList(3.5f, 4.5f, 5.0f, 3.1f));
  }

  //Test 11
  /**
   * Tests a constructor to make sure that all values are being stored properly
   */
  @Test
  void testConstructor(){
    RatingSummary rsTemp10;
		rsTemp10 = new RatingSummary("A5EF2E3O7PW777", 3);

		String expectedID = "A5EF2E3O7PW777";
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

		assertThat(actualFlag, equalTo(testFlag));
  }

  // Test 12
  /**
   * Test the equal method in AbstractRating
   */
  @Test
  void testEquals(){
    RatingSummary rsTemp11 = new RatingSummary("AZ12EFR8H999", 4); 
		RatingSummary rsTemp12;
		Boolean testFlag,
            trueFlag;
            
		rsTemp11 = rsTemp12;
		testFlag = true;

		trueFlag = rs4.equals(rs3);

		assertThat(testFlag, equalTo(trueFlag));
  }

  // Test # 13
	/**
	 * Checks to make sure that the first abstract constructor is working correctly
	 */
	@Test 
	void testAbstractRatingConstructor1(){
		RatingSummary rsTemp12;
		rsTemp12 = new RatingSummary("A3EF2E3O7PW777");

		String expectedID = "A3EF2E3O7PW777";
		String inID;
		

		Boolean flag = true;
		Boolean testFlag = false;

		inID = rsTemp12.getNodeID();
		

		if(expectedID.equals(inID)){
			testFlag = true;
		}

		assertThat((flag, equalTo(testFlag));
  }
  
  // Test 14
  /**
   * Checks for negative values in Stats
   */
  @Test
  void checkForNegativeStats(){
    rs.setList(2.7f, 7.9f, -3.5f, 4.4f);

    float tempAvg;
    tempAvg = rs.avgScore();

    // Should be some sort of validation in event of bad data (Ideally)
    assertThat(tempAvg, lessThan(0));
  }

  // Test 15
  /**
   * Test for stats over 5 
   */
  @Test
  void checkForStatsOverFive(){
    rs.setList(3.5f, 4.9f, 4.1f, 9.9f);

    float tempStDev;
    tempStDev = rs.stDevScore();

    // Should be some sort of validation in event of bad data (Ideally)
    assertThat(tempStDev, lessThan(0));
  }

 	// Test 16
	/**
	 * Tests last constructor in AbstractRating
	 */
	@Test
	void testLastConstruct(){
		String actID = "AZI45GHJK123";
		long actDegree = 9;
		List<Float> testList = new ArrayList<Float>();

		testList.add(3.7f);
		testList.add(2.1f);
		testList.add(4.5f);
		testList.add(1.5f);

		AbstractRating rsNew3 = new Rating("AZI4577JK123", 4, testList);

		assertThat(testList, equalTo(rsNew2.getList()));
  }
    
    // Test 17
    /**
	 * Tests to make sure toString is working correctly
	 */
	@Test
	void testToString(){
		testString = "A3EF2E3O7PW777" + "," + "3" + "," + "1.5,2.7,3.3,5.0" + "\n";

		rs2 = new RatingSummary("A3EF2E3O7PW777", 3);
		rs2.createList(1.5f, 2.7f, 3.3f, 5.0f);

		assertThat(testString, rs2.toString());
  }
  
  // Test 18
  /**
	 * Test the collect stats with reviewers with Letter A
	 */
	@Test
	void testCollectProductStats(){
    AbstractRatingSummary rs = new RatingSummary("A1EE2E3N7PW666", 2);
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

		assertThat(actRes, rs.getList());
  }
  
  // Test 19
  /**
   * Tests the collect product stats with letter B
   */
  @Test
	void testCollectReviewerStats(){
    AbstractRatingSummary rs2 = new RatingSummary("A1EE2E3N7PW345", 2);
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

		rs2.collectProductStats(testRatings2);

		assertThat(actRes2, equalTo(rs2.getList()));
  }
  
  //Test 20
  /**
   * Test the collect stats function but with data that does not match any criteria
   */
  @Test
	void testCollectStatsEmpty(){
    AbstractRatingSummary rs3 = new RatingSummary("A1EE2E3N7PW789", 2);
		Rating rsTemp7 = new Rating("C3EF2E397PW777", "D3EF2E3O7FR777", 1.0f);
		Rating rsTemp8 = new Rating("C3EL2E3O7PW777", "D3EF2E3O7FR777", 2.0f);
		Rating rsTemp9 = new Rating("C3EF2E3O7PW666", "D3EF2E3O7FR777", 3.0f);
		List<Rating> testRatings3 = new ArrayList<Rating>();

		testRatings3.add(rsTemp7);
		testRatings3.add(rsTemp8);
		testRatings3.add(rsTemp9);

		List<Float> actRes3 = new ArrayList<Float>();

		rs3.collectProductStats(testRatings3);

		assertThat(actRes3, equalTo(rs3.getList()));
	}
} 