package org.dharam.logviewer.websocket;


// Import the Java classes
import java.util.*;
import java.io.*;

/**
 * Implements console-based log file tailing, or more specifically, tail following:
 * it is somewhat equivalent to the unix command "tail -f"
 */
public class Tail implements LogFileTailerListener
{
  /**
   * The log file tailer
   */
  private LogFileTailer tailer;

  /**
   * Creates a new Tail instance to follow the specified file
   */
  public Tail( String filename )
  {
    tailer = new LogFileTailer( new File( filename ), 1000, false );
    tailer.addLogFileTailerListener( this );
    tailer.start();
  }

  /**
   * A new line has been added to the tailed log file
   * 
   * @param line   The new line that has been added to the tailed log file
   */
  public void newLogFileLine(String line)
  {
    System.out.println( line );
  }

  
  /**
   * Command-line launcher
   */
  public static void main( String[] args )
  {
    /*if( args.length < 1 )
    {
      System.out.println( "Usage: Tail <filename>" );
      System.exit( 0 );
    }*/
    Tail tail = new Tail("D:/Dharam/Logs Files/10.10.34.24_log1/log1/customer_logs.log");
  }
}