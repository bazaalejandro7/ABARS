
// Import the necessary packages
import java.text.Collator;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Locale;


/**
 * 
 * Author: Alejandro Baza
 * @date 2014-10-11
 * Description: This file contains the methods that control the action of courses
 * version 1.4
 * 
 */

public class AuctionRunner {

	
	//	/**
	//	 * 
	//	 * @author Alejandro Baza
	//	 * This method puts the students that bid for courses into an Arraylist
	//	 *
	//	 */
	//
	//	public void StudentBidList() {
	//		ArrayList<String> BidList = new ArrayList<String>();
	//	}

	/**
	 * @author Alejandro Baza
	 * This method sorts the list of students that bid for courses alphabetically
	 * 
	 */

	public void SortList(String x[]) {
		int j;
		boolean flag = true;  //Determines when the sort stops
		String temp;

		while ( flag )
		{
			flag = false;
			for ( j = 0;  j < x.length - 1;  j++ )
			{	//Sort
				if ( x [ j ].compareToIgnoreCase( x [ j+1 ] ) > 0 ) 
				{                                            
					temp = x [ j ];
					x [ j ] = x [ j+1]; 
					x [ j+1] = temp; 
					flag = true;
				}
			}
		}
	}
}