package org.jfree.data;

import static org.junit.Assert.*; 
import org.jfree.data.Range; 
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.experimental.runners.Enclosed;

@RunWith(Enclosed.class)
public class RangeTest {
	/*
	 * Reference:
	 * public java.lang.String toString(): Returns a string representation of this Range.
	 * Overrides: toString in class java.lang.Object
	 * Returns: A String "Range[lower,upper]" where lower=lower range and upper=upper range.
	 */
	
	//to test ToString method within Range class
	public static class ToStringTest {
		private Range test1;
		private Range test2;
		private Range test3;
		private Range test4;
		private Range test5;
	    // Different ranges are created for testing purpose
	    @Before
	    public void setUp() throws Exception {
	    	test1 = new Range (10,30);
	    	test2 = new Range (-30, -10);
	    	test3 = new Range (10.55, 99.55);
	    	test4 = new Range (0,0);
	  
	    }
	    // Checking to see if correct positive values that are in range are returned from toString() method	
	    @Test
	    public void testPositiveForMethodToString() {
	    	assertEquals("Range with lower 10 and upper 100, by calling toString method",
	    			"Range[10.0,30.0]", test1.toString());
	    }
	    // Checking to see if correct negative values that are in range are returned from toString() method	
	    @Test
	    public void testNegativeForMethodToString() {
	    	assertEquals("Range with lower -100 and upper -10, by calling toString method",
	    			"Range[-30.0,-10.0]", test2.toString());
	    }
	     // Checking to see if correct decimal values that are in range are returned from toString() method	
	    @Test
	    public void testTwoDecimalForMethodToString() {
	    	assertEquals("Range with lower 10.5 and upper 99.5, by calling toString method",
	    			"Range[10.55,99.55]", test3.toString());
	    }
	    // Checking to see if correct values that are in range are returned from toString() method	
	    @Test
	    public void testSameBoundForMethodToString() {
	    	assertEquals("Range with lower 0 and upper 0,by calling toString method",
	    			"Range[0.0,0.0]", test4.toString());
	    }
	    // Checking to see if empty string is returned as intended.
	    @Test
	    public void testNullForMethodToString() {
	    	boolean flag = false;
	    	try {
	    		test5.toString();
	    	}catch(Exception e) {
	    		flag = true;
	    	}
	    	assertTrue("Test with uninitialized input",flag);
	    }
	    
	
	    
	    @After
	    public void tearDown() throws Exception {
	    	test1 = null;
	    	test2 = null;
	    	test3 = null;
	    	test4 = null;
	    }
	}
	
	
	/*
	 * public double getLowerBound()
	 * Returns the lower bound for the range.
	 * Returns:The lower bound.
	 */

	/* Testing GetLowerBound methods in Range class */
	public static class GetLowerBoundTest {
	private Range testR;
	private Range testR2;
	private Range testR3;
	/* Two Ranges are defined below (10.0 to 30.0 and -21.3 to -20.0) for testing purpose */
	@Before
	public void setUp() throws Exception
		{
		testR = new Range(10.0, 30.0);
		testR2 = new Range(-21.3, -20.0);
		testR3 = new Range(0.00000000001,10.0);
		}
	/* Testing to see if correct positive lower bound value is returned  */
	@Test
	public void testLowerBoundPositiveValueForMethodGetLowerBound() {
		
		assertEquals("The Lower bound value is.", 10.0, testR.getLowerBound(), .0000001d);
	}
		
	/* Testing to see if correct negative lower bound value is returned  */
	@Test
	public void testLowerBoundNegativeValueForMethodGetLowerBound() {
		
		assertEquals("The Lower bound value is.", -21.3, testR2.getLowerBound(), .0000001d);
	}

	/* Testing to see if long decimal lower bound value is correctly returned  */
	@Test
	public void testLongDecimalLowerBoundValueForMethodGetLowerBound() {
		
		assertEquals("The Lower bound value is.", 0.00000000001, testR3.getLowerBound(), .0000001d);
	}

	@After
	public void tearDown()
		{
			System.out.println("Tear Down");
			testR = null;
		}

	}
	
	/*
	 * public double getUpperBound()
	 * Returns the upper bound for the range.
	 * Returns:The upper bound.
	 */

