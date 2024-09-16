package pojoClasses;

import java.util.List;

public class CreateStudentBody {
    private String name;
    private String location;
    private String phone;
    private String courses[];

    public String[] getCourses() {
        return courses;
    }

    public String getName()
    {
        return name;
    }

    public String getLocation()
    {
        return location;
    }

    public String getPhone()
    {
        return phone;
    }

    public void setCourses(String[] courses) {
        this.courses = courses;
    }

    public void setname(String name)
    {
        this.name = name;

    }
    public void setLocation(String location)
    {
        this.location = location;

    }
    public void setPhone(String phoneNum){
        {
            this.phone = phoneNum;
        }

    }
}
