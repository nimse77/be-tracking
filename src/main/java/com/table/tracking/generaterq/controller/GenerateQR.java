package com.table.tracking.generaterq.controller;

import com.table.tracking.generaterq.entity.Hotel;
import com.table.tracking.generaterq.service.GenerateQRService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@CrossOrigin(origins = {"http://localhost:4200","http://13.204.69.86","https://13.204.69.86"})
@RestController
@RequestMapping("/hotel")
public class GenerateQR {

    @Autowired
    private GenerateQRService generateQRService;

    @GetMapping("/generate-qr/{hotelId}")
    public ResponseEntity<byte[]> generateQR(@PathVariable String hotelId) throws Exception {
        return generateQRService.generateQRCode(hotelId);
    }

    @GetMapping("/hotelInfo/{hotelId}")
    public ResponseEntity<?> getHotelInfo(@PathVariable String hotelId){
        Hotel hotel=new Hotel();
        hotel.setHotelId(hotelId);
        hotel.setLatitude(17.456678);
        hotel.setLongitude(18.654333);

        return  ResponseEntity.ok(hotel);
    }
    @GetMapping("/menu/{hotelId}")
    public ResponseEntity<List<?>> getMenu(@PathVariable String hotelId) {


        Hotel item1 =new Hotel();
        List<Hotel>res=new ArrayList<>();
        item1.setHotelId("hotel123");
        item1.setName("Masala Dosa");
        item1.setDescription("Crispy dosa with spicy potato filling");
        item1.setPrice(80);
        item1.setCategory("South Indian");
        item1.setImageUrl("https://example.com/images/masala-dosa.jpg");

        Hotel item2 = new Hotel();
        item2.setHotelId("hotel123");
        item2.setName("Paneer Butter Masala");
        item2.setDescription("Rich and creamy North Indian curry");
        item2.setPrice(150);
        item2.setCategory("North Indian");
        item2.setImageUrl("https://example.com/images/paneer.jpg");
        res.add(item1);
        res.add(item2);
        return ResponseEntity.ok(res);
    }


}
