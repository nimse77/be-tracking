package com.table.tracking.generaterq.service;

import com.table.tracking.generaterq.entity.Hotel;
import net.glxn.qrgen.QRCode;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import java.io.ByteArrayOutputStream;

@Service
public class GenerateQRService {


    public ResponseEntity<byte[]> generateQRCode(@PathVariable String hotelId)throws Exception{
        //hotelId="CAT000001";
        String baseUrl = "https://13.204.69.86/menu";
        String data = String.format("%s/%s", baseUrl, hotelId);

        ByteArrayOutputStream stream = QRCode.from(data)
                .withSize(250, 250)
                .stream();

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.IMAGE_PNG);

        return new ResponseEntity<>(stream.toByteArray(), headers, HttpStatus.OK);
    }
}
