package com.cameraapp.controller;

import com.cameraapp.model.Camera;
import com.cameraapp.model.CameraType;
import com.cameraapp.model.LensType;
import com.cameraapp.service.ICameraService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/camera-api")
public class CameraController {
    @Autowired
    ICameraService cameraService;

    //http://localhost:8081/camera-api/cameras
    @GetMapping("/cameras")
    public List<Camera> getAll(){
        return cameraService.getAll();
    }
    //http://localhost:8081/camera-api/cameras/brand/canon/price/45000
    @GetMapping("/cameras/brand/{brand}/price/{price}")
   public List<Camera> showByBrandAndPrice(@PathVariable("brand")String brand, @PathVariable("price")double price){
        return cameraService.getByBrandAndPrice(brand,price);

   }
    //http://localhost:8081/camera-api/cameras/lensType/TELEPHOTO
   @GetMapping("/cameras/lensType/{lensType}")
    public List<Camera> showByLenseType(@PathVariable("lensType") String lensType){
        return cameraService.getByLensType(lensType);

    }
    //http://localhost:8081/camera-api/cameras/cameraType/DSLR
    @GetMapping("/cameras/cameraType/{cameraType}")
    public List<Camera> showByCameraType(@PathVariable("cameraType") String cameraType){
        return cameraService.getByCameraType(cameraType);

    }
    //http://localhost:8081/camera-api/cameras/price/45000
    @GetMapping("/cameras/price/{price}")
    public List<Camera> showByPrice(@PathVariable("price") double price){
    return cameraService.getByPrice(price);
    }
    @GetMapping("/cameras/cameraId/{cameraId}")
    public Camera showById(@PathVariable("cameraId") int cameraId){
        return  cameraService.getById(cameraId);
    }

    //http://localhost:8081/camera-api/cameras
    @PostMapping("/cameras")
    public Camera addCamera(@RequestBody Camera camera){
        return cameraService.addCamera(camera);
    }
    //http://localhost:8081/camera-api/cameras
    @PutMapping("/cameras")
    public void updateCamera(@RequestBody Camera camera){
         cameraService.updateCamera(camera);
    }
    @DeleteMapping("/cameras/cameraId/{cameraId}")
    public void deleteCamera(@PathVariable("cameraId") int cameraId){
        cameraService.deleteCamera(cameraId);
    }
}
