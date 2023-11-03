package kr7;

public class task2_1 {
    String surname;
    String name;
    String secondName;
    int yearBirth;
    String adress;
    String phone;
    String faculty;
    int course;
    int group;

    public task2_1(
            String s1, String s2, String s3, int b, String ad,
            String ph, String fc, int cr, int gr
    ) {
        this.surname = s1;
        this.name = s2;
        this.secondName = s3;
        this.yearBirth = b;
        this.adress = ad;
        this.phone = ph;
        this.faculty = fc;
        this.course = cr;
        this.group = gr;
    }

    public String getFaculty() {
        return this.faculty;
    }
    public int getYear() {
        return this.yearBirth;
    }
    public int getGroup() {
        return this.group;
    }
    public void printStudent() {
        System.out.println("Student: " + this.name + ", faculty: " + this.faculty + ", year of: " +
                this.yearBirth + ", course: " + this.course + ", and group: " + this.group );
    }

}
