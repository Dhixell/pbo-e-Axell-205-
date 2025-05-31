package com.example.inicodelab;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import java.util.Random;

public class TebakAngkaApp extends Application {

    private int angkaRahasia;
    private int percobaan;

    private Label labelJudul;
    private Label labelFeedback;
    private TextField inputTebakan;
    private Button tombolTebak;
    private Label labelPercobaan;

    private void mulaiPermainanBaru() {
        angkaRahasia = new Random().nextInt(100) + 1;
        percobaan = 0;
        inputTebakan.clear();
        labelFeedback.setText("Masukkan tebakanmu!");
        labelFeedback.setTextFill(Color.GRAY);
        tombolTebak.setText("🟩 Coba Tebak!");
        labelPercobaan.setText("Jumlah percobaan: 0");
    }

    private void periksaJawaban() {
        if (tombolTebak.getText().equals("🔁 Main Lagi")) {
            mulaiPermainanBaru();
            return;
        }

        try {
            int tebakan = Integer.parseInt(inputTebakan.getText());
            percobaan++;
            labelPercobaan.setText("Jumlah percobaan: " + percobaan);

            if (tebakan < angkaRahasia) {
                labelFeedback.setText("⚠ Terlalu kecil!");
                labelFeedback.setTextFill(Color.ORANGE);
            } else if (tebakan > angkaRahasia) {
                labelFeedback.setText("⚠ Terlalu besar!");
                labelFeedback.setTextFill(Color.ORANGE);
            } else {
                labelFeedback.setText("✅ Tebakan benar!");
                labelFeedback.setTextFill(Color.GREEN);
                tombolTebak.setText("🔁 Main Lagi");

                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setTitle("🎉 Selamat!");
                alert.setHeaderText("Tebakan Benar!");
                alert.setContentText("Kamu berhasil menebak dalam " + percobaan + " percobaan.");
                alert.showAndWait();
            }
        } catch (NumberFormatException e) {
            labelFeedback.setText("❌ Input harus berupa angka!");
            labelFeedback.setTextFill(Color.RED);
        }
    }

    @Override
    public void start(Stage primaryStage) {
        labelJudul = new Label("🔮 Tebak Angka 1–100");
        labelJudul.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        labelJudul.setTextFill(Color.DARKBLUE);

        labelFeedback = new Label("Masukkan tebakanmu!");
        labelFeedback.setTextFill(Color.GRAY);

        inputTebakan = new TextField();
        inputTebakan.setPromptText("Masukkan angka di sini");
        inputTebakan.setMaxWidth(250);

        tombolTebak = new Button("🟩 Coba Tebak!");
        tombolTebak.setStyle("-fx-background-color: #2ecc71; -fx-text-fill: white;");
        tombolTebak.setOnAction(e -> periksaJawaban());

        labelPercobaan = new Label("Jumlah percobaan: 0");

        HBox inputBox = new HBox(10, inputTebakan, tombolTebak);
        inputBox.setAlignment(Pos.CENTER);

        VBox content = new VBox(10, labelJudul, labelFeedback, inputBox, labelPercobaan);
        content.setAlignment(Pos.CENTER);

        VBox root = new VBox(content);
        root.setAlignment(Pos.CENTER);
        root.setStyle("-fx-background-color: #ecf0f1; -fx-padding: 30;");

        Scene scene = new Scene(root, 450, 300);
        primaryStage.setTitle("🔮 Tebak Angka Advance");
        primaryStage.setScene(scene);
        primaryStage.show();

        mulaiPermainanBaru();
    }

    public static void main(String[] args) {
        launch(args);
    }
}