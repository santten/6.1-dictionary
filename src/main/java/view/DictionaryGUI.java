package view;

import controller.DictionaryController;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;

import java.util.Objects;

public class DictionaryGUI extends Application {
    private DictionaryController controller;
    private final Label curWord = new Label("");
    private final Text curDefinition = new Text("Search A Word To Find A Definition");

    private final TextField searchBar = new TextField();

    public void start(Stage window) {
        BorderPane pane = new BorderPane();

        VBox header = new VBox();
        HBox searchBox = new HBox();
        Button searchButton = new Button("Search");

        header.getChildren().add(new Label("Dictionary"));
        searchBox.getChildren().add(searchBar);
        searchBox.getChildren().add(searchButton);
        header.getChildren().add(searchBox);

        searchButton.setOnAction(event -> controller.search());

        pane.setTop(header);

        VBox definitionBox = new VBox();
        TextFlow definitionFlow = new TextFlow(curDefinition);
        ScrollPane scrollPane = new ScrollPane(definitionFlow);
        scrollPane.setFitToWidth(true);

        definitionBox.getChildren().add(curWord);
        definitionBox.getChildren().add(scrollPane);

        pane.setCenter(definitionBox);

        Scene view = new Scene(pane);
        view.getStylesheets().add(Objects.requireNonNull(getClass().getResource("/styles.css")).toExternalForm());

        window.setTitle("Dictionary");
        window.setScene(view);
        window.show();
    }

    public void init() {
        controller = new DictionaryController(this);
    }

    public String currentSearch() {
        return searchBar.getText();
    }

    public void setDefinition(String query, String definition) {
        this.curWord.setText("\"" + query + "\"");
        this.curDefinition.setText(definition);
    }
}