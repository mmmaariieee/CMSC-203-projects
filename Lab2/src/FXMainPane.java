


import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	private Button button1, button2, button3, button4, button5, button6;
	private Label label;
    private TextField textField;
	//  declare two HBoxes
    private HBox hBox1, hBox2;
    
	//student Task #4:
	//  declare an instance of DataManager
    private DataManager dataManager;
    
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		button1 = new Button("Hello");
        button2 = new Button("Howdy");
        button3 = new Button("Chinese");
        button4 = new Button("Clear");
        button5 = new Button("Exit");
        button6 = new Button("Ukrainian");
        
        label = new Label("Feedback:");
        
        textField = new TextField();
        
		//  instantiate the HBoxes
        hBox1 = new HBox();
        hBox2 = new HBox();
        
		//student Task #4:
		//  instantiate the DataManager instance
        dataManager = new DataManager();
        
        button1.setOnAction(new ButtonHandler());
        button2.setOnAction(new ButtonHandler());
        button3.setOnAction(new ButtonHandler());
        button4.setOnAction(new ButtonHandler());
        button5.setOnAction(new ButtonHandler());
        button6.setOnAction(new ButtonHandler());
        
		//  set margins and set alignment of the components
        Insets inset = new Insets(10);
        
        HBox.setMargin(button1, inset);
        HBox.setMargin(button2, inset);
        HBox.setMargin(button3, inset);
        HBox.setMargin(button4, inset);
        HBox.setMargin(button5, inset);
        HBox.setMargin(button6, inset);
        
        hBox1.setAlignment(Pos.CENTER);
        hBox2.setAlignment(Pos.CENTER);
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
        hBox1.getChildren().addAll(label, textField);
        
		//  add the buttons to the other HBox
        hBox2.getChildren().addAll(button1, button2, button3, button4, button5, button6);
        
		//  add the HBoxes to this FXMainPanel (a VBox)
        this.getChildren().addAll(hBox1, hBox2);
		
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	private class ButtonHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent event) {
			Button selectedButton = (Button) event.getTarget();
			
			if (selectedButton == button1) {
                textField.setText(dataManager.getHello());
            } else if (selectedButton == button2) {
                textField.setText(dataManager.getHowdy());
            } else if (selectedButton == button3) {
                textField.setText(dataManager.getChinese());
            } else if (selectedButton == button4) {
                textField.setText("");
            } else if (selectedButton == button5) {
                Platform.exit();
                System.exit(0);
            } else if (selectedButton == button6) {
            	textField.setText(dataManager.getUkrainian());
            }
		}
	}
}
	
