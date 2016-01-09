package es.tta.ejemplo_tta.model;

/**
 * Created by Usuario on 09/01/2016.
 */
public class Status {
    final private  String dnii;
    final  private String password;
    private int id;
    private String user;
    private int lessonNumber;
    private String lessonTitle;
    private int nextTest;
    private int nextExercise;

    public Status(String dni, String pasw,int id, String user, int lessonNumber, String lessonTitle, int nextTest, int nextExercise){
        dnii=dni;
        password=pasw;
        this.id = id;
        this.user = user;
        this.lessonNumber = lessonNumber;
        this.lessonTitle = lessonTitle;
        this.nextTest = nextTest;
        this.nextExercise = nextExercise;

    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public void setUser(String user) {
        this.user = user;
    }

    public int getLessonNumber() {
        return lessonNumber;
    }

    public void setLessonNumber(int lessonNumber) {
        this.lessonNumber = lessonNumber;
    }
    public void setNextExercise(int nextExercise) {
        this.nextExercise = nextExercise;
    }

    public String getLessonTitle() {
        return lessonTitle;
    }

    public void setLessonTitle(String lessonTitle) {
        this.lessonTitle = lessonTitle;
    }

    public int getNextTest() {
        return nextTest;
    }

    public void setNextTest(int nextTest) {
        this.nextTest = nextTest;
    }
    public int getNextExercise() {
        return nextExercise;
    }

    public String getUser() {
        return user;
    }






}
