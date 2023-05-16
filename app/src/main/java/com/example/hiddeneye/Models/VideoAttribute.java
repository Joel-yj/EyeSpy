package com.example.hiddeneye.Models;

/**
 * Model class representing the attributes of a video.
 */

public class VideoAttribute {

    private String videoPath;
    private int age;
    private String isCarryingBackpack;
    private String isCarryingBag;
    private String lowerBodyClothing;
    private String lenLowerBodyClothing;
    private String sleeveLength;
    private String hairLength;
    private String isWearingHat;
    private String gender;
    private String colorUpperBodyClothing;
    private String colorLowerBodyClothing;


    /**
     * Returns the video path.
     *
     * @return The video path.
     */
    public String getVideoPath() {
        return videoPath;
    }

    /**
     * Sets the video path.
     *
     * @param videoPath The video path.
     */
    /**
     * Returns the age.
     *
     * @return The age.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the age.
     *
     * @param age The age.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Returns whether the person is carrying a backpack.
     *
     * @return "true" if carrying a backpack, "false" otherwise.
     */
    public String getIsCarryingBackpack() {
        return isCarryingBackpack;
    }

    /**
     * Sets whether the person is carrying a backpack.
     *
     * @param carryingBackpack "true" if carrying a backpack, "false" otherwise.
     */
    public void setCarryingBackpack(String carryingBackpack) {
        isCarryingBackpack = carryingBackpack;
    }

    public String getIsCarryingBag() {
        return isCarryingBag;
    }

    public void setCarryingBag(String carryingBag) {
        isCarryingBag = carryingBag;
    }

    public String getLowerBodyClothing() {
        return lowerBodyClothing;
    }

    public void setLowerBodyClothing(String lowerBodyClothing) {
        this.lowerBodyClothing = lowerBodyClothing;
    }

    public String getLenLowerBodyClothing() {
        return lenLowerBodyClothing;
    }

    public void setLenLowerBodyClothing(String lenLowerBodyClothing) {
        this.lenLowerBodyClothing = lenLowerBodyClothing;
    }

    public String getSleeveLength() {
        return sleeveLength;
    }

    public void setSleeveLength(String sleeveLength) {
        this.sleeveLength = sleeveLength;
    }

    public String getHairLength() {
        return hairLength;
    }

    public void setHairLength(String hairLength) {
        this.hairLength = hairLength;
    }

    public String getIsWearingHat() {
        return isWearingHat;
    }

    public void setWearingHat(String wearingHat) {
        isWearingHat = wearingHat;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getColorUpperBodyClothing() {
        return colorUpperBodyClothing;
    }

    public void setColorUpperBodyClothing(String colorUpperBodyClothing) {
        this.colorUpperBodyClothing = colorUpperBodyClothing;
    }

    public String getColorLowerBodyClothing() {
        return colorLowerBodyClothing;
    }

    public void setColorLowerBodyClothing(String colorLowerBodyClothing) {
        this.colorLowerBodyClothing = colorLowerBodyClothing;
    }

}