	/* Testing GetUpperBound methods in Range class */
	public static class GetUpperBoundTest {
	private Range testR;
	private Range testR2;
	private Range testR3;
	/* Two Ranges are defined below (10.0 to 30.0 and -21.3 to -20.0) for testing purpose */
	@Before
	public void setUp() throws Exception
		{
		testR = new Range(10.0, 30.0);
		testR2 = new Range(-21.3, -20.0);
		testR3 = new Range(0.00000000001,9.0000000000001);
		}
	/* Testing to see if correct positive upper bound value is returned  */
	@Test
	public void testUpperBoundPositiveValueForMethodGetUpperBound() {
		
		assertEquals("The Upper bound value is.", 30.0, testR.getUpperBound(), .0000001d);
	}
		
	/* Testing to see if correct negative upper bound value is returned  */
	@Test
	public void testUpperBoundNegativeValueForMethodGetUpperBound() {
		
		assertEquals("The Upper bound value is.", -20.0, testR2.getUpperBound(), .0000001d);
	}

	/* Testing to see if long decimal upper bound value is correctly returned  */
	@Test
	public void testLongDecimalUpperBoundValueForMethodGetUpperBound() {
		
		assertEquals("The Upper bound value is.", 9.0000000000001, testR3.getUpperBound(), .0000001d);
	}

	@After
	public void tearDown()
		{
			System.out.println("Tear Down");
			testR = null;
			testR2 = null;
			testR3 = null;
		}

	}
	
	/*
	 * 
	 * public double getCentralValue()
	 * Returns the central (or median) value for the range.
	 * Returns:The central value.
	 *
	 */
	
	public static class GetCentralValueTest {
		private Range testR;
		private Range testR2;
		private Range testR3;
		private Range testR4;
		private Range testR5;
		
		@Before
		public void setUp() throws Exception
			{
			testR = new Range(10.0, 30.0);
			testR2 = new Range(-22.0, -20.0);
			testR3 = new Range(0.00000000002,0.00000000004);
			testR4 = new Range(-10, 20);
			testR5 = new Range(100.0, 100.0);
			
			}
		/* Testing to see if correct positive central value is returned  */
		@Test
		public void testPositiveValuesForMethodGetCentralValue() {
			
			assertEquals("The Central value is.", 20.0, testR.getCentralValue(), .0000001d);
		}
			
		/* Testing to see if correct negative central value is returned  */
		@Test
		public void testNegativeValuesForMethodGetCentralValue() {
			
			assertEquals("The Central value is.", -21.0, testR2.getCentralValue(), .0000001d);
		}
		
		/* Testing to see if long decimal positive central value is correctly returned  */
		@Test
		public void testLongDecimalCentralValueForMethodGetCentralValue() {
			
			assertEquals("The Central value is.", 0.00000000003, testR3.getCentralValue(), .0000001d);
		}

		
		/* Testing to see if correct (negative or positive) central value is returned  */
		@Test
		public void testPositiveAndNegativeValuesForMethodGetCentralValue() {
			
			assertEquals("The Central value is.", 5.0, testR4.getCentralValue(), .0000001d);
		}
		
		/* Testing to see if correct central value is returned  */
		@Test
		public void testSameValuesForMethodGetCentralValue() {
			
			assertEquals("The Central value is.", 100.0, testR5.getCentralValue(), .0000001d);
		}
		

		@After
		public void tearDown()
			{
				System.out.println("Tear Down");
				testR = null;
				testR2 = null;
				testR3 = null;
				testR4 = null;
				testR5 = null;
			}

		}
	
	
	/*
	 * getLength: public double getLength()
	 * Returns the length of the range.
	 * Returns:The length.
	 */

	/* Testing GetLength methods in Range class*/
	public static class GetLengthTestingTest {
	private Range testR;
	private Range testR2;
	private Range testR3;
	private Range testR4;
	private Range testR5;
	/* Ranges are created for testing */
	@Before
	public void setUp() throws Exception
		{
		testR = new Range(10, 30);
		testR2 = new Range (20, 20);
		testR3 = new Range (-10, -5);
		testR4 = new Range (-999999999.9999999999, 9999999999.9999999999);
		testR5 = new Range (0, 0.0000000000000000000001);
		}

