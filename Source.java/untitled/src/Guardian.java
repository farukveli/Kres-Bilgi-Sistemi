public class Guardian {
    private int guard_Id;
    private String firstName;
    private String lastName;
    private String address;
    private String phone;
    private String depType;

    public Guardian(int guard_Id, String firstName, String lastName, String address, String phone, String depType) {
        this.guard_Id = guard_Id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.address = address;
        this.phone = phone;
        this.depType = depType;
    }

    public int getGuard_Id() {
        return guard_Id;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public String getDepType() {
        return depType;
    }


}
