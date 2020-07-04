package io.zwt.domain;

public class Customer {

    private String name;

    private String firstName;

    public Customer(String firstName, String name) {
        super();
        this.firstName = firstName;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result
            + ((firstName == null) ? 0 : firstName.hashCode());
        result = prime * result + ((name == null) ? 0 : name.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Customer other = (Customer) obj;
        if (firstName == null) {
            if (other.firstName != null)
                return false;
        } else if (!firstName.equals(other.firstName))
            return false;
        if (name == null) {
            return other.name == null;
        } else return name.equals(other.name);
    }

    @Override
    public String toString() {
        return "Customer [name=" + name + ", firstName=" + firstName + "]";
    }
}