	/* Testing to see if expected value will be returned from getLength() for given valid input */
	@Test
	public void testDifferentUpperAndLowerBoundsForMethodGetLength() {

		assertEquals("The expected length of the Range is.", 20, testR.getLength(), .0001d);
	}

	/* Checking to see if getLength() returns the expected value for a given input */
	@Test
	public void testSameUpperAndLowerBoundsForMethodGetLength() {

		assertEquals("The expected length of the Range is.", 0, testR2.getLength(), .0001d);
	}
	/* Checking to see if getLength() positive value for negative range */
	@Test
	public void testNegativeUpperAndLowerBoundsForMethodGetLength() {

		assertEquals("The expected length of the Range is.", 5, testR3.getLength(), .0001d);
	}

	/* Checking to see if getLength() positive value for very large range */
	@Test
	public void testLargeRangeForMethodGetLength() {
		double test = 999999999.9999999999 + 9999999999.9999999999;
		assertEquals("The expected length of the Range is.", test, testR4.getLength(), .0001d);
	}

	/* Checking to see if getLength() positive value for very small range */
	@Test
	public void testSmallRangeForMethodGetLength() {
		double test = 0.0000000000000000000001;
		assertEquals("The expected length of the Range is.", test, testR5.getLength(), .0001d);
	}


	@After
	public void tearDown()
		{
			System.out.println("Tear Down");
			testR = null;
			testR2 = null;
			testR3 = null;
			testR4 = null;
			testR5 = null;
		}

	}
	
	/*
	 * public boolean equals(java.lang.Object obj): Tests this object for equality with an arbitrary object.
	 * Overrides: equals in class java.lang.Object
	 * Parameters: obj - the object to test against (null permitted).
	 * Returns: true if the input object is an equivalent range.
	 */

	/* Testing Equals method in Range class */
	public static class EqualsTest{
		
		private Range testR;
		
		/* The range of 10-20 is created for testing */
		@Before
		public void setUp() throws Exception
		{
		testR = new Range(10, 20);
		}
		
		/* Testing to see if the object is equal to itself */
		@Test
		public void testingSameRangeObject() {
			Range test = new Range(10, 20);
			assertEquals("Testing a Same Range Object",true, testR.equals(test));
		}
		
		/* Testing to see if the ranges are equal to the range objects */
		@Test
		public void testingDifferentRangeObject() {
			Range test = new Range(40, 50);
			assertEquals("Testing a Different Range Object",false, testR.equals(test));
		}
		
		/* Testing to see if the other types objects would be accepted by range object or not */
		@Test
		public void testingStringObject() {
			assertEquals("Testing a Different Object",false, testR.equals("hello"));
		}
		
		/* Testing to see object with same lower bound but different upper bound are equal or not */
		@Test
		public void testingSameLowerBoundRangeObject() {
			Range test = new Range(10, 50);
			assertEquals("Testing a Different Range Object with same lower bound",false, testR.equals(test));
		}
		
		
		/* Testing to see object with same higher bound but different lower bound are equal or not */
		@Test
		public void testingSameUpperBoundRangeObject() {
			Range test = new Range(0, 20);
			assertEquals("Testing a Different Range Object with same upper bound",false, testR.equals(test));
		}
		
		/* Testing to see if the input Range has close lower and upper bound */
		/*@Test
		public void testingCloseRangeObject() {
			Range test = new Range(9.99999999999999999, 20.00000000000000000001);
			assertEquals("Testing close Range Object",false, testR.equals(test));
		}*/
		
		//For lab4 mutation test 1
		@Test
		public void MutationTest1ForEqualsMethod() {
			Range test = new Range(10,19);
			assertEquals("Testing a Different Range Object with trival diffeence on upper bound", false, testR.equals(test));
		}
		
		//For lab4 mutation test 1
		@Test
		public void MutationTest2ForEqualsMethod() {
		Range test = new Range(9,20);
		assertEquals("Testing a Different Range Object with trival diffeence on lower bound", false, testR.equals(test));
		}
////		
		@After
		public void tearDown()
		{
			System.out.println("Tear Down");
			testR = null;
		}

	}
	
