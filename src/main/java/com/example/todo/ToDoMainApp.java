package com.example.todo;

import com.example.todo.dataModel.TodoData;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class ToDoMainApp extends Application {

    /***
     *
     * @param stage
     * @throws IOException
     * This function creates a FXMLLoader with the main-windows.fxml
     * After setting the title and scene it shows the Stage
     */
    @Override
    public void start(Stage stage) throws IOException {

        // Main scene is coming from main-window.fxml file, and we are creating a fxml loader with it
        FXMLLoader fxmlLoader = new FXMLLoader(ToDoMainApp.class.getResource("main-window.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 900, 500);         // Creating the scene of 900to500
        stage.setTitle("ToDo List!");                                       // Setting the tittle
        stage.setScene(scene);                                              // Setting the scene
        stage.show();                                                       // Showing the scene
    }

    public static void main(String[] args) {
        launch();       // launch function will trigger start function
    }

    /***
     *
     * @throws Exception
     * While stopping the stage we want our data to be stored in.
     * This overriden function tries to store the data.
     */
    @Override
    public void stop() throws Exception {
        try{
            TodoData.getInstance().storeTodoItems();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }

    /***
     *
     * @throws Exception
     * During the initialization of the stage this function gets the data that has been stored previously.
     * Then initialized the app with that stored data
     */
    @Override
    public void init() throws Exception {
        try{
            TodoData.getInstance().loadTodoItems();
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}