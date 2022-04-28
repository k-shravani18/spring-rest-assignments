package com.cameraapp.controller;

import com.cameraapp.model.Camera;
import com.cameraapp.service.ICameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/camera-api")
public class CameraController {
    @Autowired
    ICameraService cameraService;

    //http://localhost:8081/camera-api/cameras
    @GetMapping("/cameras")
    public ResponseEntity<List<Camera>> getAll(){
        List<Camera> cameras=cameraService.getAll();
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","getting all cameras");
        headers.add("info","get all method called");
        ResponseEntity<List<Camera>> cameraResponse=new ResponseEntity(cameras,headers,HttpStatus.OK);
        return cameraResponse;
    }
    //http://localhost:8081/camera-api/cameras/brand/canon/price/45000
    @GetMapping("/cameras/brand/{brand}/price/{price}")
   public ResponseEntity<List<Camera>> showByBrandAndPrice(@PathVariable("brand")String brand, @PathVariable("price")double price){
        List<Camera> cameras=cameraService.getAll();
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","get by brand"+brand+" and price"+price);
        return ResponseEntity.ok().headers(headers).body(cameras);

   }
    //http://localhost:8081/camera-api/cameras/lensType/TELEPHOTO
   @GetMapping("/cameras/lensType/{lensType}")
    public ResponseEntity<List<Camera>> showByLensType(@PathVariable("lensType") String lensType){
       List<Camera> cameras=cameraService.getByLensType(lensType);
       HttpHeaders headers=new HttpHeaders();
       headers.add("desc","get by lens type");
       return ResponseEntity.ok().headers(headers).body(cameras);

    }
    //http://localhost:8081/camera-api/cameras/cameraType/DSLR
    @GetMapping("/cameras/cameraType/{cameraType}")
    public ResponseEntity<List<Camera>> showByCameraType(@PathVariable("cameraType") String cameraType){
        List<Camera> cameras= cameraService.getByCameraType(cameraType);
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","get by camera type");
        return ResponseEntity.ok().headers(headers).body(cameras);

    }
    //http://localhost:8081/camera-api/cameras/price/45000
    @GetMapping("/cameras/price/{price}")
    public ResponseEntity<List<Camera>> showByPrice(@PathVariable("price") double price){
    List<Camera>cameras= cameraService.getByPrice(price);
    HttpHeaders headers= new HttpHeaders();
    headers.add("desc","get by price");
    return  ResponseEntity.ok().headers(headers).body(cameras);
    }
    @GetMapping("/cameras/cameraId/{cameraId}")
    public ResponseEntity<Camera> showById(@PathVariable("cameraId") int cameraId){
        Camera camera=cameraService.getById(cameraId);
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","get by id");
        return ResponseEntity.ok().headers(headers).body(camera);
    }

    //http://localhost:8081/camera-api/cameras
    @PostMapping("/cameras")
    ResponseEntity<Void> addCamera(@RequestBody Camera camera){
        cameraService.addCamera(camera);
     return ResponseEntity.status(HttpStatus.CREATED).build();

    }

    //http://localhost:8081/camera-api/cameras
    @PutMapping("/cameras")
    public ResponseEntity<Void> updateCamera(@RequestBody Camera camera){
        cameraService.updateCamera(camera);
        return ResponseEntity.status(HttpStatus.ACCEPTED).build();
    }
    @DeleteMapping("/cameras/cameraId/{cameraId}")
    public  ResponseEntity<Void> deleteCamera(@PathVariable("cameraId") int cameraId){
        HttpHeaders headers=new HttpHeaders();
        headers.add("desc","delete camera by id");
        return ResponseEntity.status(HttpStatus.OK).headers(headers).build();
    }
}
