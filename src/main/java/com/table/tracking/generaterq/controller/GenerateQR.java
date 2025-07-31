package com.table.tracking.generaterq.controller;

import com.table.tracking.entity.Hotel;
import com.table.tracking.generaterq.service.GenerateQRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/hotel")
public class GenerateQR {

    @Autowired
    private GenerateQRService generateQRService;

    @GetMapping("/generate-qr/{hotelId}")
    public ResponseEntity<byte[]> generateQR(@PathVariable String hotelId) throws Exception {
        return generateQRService.generateQRCode(hotelId);
    }

    @GetMapping("/menu/{hotelId}")
    public ResponseEntity<List<?>> getMenu(@PathVariable String hotelId) {


        Hotel hotel=new Hotel();
        List<Hotel>res=new ArrayList<>();
        hotel.setHotelName("Sai");
        hotel.setHotelId(hotelId);
        hotel.setLatitude(String.valueOf(17.4033));
        hotel.setLongitude(String.valueOf(78.4774));
        res.add(hotel);
        return ResponseEntity.ok(res);
    }


}
