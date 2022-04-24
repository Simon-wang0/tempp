package io.renren.modules.sys.vo;

import lombok.Data;

import java.util.List;

@Data
public class DepartRoleVo {
  private Long departId;
  private Long id;
  private List<Long> roleId;
}
