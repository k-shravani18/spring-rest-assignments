package com.cameraapp.repository;

import com.cameraapp.model.Camera;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ICameraRepository extends JpaRepository<Camera,Integer> {
    List<Camera> getByBrandAndPrice(String brand, double price);
    List<Camera> getByLensType(String lensType);
    List<Camera> getByCameraType(String cameraType);
    List<Camera> getByPriceLessThan(double price);
}
