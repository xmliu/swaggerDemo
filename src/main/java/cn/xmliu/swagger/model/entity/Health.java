package cn.xmliu.swagger.model.entity;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

@ApiModel(value = "Health",description = "健康类")
@Data
public class Health {

    @ApiModelProperty(value = "主键")
    int id;

    @ApiModelProperty(value = "姓名")
    String name;

    @ApiModelProperty(value = "地址")
    String address;

    @ApiModelProperty(value = "等级")
    String level;
}
