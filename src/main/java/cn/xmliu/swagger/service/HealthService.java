package cn.xmliu.swagger.service;

import cn.xmliu.swagger.model.entity.Health;

import java.util.List;

public interface HealthService {

    List<Health> findList();
    boolean save(Health entity);
}
