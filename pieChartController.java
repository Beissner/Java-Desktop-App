
package piechartpractice;

import java.text.DateFormat;
import java.util.Calendar;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.chart.PieChart;
import javafx.scene.chart.PieChart.Data;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;


public class pieChartController 
{
   
    ObservableList<String> choiceList = FXCollections.observableArrayList("Country","Tests Failed","Sending IP Address","Message Class","Message ID","Date","Time");
    
    //@FXML annotation is used to tag nonpublic controller member fields and handler- connects it to the FXML file
    @FXML PieChart chart1;
    @FXML PieChart chart2;
    
    //label for pie chart title (changes depending on what data is being viewed)
    @FXML Label title1;
    @FXML Label title2;
    
    //list boxes
    @FXML ChoiceBox choiceBox1;
    //@FXML ChoiceBox choiceBox2;
    
    //DatePicker
    @FXML DatePicker datePick;
    
    @FXML
    private void initialize ()
    {
        //fill list boxes
        choiceBox1.setItems(choiceList);
        choiceBox1.setValue("Country");
        
        //choiceBox2.setItems(choiceList);
        //choiceBox2.setValue("Country");
        
        
        drawChart1();
        
       
       //set title
       title1.setText("Top 7 Message Classes"); 
       
       //fill chart2
       ObservableList<Data> list = FXCollections.observableArrayList(
            new PieChart.Data("More Java", 10),
            new PieChart.Data("More Python", 40),
            new PieChart.Data("More JavaScript", 30));
       
       chart2.setData(list);
       
        //set title
       title2.setText("Top Countries");  
        
    }
    
    private void drawChart1()
    {
        //fill chart1
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
            new PieChart.Data((String)readFile.msgClassArray.get(0), readFile.countsMsg[0]),
            new PieChart.Data((String)readFile.msgClassArray.get(1), readFile.countsMsg[1]),
            new PieChart.Data((String)readFile.msgClassArray.get(2), readFile.countsMsg[2]),
            new PieChart.Data((String)readFile.msgClassArray.get(3), readFile.countsMsg[3]),
            new PieChart.Data((String)readFile.msgClassArray.get(4), readFile.countsMsg[4]),
            new PieChart.Data((String)readFile.msgClassArray.get(5), readFile.countsMsg[5]),
            new PieChart.Data((String)readFile.msgClassArray.get(6), readFile.countsMsg[6]));
       
       chart1.setData(pieChartData);
    }
    
    
    //listener for go button
    public void goBtnListener (ActionEvent event)
    {
        //choiceBox
        String dataChoice = (String)choiceBox1.getValue();  //had to convert choiceBox object to string
        //System.out.print(dataChoice);                       //testing
        
        
        //if datePicker was selected    
        
        DateFormat fmtDate = DateFormat.getDateInstance();  //instantiate DateFormat class
           
        Calendar date = Calendar.getInstance();             //instantiate calendar class
        
        int year = date.get(Calendar.YEAR);
        int month = date.get(Calendar.MONTH);
        int day = date.get(Calendar.DAY_OF_MONTH);
        
        //testing
        //System.out.println(fmtDate.format(datePick.getTime())); 
        
       
       
        if (datePick.getValue() != null)
        {
            //only grab records with selected date
            
            //  readFile.countDate(datePick.getValue()); //figure out how to get the value entered by user
            
            //call method - fill pie chart
            drawChart1();
            
        } 
        
        
        //if timePicker was selected
        
        
        //if other filters were selected
          
    }
    
    
    
    
    
    
    
    
   //button listener for button 1
   /*public void pieChartButton1 (ActionEvent event) 
   {
      
        ObservableList<PieChart.Data> pieChartData =
                FXCollections.observableArrayList(
            new PieChart.Data((String)readFile.msgClassArray.get(0), readFile.countsMsg[0]),
            new PieChart.Data((String)readFile.msgClassArray.get(1), readFile.countsMsg[1]),
            new PieChart.Data((String)readFile.msgClassArray.get(2), readFile.countsMsg[2]),
            new PieChart.Data((String)readFile.msgClassArray.get(3), readFile.countsMsg[3]),
            new PieChart.Data((String)readFile.msgClassArray.get(4), readFile.countsMsg[4]),
            new PieChart.Data((String)readFile.msgClassArray.get(5), readFile.countsMsg[5]),
            new PieChart.Data((String)readFile.msgClassArray.get(6), readFile.countsMsg[6]));
       
       chart1.setData(pieChartData);
       
       //set title
       title1.setText("Top 7 Message Classes");
   }    
    
    
   //button listener for button 2 
   public void pieChartButton2 (ActionEvent event) 
   {
       ObservableList<Data> list = FXCollections.observableArrayList(
            new PieChart.Data("More Java", 10),
            new PieChart.Data("More Python", 40),
            new PieChart.Data("More JavaScript", 30));
       
       chart2.setData(list);
       
        //set title
       title2.setText("Top Countries");
   }    */ 

    
}
