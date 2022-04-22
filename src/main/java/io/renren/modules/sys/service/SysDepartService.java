package io.renren.modules.sys.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.extension.service.IService;
import io.renren.common.utils.PageUtils;
import io.renren.modules.sys.entity.SysDepartEntity;
import io.renren.modules.sys.entity.SysRoleEntity;

import java.util.Map;

public interface SysDepartService extends IService<SysDepartEntity> {


  PageUtils queryPage(Map<String, Object> params);

  void saveDepart(SysDepartEntity role);

  void update(SysDepartEntity role);


  void deleteEnhance(Long departId);
}
