package cn.xmliu.swagger.service.impl;

import cn.xmliu.swagger.model.entity.Health;
import cn.xmliu.swagger.model.repo.HealthRepo;
import cn.xmliu.swagger.service.HealthService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HealthServiceImpl implements HealthService {

    @Autowired
    private HealthRepo healthRepo;

    @Override
    public List<Health> findList() {
        return healthRepo.queryList();
    }

    @Override
    public boolean save(Health entity) {
        return healthRepo.save(entity);
    }
}
