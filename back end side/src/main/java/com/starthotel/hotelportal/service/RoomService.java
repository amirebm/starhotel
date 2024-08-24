package com.starthotel.hotelportal.service;

import com.starthotel.hotelportal.model.Room;
import com.starthotel.hotelportal.repository.RoomRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import javax.sql.rowset.serial.SerialBlob;
import java.io.IOException;
import java.math.BigDecimal;
import java.sql.Blob;
import java.sql.SQLException;
@Service
@RequiredArgsConstructor
public class RoomService implements IRoomService {

    private final RoomRepository roomRepository;
@Override
    public Room addNewRoom(MultipartFile file, String roomType, BigDecimal roomPrice) throws IOException, SQLException {
    Room room= new Room();
    room.setRoomType(roomType);
    room.setRoomPrice(roomPrice);
    if(!file.isEmpty()){
        byte[] photoBytes= file.getBytes();
        Blob photoBlob = new SerialBlob(photoBytes);
        room.setPhoto(photoBlob);

    }
    return roomRepository.save(room);
}


}
