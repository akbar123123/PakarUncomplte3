package com.raven.swing.table;

import com.raven.model.ModelStudent3;

public class ModelAction3 {

    public ModelStudent3 getStudent() {
        return student;
    }

    public void setStudent(ModelStudent3 student) {
        this.student = student;
    }

    public EventAction3 getEvent() {
        return event2;
    }

    public void setEvent(EventAction3 event) {
        this.event2 = event2;
    }

    public ModelAction3(ModelStudent3 student, EventAction3 event) {
        this.student = student;
        this.event2 = event2;
    }

    public ModelAction3() {
    }

    private ModelStudent3 student;
    private EventAction3 event2;
}
