package com.msanti16.servlet.domain;

import java.util.GregorianCalendar;

import com.msanti16.servlet.exceptions.BadBookingDateException;

/**
 *
 * @author evansrb1
 */
public class BookingDay {

    private int year = 0;
    private int month = 0;
    private int dayOfMonth = 0;
    private String validation=NOT_VALIDATED;

    public final static String NOT_VALID = "Incorrect Date Format";
    public final static String NOT_VALIDATED = "NOT VALIDATED";
    public final static String VALID = "VALID";

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final BookingDay other = (BookingDay) obj;
        if (this.year != other.year) {
            return false;
        }
        if (this.month != other.month) {
            return false;
        }
        if (this.dayOfMonth != other.dayOfMonth) {
            return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 53 * hash + this.year;
        hash = 53 * hash + this.month;
        hash = 53 * hash + this.dayOfMonth;
        return hash;
    }

    /** Constructor to use for Bean purposes.  Must set the three fields manually
     * 
     */
    public BookingDay() {
        super();
    }
    
    /** Constructor for testing purposes or use within the bookingrate package.
     @param year the year, from 2007 to 2020
     @param month, the month Jan = 1, Dec = 12
     @param dayOfMonth, the numerical day of the month
     */
    public BookingDay(int year, int month, int dayOfMonth) throws BadBookingDateException {
        super();
        if(month < 1 || month > 12){
            throw new BadBookingDateException("Month must be between 1 and 12", month);
        }
        if(year < 2019 || year > 2022){
            throw new BadBookingDateException("Year must be between 2019 and 2022", year);
        }
        this.dayOfMonth = dayOfMonth;
        if(badDay()){
            throw new BadBookingDateException("Day value is not acceptable", dayOfMonth);
        }
        this.year = year;
        this.month = month - 1;

    }


    /** Do the date fields describe a valid date?
     @return true if the year is between 2019 and 2022, and the day and month are valid dates
     */
    public boolean isValidDate() {
        StringBuilder builder = new StringBuilder();
        if ((year < 2019 || year > 2022) ||
            (month < 0 || month > 11) ||
            badDay()) {
            validation = NOT_VALID;
            return false;
        } else {
            validation = VALID;
            return true;
        }
    }


    /** is this day before the endDay given
     *
     * @param endDay The end day
     * @return true if this day is before the end day
     */
    public boolean before(BookingDay endDay) {
        if (endDay == null) {
            return false;
        }
        if (year < endDay.year) {
            return true;
        } else if (year > endDay.year) {
            return false;
        }
        if (month < endDay.month) {
            return true;
        } else if (month > endDay.month) {
            return false;
        }
        if (dayOfMonth < endDay.dayOfMonth) {
            return true;
        } else {
            return false;
        }
    }

    /** is this day after the endDay given
     *
     * @param endDay The end day
     * @return true if this day is after the end day
     */
    public boolean after(BookingDay endDay) {
        if (endDay == null) {
            return false;
        }
        if (year > endDay.year) {
            return true;
        } else if (year < endDay.year) {
            return false;
        }
        if (month > endDay.month) {
            return true;
        } else if (month < endDay.month) {
            return false;
        }
        if (dayOfMonth > endDay.dayOfMonth) {
            return true;
        } else {
            return false;
        }
    }

    /** Test to see if this BookinDay is after the month and day specified.
     * Note that there is no error checking on the month/day combo, also, this
     * assumes the same year
     *
     * @param month the month (1-Jan, 12-Dec)
     * @param day the day of the month
     * @return true if this Booking day is after the provided date
     */
    public boolean after(int month, int day) {
        if (this.month + 1> month) {
            return true;
        } else if (this.month + 1 < month) {
            return false;
        } else {
            if (this.dayOfMonth > day) {
                return true;
            } else {
                return false;
            }
        }
    }

    /** Test to see if this BookinDay is before the month and day specified.
     * Note that there is no error checking on the month/day combo
     *
     * @param month the month (1-Jan, 12-Dec)
     * @param day the day of the month
     * @return true if this Booking day is before the provided date
     */
    public boolean before(int month, int day) {
        if (this.month + 1 < month) {
            return true;
        } else if (this.month + 1 > month) {
            return false;
        } else {
            if (this.dayOfMonth < day) {
                return true;
            } else {
                return false;
            }
        }
    }

    /** Extra information of validation status of this date data
     *
     * @return a string explaining what is right or wrong
     */
    public String getValidationStatus() {
        return validation;
    }


    @Override
    public String toString() {
        return "" + (month + 1) + "/" + dayOfMonth +  "/" + year;
    }

    /** is the day value out of range for the given month?
     @return true if it is a bad day
     */
    protected boolean badDay() {
        switch (month) {
            case 0:
            case 2:
            case 4:
            case 6:
            case 7:
            case 9:
            case 11:
                return (dayOfMonth < 1 || dayOfMonth > 31);
            case 8:
            case 3:
            case 5:
            case 10:
                return (dayOfMonth < 1 || dayOfMonth > 30);
            case 1:
                if ((year % 4) == 0) {
                    return (dayOfMonth < 1 || dayOfMonth > 29);
                } else {
                    return (dayOfMonth < 1 || dayOfMonth > 28);
                }
            default:
                return true;
        }
    }


    /** Get a GregorianCalendar object that represents this date
     *
     * @return the GregorianCalendar object for this date
     */
    public GregorianCalendar getDate() {
        return new GregorianCalendar(year, month, dayOfMonth);
    }

    int getYear() {
        return year;
    }

    public void setYear(int year) {
        validation=NOT_VALIDATED;
        this.year = year;
    }

    public int getMonth() {
        return month + 1;

    }

    public void setMonth(int month) {
        validation=NOT_VALIDATED;
        this.month = month - 1;
    }

    public int getDayOfMonth() {
        return dayOfMonth;
    }

    public void setDayOfMonth(int dayOfMonth) {
        this.dayOfMonth = dayOfMonth;
    }

}