	/*
	 * public boolean contains(double value): 
	 * Returns true if the specified value is within the range and false otherwise.
	 * Parameters: value - the value to be tested
	 * Returns: true if the range contains the specified value.
	 */

	/* Testing Contains method in Range class  */
	public static class ContainsTest {
	private Range testR;

	/* The range of 10.0-30.0 is created for testing */
	@Before
	public void setUp() throws Exception
		{
		testR = new Range(10.0, 30.0);
		}
	/* Testing to see if range contains a number in between the upper and the lower bound */
	@Test
	public void testValueInRangeForMethodContains() {
		

		assertEquals("The value lies in Range.", true, testR.contains(20.0));
	}
	/* Testing to see if range contains a number that is less than the lower bound */
	@Test
	public void testValueLessThanLowerBoundForMethodContains() {

		assertEquals("The value is less than lower bound range value and lies inside Range.", false, testR.contains(-10.0));
	}
	/* Testing to see if range contains a number that is higher than the upper bound */
	@Test
	public void testValueMoreThanUpperBoundForMethodContains() {

		assertEquals("The value is more than upper bound range value and lies inside Range.", false, testR.contains(40.0));
	}

	/* Testing to see if range contains the lower bound */
	@Test
	public void testLowerBoundRangeValueForMethodContains() {

		assertEquals("The lower bound value lies in Range.", true, testR.contains(10.0));
	}
	/* Testing to see if range contains the upper bound */
	@Test
	public void testUpperBoundRangeValueForMethodContains() {

		assertEquals("The upper bound value lies in Range.", true, testR.contains(30.0));
	}

	/* Testing to see when the input near the lower bound */
/*	@Test
	public void testLowerBoundRangeValueWithCloserValueForMethodContains() {

		assertEquals("The lower bound value close but out of Range.", false, testR.contains(9.9999999999999999999999));
	}
*/
	/* Testing to see when the input near the upper bound */
	@Test
/*	public void testUpperBoundRangeValueWithCloserValueForMethodContains() {

		assertEquals("The upper bound value close but out of Range.", false, testR.contains(30.000000000000000000001));
	}*/

	@After
	public void tearDown()
		{
			System.out.println("Tear Down");
			testR = null;
		}

	}
	
	
	
	/*
	 * public static Range expand(Range range, double lowerMargin, double upperMargin)
	 * Returns object of type Range
	 * Parameters: range, lowerMargin and upperMargin
	 * 
	 */
	public static class ExpandTest{
		private Range testR;
		private Range testR2;

		/* Creating a new object for testing purpose*/
		@Before
		public void setUp() throws Exception
			{
			testR = new Range(10.0, 30.0);
			}
		
		/* Seeing if exception will be thrown for null parameter*/
		@Test
		public void TestExceptionForMethodExpandTest(){
	    	boolean flag = false;
	    	try {
	    		Range.expand(null, 0.5, 0.5);
	    		fail("Null is not allowed as a parameter");
	    	}catch(Exception e){
	    		flag = true;
	    	}
	    	assertTrue("Test with null argument",flag);
	    }
		/* Passing both positive values*/
		@Test
		public void testPositiveMarginsForMethodExpandTest() {
			
			testR2 = new Range(0.0, 40.0);
			assertEquals("The expected range output doesnt match with the actual output", testR2, Range.expand(testR, 0.5, 0.5));
		}
		/* Testing if a negative upper margin will be accepted*/
		/*@Test
		public void testNegativeUpperMarginForMethodExpandTest() {
			
			testR2 = new Range(-10, 0);
			assertEquals("The expected range output doesnt match with the actual output", testR2, Range.expand(testR, 0.5, -2.0));
		}*/
		/* Testing if a lower margin being negative will be accepted*/
		@Test
		public void testNegativeLowerMarginForMethodExpandTest() {
			
			testR2 = new Range(20.0, 50.0);
			assertEquals("The expected range output doesnt match with the actual output", testR2, Range.expand(testR, -0.5, 1.0));
		}
	
