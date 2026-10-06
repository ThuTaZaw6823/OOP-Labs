package lab4.q1;

public abstract class PSUStudent {

    protected int age;
    protected double gpa;

    public PSUStudent(int age, double gpa) {
        this.age = age;
        this.gpa = gpa;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public abstract double revealGrade();

    public void setCurrentYear(int currentYear) {
    }

    public void setPassThesis(boolean passThesis) {
    }
}