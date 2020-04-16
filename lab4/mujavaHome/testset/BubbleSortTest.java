import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.util.Arrays;

public class BubbleSortTest {
	private BubbleSort bs;
	
	@Before
	public void setUp() throws Exception  {
		bs = new BubbleSort();
	}
	
	@After
	public void relese() throws Exception  {
		bs = null;
	}
	
	@Test
	public void test1() {
		int[] testArr = {1,2,4,3,5};					
		int[] testRes = {1,2,3,4,5};	
		assertArrayEquals(testRes, bs.BubbleSort(testArr));
	}
	@Test
	public void test2() {
		int[] testArr ={1,-1,3,2};
		int[] testRes = {-1,1,2,3};
		assertArrayEquals(testRes, bs.BubbleSort(testArr));
	}
	@Test
	public void test3() {
		int[] testArr = {0,-2,2,6,3,7};
		int[] testRes = {-2,0,2,3,6,7};
		assertArrayEquals(testRes, bs.BubbleSort(testArr));
	}
	@Test
	public void test4() {
		int[] testArr = {1};
		int[] testRes = {1};
		assertArrayEquals(testRes, bs.BubbleSort(testArr));
	}
}
