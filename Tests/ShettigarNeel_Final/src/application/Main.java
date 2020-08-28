/* Neel Shettigar
 * CIS 2212-800 Java 1 FlexPace
 * Assignment Final  
 * July 29, 2020
 * 
 * Online resources used:
 * https://www.youtube.com/watch?v=4jTzMb32VlI
 * 	-Youtube video explaining the different types of dialog boxes in JavaFX, 
 * 	 from which I learned how to effectively use them for user input and
 * 	 displaying messages
 * 
 * https://stackoverflow.com/questions/44548460/javafx-stage-close-event-handler:
 * 	-Stackoverflow discussion on event handler for when the stage is closed.
 * 	 I used part of this code so that I could call the save to file method
 * 	 when the user exited the program. 
 *  
 */

package application;

// import libraries 
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ListView;
import javafx.scene.control.TextInputDialog;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;


public class Main extends Application {
	@Override
	public void start(Stage primaryStage) {
		Library library = new Library();
		
		VBox root = new VBox(); // root pane
		ListView display = new ListView(); //library view pane
		GridPane options = new GridPane(); // library options pane
		library.open();
		library.printDisplay(display);
		
		// create button objects
		Button add = new Button("Add");
		Button checkOut = new Button("Check Out");
		Button checkIn = new Button("Check In");
		Button delete = new Button("Delete");
		
		// add buttons to library options pane
		options.add(add, 0, 0);
		options.add(checkOut, 1, 0);
		options.add(checkIn, 2, 0);
		options.add(delete, 3, 0);
		options.setHgap(20); // spacing between buttons
		options.setPadding(new Insets(10, 70, 10, 70)); // margins around grid
		
		// add functionality to buttons
		add.setOnAction((e) ->
		{
			String title = dialogInput("Title: ");
			String format = dialogInput("Format: ");
			
			library.addNewItem(title, format);
			library.printDisplay(display);
			
		});
		
		checkOut.setOnAction((e) ->
		{
			String name = dialogInput("Who did you loan this to?");
			String date = dialogInput("When did you loan it (date)?");
						
			library.markItemOnLoan(getSelectedString(display), name, date);
			library.printDisplay(display);
			
		});
		
		checkIn.setOnAction((e) ->
		{
			library.markItemReturned(getSelectedString(display));
			library.printDisplay(display);
			
		});
		
		delete.setOnAction((e) ->
		{			
			library.deleteItem(getSelectedString(display));
			library.printDisplay(display);
			
		});
		
		root.getChildren().addAll(display, options); // add both library panes to root pane
		Scene scene = new Scene(root); // create a new scene with root pane
		primaryStage.setScene(scene);
		primaryStage.setTitle("My Library");
		primaryStage.show();
		
		// event handle for when user closes window
		primaryStage.setOnHiding((e) -> 
		{
			library.save();
		});

	}
	
	public static void main(String[] args) {
		launch(args); // open GUI application
	}
	
	// returns highlighted/selected text from the ListView library display
	public String getSelectedString(ListView display) {
		Object selected = display.getSelectionModel().getSelectedItem();
		String s = selected.toString();
		String title = s.substring(0, s.lastIndexOf("("));
		title = title.trim();
		return title;
	}
	
	// method to use a dialog box for user input 
	public String dialogInput(String prompt) {
		TextInputDialog input = new TextInputDialog();
		input.setTitle("Input");
		input.setHeaderText(prompt);
		return input.showAndWait().get();
		
	}
	
	// method to use a dialog box for displaying a message(alert)
	public static void dialogAlert(String message) {
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Message");
		alert.setHeaderText(null);
		alert.setContentText(message);
		alert.showAndWait();
		
	}
}
