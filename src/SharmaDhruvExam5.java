import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.Spinner;
import javafx.scene.control.Toggle;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.scene.control.ToggleGroup;



public class SharmaDhruvExam5 extends Application {
    public void start(Stage primaryStage) {

        Text title = new Text("A Phrase of your Choosing");
        title.setFont(Font.font("Courier New", FontWeight.BOLD, FontPosture.REGULAR, 12));

        Rectangle rect = new Rectangle(500, 500);
        rect.setFill(Color.DARKCYAN);

        Button button = new Button();
        button.setOnMousePressed(actionEvent -> {
            rect.setFill(Color.BLACK);
        });

        button.setOnMouseReleased(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent mouseEvent) {
                rect.setFill(Color.DARKCYAN);
            }
        });


        ToggleGroup group = new ToggleGroup();
        RadioButton rb1 = new RadioButton("Top");
        rb1.setToggleGroup(group);

        RadioButton rb2 = new RadioButton("Center");
        rb1.setToggleGroup(group);

        RadioButton rb3 = new RadioButton("Bottom");
        rb1.setToggleGroup(group);






        BorderPane bp = new BorderPane();
        VBox top = new VBox();
        HBox center = new HBox();

        top.getChildren().addAll(title, button);
        bp.setTop(top);

        rb1.setAlignment(Pos.CENTER);
        center.getChildren().addAll(rect, rb1, rb2, rb3);
        bp.setCenter(center);


        group.selectedToggleProperty().addListener(new ChangeListener<Toggle>()
        {
            public void changed(ObservableValue<? extends Toggle> ob,
                                Toggle o, Toggle n)
            {

                RadioButton rb = (RadioButton)group.getSelectedToggle();

                if (rb == rb1) {
                    bp.setTop(rect);
                } else if (rb == rb2) {
                    bp.setCenter(rect);
                } else if (rb == rb3) {
                    bp.setBottom(rect);
                }
            }
        });

        Spinner spin = new Spinner(0, 1, 0);

        bp.setLeft(spin);

        //Scene Wrap-Up
        Scene s = new Scene(bp, 1200, 750);
        primaryStage.setTitle("1331 Exam 5 - Dhruv Sharma");
        primaryStage.setScene(s);
        primaryStage.show();
    }
}
