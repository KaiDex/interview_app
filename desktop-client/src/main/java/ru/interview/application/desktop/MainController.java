package ru.interview.application.desktop;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import org.springframework.beans.factory.annotation.Autowired;
import ru.interview.application.model.dictionary.Category;
import ru.interview.application.service.dictionary.CategoryService;

import javax.annotation.PostConstruct;
import java.util.List;

public class MainController {
    // Инъекции Spring
    @Autowired
    private CategoryService categoryService;

    // Инъекции JavaFX
    @FXML
    private TableView<Category> table;
    @FXML
    private TextField txtName;

    // Переменные
    private ObservableList<Category> data;

    /**
     * Инициализация контроллера от JavaFX.
     * Метод вызывается после того как FXML загрузчик произвел инъекции полей.
     * <p>
     * Обратите внимание, что имя метода <b>обязательно</b> должно быть "initialize",
     * в противном случае, метод не вызовется.
     * <p>
     * Также на этом этапе еще отсутствуют бины спринга
     * и для инициализации лучше использовать метод,
     * описанный аннотацией @PostConstruct.
     * Который вызовется спрингом, после того,
     * как им будут произведены все оставшиеся инъекции.
     * {@link MainController#init()}
     */
    @FXML
    public void initialize() {
    }

    /**
     * На этом этапе уже произведены все возможные инъекции.
     */
    @PostConstruct
    public void init() {
        List<Category> contacts = categoryService.getAll();
        data = FXCollections.observableArrayList(contacts);

        // Добавляем столбцы к таблице
        TableColumn<Category, String> idColumn = new TableColumn<>("ID");
        idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));

        TableColumn<Category, String> nameColumn = new TableColumn<>("Имя");
        nameColumn.setCellValueFactory(new PropertyValueFactory<>("name"));

        table.getColumns().setAll(idColumn, nameColumn);

        // Добавляем данные в таблицу
        table.setItems(data);
    }

    /**
     * Метод, вызываемый при нажатии на кнопку "Добавить".
     * Привязан к кнопке в FXML файле представления.
     */
    @FXML
    public void addCategory() {
        Category category = categoryService.create(txtName.getText());
        data.add(category);

        // чистим поля
        txtName.setText("");
    }
}