		//Mutation Test
		@Test
		public void mutationTestForMethodExpand()
		{
			testR2 = new Range(10, 20);
			
			assertNotEquals("The expected range output doesnt match with the actual output", testR2, Range.expand(testR, -0.5, -1.0));
			
			
		}
		
		//Mutation Test
		@Test
		public void mutationTest2ForMethodExpand()
		{
			testR2 = new Range(15, 15);
					
			assertEquals("The expected range output doesnt match with the actual output", testR2, Range.expand(testR, -0.5, -1.0));
							
		}
				
		
		@After
		public void tearDown()
			{
				System.out.println("Tear Down");
				testR = null;
				testR2 = null;
			}

		}
	/*
	 * Creates a new range by combining two existing ranges.
	 *Note that:either range can be null, in which case the other range is returned;
	 *if both ranges are null the return value is null.
	 *Parameters:range1 - the first range (null permitted).
	 *range2 - the second range (null permitted).
	 *Returns: A new range subsuming both input ranges (possibly null).
	 *
	 */
		public static class CombineTest{
			private Range testR;
			private Range testR2;
			private Range testR3;

			/* Creating new objects for testing purpose */
		
			@Before
			public void setUp() throws Exception
				{
				testR = new Range(10.0, 30.0);
				testR2 = new Range(30.0, 60.0);
				}
			
			/* Testing the method combine when the first Range is null */
			@Test
			public void testFirstRangeNullForMethodCombine()
			{
				testR3 = new Range(30.0, 60.0);
				
				assertEquals("The expected range output doesnt match with the actual output", testR3, Range.combine(null, testR2));
				
			}
			
			/* Testing the method combine when the second Range is null */
			@Test
			public void testSecondRangeNullForMethodCombine()
			{
				testR3 = new Range(10.0, 30.0);
				
				assertEquals("The expected range output doesnt match with the actual output", testR3, Range.combine(testR, null));
				
			}
			
			/* Testing the method combine when first and second Range objects are null */
			@Test
			public void testBothNullRangeForMethodCombine()
			{
				testR3 = null;
				
				assertEquals("The expected range output doesnt match with the actual output", testR3, Range.combine(null, null));
				
			}
			
			
			/* Testing the method combine when first and second Range objects are have values in them */
			@Test
			public void testRangesForMethodCombine()
			{
				testR3 = new Range(10.0, 60.0);
				
				assertEquals("The expected range output doesnt match with the actual output", testR3, Range.combine(testR, testR2));
				
			}
			

			
			
			
			@After
			public void tearDown()
				{
					System.out.println("Tear Down");
					testR = null;
					testR2 = null;
					testR3 = null;
				}
			
		}
		
		/*
		 * public double constrain(double value)
		 *Returns the value within the range that is closest to the specified value.
		 *Parameters:value - the value to find the closest in-range value of.
		 *Returns:The constrained value. If value is within the range, will return the input value.
		 * 
		 */
		
		public static class ConstrainTest
		{
			private Range testR;
			private Range testR2;
	
			/* Creating a Range object of testing */
			@Before
			public void setUp() throws Exception
				{
				testR = new Range(10.0, 30.0);
				testR2 = new Range(10.0, 10.0);
				}
			
			/* Testing a value that is within the range*/
			@Test
			public void testInRangeValueForMethodConstrain()
			{
				double value = 20.1;
				assertEquals("The Expected output doesnt match with the actual output.", 20.1, testR.constrain(value), .0000001d);
			}
			
			/* Testing a value that is greater than upper bound*/
			@Test
			public void testValueGreaterThanUpperLimitForMethodConstrain()
			{
				double value = 50.0;
				assertEquals("The Expected output doesnt match with the actual output.", 30.0, testR.constrain(value), .0000001d);
			}
			
			/* Testing a value that is lower than the lower bound*/
			@Test
			public void testValueSmallerThanLowerLimitForMethodConstrain()
			{
				double value = -100;
				assertEquals("The Expected output doesnt match with the actual output.", 10.0, testR.constrain(value), .0000001d);
			}
			
			/* Testing a value that is equal to the lower bound*/
			@Test
			public void testValueEqualToLowerLimitForMethodConstrain()
			{
				double value = 10;
				assertEquals("The Expected output doesnt match with the actual output.", 10.0, testR.constrain(value), .0000001d);
			}
			
