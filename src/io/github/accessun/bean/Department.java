package io.github.accessun.bean;

public class Department {

    private Integer id;
    private String deptName;
    private Person manager;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public Person getManager() {
        return manager;
    }

    public void setManager(Person manager) {
        this.manager = manager;
    }

    public Department() {
        // TODO Auto-generated constructor stub
    }

    public Department(Integer id, String deptName, Person manager) {
        super();
        this.id = id;
        this.deptName = deptName;
        this.manager = manager;
    }

    @Override
    public String toString() {
        return "Department [id=" + id + ", deptName=" + deptName + ", manager=" + manager + "]";
    }

}
