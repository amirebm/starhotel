package com.starthotel.hotelportal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class BookedRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long bookingId;

    @Column(name="check_In")
    private LocalDate checkInDate;

    @Column(name="check_Out")
    private LocalDate checkOutDate;

    @Column(name="guest_Fullname")
    private String guestFullName;

    @Column(name="guest_Email")
    private String guestEmail;

    @Column(name="adults")
    private int numOfAdults;

    @Column(name="children")
    private int numOfChildren;

    @Column(name="total_Guest")
    private int totalNumOfGuests;

    @Column(name="confirmation_Code")
    private String bookingConfirmationCode;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="room_id")
    private Room room;

    public void calculateTotalNumberOfGuest(){
        this.totalNumOfGuests =this.numOfAdults + this.numOfChildren;
    }

    public void setNumOfAdults(int numOfAdults) {
        this.numOfAdults = numOfAdults;
        calculateTotalNumberOfGuest(); // any change for setting number of adults should
        // be called again to recalculate the number of guests
    }

    public void setNumOfChildren(int numOfChildren) {
        this.numOfChildren = numOfChildren;
        calculateTotalNumberOfGuest();// any change for setting number of children should
        // be called again to recalculate the number of guests

    }

    public void setBookingConfirmationCode(String bookingConfirmationCode) {
        this.bookingConfirmationCode = bookingConfirmationCode;
    }
}
