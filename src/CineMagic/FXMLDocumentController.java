package CineMagic;

import com.mysql.jdbc.Connection;
import com.mysql.jdbc.PreparedStatement;
import com.mysql.jdbc.Statement;
import java.net.URL;
import java.sql.ResultSet;
import java.util.ResourceBundle;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.Hyperlink;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class FXMLDocumentController implements Initializable {

    @FXML
    private Button signIn_close;

    @FXML
    private Hyperlink signIn_createAccount;

    @FXML
    private AnchorPane signIn_form;

    @FXML
    private Button signIn_loginBtn;

    @FXML
    private Button signIn_minimize;

    @FXML
    private PasswordField signIn_password;

    @FXML
    private TextField signIn_username;

    @FXML
    private Hyperlink signUp_alreadyHaveAnAccount;

    @FXML
    private Button signUp_btn;

    @FXML
    private Button signUp_close;

    @FXML
    private TextField signUp_email;

    @FXML
    private AnchorPane signUp_form;

    @FXML
    private Button signUp_minimize;

    @FXML
    private PasswordField signUp_password;

    @FXML
    private TextField signUp_username;

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

    public boolean validEmail() {
        Pattern pattern = Pattern.compile("[a-zA-Z0-9][a-zA-Z0-9.]*@[a-zA-Z0-9]+([.][a-zA-Z]+)+");
        Matcher match = pattern.matcher(signUp_email.getText());

        Alert alert;

        if (match.find() && match.group().matches(signUp_email.getText())) {

            return true;
        } else {
            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Invalid Email");
            alert.showAndWait();

            return false;
        }

    }

    public void signUp() {
        String sql = "INSERT INTO admin (email, username, password) VALUES (?, ?, ?)";
        String sql1 = "SELECT * FROM admin WHERE username = ?";
        String sql2 = "SELECT * FROM admin WHERE email = ?";

        connect = Database.connectDB();
        try {
            prepare = (PreparedStatement) connect.prepareStatement(sql);
            prepare.setString(1, signUp_email.getText());
            prepare.setString(2, signUp_username.getText());
            prepare.setString(3, signUp_password.getText());

            Alert alert;

            if (signUp_email.getText().isEmpty() || signUp_username.getText().isEmpty() || signUp_password.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else if (signUp_password.getText().length() < 6) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Password too short");
                alert.showAndWait();
            } else {

                if (validEmail()) {

                    prepare = (PreparedStatement) connect.prepareStatement(sql2);
                    prepare.setString(1, signUp_email.getText());
                    result = prepare.executeQuery();

                    if (result.next()) {
                        alert = new Alert(AlertType.ERROR);
                        alert.setTitle("Error Message");
                        alert.setHeaderText(null);
                        alert.setContentText(signUp_email.getText() + " already exists");
                        alert.showAndWait();

                    } else {
                        prepare = (PreparedStatement) connect.prepareStatement(sql1);
                        prepare.setString(1, signUp_username.getText());
                        result = prepare.executeQuery();

                        if (result.next()) {
                            alert = new Alert(AlertType.ERROR);
                            alert.setTitle("Error Message");
                            alert.setHeaderText(null);
                            alert.setContentText(signUp_username.getText() + " already exists");
                            alert.showAndWait();
                        } else {
                            prepare = (PreparedStatement) connect.prepareStatement(sql);
                            prepare.setString(1, signUp_email.getText());
                            prepare.setString(2, signUp_username.getText());
                            prepare.setString(3, signUp_password.getText());
                            prepare.execute();
                            alert = new Alert(AlertType.INFORMATION);
                            alert.setTitle("Information Message");
                            alert.setHeaderText(null);
                            alert.setContentText("Account has been successfully created");
                            alert.showAndWait();
                        
                            Stage stage = (Stage) signUp_email.getScene().getWindow();
                            
                            stage.close();
                            
                            FXMLLoader loader = new FXMLLoader(getClass().getResource("FXMLDocument.fxml"));
                            Parent root = loader.load();
                            
                            Scene scene = new Scene(root);
                            scene.setFill(Color.TRANSPARENT);
                            
                            Stage newStage = new Stage();
                            newStage.setScene(scene);
                            newStage.initStyle(StageStyle.TRANSPARENT);
                            newStage.show();

                            signUp_email.setText("");
                            signUp_username.setText("");
                            signUp_password.setText("");
                        }
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private double x = 0;
    private double y = 0;

    public void signIn() {
        String sql = "SELECT * FROM admin WHERE username = ? and password = ?";

        connect = Database.connectDB();
        try {
            prepare = (PreparedStatement) connect.prepareStatement(sql);
            prepare.setString(1, signIn_username.getText());
            prepare.setString(2, signIn_password.getText());

            result = prepare.executeQuery();

            Alert alert;

            if (signIn_username.getText().isEmpty() || signIn_password.getText().isEmpty()) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please fill all blank fields");
                alert.showAndWait();
            } else {
                if (result.next()) {
                    getData.username = signIn_username.getText();

                    String dashboardPath = "Userboard.fxml";
                    if (signIn_username.getText().contains("admin")) {
                        dashboardPath = "Dashboard.fxml";
                    }

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Login");
                    alert.showAndWait();

                    signIn_loginBtn.getScene().getWindow().hide();

                    Parent root = FXMLLoader.load(getClass().getResource(dashboardPath));

                    Stage stage = new Stage();
                    Scene scene = new Scene(root);

                    root.setOnMousePressed((MouseEvent event) -> {

                        x = event.getSceneX();
                        y = event.getSceneY();

                    });

                    root.setOnMouseDragged((MouseEvent event) -> {

                        stage.setX(event.getScreenX() - x);
                        stage.setY(event.getScreenY() - y);

                    });

                    stage.initStyle(StageStyle.TRANSPARENT);

                    stage.setScene(scene);
                    stage.show();

                } else {
                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Wrong Username or Password");
                    alert.showAndWait();
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void switchForm(ActionEvent event) {
        if (event.getSource() == signIn_createAccount) {
            signIn_form.setVisible(false);
            signUp_form.setVisible(true);
        } else if (event.getSource() == signUp_alreadyHaveAnAccount) {
            signIn_form.setVisible(true);
            signUp_form.setVisible(false);
        }
    }

    public void signIn_close() {
        System.exit(0);
    }

    public void signIn_minimize() {
        Stage stage = (Stage) signIn_form.getScene().getWindow();
        stage.setIconified(true);
    }

    public void signUp_close() {
        System.exit(0);
    }

    public void signUp_minimize() {
        Stage stage = (Stage) signUp_form.getScene().getWindow();
        stage.setIconified(true);
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    
    }

}