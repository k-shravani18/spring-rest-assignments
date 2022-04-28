package com.cameraapp.model;

import lombok.*;

import javax.persistence.*;

@AllArgsConstructor
@NoArgsConstructor
@ToString
@Getter
@Setter
@Entity
public class Camera {
    @Id
    @GeneratedValue(generator = "cam_gen",strategy = GenerationType.AUTO)
    @SequenceGenerator(name = "cam_gen",sequenceName = "cam_sequence",initialValue = 1,allocationSize = 1)
    private Integer cameraId;
    private String name;
    private String cameraType;
    private String lensType;
    private String brand;
    private double price;
}
