package 作业.班级成绩排序;

public class Student implements Comparable<Student>{
    private String name;
    private int id;
    private int score;

    public Student(String name, int id, int score) {
        this.name = name;
        this.id = id;
        this.score = score;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }

    @Override
    public String toString() {
        return "学号：" + id + ", 姓名：" + name  + ", 成绩：" + score;
    }

    @Override
    public int compareTo(Student o) {
        if(this.getScore()>o.getScore()){
            return -1;
        }else if(this.getScore()<o.getScore()){
            return 1;
        }
        return 0;
    }
}
