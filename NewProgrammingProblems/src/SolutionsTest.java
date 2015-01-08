import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class SolutionsTest {

	private Solutions sol = new Solutions();
	@Before
	public void setUp() throws Exception {
		
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testConvertToTitle() {
		
		Assert.assertEquals("Y", sol.convertToTitle(25));
	}
	@Test
	public void testBackPack(){
		Assert.assertEquals(10, sol.backPackDPOptimized(11, new int[]{2,3,5,7}));
		Assert.assertEquals(99, sol.backPackDPOptimized(100, new int[]{16,16,3,5,16,16,16,16,16,16,16,16,16,16,16,16,16}));
		Assert.assertEquals(83, sol.backPackDPOptimized(90, new int[]{12,3,7,4,5,13,2,8,4,7,6,5,7}));
		Assert.assertEquals(9, sol.backPackDP(10, new int[]{3,4,8,5}));
		
	}
	@Test
	public void testPalindrome(){
		
	}

}
