package com.starthotel.hotelportal.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.lang3.RandomStringUtils;

import java.math.BigDecimal;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@AllArgsConstructor
public class Room {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name="room_type")
    private String roomType;
    @Column(name="room_price")
    private BigDecimal roomPrice;
    @Column(name="is_booked")
    private boolean isBooked=false;
    @Lob
    private Blob photo;

    @OneToMany(mappedBy = "room", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //we're going to set the Cascade type to all now this one means when this room is
    //deleted all the booking history is going to be deleted anything
    private List<BookedRoom> bookings;

    public Room(){
        this.bookings = new ArrayList<>();
    }

    public void addBooking(BookedRoom booking){
        if(bookings== null){
            bookings=new ArrayList<>();
        }
        bookings.add(booking);
        booking.setRoom(this);
        isBooked=true;
        String bookingCode= RandomStringUtils.randomNumeric(10);

    }
}
