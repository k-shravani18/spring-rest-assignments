package com.cameraapp.service;

import com.cameraapp.exceptions.CameraNotFoundException;
import com.cameraapp.model.Camera;
import com.cameraapp.model.CameraType;
import com.cameraapp.model.LensType;
import com.cameraapp.repository.ICameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CameraServiceImpl implements ICameraService{
    @Autowired
    private ICameraRepository cameraRepository;
    @Override
    public Camera addCamera(Camera camera) {
    return cameraRepository.save(camera);
    }

    @Override
    public void updateCamera(Camera camera) {
    cameraRepository.save(camera);
    }

    @Override
    public void deleteCamera(int cameraId) {
    cameraRepository.deleteById(cameraId);
    }

    @Override
    public List<Camera> getAll() {
        return cameraRepository.findAll();
    }

    @Override
    public List<Camera> getByBrandAndPrice(String brand, double price) {
        List<Camera> cameras=cameraRepository.getByBrandAndPrice(brand,price);
        if (cameras.isEmpty())
            throw new CameraNotFoundException("this brand and price of camera not found");
        else
            return cameras;
    }

    @Override
    public List<Camera> getByLensType(String lensType) {
        List<Camera> cameras= cameraRepository.getByLensType(lensType);
        if (cameras.isEmpty())
            throw new CameraNotFoundException("this lens type not found");
        else
            return cameras;
    }

    @Override
    public List<Camera> getByCameraType(String cameraType) {
        List<Camera> cameras= cameraRepository.getByCameraType(cameraType);
        if (cameras.isEmpty())
            throw new CameraNotFoundException("this cameraType not found");
        else
            return cameras;
    }

    @Override
    public List<Camera> getByPrice(double price) {
        List<Camera> cameras= cameraRepository.getByPriceLessThan(price);
        if (cameras.isEmpty())
            throw new CameraNotFoundException("this price not found");
        else
            return cameras;
    }

    @Override
    public Camera getById(int cameraId) {
        Camera camera=cameraRepository.findById(cameraId).get();
        if(camera==null)
            throw new CameraNotFoundException("id not found");
        else
            return camera;
    }

}
