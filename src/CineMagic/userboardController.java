package CineMagic;

import com.mysql.jdbc.Statement;
import java.io.File;
import java.net.URL;
import java.sql.Time;
import java.time.LocalTime;
import java.util.Date;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.transformation.FilteredList;
import javafx.collections.transformation.SortedList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Spinner;
import javafx.scene.control.SpinnerValueFactory;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class userboardController implements Initializable {

    @FXML
    private Button addMovies_btn;

    @FXML
    private Button addMovies_clearBtn;

    @FXML
    private TableColumn<moviesData, String> addMovies_col_duration;

    @FXML
    private TableColumn<moviesData, String> addMovies_col_genre;

    @FXML
    private TableColumn<moviesData, String> addMovies_col_movieTitle;

    @FXML
    private TableColumn<moviesData, String> addMovies_col_releaseDate;

    @FXML
    private Button addMovies_deleteBtn;

    @FXML
    private TextField addMovies_duration;

    @FXML
    private AnchorPane addMovies_form;

    @FXML
    private TextField addMovies_genre;

    @FXML
    private ImageView addMovies_imageView;

    @FXML
    private Button addMovies_import;

    @FXML
    private Button addMovies_insertBtn;

    @FXML
    private TextField addMovies_movieTitle;

    @FXML
    private DatePicker addMovies_date;

    @FXML
    private TextField addMovies_search;

    @FXML
    private TableView<moviesData> addMovies_tableView;

    @FXML
    private Button addMovies_updateBtn;

    @FXML
    private Button availableMovies_btn;

    @FXML
    private Button availableMovies_buyBtn;

    @FXML
    private Button availableMovies_clearBtn;

    @FXML
    private TableColumn<moviesData, String> availableMovies_col_genre;

    @FXML
    private TableColumn<moviesData, String> availableMovies_col_movieTitle;

    @FXML
    private TableColumn<moviesData, String> availableMovies_col_showingDate;

    @FXML
    private Label availableMovies_date;

    @FXML
    private AnchorPane availableMovies_form;

    @FXML
    private Label availableMovies_genre;

    @FXML
    private ImageView availableMovies_imageView;

    @FXML
    private ImageView availableMovies_imageSlideView;

    @FXML
    private Label availableMovies_label;

    @FXML
    private Label availableMovies_movieTitle;

    @FXML
    private Label availableMovies_normalClass_price;

    @FXML
    private Spinner<Integer> availableMovies_normalClass_quantity;

    @FXML
    private Button availableMovies_selectMovie;

    @FXML
    private Label availableMovies_specialClass_price;

    @FXML
    private Spinner<Integer> availableMovies_specialClass_quantity;

    @FXML
    private TableView<moviesData> availableMovies_tableView;

    @FXML
    private Label availableMovies_title;

    @FXML
    private Label availableMovies_total;

    @FXML
    private Button close;

    @FXML
    private Button customers_btn;

    @FXML
    private Button customers_clearBtn;

    @FXML
    private TableColumn<customerData, String> customers_col_dateChecked;

    @FXML
    private TableColumn<customerData, String> customers_col_movieTitle;

    @FXML
    private TableColumn<customerData, String> customers_col_ticketNumber;

    @FXML
    private TableColumn<customerData, String> customers_col_timeChecked;

    @FXML
    private Label customers_dateChecked;

    @FXML
    private Button customers_deleteBtn;

    @FXML
    private AnchorPane customers_form;

    @FXML
    private Label customers_movieTitle;

    @FXML
    private TextField customers_search;

    @FXML
    private TableView<customerData> customers_tableView;

    @FXML
    private Label customers_ticketNumber;

    @FXML
    private Label customers_timeChecked;

    @FXML
    private Label dashboard_availableMovies;

    @FXML
    private Button dashboard_btn;

    @FXML
    private AnchorPane dashboard_form;

    @FXML
    private Label dashboard_totalEarnToday;

    @FXML
    private Label dashboard_totalSoldTicket;

    @FXML
    private Button editScreening_btn;

    @FXML
    private Button editScreening_clearBtn;

    @FXML
    private TableColumn<moviesData, String> editScreening_col_current;

    @FXML
    private TableColumn<moviesData, String> editScreening_col_duration;

    @FXML
    private TableColumn<moviesData, String> editScreening_col_genre;

    @FXML
    private TableColumn<moviesData, String> editScreening_col_movieTitle;

    @FXML
    private ComboBox<String> editScreening_current;

    @FXML
    private AnchorPane editScreening_form;

    @FXML
    private ImageView editScreening_imageView;

    @FXML
    private Label editScreening_label;

    @FXML
    private TextField editScreening_search;

    @FXML
    private TableView<moviesData> editScreening_tableView;

    @FXML
    private Label editScreening_title;

    @FXML
    private Button editScreening_updateBtn;

    @FXML
    private Button minimize;

    @FXML
    private Button signout;

    @FXML
    private AnchorPane topForm;

    @FXML
    private Label username;

    private Image image;

    private double x = 0;
    private double y = 0;

    private Connection connect;
    private PreparedStatement prepare;
    private Statement statement;
    private ResultSet result;

    private SpinnerValueFactory<Integer> spinner1;
    private SpinnerValueFactory<Integer> spinner2;

    private float price1 = 0;
    private float price2 = 0;
    private float total = 0;
    private int qty1 = 0;
    private int qty2 = 0;

    private int totalMovies;

    public void totalAvailableMovies() {

        String sql = "SELECT COUNT(id) FROM movie WHERE current = 'Showing'";

        connect = Database.connectDB();

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {

                totalMovies = result.getInt("COUNT(id)");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void displayTotalAvailableMovies() {
        totalAvailableMovies();

        dashboard_availableMovies.setText(String.valueOf(totalMovies));

    }

    private double totalIncome;

    public void totalIncomeToday() {

        Date date = new Date();
        java.sql.Date sqlDate = new java.sql.Date(date.getTime());

        String sql = "SELECT SUM(total) FROM customer WHERE date = '" + String.valueOf(sqlDate) + "'";

        connect = Database.connectDB();

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {

                totalIncome = result.getDouble("SUM(total)");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void displayTotalIncomeToday() {
        totalIncomeToday();

        dashboard_totalEarnToday.setText(String.valueOf(totalIncome) + "৳");

    }

    private int soldTicket;

    public void countTicket() {

        String sql = "SELECT count(id) FROM customer";

        connect = Database.connectDB();

        try {

            prepare = connect.prepareStatement(sql);

            result = prepare.executeQuery();

            if (result.next()) {

                soldTicket = result.getInt("count(id)");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void displayTotalSoldTicket() {

        countTicket();

        dashboard_totalSoldTicket.setText(String.valueOf(soldTicket));

    }

    public void searchCustomer() {

        FilteredList<customerData> filter = new FilteredList<>(custList, e -> true);

        customers_search.textProperty().addListener((observable, oldValue, newValue) -> {

            filter.setPredicate(predicateCustomer -> {

                if (newValue.isEmpty() || newValue == null) {

                    return true;
                }

                String searchKey = newValue.toLowerCase();

                if (predicateCustomer.getId().toString().contains(searchKey)) {
                    return true;
                } else if (predicateCustomer.getTitle().toLowerCase().contains(searchKey)) {
                    return true;
                } else if (predicateCustomer.getDate().toString().contains(searchKey)) {
                    return true;
                } else {

                    return false;

                }

            });

        });

        SortedList<customerData> sort = new SortedList<>(filter);
        sort.comparatorProperty().bind(customers_tableView.comparatorProperty());

        customers_tableView.setItems(sort);

    }

    public ObservableList<customerData> customerList() {
        ObservableList<customerData> customerL = FXCollections.observableArrayList();

        String sql = "SELECT * FROM customer";

        connect = Database.connectDB();

        try {

            customerData customerD;
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            while (result.next()) {
                customerD = new customerData(result.getInt("id"),
                        result.getString("type"),
                        result.getString("movieTitle"),
                        result.getInt("quantity"),
                        result.getDouble("total"),
                        result.getDate("date"),
                        result.getTime("time"));
                customerL.add(customerD);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return customerL;
    }

    private ObservableList<customerData> custList;

    public void showCustomerList() {

        custList = customerList();

        customers_col_ticketNumber.setCellValueFactory(new PropertyValueFactory<>("id"));
        customers_col_movieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        customers_col_dateChecked.setCellValueFactory(new PropertyValueFactory<>("date"));
        customers_col_timeChecked.setCellValueFactory(new PropertyValueFactory<>("time"));

        customers_tableView.setItems(custList);

    }

    public void selectCustomerList() {

        customerData custD = customers_tableView.getSelectionModel().getSelectedItem();
        int num = customers_tableView.getSelectionModel().getSelectedIndex();

        if ((num - 1) < -1) {
            return;
        }

        customers_ticketNumber.setText(String.valueOf(custD.getId()));
        customers_movieTitle.setText(custD.getTitle());
        customers_dateChecked.setText(String.valueOf(custD.getDate()));
        customers_timeChecked.setText(String.valueOf(custD.getTime()));

    }

    public void deleteCustomer() {

        String sql = "DELETE FROM customer WHERE id = '" + customers_ticketNumber.getText() + "'";
        connect = Database.connectDB();

        try {

            Alert alert;

            statement = (Statement) connect.createStatement();

            if (customers_ticketNumber.getText().isEmpty()
                    || customers_movieTitle.getText().isEmpty()
                    || customers_dateChecked.getText().isEmpty()
                    || customers_timeChecked.getText().isEmpty()) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please select the customer first");
                alert.showAndWait();
            } else {

                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure you want to delete " + customers_movieTitle.getText() + "?");

                Optional<ButtonType> option = alert.showAndWait();

                if (option.get() == ButtonType.OK) {

                    statement.executeUpdate(sql);

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Removed");
                    alert.showAndWait();

                    showCustomerList();
                    clearCustomer();

                } else {
                    return;
                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void clearCustomer() {

        customers_ticketNumber.setText("");
        customers_movieTitle.setText("");
        customers_dateChecked.setText("");
        customers_timeChecked.setText("");

    }

    private int num;
    private int qty;

    public void buy() {

        String sql = "INSERT INTO customer (type, movieTitle, quantity, total, date, time) VALUES (?, ?, ?, ?, ?, ?)";

        connect = Database.connectDB();

        String type = "";
        if (price1 > 0 && price2 == 0) {

            type = "Special Class";

        } else if (price2 > 0 && price1 == 0) {

            type = "Normal Class";

        } else if (price2 > 0 && price1 > 0) {

            type = "Special & Normal Class";

        }

        Date date = new Date();
        java.sql.Date setDate = new java.sql.Date(date.getTime());

        try {

            LocalTime localTime = LocalTime.now();

            Time time = Time.valueOf(localTime);

            qty = qty1 + qty2;

            prepare = connect.prepareStatement(sql);
            prepare.setString(1, type);
            prepare.setString(2, availableMovies_title.getText());
            prepare.setString(3, String.valueOf(qty));
            prepare.setString(4, String.valueOf(total));
            prepare.setString(5, String.valueOf(setDate));
            prepare.setString(6, String.valueOf(time));

            Alert alert;

            if (availableMovies_imageView.getImage() == null || availableMovies_title.getText().isEmpty()) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please select the movie first");
                alert.showAndWait();

            } else if (price1 == 0 && price2 == 0) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please indicate the quantity of ticket you want to purchase");
                alert.showAndWait();

            } else {

                prepare.executeUpdate();

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully purchased");
                alert.showAndWait();

                String sql1 = "SELECT * FROM customer";
                prepare = connect.prepareStatement(sql1);
                result = prepare.executeQuery();

                int num = 0;

                while (result.next()) {
                    num = result.getInt("id");
                }

                String sql2 = "INSERT INTO customer_info (customer_id, type, total, movieTitle) VALUES (?, ?, ?, ?)";

                prepare = connect.prepareStatement(sql2);

                prepare.setString(1, String.valueOf(num));
                prepare.setString(2, type);
                prepare.setString(3, String.valueOf(total));
                prepare.setString(4, availableMovies_title.getText());

                prepare.execute();

                clearPurchaseTicketInfo();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void clearPurchaseTicketInfo() {
        spinner1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
        spinner2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);

        availableMovies_specialClass_quantity.setValueFactory(spinner1);
        availableMovies_normalClass_quantity.setValueFactory(spinner2);

        availableMovies_specialClass_price.setText("0.0৳");
        availableMovies_normalClass_price.setText("0.0৳");
        availableMovies_total.setText("0.0৳");

        availableMovies_imageView.setImage(null);
        availableMovies_title.setText("");
    }

    public void showSpinnerValue() {
        spinner1 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);
        spinner2 = new SpinnerValueFactory.IntegerSpinnerValueFactory(0, 10, 0);

        availableMovies_specialClass_quantity.setValueFactory(spinner1);
        availableMovies_normalClass_quantity.setValueFactory(spinner2);
    }

    public void getSpinnerValue(MouseEvent event) {

        qty1 = availableMovies_specialClass_quantity.getValue();
        qty2 = availableMovies_normalClass_quantity.getValue();

        price1 = (qty1 * 500);
        price2 = (qty2 * 300);

        total = (price1 + price2);

        availableMovies_specialClass_price.setText(String.valueOf(price1) + "৳");
        availableMovies_normalClass_price.setText(String.valueOf(price2) + "৳");

        availableMovies_total.setText(String.valueOf(total));

    }

    public ObservableList<moviesData> availableMoviesList() {

        ObservableList<moviesData> listAvMovies = FXCollections.observableArrayList();

        String sql = "SELECT * FROM movie WHERE current = 'Showing'";

        connect = Database.connectDB();

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            moviesData movD;

            while (result.next()) {

                movD = new moviesData(result.getInt("id"),
                        result.getString("movieTitle"),
                        result.getString("genre"),
                        result.getString("duration"),
                        result.getString("image"),
                        result.getDate("date"),
                        result.getString("current"));

                listAvMovies.add(movD);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listAvMovies;
    }

    private ObservableList<moviesData> availableMoviesList;

    public void showAvailableMovies() {

        availableMoviesList = availableMoviesList();

        availableMovies_col_movieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        availableMovies_col_genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        availableMovies_col_showingDate.setCellValueFactory(new PropertyValueFactory<>("date"));
        availableMovies_tableView.setItems(availableMoviesList);

    }

    public void selectAvailableMovies() {
        moviesData movD = availableMovies_tableView.getSelectionModel().getSelectedItem();
        int num = availableMovies_tableView.getSelectionModel().getSelectedIndex();
        if ((num - 1) < -1) {
            return;
        }

        getData.path = movD.getImage();

        getData.movieId = movD.getId();

        availableMovies_movieTitle.setText(movD.getTitle());
        availableMovies_genre.setText(movD.getGenre());
        availableMovies_date.setText(String.valueOf(movD.getDate()));

        getData.path = movD.getImage();
        getData.title = movD.getTitle();

    }

    public void selectMovie() {

        Alert alert;

        if (availableMovies_movieTitle.getText().isEmpty()
                || availableMovies_genre.getText().isEmpty()
                || availableMovies_date.getText().isEmpty()) {

            alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select the movie first");
            alert.showAndWait();

        } else {

            String uri = "file:" + getData.path;

            image = new Image(uri, 122, 157, false, true);
            availableMovies_imageView.setImage(image);
            availableMovies_title.setText(getData.title);

            availableMovies_movieTitle.setText("");
            availableMovies_genre.setText("");
            availableMovies_date.setText("");

        }

    }

    private String[] currentList = {"Showing", "End Showing"};

    public void comboBox() {
        editScreening_current.setItems(FXCollections.observableArrayList(currentList));
    }

    public void updateEditScreening() {
        String title = editScreening_title.getText();
        Image image = editScreening_imageView.getImage();
        String current = editScreening_current.getValue();

        if (title.isEmpty() || image == null || current == null) {
            Alert alert = new Alert(AlertType.ERROR);
            alert.setTitle("Error Message");
            alert.setHeaderText(null);
            alert.setContentText("Please select the movie first");
            alert.showAndWait();
            return;
        }

        String sql = "UPDATE movie SET current = ? WHERE movieTitle = ?";

        try (Connection connect = Database.connectDB(); PreparedStatement statement = connect.prepareStatement(sql)) {
            statement.setString(1, current);
            statement.setString(2, title);
            statement.executeUpdate();

            Alert alert = new Alert(AlertType.INFORMATION);
            alert.setTitle("Information Message");
            alert.setHeaderText(null);
            alert.setContentText("Successfully Updated");
            alert.showAndWait();

            showEditScreening();
            clearEditScreening();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public void clearEditScreening() {
        editScreening_title.setText("");
        editScreening_imageView.setImage(null);
        editScreening_current.getSelectionModel().clearSelection();
    }

    public void searchEditScreening() {
        String search = editScreening_search.getText().toLowerCase();
        FilteredList<moviesData> filteredList = editScreeningL.filtered(movie
                -> movie.getTitle().toLowerCase().contains(search)
                || movie.getGenre().toLowerCase().contains(search)
                || movie.getDuration().toLowerCase().contains(search)
                || movie.getCurrent().toLowerCase().contains(search)
        );
        editScreening_tableView.setItems(filteredList);
    }

    public void selectEditScreening() {
        moviesData movD = editScreening_tableView.getSelectionModel().getSelectedItem();
        if (movD == null) {
            return;
        }
        String uri = "file:" + movD.getImage();
        Image image = new Image(uri, 111, 159, false, true);
        editScreening_imageView.setImage(image);
        editScreening_title.setText(movD.getTitle());
    }

    public ObservableList<moviesData> editScreeningList() {
        ObservableList<moviesData> editSList = FXCollections.observableArrayList();
        String sql = "SELECT * FROM movie";
        try (Connection connect = Database.connectDB(); PreparedStatement prepare = connect.prepareStatement(sql)) {
            try (ResultSet result = prepare.executeQuery()) {
                while (result.next()) {
                    moviesData movD = new moviesData(result.getInt("id"), result.getString("movieTitle"), result.getString("genre"), result.getString("duration"), result.getString("image"), result.getDate("date"), result.getString("current"));
                    editSList.add(movD);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return editSList;
    }

    private ObservableList<moviesData> editScreeningL;

    public void showEditScreening() {
        editScreeningL = editScreeningList();
        editScreening_col_movieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        editScreening_col_genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        editScreening_col_duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        editScreening_col_current.setCellValueFactory(new PropertyValueFactory<>("current"));
        editScreening_tableView.setItems(editScreeningL);
    }

    public void searchAddMovies() {

        FilteredList<moviesData> filter = new FilteredList<>(listAddMovies, e -> true);
        addMovies_search.textProperty().addListener((observable, oldValue, newValue) -> {

            filter.setPredicate(predicateMoviesData -> {

                if (newValue.isEmpty() || newValue == null) {

                    return true;
                }

                String keySearch = newValue.toLowerCase();

                if (predicateMoviesData.getTitle().toLowerCase().contains(keySearch)) {
                    return true;
                } else if (predicateMoviesData.getGenre().toLowerCase().contains(keySearch)) {
                    return true;
                } else if (predicateMoviesData.getDuration().toLowerCase().contains(keySearch)) {
                    return true;
                } else if (predicateMoviesData.getDate().toString().contains(keySearch)) {
                    return true;
                }

                return false;

            });

        });

        SortedList<moviesData> sortData = new SortedList<>(filter);
        sortData.comparatorProperty().bind(addMovies_tableView.comparatorProperty());

        addMovies_tableView.setItems(sortData);

    }

    public void importImage() {

        FileChooser open = new FileChooser();

        open.setTitle("Open Image File");
        open.getExtensionFilters().add(new ExtensionFilter("Image File", "*jpg", "*png"));

        Stage stage = (Stage) addMovies_form.getScene().getWindow();
        File file = open.showOpenDialog(stage);

        if (file != null) {

            image = new Image(file.toURI().toString(), 107, 141, false, true);
            addMovies_imageView.setImage(image);

            getData.path = file.getAbsolutePath();

        }

    }

    public void movieId() {
        String sql = "SELECT count(id) FROM movie";

        connect = Database.connectDB();

        try {
            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            if (result.next()) {

                getData.movieId = result.getInt("count(id)");

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void insertAddMovies() {

        String sql1 = "SELECT * FROM movie WHERE movieTitle = '"
                + addMovies_movieTitle.getText() + "'";

        connect = Database.connectDB();

        Alert alert;

        try {

            statement = (Statement) connect.createStatement();
            result = statement.executeQuery(sql1);

            if (result.next()) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText(addMovies_movieTitle.getText() + "is already exist!");
                alert.showAndWait();

            } else {

                if (addMovies_movieTitle.getText().isEmpty()
                        || addMovies_genre.getText().isEmpty()
                        || addMovies_duration.getText().isEmpty()
                        || addMovies_imageView.getImage() == null
                        || addMovies_date.getValue() == null) {

                    alert = new Alert(AlertType.ERROR);
                    alert.setTitle("Error Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Please fill all black fields");
                    alert.showAndWait();

                } else {

                    String sql = "INSERT INTO movie (id, movieTitle, genre, duration, image, date, current) VALUES (?,?,?,?,?,?,?)";

                    String uri = getData.path;
                    uri = uri.replace("\\", "\\\\");

                    movieId();

                    String mID = String.valueOf(getData.movieId + 1);

                    prepare = connect.prepareStatement(sql);

                    prepare.setString(1, mID);
                    prepare.setString(2, addMovies_movieTitle.getText());
                    prepare.setString(3, addMovies_genre.getText());
                    prepare.setString(4, addMovies_duration.getText());
                    prepare.setString(5, uri);
                    prepare.setString(6, String.valueOf(addMovies_date.getValue()));
                    prepare.setString(7, "Showing");

                    prepare.execute();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully added new movie");
                    alert.showAndWait();

                    clearAddMoviesList();
                    showAddMoviesList();

                }

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void updateAddMovies() {
        String uri = getData.path;
        uri = uri.replace("\\", "\\\\");

        String sql = "UPDATE movie SET movieTitle = '" + addMovies_movieTitle.getText()
                + "', genre = '" + addMovies_genre.getText()
                + "', duration = '" + addMovies_duration.getText()
                + "', image = '" + uri
                + "', date = '" + addMovies_date.getValue()
                + "' WHERE id = '" + String.valueOf(getData.movieId) + "'";

        connect = Database.connectDB();

        try {

            statement = (Statement) connect.createStatement();

            Alert alert;

            if (addMovies_movieTitle.getText().isEmpty()
                    || addMovies_genre.getText().isEmpty()
                    || addMovies_duration.getText().isEmpty()
                    || addMovies_imageView.getImage() == null
                    || addMovies_date.getValue() == null) {

                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please select the movie first");
                alert.showAndWait();

            } else {

                statement.executeUpdate(sql);

                alert = new Alert(AlertType.INFORMATION);
                alert.setTitle("Information Message");
                alert.setHeaderText(null);
                alert.setContentText("Successfully Updated " + addMovies_movieTitle.getText());
                alert.showAndWait();

                showAddMoviesList();
                clearAddMoviesList();

            }

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void deleteAddMovies() {
        String sql = "DELETE FROM movie WHERE movieTitle = '" + addMovies_movieTitle.getText() + "'";
        connect = Database.connectDB();

        try {
            statement = (Statement) connect.createStatement();

            Alert alert;
            if (addMovies_movieTitle.getText().isEmpty()
                    || addMovies_genre.getText().isEmpty()
                    || addMovies_duration.getText().isEmpty()
                    || addMovies_imageView.getImage() == null
                    || addMovies_date.getValue() == null) {
                alert = new Alert(AlertType.ERROR);
                alert.setTitle("Error Message");
                alert.setHeaderText(null);
                alert.setContentText("Please select the movie first");
                alert.showAndWait();
            } else {
                alert = new Alert(AlertType.CONFIRMATION);
                alert.setTitle("Confirmation Message");
                alert.setHeaderText(null);
                alert.setContentText("Are you sure want to delete " + addMovies_movieTitle.getText() + "?");

                Optional<ButtonType> option = alert.showAndWait();
                if (ButtonType.OK.equals(option.get())) {
                    statement.executeUpdate(sql);

                    showAddMoviesList();
                    clearAddMoviesList();

                    alert = new Alert(AlertType.INFORMATION);
                    alert.setTitle("Information Message");
                    alert.setHeaderText(null);
                    alert.setContentText("Successfully Deleted");
                    alert.showAndWait();
                } else {
                    return;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void clearAddMoviesList() {

        addMovies_movieTitle.setText("");
        addMovies_genre.setText("");
        addMovies_duration.setText("");
        addMovies_imageView.setImage(null);
        addMovies_date.setValue(null);

    }

    public ObservableList<moviesData> addMoviesList() {

        ObservableList<moviesData> listData = FXCollections.observableArrayList();

        String sql = "SELECT * FROM movie";

        connect = Database.connectDB();

        try {

            prepare = connect.prepareStatement(sql);
            result = prepare.executeQuery();

            moviesData movD;

            while (result.next()) {

                movD = new moviesData(result.getInt("id"), result.getString("movieTitle"), result.getString("genre"), result.getString("duration"), result.getString("image"), result.getDate("date"), result.getString("current"));

                listData.add(movD);

            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return listData;
    }

    private ObservableList<moviesData> listAddMovies;

    public void showAddMoviesList() {

        listAddMovies = addMoviesList();

        addMovies_col_movieTitle.setCellValueFactory(new PropertyValueFactory<>("title"));
        addMovies_col_genre.setCellValueFactory(new PropertyValueFactory<>("genre"));
        addMovies_col_duration.setCellValueFactory(new PropertyValueFactory<>("duration"));
        addMovies_col_releaseDate.setCellValueFactory(new PropertyValueFactory<>("date"));

        addMovies_tableView.setItems(listAddMovies);

    }

    public void selectAddMoviesList() {
        moviesData movD = addMovies_tableView.getSelectionModel().getSelectedItem();
        int num = addMovies_tableView.getSelectionModel().getSelectedIndex();
        if ((num - 1) < -1) {
            return;
        }

        getData.path = movD.getImage();
        getData.movieId = movD.getId();
        addMovies_movieTitle.setText(movD.getTitle());
        addMovies_genre.setText(movD.getGenre());
        addMovies_duration.setText(movD.getDuration());
        addMovies_date.setValue(movD.getDate().toLocalDate());

        String uri = "file:" + movD.getImage();

        image = new Image(uri, 107, 141, false, true);
        addMovies_imageView.setImage(image);

    }

    public void logout() {

        signout.getScene().getWindow().hide();
        try {

            Parent root = FXMLLoader.load(getClass().getResource("FXMLDocument.fxml"));

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

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void switchForm(ActionEvent event) {

        if (event.getSource() == dashboard_btn) {

            dashboard_form.setVisible(true);
            addMovies_form.setVisible(false);
            availableMovies_form.setVisible(false);
            editScreening_form.setVisible(false);
            customers_form.setVisible(false);

            dashboard_btn.setStyle("-fx-background-color:#ae2d3c");
            addMovies_btn.setStyle("-fx-background-color:transparent");
            availableMovies_btn.setStyle("-fx-background-color:transparent");
            editScreening_btn.setStyle("-fx-background-color:transparent");
            customers_btn.setStyle("-fx-background-color:transparent");

            displayTotalSoldTicket();
            displayTotalIncomeToday();
            displayTotalAvailableMovies();

        } else if (event.getSource() == addMovies_btn) {

            dashboard_form.setVisible(false);
            addMovies_form.setVisible(true);
            availableMovies_form.setVisible(false);
            editScreening_form.setVisible(false);
            customers_form.setVisible(false);

            dashboard_btn.setStyle("-fx-background-color:transparent");
            addMovies_btn.setStyle("-fx-background-color:#ae2d3c");
            availableMovies_btn.setStyle("-fx-background-color:transparent");
            editScreening_btn.setStyle("-fx-background-color:transparent");
            customers_btn.setStyle("-fx-background-color:transparent");

            showAddMoviesList();

        } else if (event.getSource() == availableMovies_btn) {

            dashboard_form.setVisible(false);
            addMovies_form.setVisible(false);
            availableMovies_form.setVisible(true);
            editScreening_form.setVisible(false);
            customers_form.setVisible(false);

            dashboard_btn.setStyle("-fx-background-color:transparent");
            addMovies_btn.setStyle("-fx-background-color:transparent");
            availableMovies_btn.setStyle("-fx-background-color:#ae2d3c");
            editScreening_btn.setStyle("-fx-background-color:transparent");
            customers_btn.setStyle("-fx-background-color:transparent");

            showAvailableMovies();

        } else if (event.getSource() == editScreening_btn) {

            dashboard_form.setVisible(false);
            addMovies_form.setVisible(false);
            availableMovies_form.setVisible(false);
            editScreening_form.setVisible(true);
            customers_form.setVisible(false);

            dashboard_btn.setStyle("-fx-background-color:transparent");
            addMovies_btn.setStyle("-fx-background-color:transparent");
            availableMovies_btn.setStyle("-fx-background-color:transparent");
            editScreening_btn.setStyle("-fx-background-color:#ae2d3c");
            customers_btn.setStyle("-fx-background-color:transparent");

            showEditScreening();

        } else if (event.getSource() == customers_btn) {

            dashboard_form.setVisible(false);
            addMovies_form.setVisible(false);
            availableMovies_form.setVisible(false);
            editScreening_form.setVisible(false);
            customers_form.setVisible(true);

            dashboard_btn.setStyle("-fx-background-color:transparent");
            addMovies_btn.setStyle("-fx-background-color:transparent");
            availableMovies_btn.setStyle("-fx-background-color:transparent");
            editScreening_btn.setStyle("-fx-background-color:transparent");
            customers_btn.setStyle("-fx-background-color:#ae2d3c");

            showCustomerList();

        }

    }

    public void displayUsername() {

        username.setText(getData.username);

    }

    public void close() {
        System.exit(0);
    }

    public void minimize() {
        Stage stage = (Stage) topForm.getScene().getWindow();
        stage.setIconified(true);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        displayUsername();

        showAddMoviesList();

        showEditScreening();

        comboBox();

        showAvailableMovies();

        showSpinnerValue();

        showCustomerList();

        displayTotalSoldTicket();

        displayTotalIncomeToday();

        displayTotalAvailableMovies();
    }

}