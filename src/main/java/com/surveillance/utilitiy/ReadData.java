package com.surveillance.utilitiy;



import java.util.Hashtable;

//import org.testng.annotations.Test;






public class ReadData {
public static void main(String[] args) {
//	getData()
}
	
	/**
	 * Method Name	: getData
	 * purpose		:   // find the test in xls
						// find number of cols in test
						// number of rows in test
						// put the data in hashtable and put hashtable in object array
						// return object array
	 * parameters 	: sheet name, testcase, xls
	 * Example		: <MasterSheet>, <>, <>
	 */
		public static Object[][] getData(String sheetName,String testCase,Xls_Reader xls){
		 			System.out.println("*************");
			// find the test in xls
			// find number of cols in test
			// number of rows in test
			// put the data in hashtable and put hashtable in object array
			// return object array
			
			int testCaseStartRowNum=0;
			for(int rNum=1;rNum<=xls.getRowCount(sheetName);rNum++){
				
				if(testCase.equals(xls.getCellData(sheetName, 0, rNum))){
					testCaseStartRowNum = rNum;
					break;
				}
			}
			System.out.println("Test Starts from row -> "+ testCaseStartRowNum);
			
			
			// total cols
			int colStartRowNum=testCaseStartRowNum+1;
			int cols=0;
			while(!xls.getCellData(sheetName, cols, colStartRowNum).equals("")){
				cols++;
			}
			System.out.println("Total cols in test -> "+ cols);
			

			// rows
			int rowStartRowNum=testCaseStartRowNum+2;
			int rows=0;
			while(!xls.getCellData(sheetName, 0, (rowStartRowNum+rows)).equals("")){
				rows++;
			}
			System.out.println("Total rows in test -> "+ rows);
			Object[][] data = new Object[rows][1];
			Hashtable<String,String> table=null;
			
			// print the test data
			for(int rNum=rowStartRowNum;rNum<(rows+rowStartRowNum);rNum++){
			table=new Hashtable<String,String>();
				for(int cNum=0;cNum<cols;cNum++){
					table.put(xls.getCellData(sheetName, cNum, colStartRowNum),xls.getCellData(sheetName, cNum, rNum));
					System.out.print(xls.getCellData(sheetName, cNum, rNum)+" - ");
				}
				data[rNum-rowStartRowNum][0]=table;
				System.out.println();
			}

			return data;// dummy
				
			
		}


		/**
		 * Method Name	: getDataNew
		 * purpose		:   // find the test in xls
							// find number of cols in test
							// number of rows in test
							// put the data in hashtable and put hashtable in object array
							// return object array
		 * parameters 	: sheet name, testcase, xls
		 * Example		: <MasterSheet>, <>, <>
		 */
		public static Hashtable<String, String>[][] getDataNew(String sheetName,String testCase,Xls_Reader xls){
 			System.out.println("*************");
	// find the test in xls
	// find number of cols in test
	// number of rows in test
	// put the data in hashtable and put hashtable in object array
	// return object array
	
	int testCaseStartRowNum=0;
	for(int rNum=1;rNum<=xls.getRowCount(sheetName);rNum++){
		
		if(testCase.equals(xls.getCellData(sheetName, 0, rNum))){
			testCaseStartRowNum = rNum;
			break;
		}
	}
	System.out.println("Test Starts from row -> "+ testCaseStartRowNum);
	
	
	// total cols
	int colStartRowNum=testCaseStartRowNum+1;
	int cols=0;
	while(!xls.getCellData(sheetName, cols, colStartRowNum).equals("")){
		cols++;
	}
	System.out.println("Total cols in test -> "+ cols);
	

	// rows
	int rowStartRowNum=testCaseStartRowNum+2;
	int rows=0;
	while(!xls.getCellData(sheetName, 0, (rowStartRowNum+rows)).equals("")){
		rows++;
	}
	System.out.println("Total rows in test -> "+ rows);
	Hashtable<String,String>[][] data = new Hashtable[rows][1];
	Hashtable<String,String> table=null;
	
	// print the test data
	for(int rNum=rowStartRowNum;rNum<(rows+rowStartRowNum);rNum++){
	table=new Hashtable<String,String>();
		for(int cNum=0;cNum<cols;cNum++){
			table.put(xls.getCellData(sheetName, cNum, colStartRowNum),xls.getCellData(sheetName, cNum, rNum));
//			System.out.print(xls.getCellData(sheetName, cNum, rNum)+" - ");
		}
		data[rNum-rowStartRowNum][0]=table;
//		System.out.println();
	}

	return data;// dummy
	}

		

		/**
		 * Method Name	: getData
		 * purpose		: returns the total number of steps present in a testcase
		 * parameters 	: sheet name, Testcase, xls, TotalSteps
		 * Example		: <BarcodeConfigTc>, <TC3>, <>, <40>
		 */		
public static int stepsCount(String sheetName,String TCID,Xls_Reader xls,int totalSteps)
{
			int stepNumber=0;
			int rowNum=2;
			
			for(int i=0;i<totalSteps;i++)
			{
				
										
			if(TCID.equals(xls.getCellData(sheetName, "TCID", rowNum)))
					{
				stepNumber++;
					}
			rowNum++;
					}
			
			return stepNumber;
			
		}
		
		
		
	}


