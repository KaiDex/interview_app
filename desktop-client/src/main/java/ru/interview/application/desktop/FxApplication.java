package ru.interview.application.desktop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.TilePane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import ru.interview.application.model.dictionary.Category;
import ru.interview.application.model.dictionary.Question;
import ru.interview.application.model.dictionary.Topic;
import ru.interview.application.service.dictionary.CategoryService;
import ru.interview.application.service.dictionary.QuestionService;
import ru.interview.application.service.dictionary.TopicService;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "ru.interview.application.repository")
@ComponentScan("ru.interview")
@EntityScan("ru.interview")
public class FxApplication extends AbstractJavaFxApplicationSupport {

    @Value("${ui.title:JavaFX приложение}")
    private String windowTitle;

    @Autowired
    private ConfigurationControllers.View view;
    @Autowired
    private CategoryService categoryService;
    @Autowired
    private TopicService topicService;
    @Autowired
    private QuestionService questionService;

    @Override
    public void start(Stage stage) {
        stage.setTitle(windowTitle);
        VBox root = new VBox();
        root.setSpacing(50);

        root.getChildren().add(buildCategoriesPane());
        root.getChildren().add(buildTopicsPane());
        root.getChildren().add(buildQuestionsTable());

//        stage.setScene(new Scene(view.getView()));
        stage.setScene(new Scene(root, 600, 400));
        stage.setResizable(true);
        stage.centerOnScreen();
        stage.show();
    }

    public static void main(String[] args) {
        launchApp(FxApplication.class, args);
    }

    private TilePane buildCategoriesPane() {
        TilePane categoriesPane = new TilePane();
        for (Category category : categoryService.getAll()) {
            categoriesPane.getChildren().add(new Button(category.getName()));
        }
        categoriesPane.getChildren().add(constructAddButton());

        return categoriesPane;
    }


    private TilePane buildTopicsPane() {
        TilePane topicsPane = new TilePane();
        for (Topic topic : topicService.getAll()) {
            topicsPane.getChildren().add(new Button(topic.getName()));
        }
        topicsPane.getChildren().add(constructAddButton());

        return topicsPane;
    }

    private TableView<Question> buildQuestionsTable() {
        TableView<Question> questionTableView = new TableView<>();
        ObservableList<Question> questions = FXCollections.observableArrayList(questionService.getAll());
        questionTableView.setItems(questions);

        TableColumn<Question, String> textCol = new TableColumn<>("Text");
        textCol.setCellValueFactory(new PropertyValueFactory("text"));
        TableColumn<Question, String> answerCol = new TableColumn<>("Answer");
        answerCol.setCellValueFactory(new PropertyValueFactory("answer"));

        questionTableView.getColumns().addAll(textCol, answerCol);

        return questionTableView;
    }

    private Button constructAddButton() {
        Button addButton = new Button();
        addButton.setText("Добавить...");
        addButton.setStyle("-fx-text-fill: green;");
        return addButton;
    }

}
