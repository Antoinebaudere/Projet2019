package sample;

import javafx.application.Application;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.stage.Stage;

import javafx.scene.control.TableView;

import javafx.scene.control.Label;

public class Main extends Application {
    //Variable globale contenant la TableView (permettant l'affichage des tweets dans l'interface)
    private TableView table;
    @Override
    public void start(Stage primaryStage) throws Exception{
        //Lancement du project
        Project p=new Project();
        //import des données
        p.importdonnee();
        //création de l'interface
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //On donne un titre à la fenêtre
        primaryStage.setTitle("Projet Java");
        Label label = new Label("Fouille de texte java");
        label.setTextFill(Color.DARKBLUE);
        label.setFont(Font.font("Calibri", FontWeight.BOLD, 33));
        HBox hb = new HBox();
        hb.setAlignment(Pos.CENTER);
        hb.getChildren().add(label);
        //création des colonnes (nom + PropertyValueFactory)
        table = new TableView();
        TableColumn idCol = new TableColumn("Pseudo");
        idCol.setCellValueFactory(new PropertyValueFactory("pseudo"));
        TableColumn dateCol = new TableColumn("Date");
        dateCol.setCellValueFactory(new PropertyValueFactory("date"));
        TableColumn contenuCol = new TableColumn("Contenu");
        contenuCol.setCellValueFactory(new PropertyValueFactory("contenu"));
        TableColumn retweetCol = new TableColumn("Nom Retweet");
        retweetCol.setCellValueFactory(new PropertyValueFactory("NomRetweet"));

        table.getColumns().setAll(idCol, dateCol,contenuCol,retweetCol);
        table.setPrefWidth(800);
        table.setPrefHeight(450);
        table.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);

        // Vbox
        VBox vbox = new VBox(20);
        vbox.setPadding(new Insets(25, 25, 25, 25));
        vbox.getChildren().addAll(hb, table);

        // Scene
        Scene scene = new Scene(vbox, 900, 675); // w x h
        primaryStage.setScene(scene);
        primaryStage.show();

        //On affiche les 10000 premiers tweets afin de ne pas surcharger la GUI
        int cmp=0;
        for(Tweet t:p.sortedSurfaceFormSet) {
            table.getItems().add(t);
            cmp++;
            if(cmp>10000)break;
        }
        //On affiche le stage
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
