package lab4.q2;

public class GradStudent extends PSUStudent {

    private boolean passThesis;

    public GradStudent(int age, double gpa) {
        super(age, gpa);
        this.passThesis = false;
    }

    @Override
    public void setPassThesis(boolean passThesis) {
        this.passThesis = passThesis;
    }

    @Override
    public double revealGrade() {
        if (passThesis) {
            return gpa;
        }

        return 0.0;
    }
}
