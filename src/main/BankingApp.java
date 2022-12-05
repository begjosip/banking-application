/**
 *
 * @author Josip Begic
 */

package main;

import formsUI.*;

public class BankingApp {
	public static void main(String args[]) {
		MenuForm mainFrame = new MenuForm();
		mainFrame.setLocationRelativeTo(null);
		mainFrame.setVisible(true);
		System.out.println("App running!");
	}
}