/*
 * 	Used to read the statistics
 *	Has several static functions to use for reading
 *	(Non-creational class)
 */
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class StatisticsReader {
	
	private StatisticsReader(){}	//don't allow instances of this object
									//static functions call only
	
	public static double[] readRatingFromFile(String filename) throws NullPointerException,IOException{
		double[] 	m_rates = new double[256];
		File		m_file = new File(filename);
		final int 	SPACE = 32;

		if (m_file==null)
			throw new NullPointerException("The file object is not set");
	
		BufferedReader br = new BufferedReader(new FileReader(m_file));
		while (br.ready()) {
			String sLine = br.readLine();
			
			int indexOfSpace = sLine.indexOf(SPACE);
			if (indexOfSpace>-1)
			{
				String sCharPart = sLine.substring(0, indexOfSpace).trim();		//left part
				String sRatePart = sLine.substring(indexOfSpace+1).trim(); 		//right part
				
				int asciiValue;
				if (sCharPart.equals("space")) {
					asciiValue = 32;
				}
				else {
					asciiValue = (int)(sCharPart.charAt(0)); 
				}
				m_rates[asciiValue] = Double.parseDouble(sRatePart);
			}
		}
		
		return m_rates;
	}

	public static double[] countRatingInFile(String filename) throws NullPointerException,IOException{ 
		double[] 	m_rates = new double[256];
		double[] 	m_counters= new double[256];
		int			m_sumCount=0;
		File		m_file = new File(filename);
		final int 	SPACE = 32;
		char[]		buf = new char[4096];
		int 		bytesRead=0;

		if (m_file==null)
			throw new NullPointerException("The file object is not set");

		//init 'm_counters' array
		for (int i=0 ; i<m_counters.length ; i++)
			m_counters[i]=0;
		
		//read from file
		BufferedReader br = new BufferedReader(new FileReader(m_file));

		//read chars and update counter array;
		do {
			bytesRead = br.read(buf);
			for (int i=0 ; i<bytesRead ; i++) {
				char c = Character.toUpperCase(buf[i]);
				if (isHandledChar(c)) {
					m_counters[(int)c]++;
				}				
			}	
		}while ( br.ready() );
		
		
		//calc sum of count
		m_sumCount=0;
		for (int i=0 ; i<m_counters.length ; i++) {
			m_sumCount += m_counters[i];
		}
		
		//calc rates
		for (int i=0 ; i<m_counters.length ; i++) {
			m_rates[i] = m_counters[i] / m_sumCount;
		}
		
		return m_rates;
	}
	
	public static final boolean isHandledChar(char c) {
		if ( (c>='a' && c<='z') || (c>='A' && c<='Z') || c==' ')
			return true;
		else			
			return false;
	}
}
