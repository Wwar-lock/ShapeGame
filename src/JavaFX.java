import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.Node;
import javafx.scene.effect.InnerShadow;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.scene.Cursor;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseDragEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Ellipse;
import javafx.scene.shape.Polygon;
import javafx.scene.shape.Rectangle;
import javafx.scene.transform.Scale;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Label;
import javafx.stage.Stage;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

import java.awt.*;

import static java.math.RoundingMode.DOWN;
import static java.math.RoundingMode.UP;
import static javax.swing.JSplitPane.LEFT;
import static javax.swing.JSplitPane.RIGHT;

public class JavaFX extends Application {

    Circle circle_Blue;
    Button brect;
    Rectangle Square_green;
    Ellipse Ellipse_yellow;
    Rectangle Rectangle_Red;
    Label l,l1,instructions;
    Text t;
    double orgSceneX, orgSceneY;
    double orgTranslateX, orgTranslateY;
    static int click1=0;
    static int click2=0;
    static int click3=0;
    static int click4=0;
    @Override
    public void start(Stage primaryStage) {

        l = new Label("Click And Drag Figures");
        l.setFont(new Font("Cambria",38));
        l.setTranslateX(320);
        l.setTranslateY(300);
        l.setTextFill(Color.web("#0076a3"));

        l1 = new Label("Play With Shapes");
        l1.setFont(new Font("Cambria",38));
        l1.setTranslateX(350);
        l1.setTranslateY(30);
        l1.setTextFill(Color.web("#0076a3"));
        l1.setVisible(false);

        instructions = new Label();
        instructions.setText("Instructions to play:\n" +
                "                       (1). To Increase and Decrease the Size of Circle Press Q and E resp.\n" +
                "                       (2) To Increase and Decrease the Size of Square Press Q and E resp.\n" +
                "                       (3) To Increase and Decrease Length of Rectangle Press Q and E resp,\n" +
                "                       (4) To Increase and Decrease Breadth of Rectangle Press Z and C resp,\n" +
                "                       (5) To Increase and Decrease X-Radius Press Q and E resp,\n" +
                "                       (6) To Increase and Decrease Y-Radius Press Z and C resp,\n" +
                "                       (7) Press Del to Delete The Shape\n" +
                "                       (8) Use W,A,S,D to move the Shapes\n");
        instructions.setFont(new Font("Cambria",14));
        instructions.setTranslateX(100);
        instructions.setTranslateY(700);
        instructions.setTextFill(Color.web("#0076a3"));
//        instructions.setVisible(false);

        l.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                l.setScaleX(1.5);
                l.setScaleY(1.5);
            }
        });

        l.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                l.setScaleX(1);
                l.setScaleY(1);
            }
        });

        l1.setOnMouseEntered(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                l1.setScaleX(1.5);
                l1.setScaleY(1.5);
            }
        });

        l1.setOnMouseExited(new EventHandler<MouseEvent>() {
            @Override public void handle(MouseEvent e) {
                l1.setScaleX(1);
                l1.setScaleY(1);
            }
        });

        circle_Blue = new Circle(60.0f, Color.BLUE);
        circle_Blue.setCursor(Cursor.CROSSHAIR);
        circle_Blue.setTranslateX(300);
        circle_Blue.setTranslateY(400);
        circle_Blue.setOnMousePressed(circleOnMousePressedEventHandler);
        circle_Blue.setOnMouseDragged(circleOnMouseDraggedEventHandler);
        circle_Blue.setVisible(false);
        circle_Blue.setOnKeyPressed(e -> {
            switch(e.getCode()){
                case S: circle_Blue.setTranslateY(circle_Blue.getTranslateY() + 2); break;
                case W: circle_Blue.setTranslateY(circle_Blue.getTranslateY() - 2); break;
                case A: circle_Blue.setTranslateX(circle_Blue.getTranslateX() - 2); break;
                case D: circle_Blue.setTranslateX(circle_Blue.getTranslateX() + 2); break;
                case Q: circle_Blue.setRadius(circle_Blue.getRadius()+2);break;
                case E: circle_Blue.setRadius(circle_Blue.getRadius()-2);break;
                case DELETE: circle_Blue.setVisible(false);
            }
        });

        Button btn2 = new Button();
        btn2.setText("Circle");
        btn2.setTranslateX(75);
        btn2.setTranslateY(400);
        btn2.setStyle("-fx-border-color: blue; -fx-border-width: 5px;");
        btn2.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                l.setVisible(false);
                l1.setVisible(true);
                circle_Blue.setVisible(true);
                circle_Blue.requestFocus();
            }
        });


        Rectangle_Red = new Rectangle(300,120,Color.RED);
        Rectangle_Red.setCursor(Cursor.CROSSHAIR);
        Rectangle_Red.setTranslateX(250);
        Rectangle_Red.setTranslateY(120);
        Rectangle_Red.setOnMousePressed(rectangleOnMousePressedEventHandler);
        Rectangle_Red.setOnMouseDragged(rectangleOnMouseDraggedEventHandler);
        Rectangle_Red.setVisible(false);
        Rectangle_Red.setOnKeyPressed(e -> {
            switch(e.getCode()){
                case S: Rectangle_Red.setTranslateY(Rectangle_Red.getTranslateY() + 2); break;
                case W: Rectangle_Red.setTranslateY(Rectangle_Red.getTranslateY() - 2); break;
                case A: Rectangle_Red.setTranslateX(Rectangle_Red.getTranslateX() - 2); break;
                case D: Rectangle_Red.setTranslateX(Rectangle_Red.getTranslateX() + 2); break;
                case Q: Rectangle_Red.setWidth(Rectangle_Red.getWidth()+2);break;
                case Z: Rectangle_Red.setHeight(Rectangle_Red.getHeight()+2);break;
                case E: Rectangle_Red.setWidth(Rectangle_Red.getWidth()-2);break;
                case C: Rectangle_Red.setHeight(Rectangle_Red.getHeight()-2);break;
                case DELETE: Rectangle_Red.setVisible(false);
            }
        });

        Button btn = new Button();
        btn.setText("Rectangle");
        btn.setTranslateX(75);
        btn.setTranslateY(200);
        btn.setStyle("-fx-border-color: red; -fx-border-width: 5px;");
        btn.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                l.setVisible(false);
                l1.setVisible(true);
                Rectangle_Red.setVisible(true);
                Rectangle_Red.requestFocus();
            }
        });

        Square_green = new Rectangle(150,150,Color.GREEN);
        Square_green.setCursor(Cursor.CROSSHAIR);
        Square_green.setTranslateX(600);
        Square_green.setTranslateY(250);
        Square_green.setOnMousePressed(squareOnMousePressedEventHandler);
        Square_green.setOnMouseDragged(squareOnMouseDraggedEventHandler);
        Square_green.setVisible(false);
        Square_green.setOnKeyPressed(e -> {
            switch(e.getCode()){
                case S: Square_green.setTranslateY(Square_green.getTranslateY() + 2); break;
                case W: Square_green.setTranslateY(Square_green.getTranslateY() - 2); break;
                case A: Square_green.setTranslateX(Square_green.getTranslateX() - 2); break;
                case D: Square_green.setTranslateX(Square_green.getTranslateX() + 2); break;
                case Q: Square_green.setWidth(Square_green.getWidth()+2);Square_green.setHeight(Square_green.getHeight()+2);break;
                case E: Square_green.setWidth(Square_green.getWidth()-2);Square_green.setHeight(Square_green.getHeight()-2);break;
                case DELETE: Square_green.setVisible(false);
            }
        });

        Button btn1 = new Button();
        btn1.setText("Square");
        btn1.setTranslateX(75);
        btn1.setTranslateY(300);
        btn1.setStyle("-fx-border-color: green; -fx-border-width: 5px;");
        btn1.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                l.setVisible(false);
                l1.setVisible(true);
                Square_green.setVisible(true);
                Square_green.requestFocus();
            }
        });

        Ellipse_yellow = new Ellipse();
        Ellipse_yellow.setCursor(Cursor.CROSSHAIR);
        Ellipse_yellow.setFill(Color.YELLOW);
        Ellipse_yellow.setTranslateX(300);
        Ellipse_yellow.setTranslateY(400);
        Ellipse_yellow.setCenterX(300.0f);
        Ellipse_yellow.setCenterY(150.0f);
        Ellipse_yellow.setRadiusX(150.0f);
        Ellipse_yellow.setRadiusY(75.0f);
        Ellipse_yellow.setOnMousePressed(ellipseOnMousePressedEventHandler);
        Ellipse_yellow.setOnMouseDragged(ellipseOnMouseDraggedEventHandler);
        Ellipse_yellow.setVisible(false);
        Ellipse_yellow.setOnKeyPressed(e -> {
            switch(e.getCode()){
                case S: Ellipse_yellow.setTranslateY(Ellipse_yellow.getTranslateY() + 2); break;
                case W: Ellipse_yellow.setTranslateY(Ellipse_yellow.getTranslateY() - 2); break;
                case A: Ellipse_yellow.setTranslateX(Ellipse_yellow.getTranslateX() - 2); break;
                case D: Ellipse_yellow.setTranslateX(Ellipse_yellow.getTranslateX() + 2); break;
                case Q: Ellipse_yellow.setRadiusX(Ellipse_yellow.getRadiusX()+2);break;
                case E: Ellipse_yellow.setRadiusX(Ellipse_yellow.getRadiusX()-2);break;
                case Z: Ellipse_yellow.setRadiusY(Ellipse_yellow.getRadiusY()+2);break;
                case C: Ellipse_yellow.setRadiusY(Ellipse_yellow.getRadiusY()-2);break;
                case DELETE: Ellipse_yellow.setVisible(false);
            }
        });


        Button btn3 = new Button();
        btn3.setText("Ellipse");
        btn3.setTranslateX(75);
        btn3.setTranslateY(500);
        btn3.setStyle("-fx-border-color: yellow; -fx-border-width: 5px;");
        btn3.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent event) {
                l.setVisible(false);
                l1.setVisible(true);
                Ellipse_yellow.setVisible(true);
                Ellipse_yellow.requestFocus();
            }
        });

        Group root = new Group();
        root.getChildren().addAll(circle_Blue,Rectangle_Red,Square_green,btn,btn1,btn2,btn3,Ellipse_yellow);
        root.getChildren().add(l);
        root.getChildren().add(l1);
        root.getChildren().add(instructions);

        primaryStage.setResizable(false);
        primaryStage.setScene(new Scene(root, 905,900,Color.BEIGE));