			/* Testing a value that is equal to the upper bound*/
			@Test
			public void testValueEqualToUpperLimitForMethodConstrain()
			{
				double value = 30;
				assertEquals("The Expected output doesnt match with the actual output.", 30.0, testR.constrain(value), .0000001d);
			}
			
			//Mutation Test
			@Test
			public void mutationTest1ForMethodConstrain()
			{
				double value = 11;
				assertEquals("The Expected output doesnt match with the actual output.", 11, testR.constrain(value), .0000001d);
			}
			
			//Mutation Test
			@Test
			public void mutationTest2ForMethodConstrain()
			{
				double value = 9;
				assertEquals("The Expected output doesnt match with the actual output.", 10, testR.constrain(value), .0000001d);
			}
			
			//Mutation Test
			@Test
			public void mutationTest3ForMethodConstrain()
			{
				double value = 31;
				assertEquals("The Expected output doesnt match with the actual output.", 30, testR.constrain(value), .0000001d);
			}
			
			
			
			@After
			public void tearDown()
			{
					System.out.println("Tear Down");
					testR = null;

			}
		}
		
		/*
		 * public int hashCode()
		 * Returns integer hashcode for given range
		 * Parameters: None
		 *
		 * 
		 */
		public static class hashCodeTest{
			
			private Range r1;
			private Range r2;
			private Range r3;
			
			
			/* Create Range object for testing*/
			@Before
			public void setUp() throws Exception{
				r1 = new Range (1,100);	
				r2 = new Range (0,50);
				r3 = new Range(10, 40);

				
			}
			/* Testing if two different values will create a hashcode*/
			@Test
			public void stmtCoverageTestForMethodHashCode() {
				int x = r1.hashCode();
				int y = r2.hashCode();
				assertNotEquals("Test with different range input", x,y);
			}
			
			
			//mutation test
		@Test
			public void mutationTest3ForMethodHashCode() {
				int x = r3.hashCode();
				assertEquals("Test with same range input", -2074607616, x);
			}			
		
		}
		
		// Constructor TestCase
		public static class construtorTest{
			private Range r1;
			private Range r2;
			@Before
			public void setUp() throws Exception{
				r2 = new Range(0,100);
			}
			
			//test the branch with situation when lower > upper
			@Test
			public void BranchCoverageTestForConstructor() {
				boolean flag = false;
				try {
					r1 = new Range(100,0);
					fail("Error with Constructor: lower > upper accepted.");
				}catch(Exception e){
					flag = true;
				}
				assertTrue("Test Constructor with lower > up", flag);
			}
			
			// For Lab4 mutation test
			@Test(expected = IllegalArgumentException.class)
			public void MutationTest1ForConstructor() {
				r1 = new Range(100.1,100);
			}
			
			
			@After
			public void tearDown()
			{
			}
		}
		
		// Method intersects TestCase
		public static class intersectsTest{
			private Range r1;
			private Range r2;
			@Before
			public void setUp() throws Exception{
				r1 = new Range(10, 30);
			}
			
			//branch coverage (true, true)
			@Test
			public void LeftIntersectTestForIntersects() {
				assertTrue("test with arg1 < this.lower, arg2 > this.lower", r1.intersects(0,20));
			}
			
			//branch coverage (true, false)
			@Test
			public void LeftApartTestForIntersects() {
				assertFalse("test with arg1 < this.lower, arg2 < this.lower", r1.intersects(0,5));
			}
			
			//branch coverage (true, true, true)
			@Test
			public void RightIntersectTestForIntersects() {
				assertTrue("test with arg1 > this.lower, arg2 > arg1, arg1 < this.upper", r1.intersects(20,40));
			}
			
			//branch coverage (true, false, true)
			@Test
			public void RightApartTestForIntersects() {
				assertFalse("test with arg1 > this.lower, arg2 > arg1, arg1 > this.upper", r1.intersects(50,100));
			}
			
			//branch coverage (true, true, false)
			@Test
			public void InvalidInputTestForIntersects() {
				assertFalse("test with arg1 > this.lower, arg2 < arg1, arg1 < this.upper", r1.intersects(20,15));
			}
			
