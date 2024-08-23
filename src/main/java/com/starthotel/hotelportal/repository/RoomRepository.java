package com.starthotel.hotelportal.repository;

import com.starthotel.hotelportal.model.Room;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RoomRepository extends JpaRepository<Room,Long> {
}
