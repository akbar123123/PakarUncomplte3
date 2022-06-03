package com.raven.swing.table;

import com.raven.model.ModelStudent2;

public class ModelAction2 {

    public ModelStudent2 getStudent() {
        return student;
    }

    public void setStudent(ModelStudent2 student) {
        this.student = student;
    }

    public EventAction2 getEvent() {
        return event2;
    }

    public void setEvent(EventAction2 event) {
        this.event2 = event2;
    }

    public ModelAction2(ModelStudent2 student, EventAction2 event) {
        this.student = student;
        this.event2 = event2;
    }

    public ModelAction2() {
    }

    private ModelStudent2 student;
    private EventAction2 event2;
}
