package com.rab3tech.vo;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlRootElement;

import lombok.Data;

@Data
@XmlRootElement
public class DogWrapper {
	List<Dog> dogs=new ArrayList<>();
}
