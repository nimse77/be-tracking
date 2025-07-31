package com.table.tracking.generaterq.service;

import com.table.tracking.entity.Hotel;
import net.glxn.qrgen.QRCode;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.ByteArrayOutputStream;

@Service
public class GenerateQRService {


    public ResponseEntity<byte[]> generateQRCode(@PathVariable String hotelId)throws Exception{
        Hotel  hotel=new Hotel();
       hotel.setHotelName("Sai");
       hotel.setHotelId(hotelId);
       hotel.setLatitude(String.valueOf(17.4033));
       hotel.setLongitude(String.valueOf(78.4774));

        String baseUrl = "http://13.232.37.142/menu"; // or use IP/localhost for testing
//        String data = String.format("%s?hotelId=%s&lat=%s&lng=%s",
//                baseUrl, hotel.getHotelId(), hotel.getLatitude(), hotel.getLongitude());
        String data=String.format("%s?hotelId=%s",baseUrl,hotelId);
        ByteArrayOutputStream stream = QRCode.from(data).withSize(250, 250).stream();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);
        return new ResponseEntity<>(stream.toByteArray(), headers, HttpStatus.OK);
    }
}
