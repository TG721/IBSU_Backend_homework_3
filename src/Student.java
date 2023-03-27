import java.util.List;

public class Student {
    private String fullName;
    private List<Double> examPoint;
    private Double average;

    public Student(String fullName, List<Double> examPoint) {
        this.fullName = fullName;
        this.examPoint = examPoint;
    }

    public void calculateAverage(){
        Double sum=0.0;
        int counter;
        for (counter=0; counter<examPoint.size(); counter++) {
            sum += examPoint.get(counter);
        }
        this.average = sum/counter;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public List<Double> getExamPoint() {
        return examPoint;
    }

    public void setExamPoint(List<Double> examPoint) {
        this.examPoint = examPoint;
    }

    public Double getAverage() {
        return average;
    }
}
