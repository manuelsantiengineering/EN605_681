package com.msanti16.servlet.domain;

import java.util.Date;

import com.msanti16.servlet.exceptions.BadUserNameException;

public class Reservation {
    private long            id = -1L;
    private String          first = "";
    private String          last = "";
    private Date            startDay;
    private int							numberOfDays;
    private int							guide;
    private int							location;


    public Reservation() {
        super();
    }

    public Reservation(long id, String first, String last, Date startDay, int numberOfDays, int guide, int location)
            throws BadUserNameException {
        super();
        this.first = first.trim();
        this.last = last.trim();
        if(this.first.length() < 1 || this.first.isEmpty()){
            throw new BadUserNameException("First name value is too short", this.first);
        }
        if(!this.first.matches("^[a-zA-Z]*$")){
            throw new BadUserNameException("First name must be all characters", this.first);
        }
        if(this.last.length() < 1 || this.last.isEmpty()){
          throw new BadUserNameException("Last name value is too short", this.last);
	      }
	      if(!this.last.matches("^[a-zA-Z]*$")){
	          throw new BadUserNameException("Last name must be all characters", this.last);
	      }

        this.id = id;
        this.startDay = startDay;
        this.numberOfDays = numberOfDays;
        this.guide = guide;
        this.location = location;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

		public String getFirst() {
			return first;
		}

		public void setFirst(String first) throws BadUserNameException {
			this.first = first.trim();
      if(this.first.length() < 1 || this.first.isEmpty()){
          throw new BadUserNameException("First name value is too short", this.first);
      }
      if(!this.first.matches("^[a-zA-Z]*$")){
          throw new BadUserNameException("First name must be all characters", this.first);
      }
		}

		public String getLast() {
			return last;
		}

		public void setLast(String last) throws BadUserNameException {
			this.last = last.trim();
      if(this.last.length() < 1 || this.last.isEmpty()){
        throw new BadUserNameException("Last name value is too short", this.last);
      }
      if(!this.last.matches("^[a-zA-Z]*$")){
          throw new BadUserNameException("Last name must be all characters", this.last);
      }
		}

		public Date getStartDay() {
			return startDay;
		}

		public void setStartDay(Date startDay) {
			this.startDay = startDay;
		}

		public int getNumberOfDays() {
			return numberOfDays;
		}

		public void setNumberOfDays(int numberOfDays) {
			this.numberOfDays = numberOfDays;
		}

		public int getGuide() {
			return guide;
		}

		public void setGuide(int guide) {
			this.guide = guide;
		}

		public int getLocation() {
			return location;
		}

		public void setLocation(int location) {
			this.location = location;
		}
    
}
