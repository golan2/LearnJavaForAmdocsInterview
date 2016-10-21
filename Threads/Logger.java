import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.TimeZone;

public class Logger {
	final String DATE_FORMAT = "yyyy-MM-dd-HH-mm-ss";
	FileWriter fw;
	
	public Logger(String sFile ) throws IOException {
		fw = new FileWriter(sFile,true);
		
	}
	
	public void write(String sLine) throws IOException {
		
	    Calendar cal = Calendar.getInstance(TimeZone.getDefault());
	    java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat(DATE_FORMAT);	
	    sdf.setTimeZone(TimeZone.getDefault());	          
	    String sDateTime = sdf.format(cal.getTime());
		
		fw.write("[" + sDateTime + "] " + sLine);
		fw.flush();
	}
	
	public void writeLine(String sLine) throws IOException {
		write(sLine + "\n");
	}
}