			//for single argument, stmt coverage test
			@Test
			public void IsIntersectTestForIntersects() {
				r2 = new Range(15,20);
				assertTrue("Intersect Input Range", r1.intersects(r2));
			}
			
			//Mutation Test
			@Test
			public void mutationTest1ForMethodIntersects()
			{
				assertTrue("test with arg1 > this.lower, arg2 > this.lower", r1.intersects(11,11));
			}
			
			//Mutation Test
			@Test
			public void mutationTest2ForMethodIntersects()
			{
				assertTrue("test with arg1 > this.lower, arg2 > this.lower", r1.intersects(29,31));
			}
			
			//Mutation Test
			@Test
			public void mutationTest3ForMethodIntersects()
			{
				assertTrue("test with arg1 < this.lower, arg2 > this.lower", r1.intersects(9,11));
			}
			
			
			
			//for single argument
			@Test
			public void NotIntersectTestForIntersects() {
				r2 = new Range(0,5);
				assertFalse("Apart Input Range", r1.intersects(r2));
			}
			
			@After
			public void tearDown()
			{
			}
		}
		
		
		//combineIgnoringNaN Method
		public static class combineIgnoringNaNTest{
			private Range r1;
			private Range r2;
			@Before
			public void setUp() throws Exception{
			}
			
			//both input null
			@Test
			public void BothNullTestForMethodcombineIgnoringNaNTest(){
				assertNull(Range.combineIgnoringNaN(r1,r2));
			}
			
			//branch coverage (true, false)
			//input 1 is null
			@Test
			public void Arg1NullTestForMethodcombineIgnoringNaN(){
				r2 = new Range (1,2);
				assertEquals("test with null input1",r2, Range.combineIgnoringNaN(r1,r2));
			}
			
			//branch coverage (false, true)
			//only input 2 is null
			@Test
			public void Arg2NullTestForMethodcombineIgnoringNaNTest(){
				r1 = new Range (1,2);
				assertEquals("test with null input1",r1, Range.combineIgnoringNaN(r1,r2));
			}
			
			//branch coverage (false,false,true)
			//both input valid, 
			@Test
			public void BothValidTestForMethodcombineIgnoringNaNTest(){
				r1 = new Range (1,2);
				r2 = new Range (2,3);
				assertEquals("Both Valid input",new Range(1,3), Range.combineIgnoringNaN(r1,r2));
			}
			
			
			@After
			public void tearDown()
			{
			}
		}
		
		//isNaNRange Method
		/*public static class isNaNRangeTest{
			private Range r1;
			@Before
			public void setUp() throws Exception{
				
				r1 = new Range (10,20);
			}
			
			@Test
			// Stmt coverage test with valid input
			public void stmtTestForMethodIsNaNRange() {
				assertTrue("Test with valid input", r1.isNaNRange());
			}
			
			
			@After
			public void tearDown(){
			}
			
		}*/
		
		//scale Method
		public static class scaleTest{
			
			private Range r1;
			private Range r2;
			
			@Before
			public void setUp() throws Exception{
				
				r1 = new Range (10,20);
			}
			
			
			//null range object
			@Test
			public void TestExceptionForMethodScale(){
		    	boolean flag = false;
		    	try {
		    		Range.scale(null, 0.5);
		    		fail("Null is not allowed as a parameter");
		    	}catch(Exception e){
		    		flag = true;
		    	}
		    	assertTrue("Test with null argument",flag);
		    }
			
			//Negative Factor
			@Test
			public void TestExceptionWithNegativeFactorForMethodScale(){
		    	boolean flag = false;
		    	try {
		    		Range.scale(r1, -0.5);
		    		fail("Negative factor value is not allowed");
		    	}catch(Exception e){
		    		flag = true;
		    	}
		    	assertTrue("Test with Negative Factor",flag);
		    }
			
			//Positive Factor and with a range object
			
			@Test
			public void TestPositiveFactorAndRangeObjectForMethodScale()
			{
				r2 = new Range(10, 20);
				assertEquals("The Expected output From Scale Method doesnot match with actual output", r2, Range.scale(r1, 1.0));
				
			}
			
