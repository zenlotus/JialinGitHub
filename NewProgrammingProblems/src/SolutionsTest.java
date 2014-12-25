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

}
