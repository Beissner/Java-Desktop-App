/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package piechartpractice;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;


public class readFile 
{
      
    //declare variables and arrays
    public static ArrayList records;          //create a reference - built in array class
    public static ArrayList msgClassArray;    //to track how many new message classes are in log (deleted, virus, adult)
    ArrayList countryArray;     //to track countries
    
   // public static ArrayList displayClassArray;  //use this array to display in charts
    
    String splitString = " ";
    public static int[] countsMsg;
        
   // read file
    public readFile ()
    {
        String strLine = " ";
        
        //create object
        records = new ArrayList();
        msgClassArray = new ArrayList();
        
        //read the file
        try 
        {
            //open file
            File logFile = new File("/Users/emilybeissner/Desktop/RiverApp_Log.log");
            Scanner inputFile = new Scanner(logFile);
            
            
            //read log line by line
           while (inputFile.hasNext())   
           {
             
              strLine = inputFile.nextLine();
              
             //System.out.println (strLine);
             
             //call splitLine method
             splitLine (strLine);
            }
       
           //close file
           inputFile.close();
           
        } 
        
        catch (FileNotFoundException | InputMismatchException ex) 
        {
            System.out.println("Error processing the file."); 
        }
        
        //call method that counts message classes in log
        countMsgClass ();
    
    }
    
     // Split up line into seperate strings - put each catagory into it's own class? 
    public void splitLine (String str)
    {
        
        
         String[] splitStrings = str.split("\t");
         
         //create logFile object
         logFile setRecords = new logFile();
         
         setRecords.dateTime = splitStrings[0];
         setRecords.msgClass = splitStrings[1];
         setRecords.classID = splitStrings[2];
         setRecords.sndgIP = splitStrings[3];
         setRecords.rcvIP = splitStrings[4];
         setRecords.country = splitStrings[5];
        
         if (splitStrings.length == 7)
        {
         setRecords.failedTests = splitStrings[6].split(",");   
        }
        else
        {
            setRecords.failedTests = null;
        }
         
         //add object to array records (building array of objects)
         records.add(setRecords);
         
         //tracking message classes (adult, deleted, virus)
         //look at if found new message class - check if already exists in array
         if (!msgClassArray.contains(setRecords.msgClass)) //new msg
         {
             //add to msgClassArray
             msgClassArray.add(setRecords.msgClass);
         }
         
         //track countries
//         if (!countryArray.contains(setRecords.country))
//         {
//             //add to countryArray
//             countryArray.add(setRecords.country);
//         }
         
    
    }
    
    //method that identifies and counts message classes from log file
    public void countMsgClass ()
    {
      //create array where length of array is how many different message classes there are
      //counts how many of each there are
        
      //int[] countsMsg = new int[msgClassArray.size()]; 
       countsMsg = new int[msgClassArray.size()];
      
      for (int i=0; i< countsMsg.length; ++i)
      {
          countsMsg[i] = 0;    //why zero? 
      }
      
      //process all 250,000 records and check the how many message class and add to counter
      //records is big array of objects (one object for every line in log)
      for (int i=0; i < records.size(); ++i)
      {
          //get array index from msgClassArray for message class of this record
          logFile r = (logFile)records.get(i); //create reference to BIG ArrayList - records 
          String msgC  = r.msgClass;
          int ndx = msgClassArray.indexOf(msgC);
          //int ndx = msgClassArray.indexOf(((logFile)records.get(i)).msgClass);
                    
          countsMsg[ndx]++;
          
          
          
         
      }
      
    }
    
    //receiving date given by user
    public static void countDate (String date)
    {
      //create array where length of array is how many different message classes there are
      //counts how many of each there are
    
      
      //int[] countsMsg = new int[msgClassArray.size()]; 
      //countsMsg = new int[msgClassArray.size()];
      
        //setting everything to zero (count again)
      for (int i=0; i< countsMsg.length; ++i)
      {
          countsMsg[i] = 0;    //why zero? 
      }
      
      //process all 250,000 records and check the how many message class and add to counter
      //records is big array of objects (one object for every line in log)
      for (int i=0; i < records.size(); ++i)
      {

          //get array index from msgClassArray for message class of this record
          logFile r = (logFile)records.get(i); //create reference to BIG ArrayList - records
          
          if (r.dateTime.contains(date))
          {
                 
                String msgC  = r.msgClass;
                int ndx = msgClassArray.indexOf(msgC);

               //if statement (only grab class messages that match the date)

                countsMsg[ndx]++;
          }
          
          
       
      }
     
    }    
    
}
