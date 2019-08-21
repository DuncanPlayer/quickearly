package net.messi.early.pojo;

public class EarlyshopMaterial {
    private Integer id;

    private String foodid;

    private String name;

    private String materialbrief;

    private String price;

    private String role;

    private String materialurl;

    private String unit;

    private String materialtype;

    private Integer reservationNum;

    public Integer getReservationNum() {
        return reservationNum;
    }

    public void setReservationNum(Integer reservationNum) {
        this.reservationNum = reservationNum;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getFoodid() {
        return foodid;
    }

    public void setFoodid(String foodid) {
        this.foodid = foodid == null ? null : foodid.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public String getMaterialbrief() {
        return materialbrief;
    }

    public void setMaterialbrief(String materialbrief) {
        this.materialbrief = materialbrief == null ? null : materialbrief.trim();
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price == null ? null : price.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getMaterialurl() {
        return materialurl;
    }

    public void setMaterialurl(String materialurl) {
        this.materialurl = materialurl == null ? null : materialurl.trim();
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit == null ? null : unit.trim();
    }

    public String getMaterialtype() {
        return materialtype;
    }

    public void setMaterialtype(String materialtype) {
        this.materialtype = materialtype == null ? null : materialtype.trim();
    }
}