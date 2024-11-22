package com.example;



import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.stage.FileChooser;
import java.io.File;
import java.util.ArrayList;




public class HelloApplication extends Application {

    // ArrayList to store Person objects
    private ArrayList<Person> personList = new ArrayList<>();

    @Override
    public void start(Stage primaryStage) {
        // Create the layout
        VBox root = new VBox(10);
        root.setPadding(new Insets(20));
        root.setAlignment(Pos.TOP_CENTER);

        // Banner placeholder
        Label banner = new Label("Banner");
        banner.setStyle("-fx-font-size: 24px; -fx-font-weight: bold;");
        root.getChildren().add(banner);

        // Form fields
        GridPane formGrid = new GridPane();
        formGrid.setHgap(10);
        formGrid.setVgap(10);

        // Name
        Label nameLabel = new Label("Name:");
        TextField nameField = new TextField();
        formGrid.add(nameLabel, 0, 0);
        formGrid.add(nameField, 1, 0);

        // Father Name
        Label fatherNameLabel = new Label("Father Name:");
        TextField fatherNameField = new TextField();
        formGrid.add(fatherNameLabel, 0, 1);
        formGrid.add(fatherNameField, 1, 1);

        // CNIC
        Label cnicLabel = new Label("CNIC:");
        TextField cnicField = new TextField();
        formGrid.add(cnicLabel, 0, 2);
        formGrid.add(cnicField, 1, 2);

        // Date Picker
        Label dateLabel = new Label("Date of Birth:");
        DatePicker datePicker = new DatePicker();
        formGrid.add(dateLabel, 0, 3);
        formGrid.add(datePicker, 1, 3);

        // Gender (Radio Buttons)
        Label genderLabel = new Label("Gender:");
        ToggleGroup genderGroup = new ToggleGroup();
        RadioButton maleRadio = new RadioButton("Male");
        RadioButton femaleRadio = new RadioButton("Female");
        maleRadio.setToggleGroup(genderGroup);
        femaleRadio.setToggleGroup(genderGroup);
        HBox genderBox = new HBox(10, maleRadio, femaleRadio);
        formGrid.add(genderLabel, 0, 4);
        formGrid.add(genderBox, 1, 4);

        // City (ComboBox)
        Label cityLabel = new Label("City:");
        ComboBox<String> cityComboBox = new ComboBox<>();
        cityComboBox.getItems().addAll("Lahore", "Karachi", "Islamabad", "Peshawar", "Quetta");
        formGrid.add(cityLabel, 0, 5);
        formGrid.add(cityComboBox, 1, 5);

        // Image (File Chooser)
        Label imageLabel = new Label("Image:");
        Button fileChooserButton = new Button("Choose Image");
        Label fileNameLabel = new Label("No file selected");
        fileChooserButton.setOnAction(e -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Image Files", "*.png", "*.jpg", "*.jpeg"));
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedFile != null) {
                fileNameLabel.setText(selectedFile.getName());
            }
        });
        HBox fileChooserBox = new HBox(10, fileChooserButton, fileNameLabel);
        formGrid.add(imageLabel, 0, 6);
        formGrid.add(fileChooserBox, 1, 6);

        // Add the form to the layout
        root.getChildren().add(formGrid);

        // Save Button
        Button saveButton = new Button("Save");
        saveButton.setOnAction(e -> {
            String name = nameField.getText();
            String fatherName = fatherNameField.getText();
            String cnic = cnicField.getText();
            String dateOfBirth = datePicker.getValue() != null ? datePicker.getValue().toString() : "";
            String gender = ((RadioButton) genderGroup.getSelectedToggle()).getText();
            String city = cityComboBox.getValue();
            File imageFile = null; // Add logic to retrieve file if needed

            // Create Person object and add to ArrayList
            Person person = new Person(name, fatherName, cnic, dateOfBirth, gender, city, imageFile);
            personList.add(person);

            // Clear fields
            nameField.clear();
            fatherNameField.clear();
            cnicField.clear();
            datePicker.setValue(null);
            genderGroup.getSelectedToggle().setSelected(false);
            cityComboBox.setValue(null);
            fileNameLabel.setText("No file selected");

            // Confirmation
            Alert alert = new Alert(Alert.AlertType.INFORMATION);
            alert.setTitle("Success");
            alert.setHeaderText("Data Saved");
            alert.setContentText("Person data has been saved successfully!");
            alert.showAndWait();
        });
        root.getChildren().add(saveButton);

        // Create the scene and set the stage
        Scene scene = new Scene(root, 600, 500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Person Form");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
        // ArrayList<Person> p=new ArrayList<>();
        // for (Person person : p) {
        //     System.out.println(person);
        // }
    }
}

