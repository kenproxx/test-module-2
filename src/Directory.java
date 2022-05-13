public class Directory {
   private int id ;
    private String numberPhone;
    private int group;
    private String name;
    private int gender;
    private String address;

    private String email;

    public Directory() {
    }

    public Directory( String numberPhone, int group, String name, int gender, String address, String email) {
        this.numberPhone = numberPhone;
        this.group = group;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.email = email;
    }
    public Directory(int id, String numberPhone, int group, String name, int gender, String address, String email) {
        this.id = id;
        this.numberPhone = numberPhone;
        this.group = group;
        this.name = name;
        this.gender = gender;
        this.address = address;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNumberPhone() {
        return numberPhone;
    }

    public void setNumberPhone(String numberPhone) {
        this.numberPhone = numberPhone;
    }

    public int getGroup() {
        return group;
    }

    public void setGroup(int group) {
        this.group = group;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public String gender() {
        String gender = "Other";
        if (getGender() == 1) {
            gender = "Man";
        } else if (getGender() == 2) {
            gender = "Women";
        }
        return gender;
    }

    public String group() {
        String group = "Other";
        if (getGroup() == 1) {
            group = "Family";
        } else if (getGroup() == 2) {
            group = "Work";
        }
        return group;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Directory{" +
                "id=" + this.id +
                ", numberPhone=" + numberPhone +
                ", group=" + group() +
                ", name=" + name +
                ", gender=" + gender() +
                ", address=" + address  +
                ", email=" + email +
                '}';
    }
}
