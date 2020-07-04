package io.zwt.domain;

public class Account {

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    private int id;

    private String name;

    private String firstName;

    public Account(String firstName, String name, int id) {
        super();
        this.firstName = firstName;
        this.name = name;
        this.id = id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        result = prime * result
            + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public String toString() {
        return "Account [id=" + id + ", name=" + name + ", firstName="
            + firstName + "]";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Account other = (Account) obj;
        if (id != other.id)
            return false;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (name == null) {
            return other.name == null;
        } else return name.equals(other.name);
    }
}
