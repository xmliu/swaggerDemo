package cn.xmliu.swagger.model.repo;

import cn.xmliu.swagger.model.entity.Health;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

public interface HealthRepo {

    List<Health> queryList();
    boolean save(Health entity);

}
