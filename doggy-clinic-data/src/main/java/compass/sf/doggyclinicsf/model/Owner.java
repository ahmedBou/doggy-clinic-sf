package compass.sf.doggyclinicsf.model;

import java.util.HashSet;
import java.util.Set;

public class Owner extends Person{

    private String address;
    private String city;
    private String telephone;
    private Set<Doggy> dogs = new HashSet<>();

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }



    public Set<Doggy> getDogs() {
        return dogs;
    }

    public void setDogs(Set<Doggy> dogs) {
        this.dogs = dogs;
    }
}
