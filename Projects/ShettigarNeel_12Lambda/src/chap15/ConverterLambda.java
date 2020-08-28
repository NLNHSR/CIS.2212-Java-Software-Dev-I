/* Neel Shettigar
 * CIS 2212-800 Java 1 FlexPace
 * Assignment 12 - ConverterLambda  
 * July 26, 2020
 */

package chap15;

// import libraries 
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.text.DecimalFormat;
import java.util.Scanner;
import javax.swing.JFileChooser;
import javafx.application.Application;
import javafx.geometry.HPos;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.stage.Stage;

// create subclass of Applications
public class ConverterLambda extends Application
{
   @Override // override start method
   public void start(Stage primaryStage)
   {
	   int MIN = 75, MAX = 150;
       Label l1=new Label("");
       Label l1_=new Label("");
       
       // title labels
       Label l2=new Label("Currency");
       Label l2_=new Label("Converter");
       l2.setTextFill(Color.web("#B22222"));
       l2.setFont(Font.font("Rockwell",20));
       l2_.setTextFill(Color.web("#B22222"));
       l2_.setFont(Font.font("Rockwell",20));
       l2_.setPadding(new Insets(0, 0, 15, 0));
       
       // currency labels
       Label l3=new Label("US Dollars");
       l3.setPadding(new Insets(0, 0, 20, 0));
       Label l4=new Label("Indian Rupee");
       Label l5=new Label("EU Euro");
       Label l6=new Label("British Pounds");
       Label l7=new Label("Japanese Yen");
       Label l8=new Label("Korean Won");
       
       // currency text fields 
       TextField t1=new TextField();
       t1.setMinWidth(MIN);
       t1.setMaxWidth(MAX);
       TextField t2=new TextField();
       t2.setDisable(true);
       t2.setStyle("-fx-control-inner-background: #A8A8A8");
       t2.setMinWidth(MIN);
       t2.setMaxWidth(MAX);
       TextField t3=new TextField();
       t3.setDisable(true);
       t3.setStyle("-fx-control-inner-background: #A8A8A8");
       t3.setMinWidth(MIN);
       t3.setMaxWidth(MAX);
       TextField t4=new TextField();
       t4.setDisable(true);
       t4.setStyle("-fx-control-inner-background: #A8A8A8");
       t4.setMinWidth(MIN);
       t4.setMaxWidth(MAX);
       TextField t5=new TextField();
       t5.setDisable(true);
       t5.setStyle("-fx-control-inner-background: #A8A8A8");
       t5.setMinWidth(MIN);
       t5.setMaxWidth(MAX);
       TextField t6=new TextField();
       t6.setDisable(true);
       t6.setStyle("-fx-control-inner-background: #A8A8A8");
       t6.setMinWidth(MIN);
       t6.setMaxWidth(MAX);
       
       // interaction buttons
       Button bt1=new Button("Convert");
       bt1.setFont(new Font("Papyrus",10));
       bt1.setTextFill(Color.web("white"));
       bt1.setStyle("-fx-background-color: #B22222; ");
       bt1.setMinWidth(MIN);
       bt1.setMaxWidth(MAX);
       Button bt2=new Button("Clear");
       bt2.setFont(new Font("Papyrus",10));
       bt2.setTextFill(Color.web("yellow"));
       bt2.setStyle("-fx-background-color: #2F4F4F; ");
       bt2.setMinWidth(MIN);
       bt2.setMaxWidth(MAX);
       Button bt3=new Button("Exit");
       bt3.setFont(new Font("Papyrus",10));
       bt3.setTextFill(Color.web("yellow"));
       bt3.setStyle("-fx-background-color: #2F4F4F; ");
       bt3.setMinWidth(MIN);
       bt3.setMaxWidth(MAX);
       
       // USD textbox enter 
       t1.addEventHandler(KeyEvent.KEY_PRESSED, ev ->
       {
           if (ev.getCode() == KeyCode.ENTER)
           {
               bt1.fire();
               ev.consume();
           }
       });
       
       // convert button
       bt1.setOnAction((event)->
       {
           if(t1.getText().equals("") == false)
           {
               String str=t1.getText();
               str=str.substring(str.indexOf('$')+1).trim();  
               t2.setDisable(false);
               t3.setDisable(false);
               t4.setDisable(false);
               t5.setDisable(false);
               t6.setDisable(false);  
               t2.setStyle("-fx-control-inner-background: #FFFFFF");
               t3.setStyle("-fx-control-inner-background: #FFFFFF");
               t4.setStyle("-fx-control-inner-background: #FFFFFF");
               t5.setStyle("-fx-control-inner-background: #FFFFFF");
               t6.setStyle("-fx-control-inner-background: #FFFFFF");
               double val=Double.parseDouble(str);      
               double val1=val*71.23458;
               double val2=val*.90048;
               double val3=val*.83218;
               double val4=val*108.83761;
               double val5=val*1166.40492;          
               DecimalFormat df = new DecimalFormat("#.00");
               df.setGroupingUsed(true);
               df.setGroupingSize(3);  
               t2.setText("Rs."+df.format(val1));
               t3.setText(df.format(val2)+" \u20ac");
               t4.setText("\u00a3"+df.format(val3));
               t5.setText("\u00a5 "+df.format(val4));
               t6.setText("\u20a9 "+df.format(val5));
               outputToFile(val1, val2, val3, val4, val5);
               
           }
       });

       // clear button
       bt2.setOnAction((event)->
       {
           t2.setStyle("-fx-control-inner-background: #808080");
           t3.setStyle("-fx-control-inner-background: #808080");
           t4.setStyle("-fx-control-inner-background: #808080");
           t5.setStyle("-fx-control-inner-background: #808080");
           t6.setStyle("-fx-control-inner-background: #808080");
           t1.setText("");
           t2.setText("");
           t3.setText("");
           t4.setText("");
           t5.setText("");
           t6.setText("");
           t2.setDisable(true);
           t3.setDisable(true);
           t4.setDisable(true);
           t5.setDisable(true);
           t6.setDisable(true);
           
       });

       // exit button
       bt3.setOnAction((event)->
       {
           System.exit(0);
       });
       
       
       // set up grid pane
       GridPane gridPane = new GridPane();
       gridPane.setVgap(10);
       gridPane.setHgap(11);
      
       // grid alignment 
       GridPane.setHalignment(l2, HPos.CENTER);
       GridPane.setHalignment(l2_, HPos.CENTER);
       GridPane.setHalignment(l3, HPos.RIGHT);
       GridPane.setHalignment(l4, HPos.RIGHT);
       GridPane.setHalignment(l5, HPos.RIGHT);
       GridPane.setHalignment(l6, HPos.RIGHT);
       GridPane.setHalignment(l7, HPos.RIGHT);
       GridPane.setHalignment(l8, HPos.RIGHT);
      
       // add nodes(labels & buttons) to pane 
       gridPane.setPadding(new Insets(15,10,15,10));
       gridPane.setAlignment(Pos.CENTER);
       gridPane.add(l1, 0, 0);
       gridPane.add(l2, 1, 0);
       gridPane.add(l1_, 0, 1);
       gridPane.add(l2_, 1, 1);
       gridPane.add(l3, 0,2);
       gridPane.add(t1, 1, 2);
       gridPane.add(l4, 0, 3);
       gridPane.add(t2, 1, 3);
       gridPane.add(l5, 0, 4);
       gridPane.add(t3, 1, 4);
       gridPane.add(l6, 0, 5);
       gridPane.add(t4, 1, 5);
       gridPane.add(l7, 0, 6);
       gridPane.add(t5, 1, 6);
       gridPane.add(l8, 0, 7);
       gridPane.add(t6, 1, 7);
       gridPane.add(bt1, 1, 8);
       gridPane.add(bt2, 1, 9);
       gridPane.add(bt3, 1, 10);
       
       StackPane root = new StackPane();
       root.setStyle("-fx-background-color: #F5F5F5; ");
       root.getChildren().add(gridPane);
       Scene scene = new Scene(root, 300, 460);
       primaryStage.setTitle("JavaFX GUI"); // stage title
       primaryStage.setResizable(false); // prevent from changing size
       primaryStage.setScene(scene);
       primaryStage.show(); // make stage visible
   }
   
   public static void main(String[] args)
   {
       launch(args); // call GUI
   }
   
   public void outputToFile(double val1, double val2, double val3, double val4, double val5){ // method to output to users file of choice
	   Scanner input = null;
		
	   PrintWriter output = null;
		try {
			
			// create object
			JFileChooser chooseFile = new JFileChooser();	
			
			// if file is chosen, get that selected file. Be sure to choose a .txt file
			if(chooseFile.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
				File file1 = chooseFile.getSelectedFile(); 	// assign the selected file to file1 variable
				
				// write conversions to file
				output = new PrintWriter(file1);
				output.println("Rs." + val1);
	            output.println(val2 + " \u20ac");
	            output.println("\u00a3" + val3);
	            output.println("\u00a5 " + val4);
	            output.println("\u20a9 " + val5);
				
			} // end if statement
		} catch(FileNotFoundException ex) {
			System.out.println("The file you were looking for is not found. \n" + ex);
		} finally {
			output.close();   // close the file so there is no resource leak
		}
	   
	   
   }
}