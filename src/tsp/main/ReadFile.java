package tsp.main ;

import java.awt.* ;
import java.util.* ;
import java.io.* ;

public class ReadFile{

    private static final int numOfCity = 48;
	// raw data -> one line String the words seperated by " "
	public static String read ( final String fileName ) throws IOException{

		StringBuilder sb = new StringBuilder() ;

		BufferedReader br = new BufferedReader(new FileReader(fileName));

		String line;

		int i = 0;

		while((line = br.readLine()) != null){	
		
			// first 7 lines : unnecessary information
			if(i>=7)	
				sb.append(line);
			i++;

		}
		
		return sb.toString();

	}

	// one line data to 2-dimensional int array
	public static Integer[][] toArr( String str ){
		
		Integer arr[][] = new Integer[numOfCity][numOfCity] ;
	
		int row = 0 ;
			
		str = str.replace("0EOF", "") ;
		// replace "0EOF" with ""
		
	    String[] subStrings = str.split(" 0 ");
		// split by row

        arr[0][0] = 0;

        for(String subString : subStrings){

            try{

                row++;

                if(row == 1)continue;

                Integer[] oneRowTemp = toIntElement(subString);
				// split the row into word unit
			
                for(int j = 0; j<row; j++){
    
                    arr[row-1][j] = oneRowTemp[j];
					// lower half

                    arr[j][row-1] = oneRowTemp[j];
					// upper half
	
                }
    
                arr[row-1][row-1] = 0;
				// fill the blank on diagonal line with zero				

            }catch(Exception e){

                e.printStackTrace();

            }
        }
		
		return arr;
	}

	// row -> int []
    private static Integer[] toIntElement(String oneRow) throws Exception{

        String[] sub = oneRow.split(" ");
		// split a row into int word element 

        Integer[] oneRowArr = new Integer[48];

        for(int i = 0; i<sub.length; i++){

            if(sub[i] == null)
                sub[i] = "0";

//            System.out.println(sub[i]+"\n");

            oneRowArr[i] = Integer.parseInt(sub[i]);
            
        }

        return oneRowArr;
    }

}
