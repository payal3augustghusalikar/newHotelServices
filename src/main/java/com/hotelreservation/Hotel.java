package com.hotelreservation;

public class Hotel implements Comparable<Hotel> {
    private String name;
    private float rate;
    private float weekendRate;
    public int rating;
private float rateForRewardCustomer;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getRate() {
        return rate;
    }

    public void setRate(float rate) {
        this.rate = rate;
    }

    public float getWeekendRate() {
        return weekendRate;
    }

    public void setWeekendRate(float weekendRate) {
        this.weekendRate = weekendRate;
    }

    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public float getRateForRewardCustomer() {
        return rateForRewardCustomer;
    }

    public void setRateForRewardCustomer(float rateForRewardCustomer) {
        this.rateForRewardCustomer = rateForRewardCustomer;
    }

    @Override
    public String toString() {
        return "Hotel{" +
                "name='" + name + '\'' +
                ", rate=" + rate +
                ", weekendRate=" + weekendRate +
                ", rating=" + rating +
                ", rateForRewardCustomer=" + rateForRewardCustomer +
                '}';
    }

    @Override
    public int compareTo(Hotel h) {
        return (int) (this.rate - h.rate);
    }
}