			@After
			public void tearDown(){
				
				r1 =null;
				r2 = null;
			}
		}
			
			
			//shift Method
			public static class shiftTest{
				
				private Range r1;
				private Range r2;
				private Range r3;
				
				@Before
				public void setUp() throws Exception{
					
					r1 = new Range (-20,20);
					r3 = new Range(0, 0);
				}
				
				
				//null range object
				@Test
				public void TestExceptionForMethodScale(){
			    	boolean flag = false;
			    	try {
			    		Range.shift(null, 0.5, true);
			    		fail("Null is not allowed as a parameter");
			    	}catch(Exception e){
			    		flag = true;
			    	}
			    	assertTrue("Test with null argument",flag);
			    }
				
				//zero crossing is allowed and range object is not null
				
				@Test
				public void TestWithZeroCrossingForMethodShift()
				{
					r2 = new Range(1, 41);
					
					assertEquals("The Expected output From Shift Method doesnot match with actual output", r2, Range.shift(r1, 21.0, true));
				}
				
				//zero crossing is not allowed and range object is not null
				
				@Test
				public void TestWithoutZeroCrossingForMethodShift()
				{
					r2 = new Range(0, 41);
					assertEquals("The Expected output From Shift Method doesnot match with actual output", r2, Range.shift(r1, 21.0, false));
				}
				
				//zero crossing is not allowed and range object is not null and delta is zero
				@Test
				public void TestWithoutZeroCrossingWithZeroDeltaValueForMethodShift()
				{
					r2 = new Range(20, 20);
					assertEquals("The Expected output From Shift Method doesnot match with actual output", r2, Range.shift(r3, 20, false));
				}
				
				@After
				public void tearDown(){
					
					r1 =null;
					r2 = null;
					r3  =null;
				}
			}
				
				//shift Method
				public static class shift2Test{
					
					private Range r1;
					private Range r2;
					@Before
					public void setUp() throws Exception{
						
						r1 = new Range (-20,20);
					}
					
					
					//Statement coverage Test
					//Range object and positive delta value
					@Test
					public void testStmCovergeForMethodShift2()
					{
						r2 = new Range(0, 41);
						
						assertEquals("The Expected output From Shift Method doesnot match with actual output", r2, Range.shift(r1, 21.0));
					}
					
					
					@After
					public void tearDown(){
						
						r1 =null;
						r2 = null;
					}
			
			
		}
				
				
			
				//expandToInclude Method
				public static class ExpandToIncludeTest
				{
					
					private Range r1;
					private Range r2;
					private Range r3;
					private Range r4;
					@Before
					public void setUp() throws Exception{
						
						r1 = new Range (10,20);
						r3  =null;
						r4 = new Range(20, 20);
						
					}
					
					//testing with null range object
					@Test
					public void testNullRangeObjectForMethodExpandToInclude()
					{
						r2 = new Range(20, 20);
						
						assertEquals("The Expected output From ExpandToInclude Method doesnot match with actual output", r2, Range.expandToInclude(r3, 20.0));
						
					}
					
					//testing with value less than lower range value
					@Test
					public void testValueLessThanLowerRangeValueForMethodExpandToInclude()
					{
						r2 = new Range(0, 20);
						
						assertEquals("The Expected output From ExpandToInclude Method doesnot match with actual output", r2, Range.expandToInclude(r1, 0));
					}
					
					//testing with value greater than upper range value
					@Test
					public void testValueGreaterThanUpperRangeValueForMethodExpandToInclude()
					{
						r2 = new Range(10, 100);
						
						assertEquals("The Expected output From ExpandToInclude Method doesnot match with actual output", r2, Range.expandToInclude(r1, 100));
					}
					
					//testing with value equal to upper range and lower range value
					@Test
					public void testValueEqualToRangeLimitsForMethodExpandToInclude()
					{
						r2 = new Range(20, 20);
						
						assertEquals("The Expected output From ExpandToInclude Method doesnot match with actual output", r2, Range.expandToInclude(r4, 20));
					}

					@After
					public void tearDown(){
						
						r1 =null;
						r2 = null;
						r3 = null;
						r4 = null;
					}
					
				}
				
				
	
}
