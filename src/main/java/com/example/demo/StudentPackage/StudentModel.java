package com.example.demo.StudentPackage;


import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import java.util.List;

@Document(collection = "sirarvindbcollection")
public class StudentModel {

    @Id // Marks this field as the primary key
    private String id;

    private String name;
    private int age;
    private String username;
    private String password;

    // Adding new fields for student schedules, upcoming events, and personal goals
    private List<String> schedule; // Array of schedules (could be a list of event names, for example)
    private List<String> upcomingEvents; // List of upcoming events (e.g., exams, sports)
    private List<String> personalGoals; // List of personal goals (e.g., academic or extracurricular goals)

    // No-argument constructor (required by MongoDB and Spring Data)
    public StudentModel() {
    }

    // All-arguments constructor for convenience
    public StudentModel(String id, String name, int age, String username, String password,
                        List<String> schedule, List<String> upcomingEvents, List<String> personalGoals) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.username = username;
        this.password = password;
        this.schedule = schedule;
        this.upcomingEvents = upcomingEvents;
        this.personalGoals = personalGoals;
    }

    // Getters and Setters
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<String> getSchedule() {
        return schedule;
    }

    public void setSchedule(List<String> schedule) {
        this.schedule = schedule;
    }

    public List<String> getUpcomingEvents() {
        return upcomingEvents;
    }

    public void setUpcomingEvents(List<String> upcomingEvents) {
        this.upcomingEvents = upcomingEvents;
    }

    public List<String> getPersonalGoals() {
        return personalGoals;
    }

    public void setPersonalGoals(List<String> personalGoals) {
        this.personalGoals = personalGoals;
    }

    @Override
    public String toString() {
        return "StudentModel{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                ", schedule=" + schedule +
                ", upcomingEvents=" + upcomingEvents +
                ", personalGoals=" + personalGoals +
                '}';
    }
}
