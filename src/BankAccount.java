import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;

import javafx.scene.image.ImageView;

import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.Circle;

import javafx.scene.text.Text;

import javafx.stage.Stage;

/**
 * Creates visual window to represent a user's BankAccount.
 *
 * @author dsharma97
 * @version 11.0.12
 **/

public class BankAccount extends Application {

        /**
         * Runs the actual stage where the application runs.
         *
         * @param primaryStage stage where application runs
         */
        public void start(Stage primaryStage) {

            ImageView chungus = new ImageView("chungus.jpg");
            chungus.fitHeightProperty().bind(primaryStage.heightProperty());
            chungus.fitWidthProperty().bind(primaryStage.widthProperty());


            Rectangle transactionRect = new Rectangle(200, 225, 500, 300);
            transactionRect.setFill(Color.BLUE);

            Circle topCircle = new Circle(870, 30, 30);
            topCircle.setFill(Color.RED);

            Text accountBal = new Text(864, 34, "21");

            Pane pane = new Pane();

            pane.getChildren().add(chungus);
            pane.getChildren().add(transactionRect);
            pane.getChildren().add(topCircle);
            pane.getChildren().add(accountBal);



            primaryStage.setTitle("Bank Account");
            primaryStage.setScene(new Scene(pane, 900, 750));
            primaryStage.show();
        }


}
