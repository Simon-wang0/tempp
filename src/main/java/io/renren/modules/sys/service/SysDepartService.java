package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.SysDepartEntity;
import io.renren.modules.sys.entity.SysRoleEntity;
import io.renren.modules.sys.vo.DepartRoleVo;

import java.util.List;
import java.util.Map;

public interface SysDepartService extends IService<SysDepartEntity> {


  PageUtils queryPage(Map<String, Object> params);


  Boolean saveDepart(SysDepartEntity depart, List<Long> roleId);

  void update(SysDepartEntity role,List<Long> roleIds);


  void deleteEnhance(DepartRoleVo param);
}
