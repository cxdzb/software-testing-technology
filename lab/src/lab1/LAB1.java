package lab1;

import java.util.Vector;

public class LAB1 {
	private int[] pocket = {50, 20, 10, 5, 5, 1, 1, 1,};
	private boolean[] payment = new boolean[this.pocket.length];
	private boolean result = false;
	public void payMoney(Integer x) {
		for(int i = 0; i < this.pocket.length; i++) {
			this.payment[i] = false;
		}
		this.result = false;
		if(x >= 0) { // If x<0, return false.
			for(int i = 0; i < this.pocket.length; i++) { // According to size of coins, pay the coin from top to bottom.
				if(x >= pocket[i]) { // If the rest of the required money is more then current coin, pay current coin.
					x -= pocket[i];
					this.payment[i] = true;
				}
				if(x == 0) { // End to pay.
					this.result = true;
				}
			}
		}
	}
	public boolean getResult() {
		return this.result;
	}
	public String getDetail() {
		if(this.result) {
			Vector<Integer> detail = new Vector<Integer>();
			for(int i = 0; i < this.pocket.length; i++) {
				if(this.payment[i]) {
					detail.add(this.pocket[i]);
				}
			}
			return detail.toString();
		}
		return null;
	}
}
