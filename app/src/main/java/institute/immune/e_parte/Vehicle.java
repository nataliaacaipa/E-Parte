package institute.immune.e_parte;

public class Vehicle {
    private int id;
    private String name;
    private String surname;
    private String licensePlate;
    private String address;
    private int postcode;
    private int iva;
    private String model;
    private String country;
    private int policyNumber;
    private String agency;
    private int gcn;
    private String gcc;
    private int damagesInsured;
    private int driverLicenseNumber;
    private String category;
    private String issuedIn;
    private String validUntil;
    private int userID;

    Vehicle(int id, String name, String surname, String licensePlate, String address, int postcode, int iva, String model, String country, int policyNumber, String agency, int gcn, String gcc, int damagesInsured, int driverLicenseNumber, String category, String issuedIn, String validUntil, int userID){
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.licensePlate = licensePlate;
        this.address = address;
        this.postcode = postcode;
        this.iva = iva;
        this.model = model;
        this.country = country;
        this.policyNumber = policyNumber;
        this.agency = agency;
        this.gcn = gcn;
        this.gcc = gcc;
        this.damagesInsured = damagesInsured;
        this.driverLicenseNumber = driverLicenseNumber;
        this.category = category;
        this.issuedIn = issuedIn;
        this.validUntil = validUntil;
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

    public int getIva() {
        return iva;
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

    public String getGcc() {
        return gcc;
    }

    public int getDamagesInsured() {
        return damagesInsured;
    }

    public int getDriverLicenseNumber() {
        return driverLicenseNumber;
    }

    public String getCategory() {
        return category;
    }

    public String getIssuedIn() {
        return issuedIn;
    }

    public String getValidUntil() {
        return validUntil;
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

    public void setIva(int iva) {
        this.iva = iva;
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

    public void setGcc(String gcc) {
        this.gcc = gcc;
    }

    public void setDamagesInsured(int damagesInsured) {
        this.damagesInsured = damagesInsured;
    }

    public void setDriverLicenseNumber(int driverLicenseNumber) {
        this.driverLicenseNumber = driverLicenseNumber;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public void setIssuedIn(String issuedIn) {
        this.issuedIn = issuedIn;
    }

    public void setValidUntil(String validUntil) {
        this.validUntil = validUntil;
    }

    public void setUserID(int userID) {
        this.userID = userID;
    }

}
