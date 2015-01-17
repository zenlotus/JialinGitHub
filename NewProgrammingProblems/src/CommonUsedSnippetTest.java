

import org.junit.Assert;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class CommonUsedSnippetTest {

	CommonUsedSnippet sol = null;
	@Before
	public void setUp() throws Exception {
		sol = new CommonUsedSnippet();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testFindCloesePowerOfTen() {
		Assert.assertEquals(sol.findCloesePowerOfTen(3157), 1000);
		Assert.assertEquals(sol.findCloesePowerOfTen(3), 1);
		Assert.assertEquals(sol.findCloesePowerOfTen(57), 10);
	}
	
	@Test
	public void testGcd(){
		Assert.assertEquals(sol.gcd(28, 32), 4);
	}

}
