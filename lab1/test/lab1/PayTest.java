package lab1;

import static org.junit.Assert.assertEquals;
import java.util.*;
import org.junit.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import lab1.Pay;

@RunWith(Parameterized.class)
public class PayTest {
	private int input;
	private boolean expected;
	private Pay l = null;
	
	public PayTest(int input, boolean expected) {
		this.input = input;
		this.expected = expected;
	}
	
	@Before
	public void setUp() { // Initialize the pocket.
		this.l = new Pay();
	}
	
	@Parameters
	public static Collection<Object[]> getData(){
		return Arrays.asList(new Object[][]{
			{-1, false},
			{0, true},
			{1, true},
			{3, true},
			{6, true},
			{10, true},
			{15, true},
			{30, true},
			{50, true},
			{93, true},
			{94, false}
		});
	}
	
	@Test
	public void test() {
		this.l.payMoney(this.input);
		assertEquals(this.l.getResult(), this.expected);
		System.out.println(this.l.getDetail());
	}
}