//        primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setTitle("Shapes");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }



    EventHandler<MouseEvent> circleOnMousePressedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    circle_Blue.requestFocus();
                    orgSceneX = t.getSceneX();
                    orgSceneY = t.getSceneY();
                    orgTranslateX = ((Circle)(t.getSource())).getTranslateX();
                    orgTranslateY = ((Circle)(t.getSource())).getTranslateY();
                }
            };

    EventHandler<MouseEvent> circleOnMouseDraggedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    double offsetX = t.getSceneX() - orgSceneX;
                    double offsetY = t.getSceneY() - orgSceneY;
                    double newTranslateX = orgTranslateX + offsetX;
                    double newTranslateY = orgTranslateY + offsetY;

                    ((Circle)(t.getSource())).setTranslateX(newTranslateX);
                    ((Circle)(t.getSource())).setTranslateY(newTranslateY);

                }
            };

    EventHandler<MouseEvent> rectangleOnMousePressedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    Rectangle_Red.requestFocus();
                    orgSceneX = t.getSceneX();
                    orgSceneY = t.getSceneY();
                    orgTranslateX = ((Rectangle)(t.getSource())).getTranslateX();
                    orgTranslateY = ((Rectangle)(t.getSource())).getTranslateY();
                }
            };

    EventHandler<MouseEvent> rectangleOnMouseDraggedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    double offsetX = t.getSceneX() - orgSceneX;
                    double offsetY = t.getSceneY() - orgSceneY;
                    double newTranslateX = orgTranslateX + offsetX;
                    double newTranslateY = orgTranslateY + offsetY;

                    ((Rectangle)(t.getSource())).setTranslateX(newTranslateX);
                    ((Rectangle)(t.getSource())).setTranslateY(newTranslateY);
                }
            };
    EventHandler<MouseEvent> squareOnMousePressedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    Square_green.requestFocus();
                    orgSceneX = t.getSceneX();
                    orgSceneY = t.getSceneY();
                    orgTranslateX = ((Rectangle)(t.getSource())).getTranslateX();
                    orgTranslateY = ((Rectangle)(t.getSource())).getTranslateY();
                }
            };

    EventHandler<MouseEvent> squareOnMouseDraggedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    double offsetX = t.getSceneX() - orgSceneX;
                    double offsetY = t.getSceneY() - orgSceneY;
                    double newTranslateX = orgTranslateX + offsetX;
                    double newTranslateY = orgTranslateY + offsetY;

                    ((Rectangle)(t.getSource())).setTranslateX(newTranslateX);
                    ((Rectangle)(t.getSource())).setTranslateY(newTranslateY);
                }
            };
    EventHandler<MouseEvent> ellipseOnMousePressedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    Ellipse_yellow.requestFocus();
                    orgSceneX = t.getSceneX();
                    orgSceneY = t.getSceneY();
                    orgTranslateX = ((Ellipse)(t.getSource())).getTranslateX();
                    orgTranslateY = ((Ellipse)(t.getSource())).getTranslateY();
                }
            };

    EventHandler<MouseEvent> ellipseOnMouseDraggedEventHandler =
            new EventHandler<MouseEvent>() {

                @Override
                public void handle(MouseEvent t) {
                    double offsetX = t.getSceneX() - orgSceneX;
                    double offsetY = t.getSceneY() - orgSceneY;
                    double newTranslateX = orgTranslateX + offsetX;
                    double newTranslateY = orgTranslateY + offsetY;

                    ((Ellipse)(t.getSource())).setTranslateX(newTranslateX);
                    ((Ellipse)(t.getSource())).setTranslateY(newTranslateY);

                }
            };
}
