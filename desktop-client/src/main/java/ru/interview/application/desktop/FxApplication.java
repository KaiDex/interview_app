package ru.interview.application.desktop;

import javafx.scene.Scene;
import javafx.stage.Stage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "ru.interview.application.repository")
@ComponentScan("ru.interview")
@EntityScan("ru.interview")
public class FxApplication extends AbstractJavaFxApplicationSupport {

    @Value("${ui.title:JavaFX приложение}")
    private String windowTitle;

    @Autowired
    private ConfigurationControllers.View view;

    @Override
    public void start(Stage stage) {
        stage.setTitle(windowTitle);
        stage.setScene(new Scene(view.getView()));
        stage.setResizable(true);
        stage.centerOnScreen();
        stage.show();
    }

    public static void main(String[] args) {
        launchApp(FxApplication.class, args);
    }

}
