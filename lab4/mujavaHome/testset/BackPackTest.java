import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;

public class BackPackTest {
	private BackPack bp;
	
	@Before
	public void setUp() throws Exception {
		bp = new BackPack();
	}

	@After
	public void release() throws Exception {
		bp = null;
	}

	@Test
	public void test0() {
		int m = 10;
		int n = 3;
		int[] w = {3,4,5};
		int[] p = {4,5,6};
		int[][] a = {
				{0,0,0,0,0,0,0,0,0,0,0},
				{0,0,0,4,4,4,4,4,4,4,4},
				{0,0,0,4,5,5,5,9,9,9,9},
				{0,0,0,4,5,6,6,9,10,11,11}
		};
		assertArrayEquals(a, bp.BackPack_Solution(m, n, w, p));
	}
}
