package institute.immune.e_parte;

public class Vehicle {
    private int id;
    private String name;
    private String surname;
    private String address;
    private int postcode;
    private String model;
    private String country;
    private String licensePlate;
    private String insuranceCompany;
    private int policyNumber;
    private String agency;
    private int gcn;
    private String gccfrom;
    private String gccto;
    private int userID;

    Vehicle(int id, String name, String surname, String licensePlate, String address, int postcode, String model, String country, int policyNumber, String insuranceCompany, String agency, int gcn, String s, String gccfrom, String gccto, int userID){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.licensePlate = licensePlate;
        this.address = address;
        this.postcode = postcode;
        this.model = model;
        this.country = country;
        this.policyNumber = policyNumber;
        this.insuranceCompany = insuranceCompany;
        this.agency = agency;
        this.gcn = gcn;
        this.gccfrom = gccfrom;
        this.gccto = gccto;
        this.userID = userID;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getLicensePlate() {
        return licensePlate;
    }

    public String getAddress() {
        return address;
    }

    public int getPostcode() {
        return postcode;
    }

    public String getModel() {
        return model;
    }

    public String getCountry() {
        return country;
    }

    public int getPolicyNumber() {
        return policyNumber;
    }

    public String getAgency() {
        return agency;
    }

    public int getGcn() {
        return gcn;
    }

    public String getInsuranceCompany() {
        return insuranceCompany;
    }

    public int getUserID() {
        return userID;
    }
    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setLicensePlate(String licensePlate) {
        this.licensePlate = licensePlate;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPostcode(int postcode) {
        this.postcode = postcode;
    }

    public void setModel(String model) {
        this.model = model;
    }
    public void setCountry(String country) {
        this.country = country;
    }

    public void setPolicyNumber(int policyNumber) {
        this.policyNumber = policyNumber;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public void setGcn(int gcn) {
        this.gcn = gcn;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

    public void setInsuranceCompany(String insuranceCompany) {
        this.insuranceCompany = insuranceCompany;
    }
    public void setGccfrom(String gccfrom) {
        this.gccfrom = gccfrom;
    }


    public String getGccfrom() {
        return gccfrom;
    }

    public String getGccto() {
        return gccto;
    }

    public void setGccto(String gccto) {
        this.gccto = gccto;
    }


}
