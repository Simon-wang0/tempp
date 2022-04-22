package io.renren.modules.sys.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import javax.validation.constraints.NotBlank;
import java.util.Date;
import java.util.List;

@Data
@TableName("depart")
public class SysDepartEntity {
  private static final long serialVersionUID = 1L;
  /**
   * ID
   */
  @TableId
  private Long departId;
  @NotBlank(message = "名称不能为空")
  private String departName;
  // 0 正常  1 停用
  private int  status;
  /**
   * 创建时间
   */
  private Date createTime;
  private Date updateTime;
  //部门下的角色
  @TableField(exist = false)
  List<SysRoleEntity> sysRole;
  String description;
  //区分标识
  String distinguishing;
}
