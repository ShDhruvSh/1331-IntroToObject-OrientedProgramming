import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.layout.Pane;
import javafx.scene.text.Font;
import javafx.scene.text.FontPosture;
import javafx.scene.text.FontWeight;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.Stage;


/**
 * Creates a window to display an Animal Sanctuary user interface.
 *
 * @author dsharma97
 * @version 11.0.12
 **/

public class AnimalSanctuary extends Application {
    /**
     * Runs the actual stage where the application runs.
     *
     * @param primaryStage stage where application runs
     */
    public void start(Stage primaryStage) {

        ImageView farm = new ImageView("animalImage.jpg");


        farm.fitHeightProperty().bind(primaryStage.heightProperty());
        farm.fitWidthProperty().bind(primaryStage.widthProperty());

        Pane pane = new Pane();


        Label title = new Label("The Animal Sanctuary");
        title.setTextFill(Color.DARKCYAN);
        title.setFont(Font.font("Courier New", FontWeight.BOLD, FontPosture.REGULAR, 40));
        title.setOnMouseEntered(mouseEvent -> {
            title.setScaleX(2);
            title.setScaleY(2);
        });
        title.setOnMouseExited(mouseEvent -> {
            title.setScaleX(1);
            title.setScaleY(1);
        });



        BorderPane bp = new BorderPane();
        bp.layoutXProperty().bind(pane.widthProperty().subtract(bp.widthProperty()).divide(2));
        bp.layoutYProperty().bind(bp.heightProperty().subtract(bp.heightProperty()).add(20));
        bp.setPrefSize(1000, 650);
        bp.setPadding(new Insets(40, 40, 40, 40)); //margins around whole bp

        //Animal display
        GridPane gp = new GridPane();
        gp.setAlignment(Pos.CENTER);
        gp.setHgap(20);
        gp.setVgap(20);

        bp.setTop(title);
        bp.setAlignment(title, Pos.CENTER);
        bp.setCenter(gp);
        bp.setAlignment(gp, Pos.CENTER);


        //Animal Display Labels
        Label lab1 = new Label("Empty");
        lab1.setStyle("-fx-background-color: SALMON; -fx-padding: 80px;");
        gp.setConstraints(lab1, 0, 0);
        Label lab2 = new Label("Empty");
        lab2.setStyle("-fx-background-color: SALMON; -fx-padding: 80px;");
        gp.setConstraints(lab2, 1, 0);
        Label lab3 = new Label("Empty");
        lab3.setStyle("-fx-background-color: SALMON; -fx-padding: 80px;");
        gp.setConstraints(lab3, 2, 0);
        Label lab4 = new Label("Empty");
        lab4.setStyle("-fx-background-color: SALMON; -fx-padding: 80px;");
        gp.setConstraints(lab4, 0, 1);
        Label lab5 = new Label("Empty");
        lab5.setStyle("-fx-background-color: SALMON; -fx-padding: 80px;");
        gp.setConstraints(lab5, 1, 1);
        Label lab6 = new Label("Empty");
        lab6.setStyle("-fx-background-color: SALMON; -fx-padding: 80px;");
        gp.setConstraints(lab6, 2, 1);

        gp.getChildren().addAll(lab1, lab2, lab3, lab4, lab5, lab6);

        //New Animal Submitter
        HBox animalSubmitter = new HBox(10);
        animalSubmitter.setAlignment(Pos.CENTER);

        //Name of Animal
        TextField nameAnimalText = new TextField();
        VBox nameAnimal = new VBox(new Text("Type name here:"), nameAnimalText);

        //Health of animal
        TextField healthAnimalText = new TextField();

        //Only allows user to enter the numbers 1-5
        healthAnimalText.textProperty().addListener((observable, oldValue, newValue) -> {
            if (!newValue.matches("1|2|3|4|5")) {
                healthAnimalText.setText(newValue.replaceAll("[^1-5]", ""));
                if (healthAnimalText.getText().length() > 0) {
                    healthAnimalText.setText(healthAnimalText.getText().substring(0, 1));

                }
            }
        });
        VBox healthAnimal = new VBox(new Text("Type health here:"), healthAnimalText);

        //Animal Type
        ComboBox<Animal> cbxAnimal = new ComboBox<>();
        cbxAnimal.getItems().setAll(Animal.values());

        //Images of animal occupancy
        ImageView moveAnimal1 = new ImageView("animal.png");
        moveAnimal1.setFitHeight(50);
        moveAnimal1.setFitWidth(50);
        moveAnimal1.setX(-100);
        ImageView moveAnimal2 = new ImageView("animal.png");
        moveAnimal2.setFitHeight(50);
        moveAnimal2.setFitWidth(50);
        moveAnimal2.setX(-100);
        ImageView moveAnimal3 = new ImageView("animal.png");
        moveAnimal3.setFitHeight(50);
        moveAnimal3.setFitWidth(50);
        moveAnimal3.setX(-100);
        ImageView moveAnimal4 = new ImageView("animal.png");
        moveAnimal4.setFitHeight(50);
        moveAnimal4.setFitWidth(50);
        moveAnimal4.setX(-100);
        ImageView moveAnimal5 = new ImageView("animal.png");
        moveAnimal5.setFitHeight(50);
        moveAnimal5.setFitWidth(50);
        moveAnimal5.setX(-100);
        ImageView moveAnimal6 = new ImageView("animal.png");
        moveAnimal6.setFitHeight(50);
        moveAnimal6.setFitWidth(50);
        moveAnimal6.setX(-100);

        Button addAnimal = new Button("Add Animal!");
        Queue<String> waitingAnimals = new Queue<>();

        //Adds an animal after button is pressed
        addAnimal.setOnAction(actionEvent -> {
            if (nameAnimalText.getText().equals("")) {
                nameAnimalText.setText("No Name Yet");
            }
            if (healthAnimalText.getText().equals("")) {
                healthAnimalText.setText("5");
            }
            if (lab1.getText().equals("Empty")) {
                lab1.setText(nameAnimalText.getText() + "\nHealth: " + healthAnimalText.getText()
                        + "\nType: " + cbxAnimal.getValue());
                lab1.setStyle("-fx-background-color: SKYBLUE; -fx-padding: 80px;");

                //Animation for 1
                moveAnimal1.setX(-100);
                moveAnimal1.setY(bp.getLayoutY() + lab1.getLayoutY() + 80);
                AnimationTimer timer = new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                        if (moveAnimal1.getX() < bp.getLayoutX() + lab1.getLayoutX() + 80) {
                            moveAnimal1.setX(moveAnimal1.getX() + 7.0);
                        }
                    }
                };
                timer.start();
            } else if (lab2.getText().equals("Empty")) {
                lab2.setText(nameAnimalText.getText() + "\nHealth: " + healthAnimalText.getText()
                        + "\nType: " + cbxAnimal.getValue());
                lab2.setStyle("-fx-background-color: SKYBLUE; -fx-padding: 80px;");

                //Animation for 2
                moveAnimal2.setX(-100);
                moveAnimal2.setY(bp.getLayoutY() + lab2.getLayoutY() + 80);
                AnimationTimer timer = new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                        if (moveAnimal2.getX() < bp.getLayoutX() + lab2.getLayoutX() + 80) {
                            moveAnimal2.setX(moveAnimal2.getX() + 7.0);
                        }
                    }
                };
                timer.start();
            } else if (lab3.getText().equals("Empty")) {
                lab3.setText(nameAnimalText.getText() + "\nHealth: " + healthAnimalText.getText()
                        + "\nType: " + cbxAnimal.getValue());
                lab3.setStyle("-fx-background-color: SKYBLUE; -fx-padding: 80px;");

                //Animation for 3
                moveAnimal3.setX(-100);
                moveAnimal3.setY(bp.getLayoutY() + lab3.getLayoutY() + 80);
                AnimationTimer timer = new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                        if (moveAnimal3.getX() < bp.getLayoutX() + lab3.getLayoutX() + 80) {
                            moveAnimal3.setX(moveAnimal3.getX() + 7.0);
                        }
                    }
                };
                timer.start();
            } else if (lab4.getText().equals("Empty")) {
                lab4.setText(nameAnimalText.getText() + "\nHealth: " + healthAnimalText.getText()
                        + "\nType: " + cbxAnimal.getValue());
                lab4.setStyle("-fx-background-color: SKYBLUE; -fx-padding: 80px;");

                //Animation for 4
                moveAnimal4.setX(-100);
                moveAnimal4.setY(bp.getLayoutY() + lab4.getLayoutY() + 80);
                AnimationTimer timer = new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                        if (moveAnimal4.getX() < bp.getLayoutX() + lab4.getLayoutX() + 80) {
                            moveAnimal4.setX(moveAnimal4.getX() + 7.0);
                        }
                    }
                };
                timer.start();
            } else if (lab5.getText().equals("Empty")) {
                lab5.setText(nameAnimalText.getText() + "\nHealth: " + healthAnimalText.getText()
                        + "\nType: " + cbxAnimal.getValue());
                lab5.setStyle("-fx-background-color: SKYBLUE; -fx-padding: 80px;");

                //Animation for 5
                moveAnimal5.setX(-100);
                moveAnimal5.setY(bp.getLayoutY() + lab5.getLayoutY() + 80);
                AnimationTimer timer = new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                        if (moveAnimal5.getX() < bp.getLayoutX() + lab5.getLayoutX() + 80) {
                            moveAnimal5.setX(moveAnimal5.getX() + 7.0);
                        }
                    }
                };
                timer.start();
            } else if (lab6.getText().equals("Empty")) {
                lab6.setText(nameAnimalText.getText() + "\nHealth: " + healthAnimalText.getText()
                        + "\nType: " + cbxAnimal.getValue());
                lab6.setStyle("-fx-background-color: SKYBLUE; -fx-padding: 80px;");

                //Animation for 6
                moveAnimal6.setX(-100);
                moveAnimal6.setY(bp.getLayoutY() + lab6.getLayoutY() + 80);
                AnimationTimer timer = new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                        if (moveAnimal6.getX() < bp.getLayoutX() + lab6.getLayoutX() + 80) {
                            moveAnimal6.setX(moveAnimal6.getX() + 7.0);
                        }
                    }
                };
                timer.start();
            } else {
                waitingAnimals.enqueue(nameAnimalText.getText() + "\nHealth: "
                        + healthAnimalText.getText() + "\nType: " + cbxAnimal.getValue());

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "There is no more room! \n"
                        + "This animal has been added to the queue!", ButtonType.OK);
                alert.showAndWait();
            }
            //Reset inputs
            nameAnimalText.setText("");
            healthAnimalText.setText("");
            cbxAnimal.valueProperty().set(null);

        });

        //Removing an animal
        lab1.setOnMouseClicked(event -> {
            if (!lab1.getText().equals("Empty")) {
                lab1.setText("Empty");
                lab1.setStyle("-fx-background-color: SALMON; -fx-padding: 80px;");
                moveAnimal1.setY(-100);
            }
            if (waitingAnimals.size() != 0) {
                lab1.setText(waitingAnimals.dequeue());
                lab1.setStyle("-fx-background-color: SKYBLUE; -fx-padding: 80px;");

                //Animation for 1
                moveAnimal1.setX(-100);
                moveAnimal1.setY(bp.getLayoutY() + lab1.getLayoutY() + 80);
                AnimationTimer timer = new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                        if (moveAnimal1.getX() < bp.getLayoutX() + lab1.getLayoutX() + 80) {
                            moveAnimal1.setX(moveAnimal1.getX() + 7.0);
                        }
                    }
                };
                timer.start();
            }
        });

        lab2.setOnMouseClicked(event -> {
            if (!lab2.getText().equals("Empty")) {
                lab2.setText("Empty");
                lab2.setStyle("-fx-background-color: SALMON; -fx-padding: 80px;");
                moveAnimal2.setY(-100);
            }
            if (waitingAnimals.size() != 0) {
                lab2.setText(waitingAnimals.dequeue());
                lab2.setStyle("-fx-background-color: SKYBLUE; -fx-padding: 80px;");

                //Animation for 2
                moveAnimal2.setX(-100);
                moveAnimal2.setY(bp.getLayoutY() + lab2.getLayoutY() + 80);
                AnimationTimer timer = new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                        if (moveAnimal2.getX() < bp.getLayoutX() + lab2.getLayoutX() + 80) {
                            moveAnimal2.setX(moveAnimal2.getX() + 7.0);
                        }
                    }
                };
                timer.start();
            }
        });

        lab3.setOnMouseClicked(event -> {
            if (!lab3.getText().equals("Empty")) {
                lab3.setText("Empty");
                lab3.setStyle("-fx-background-color: SALMON; -fx-padding: 80px;");
                moveAnimal3.setY(-100);
            }
            if (waitingAnimals.size() != 0) {
                lab3.setText(waitingAnimals.dequeue());
                lab3.setStyle("-fx-background-color: SKYBLUE; -fx-padding: 80px;");

                //Animation for 3
                moveAnimal3.setX(-100);
                moveAnimal3.setY(bp.getLayoutY() + lab3.getLayoutY() + 80);
                AnimationTimer timer = new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                        if (moveAnimal3.getX() < bp.getLayoutX() + lab3.getLayoutX() + 80) {
                            moveAnimal3.setX(moveAnimal3.getX() + 7.0);
                        }
                    }
                };
                timer.start();
            }
        });

        lab4.setOnMouseClicked(event -> {
            if (!lab4.getText().equals("Empty")) {
                lab4.setText("Empty");
                lab4.setStyle("-fx-background-color: SALMON; -fx-padding: 80px;");
                moveAnimal4.setY(-100);
            }
            if (waitingAnimals.size() != 0) {
                lab4.setText(waitingAnimals.dequeue());
                lab4.setStyle("-fx-background-color: SKYBLUE; -fx-padding: 80px;");

                //Animation for 4
                moveAnimal4.setX(-100);
                moveAnimal4.setY(bp.getLayoutY() + lab4.getLayoutY() + 80);
                AnimationTimer timer = new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                        if (moveAnimal4.getX() < bp.getLayoutX() + lab4.getLayoutX() + 80) {
                            moveAnimal4.setX(moveAnimal4.getX() + 7.0);
                        }
                    }
                };
                timer.start();
            }
        });

        lab5.setOnMouseClicked(event -> {
            if (!lab5.getText().equals("Empty")) {
                lab5.setText("Empty");
                lab5.setStyle("-fx-background-color: SALMON; -fx-padding: 80px;");
                moveAnimal5.setY(-100);
            }
            if (waitingAnimals.size() != 0) {
                lab5.setText(waitingAnimals.dequeue());
                lab5.setStyle("-fx-background-color: SKYBLUE; -fx-padding: 80px;");

                //Animation for 5
                moveAnimal5.setX(-100);
                moveAnimal5.setY(bp.getLayoutY() + lab5.getLayoutY() + 80);
                AnimationTimer timer = new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                        if (moveAnimal5.getX() < bp.getLayoutX() + lab5.getLayoutX() + 80) {
                            moveAnimal5.setX(moveAnimal5.getX() + 7.0);
                        }
                    }
                };
                timer.start();
            }
        });

        lab6.setOnMouseClicked(event -> {
            if (!lab6.getText().equals("Empty")) {
                lab6.setText("Empty");
                lab6.setStyle("-fx-background-color: SALMON; -fx-padding: 80px;");
                moveAnimal6.setY(-100);
            }
            if (waitingAnimals.size() != 0) {
                lab6.setText((String) waitingAnimals.dequeue());
                lab6.setStyle("-fx-background-color: SKYBLUE; -fx-padding: 80px;");

                //Animation for 6
                moveAnimal6.setX(-100);
                moveAnimal6.setY(bp.getLayoutY() + lab6.getLayoutY() + 80);
                AnimationTimer timer = new AnimationTimer() {
                    @Override
                    public void handle(long now) {
                        if (moveAnimal6.getX() < bp.getLayoutX() + lab6.getLayoutX() + 80) {
                            moveAnimal6.setX(moveAnimal6.getX() + 7.0);
                        }
                    }
                };
                timer.start();
            }
        });


        //Adding all the inputs in one HBox
        animalSubmitter.getChildren().addAll(nameAnimal, healthAnimal, cbxAnimal, addAnimal);

        //Adding input HBox to bp
        bp.setBottom(animalSubmitter);
        bp.setAlignment(animalSubmitter, Pos.CENTER);

        //Adding BorderPane/Images to pane
        pane.getChildren().add(farm);
        pane.getChildren().add(bp);
        pane.getChildren().addAll(moveAnimal1, moveAnimal2, moveAnimal3,
                moveAnimal4, moveAnimal5, moveAnimal6);


        //Scene Wrap-Up
        Scene s = new Scene(pane, 1200, 750);
        primaryStage.setTitle("My Animal Sanctuary");
        primaryStage.setScene(s);
        primaryStage.show();
    }
}
