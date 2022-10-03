package com.example.todo;

import com.example.todo.dataModel.TodoData;
import com.example.todo.dataModel.TodoItem;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

import java.time.LocalDate;

public class DialogController {

    @FXML
    private TextField shortDescription;
    @FXML
    private TextArea details;
    @FXML
    private DatePicker deadlinePicker;


    public TodoItem processResults(){
        String shortDescription = this.shortDescription.getText().trim();
        String details = this.details.getText().trim();
        LocalDate deadlineValue = this.deadlinePicker.getValue();

        TodoItem newItem = new TodoItem(shortDescription,details,deadlineValue);
        TodoData.getInstance().addTodoItem(newItem);
        return newItem;
    }

}
