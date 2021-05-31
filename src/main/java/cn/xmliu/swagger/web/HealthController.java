package cn.xmliu.swagger.web;

import cn.xmliu.swagger.model.entity.ServerResponse;
import cn.xmliu.swagger.model.entity.Health;
import cn.xmliu.swagger.service.HealthService;
import io.swagger.annotations.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@ApiIgnore
@Api(tags = "健康API接口")
@Controller
@RequestMapping("/health")
public class HealthController {

    @Autowired
    private HealthService healthService;

    @ApiOperation(value="查询", notes="条件查询",hidden = false)
    @ApiResponses(value = {
            @ApiResponse(code = 200, message = "返回所有数据",response = Health.class)
    })
    @ApiImplicitParams({
            @ApiImplicitParam(name="name",value="名字",required=false,paramType="form"),
            @ApiImplicitParam(name="address",value="住址",required=false,paramType="form"),
            @ApiImplicitParam(name="level",value="等级",required=false,paramType="form",dataType="Integer")
    })
    @GetMapping(value = "allData")
    @ResponseBody
    public ServerResponse allData(@RequestParam (required = false) String id){
        List<Health> list = healthService.findList();
        return ServerResponse.success().put("list",list);
    }

    @PostMapping(value = "save")
    @ResponseBody
    public ServerResponse save(@RequestBody @ApiParam(value = "健康实体类", required = true)  Health entity) {
        if(null == entity){
            return ServerResponse.error("保存对象不能为空");
        }
        boolean result = healthService.save(entity);
        return (result == true) ? ServerResponse.success() : ServerResponse.error("保存错误");
    }

}
