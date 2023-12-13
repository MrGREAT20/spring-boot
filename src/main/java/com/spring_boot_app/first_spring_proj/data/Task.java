package com.spring_boot_app.first_spring_proj.data;

import java.util.Date;

public class Task {
        String title;
        Date duedate;
        Boolean iscompleted;
        public Task(String title, Date duedate, Boolean iscompleted){
            this.title = title;
            this.duedate = duedate;
            this.iscompleted = iscompleted;
        }
        public Date getDuedate() {
            return duedate;
        }
        public void setDuedate(Date duedate) {
            this.duedate = duedate;
        }
        public Boolean getIscompleted() {
            return iscompleted;                                                                   
        }
        public void setIscompleted(Boolean iscompleted) {
            this.iscompleted = iscompleted;
        }
        public String getTitle() {
            return title;
        }
        public void setTitle(String title) {
            this.title = title;
        }
}

/**
 * If you comment out the getters and setters, you will not get the list of task, WHY?
 * 
 * because the arraylist <Task> ka function .get() will use Tasks.getDuedate(), Tasks.getTitle(), Tasks.getIsCompleted()
 * if we have not mentioned than it wont show in the GET "/tasks" route
 * 
 * even if you comment out the setters, you will still see the output because we are only using GETTERS method
 */