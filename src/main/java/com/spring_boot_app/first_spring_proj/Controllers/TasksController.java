package com.spring_boot_app.first_spring_proj.Controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.spring_boot_app.first_spring_proj.data.Task;

import java.util.ArrayList;
import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;








@RestController
@RequestMapping("/tasks")
public class TasksController {

    
    ArrayList<Task>tasks;
    public TasksController(){
        this.tasks = new ArrayList<>();
        this.tasks.add(new Task("Task1", new Date(), false));
        this.tasks.add(new Task("Task2", new Date(), false));
    }


    @GetMapping("")
    public ArrayList<Task> getAllTasks() {
        return tasks;
    }
    /**
     * This will give me all the tasks 
     * the good part of SPring framework is, even if i return an arrayList of tasks
     * it will get converted to JSON and it will be shown on the display
     * 
     */


    @GetMapping("/{id}")
    public Task getTaskBYId(@PathVariable("id") Integer id) {
        return tasks.get(id);
    }
    /** eg 
     *     "tasks/0" will show the first task, 
     *     "tasks/1" will show the second task
     * 
     */


    // @PostMapping("")
    // public ArrayList<Task> postMethodName(@RequestBody Task task) {
    //     this.tasks.add(task);
    //     return tasks;
    // }
    /**
     * do a POST request from POSTMAN with body set as raw and write this object
     * 
     * {
            "title": "Task3",
            "duedate" : "{{$timestamp}}",
            "iscompleted" : "false"

        }

        here is the response

        STATUS : 200

        [
            {
                "title": "Task1",
                "duedate": "2023-12-13T12:50:27.542+00:00",
                "iscompleted": false
            },
            {
                "title": "Task2",
                "duedate": "2023-12-13T12:50:27.542+00:00",
                "iscompleted": false
            },
            {
                "title": "Task3",
                "duedate": "1970-01-20T16:54:32.555+00:00",
                "iscompleted": false
            }
        ]


        we can make some changes in the code to put custom HTTP CODE

     */

    @PostMapping("")
    public ResponseEntity<ArrayList<Task>>createTask(@RequestBody Task task) {
        this.tasks.add(task);
        return new ResponseEntity<>(tasks, HttpStatus.CREATED);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity <ArrayList<Task>> deleteTask(@PathVariable("id") Integer id){
        if(this.tasks.size() > 0){
            this.tasks.remove((int)id); // this.tasks.remove(id) was not working, so we 
        }
        return new ResponseEntity<>(tasks, HttpStatus.CREATED);
    }

    
    @PatchMapping("/{id}")
    public ResponseEntity<ArrayList<Task>> updateTask(@PathVariable("id") Integer id, @RequestBody Task ntask){
        if(this.tasks.size() > (int)id){
            this.tasks.set((int) id, ntask);
        }
        else{
            return new ResponseEntity<>(tasks, HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>(tasks, HttpStatus.CREATED);
    }
    
    
    
}

